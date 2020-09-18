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
package com.gw2tb.gw2api.client.v2

import com.gw2tb.gw2api.client.*
import com.gw2tb.gw2api.client.internal.*
import com.gw2tb.gw2api.types.v2.*
import kotlinx.serialization.builtins.*
import kotlin.jvm.*

/**
 * Creates a request used to query the list of available IDs.
 *
 * Returns information about unlockable emotes.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/emotes]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2EmotesIDs(configure: (RequestBuilder<List<String>>.() -> Unit)? = null): RequestBuilder<List<String>> = request(
    path = "/v2/emotes",
    parameters = mapOfNonNullValues("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(String.serializer()),
    configure = configure
)

/**
 * Creates a request used to query a single [item](GW2v2Emote) by its ID.
 *
 * Returns information about unlockable emotes.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/emotes]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2EmotesByID(id: String, configure: (RequestBuilder<GW2v2Emote>.() -> Unit)? = null): RequestBuilder<GW2v2Emote> = request(
    path = "/v2/emotes",
    parameters = mapOfNonNullValues("id" to id, "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2Emote.serializer(),
    configure = configure
)

/**
 * Creates a request used to query one or more [items](GW2v2Emote) by their IDs.
 *
 * Returns information about unlockable emotes.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/emotes]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2EmotesByIDs(ids: Collection<String>, configure: (RequestBuilder<List<GW2v2Emote>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Emote>> = request(
    path = "/v2/emotes",
    parameters = mapOfNonNullValues("ids" to ids.joinToString(","), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2Emote.serializer()),
    configure = configure
)

/**
 * Creates a request used to query all available [items](GW2v2Emote).
 *
 * Returns information about unlockable emotes.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/emotes]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2EmotesAll(configure: (RequestBuilder<List<GW2v2Emote>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Emote>> = request(
    path = "/v2/emotes",
    parameters = mapOfNonNullValues("ids" to "all", "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2Emote.serializer()),
    configure = configure
)

/**
 * Creates a request used to query one or more [items](GW2v2Emote) by page.
 *
 * Returns information about unlockable emotes.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/emotes]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2EmotesByPage(page: Int, pageSize: Int = 200, configure: (RequestBuilder<List<GW2v2Emote>>.() -> Unit)? = null): RequestBuilder<List<GW2v2Emote>> = request(
    path = "/v2/emotes",
    parameters = mapOfNonNullValues("page" to page.toString(), "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2Emote.serializer()),
    configure = configure
)