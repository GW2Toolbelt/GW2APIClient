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
package com.gw2tb.gw2apiclient.build.codegen

import com.gw2tb.apigen.model.*
import com.gw2tb.apigen.schema.*
import java.util.*
import kotlin.time.*

private fun Duration.normalizeCacheTime(): String {
    require((inSeconds % 60.0) == 0.0)

    return when {
        isInfinite() -> "INFINITE"
        else -> {
            if ((inMinutes % 60.0) == 0.0 && (inMinutes / 60.0) > 1.0) {
                "${inHours.toInt()}h"
            } else {
                "${inMinutes.toInt()}m"
            }
        }
    }
}

internal val String.asComment: String get() = comment({
    append(this@asComment)
})

private fun comment(action: StringBuilder.() -> Unit, isDocComment: Boolean = false): String =
    StringBuilder().apply(action).toString().lines().let {
        val start = if (isDocComment) "/**" else "/*"

        when (it.size) {
            0 -> ""
            1 -> "$start ${it[0]} */$n"
            else -> StringBuilder().apply(action).toString().lines().joinToString(separator = "$n *", prefix = "$start$n *", postfix = "$n */$n") { line ->
                if (line.isNotBlank()) " $line" else ""
            }
        }
    }

@Suppress("NOTHING_TO_INLINE")
private inline fun docComment(noinline action: StringBuilder.() -> Unit): String = comment(action, isDocComment = true)

internal fun Endpoint.dokka(queryType: String): String = docComment {
    append("$queryType$n$n")
    append("$summary$n$n")
    append("""
                |```
                |Authenticated:       ${if (security.isNotEmpty()) "Yes (${security.joinToString()})" else "No"}
                |Paginated:           ${if (queryTypes.any { it is QueryType.ByPage }) "Yes" else "No"}
                |Bulk expanded:       ${if (queryTypes.any { it is QueryType.ByIds }) "Yes" else "No"}
                |Localized:           ${if (isLocalized) "Yes" else "No"}
                |Cache time:          ${cache?.normalizeCacheTime() ?: "N/A"}
                |```
            """.trimMargin() + n + n)
    append("Read more: [https://wiki.guildwars2.com/wiki/API:2/${route.toLowerCase(Locale.ENGLISH).removePrefix("/")}]$n$n")
    append("@receiver        the client instance used to make the request$n")
    append("@param configure configure action for the request$n$n")
    append("@return  the request that can be executed to query the API")
}

internal fun SchemaConditional.dokka(): String = docComment {
    append(description)

    if (sharedProperties.isNotEmpty()) {
        append("$n$n")
        append(sharedProperties.values.joinToString(separator = n) { property ->
            "@property ${property.camelCaseName} ${property.description}"
        })
    }
}

internal fun SchemaRecord.dokka(): String = docComment {
    append(description)

    if (properties.isNotEmpty()) {
        append("$n$n")
        append(properties.values.joinToString(separator = n) { property ->
            "@param ${property.camelCaseName} ${property.description}"
        })
    }
}