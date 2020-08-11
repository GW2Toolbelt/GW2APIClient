/*
 * Copyright (c) 2018-2020 Leon Linhart
 * MACHINE GENERATED FILE, DO NOT EDIT
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
@file:JvmName("GW2v2")
@file:JvmMultifileClass
@file:Suppress("PackageDirectoryMismatch", "UnusedImport")
package gw2api.v2

import gw2api.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.json.*
import kotlin.jvm.*

public fun GW2APIClient.gw2v2ProfessionsIds(configure: (RequestBuilder<List<String>>.() -> Unit)? = null): RequestBuilder<List<String>> = request(
    path = "/v2/professions",
    parameters = mapOf("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(String.serializer()),
    configure = configure
)

public fun GW2APIClient.gw2v2ProfessionsById(id: String, configure: (RequestBuilder<GW2v2Professions>.() -> Unit)? = null): RequestBuilder<GW2v2Professions> = request(
    path = "/v2/professions",
    parameters = mapOf("id" to id, "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = Language.API_V2,
    serializer = GW2v2Professions.serializer(),
    configure = configure
)

public fun GW2APIClient.gw2v2ProfessionsByIds(ids: Collection<String>, configure: (RequestBuilder<List<GW2v2Professions>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Professions>> = request(
    path = "/v2/professions",
    parameters = mapOf("ids" to ids.joinToString(","), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = Language.API_V2,
    serializer = ListSerializer(GW2v2Professions.serializer()),
    configure = configure
)

public fun GW2APIClient.gw2v2ProfessionsAll(configure: (RequestBuilder<List<GW2v2Professions>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Professions>> = request(
    path = "/v2/professions",
    parameters = mapOf("ids" to "all", "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = Language.API_V2,
    serializer = ListSerializer(GW2v2Professions.serializer()),
    configure = configure
)

public fun GW2APIClient.gw2v2ProfessionsByPage(page: Int, pageSize: Int = 200, configure: (RequestBuilder<List<GW2v2Professions>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Professions>> = request(
    path = "/v2/professions",
    parameters = mapOf("page" to page.toString(), "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = Language.API_V2,
    serializer = ListSerializer(GW2v2Professions.serializer()),
    configure = configure
)

@Serializable
public data class GW2v2Professions(
    val id: String,
    val name: String,
    val code: Int,
    val icon: String,
    @SerialName("icon_big")
    val bigIcon: String,
    val specializations: List<Int>,
    val weapons: Map<String, Weapons>,
    val flags: List<String>,
    val skills: List<Skills>,
    val training: List<Training>,
    @SerialName("skills_by_palette")
    val skillsByPalette: List<List<Int>>
) {

    @Serializable
    public data class Weapons(
        val specialization: Int? = null,
        val flags: List<String>,
        val skills: List<Skills>
    ) {
    
        @Serializable
        public data class Skills(
            val id: Int,
            val slot: String,
            val attunement: String? = null,
            val offhand: String? = null
        )
    
    }

    @Serializable
    public data class Skills(
        val id: Int,
        val slot: String,
        val type: String,
        val attunement: String? = null,
        val source: String? = null
    )

    @Serializable
    public data class Training(
        val id: Int,
        val category: String,
        val name: String,
        val track: List<Track>
    ) {
    
        @Serializable
        public data class Track(
            val cost: Int,
            val type: String,
            @SerialName("skill_id")
            val skillId: Int? = null,
            @SerialName("trait_id")
            val traitId: Int? = null
        )
    
    }

}