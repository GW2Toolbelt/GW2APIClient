/*
 * Copyright (c) 2018-2020 Leon Linhart
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.themrmilchmann.build.apigen

import com.github.gw2toolbelt.apigen.*
import com.github.gw2toolbelt.apigen.model.*
import com.github.gw2toolbelt.apigen.schema.*
import org.gradle.api.*
import org.gradle.api.tasks.*
import java.io.*
import java.util.*

private const val t = "    "

@CacheableTask
open class Generate : DefaultTask() {

    private val String.listSerializer get() = "$this.serializer().list"
    private val KotlinTypeInfo.listSerializer get() = "${serializer}.list"

    private fun SchemaType.toKotlinType(titleCaseName: String, dataClasses: MutableMap<String, SchemaMap>): KotlinTypeInfo {
        fun KotlinTypeInfo(type: String) = KotlinTypeInfo(type, "$type.serializer()")

        return when (this) {
            SchemaType.Kind.BOOLEAN -> KotlinTypeInfo("Boolean")
            SchemaType.Kind.DECIMAL -> KotlinTypeInfo("Double")
            SchemaType.Kind.INTEGER -> KotlinTypeInfo("Int")
            SchemaType.Kind.STRING -> KotlinTypeInfo("String")
            is SchemaArray -> {
                val itemType = items.toKotlinType(titleCaseName, dataClasses)
                KotlinTypeInfo("List<${itemType.name}>", "${itemType.serializer}.list")
            }
            is SchemaMap -> KotlinTypeInfo(titleCaseName).also { dataClasses[titleCaseName] = this }
            else -> error("Unsupported SchemaType: $this")
        }
    }

    private data class KotlinTypeInfo(
        val name: String,
        val serializer: String
    ) {
        override fun toString() = name
    }

    @Input
    lateinit var licenseHeader: String

    @OutputDirectory
    lateinit var outputDirectory: File

    @TaskAction
    fun generate() {
        with(API_V2_DEFINITION) {
            endpoints.forEach { endpoint ->
                val routeTitleCase = endpoint.route.replace("/", "")

                val (dataClassType, rootDataClassSchema) = with (mutableMapOf<String, SchemaMap>()) {
                    endpoint.schema!!.toKotlinType("GW2v2$routeTitleCase", this) to this.entries.firstOrNull()?.value
                }

                fun requestBody(
                    parameters: String,
                    serializer: String,
                    replaceInPath: String = "emptyMap()",
                    requiredPermissions: String = "emptySet()",
                    isIdsEndpoint: Boolean = false
                ) =
                    """
                    path = "/v2${endpoint.route.toLowerCase(Locale.ENGLISH)}",
                    parameters = $parameters,
                    replaceInPath = emptyMap(),
                    requiresAuthentication = ${if (endpoint.security.isNotEmpty()) "true" else "false"},
                    requiredPermissions = emptySet(),
                    supportedLanguages = ${if (endpoint.isLocalized && !isIdsEndpoint) "API_V2_LANGS" else "emptySet()"},
                    serializer = $serializer,
                    configure = configure
                    """.trimIndent().lines().joinToString(separator = "\n") { "$t$it" }

                val functions = endpoint.queryTypes.let { queryTypes -> sequence {
                    if (queryTypes !== null) {
                        val idType = when (endpoint.idType) {
                            is SchemaType.Kind.INTEGER -> "Int"
                            is SchemaType.Kind.STRING -> "String"
                            else -> error("Unsupported ID type for endpoint: $endpoint")
                        }

                        yield(
                            """
                            |fun GW2APIClient.gw2v2${routeTitleCase}Ids(configure: (RequestBuilder<List<$idType>>.() -> Unit)? = null): RequestBuilder<List<$idType>> = request(
                            |${requestBody(
                                parameters = "emptyMap()",
                                serializer = idType.listSerializer,
                                isIdsEndpoint = true
                            )}
                            |)
                            """.trimMargin()
                        )

                        queryTypes.forEach { queryType ->
                            when (queryType) {
                                is QueryType.ById -> yield(
                                    """
                                    |fun GW2APIClient.gw2v2${routeTitleCase}ById(id: $idType, configure: (RequestBuilder<$dataClassType>.() -> Unit)? = null): RequestBuilder<$dataClassType> = request(
                                    |${requestBody(
                                        parameters = """mapOf("id" to id.toString())""",
                                        serializer = dataClassType.serializer
                                    )}
                                    |)
                                    """.trimMargin()
                                )
                                is QueryType.ByIds -> {
                                    yield(
                                        """
                                        |fun GW2APIClient.gw2v2${routeTitleCase}ByIds(ids: Collection<$idType>, configure: (RequestBuilder<List<$dataClassType>>.() -> Unit)? = null): RequestBuilder<List<$dataClassType>> = request(
                                        |${requestBody(
                                            parameters = """mapOf("ids" to ids.joinToString(","))""",
                                            serializer = dataClassType.listSerializer
                                        )}
                                        |)
                                        """.trimMargin()
                                    )

                                    if (queryType.supportsAll) yield(
                                        """
                                        |fun GW2APIClient.gw2v2${routeTitleCase}All(configure: (RequestBuilder<List<$dataClassType>>.() -> Unit)? = null): RequestBuilder<List<$dataClassType>> = request(
                                        |${requestBody(
                                            parameters = """mapOf("ids" to "all")""",
                                            serializer = dataClassType.listSerializer
                                        )}
                                        |)
                                        """.trimMargin()
                                    )
                                }
                                is QueryType.ByPage -> yield(
                                    """
                                    |fun GW2APIClient.gw2v2${routeTitleCase}ByPage(page: Int, pageSize: Int, configure: (RequestBuilder<List<$dataClassType>>.() -> Unit)? = null): RequestBuilder<List<$dataClassType>> = request(
                                    |${requestBody(
                                        parameters = """mapOf("page" to page.toString(), "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }.toString())""",
                                        serializer = dataClassType.listSerializer
                                    )}
                                    |)
                                    """.trimMargin()
                                )
                                else -> error("Unsupported QueryType: $queryType")
                            }
                        }
                    } else {
                        val RequestBuilder = "RequestBuilder<${dataClassType.name}>"

                        yield(
                            """
                            |fun GW2APIClient.gw2v2$routeTitleCase(configure: ($RequestBuilder.() -> Unit)? = null): $RequestBuilder = request(
                            |${requestBody(
                                parameters = "emptyMap()",
                                serializer = dataClassType.serializer
                            )}
                            |)
                            """.trimMargin()
                        )
                    }
                }}

                fun SchemaMap.createDataClass(className: String, indent: String = ""): String {
                    val dataClasses = mutableMapOf<String, SchemaMap>()

                    return """
                    |@Serializable
                    |data class $className(
                    |${properties.map { (_, property) ->
                        StringBuilder().run {
                            if (property.isDeprecated) append("""$t@Deprecated(message = "")${"\n"}""")
                            if (property.serialName != property.propertyName) append("""$t@SerialName("${property.serialName}")${"\n"}""")
                            append("${t}val ${property.propertyName}: ${property.type.toKotlinType(property.propertyName.let { "${it.toCharArray()[0].toUpperCase()}${it.substring(1)}" }, dataClasses)}")
                            toString()
                        }
                    }.joinToString(separator = ",\n")}
                    |)${if (dataClasses.isNotEmpty()) """
                    | {
                    |
                    |${dataClasses.map { (name, schema) -> schema.createDataClass(name, t) }.joinToString(separator = "\n\n")}
                    |
                    |}
                    """.trimMargin() else ""}
                    """.trimMargin().prependIndent(indent)
                }

                File(outputDirectory, "kotlin/gw2api/v2/routes/${endpoint.route.toLowerCase(Locale.ENGLISH).substringBeforeLast("/")}/${routeTitleCase.let { "${it.toCharArray()[0].toLowerCase()}${it.substring(1)}" }}.kt").also { outputFile ->
                    outputFile.parentFile.mkdirs()
                    outputFile.writeText(
                        """
/*
${licenseHeader.prependIndent(" * ")}
 */
@file:JvmName("GW2v2")
@file:JvmMultifileClass
@file:Suppress("PackageDirectoryMismatch", "UnusedImport")
package gw2api.v2

import gw2api.*
import gw2api.extra.*
import gw2api.misc.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlin.jvm.*

${functions.joinToString(separator = "\n\n")}${rootDataClassSchema.let { if (it !== null) "\n\n" + it.createDataClass("GW2v2$routeTitleCase") else "" }}
""".trimIndent()
                    )
                }
            }
        }
    }

}