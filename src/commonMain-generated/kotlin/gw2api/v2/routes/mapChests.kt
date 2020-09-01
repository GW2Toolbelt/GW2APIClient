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

/**
 * Creates a request used to query the list of available IDs.
 *
 * Returns information about the Hero's Choice Chests that can be acquired once per day.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60.0m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/mapchests]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2MapChestsIDs(configure: (RequestBuilder<List<Int>>.() -> Unit)? = null): RequestBuilder<List<Int>> = request(
    path = "/v2/mapchests",
    parameters = mapOf("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(Int.serializer()),
    configure = configure
)

/**
 * Creates a request used to query a single [item](GW2v2MapChest) by its ID.
 *
 * Returns information about the Hero's Choice Chests that can be acquired once per day.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60.0m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/mapchests]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2MapChestsByID(id: Int, configure: (RequestBuilder<GW2v2MapChest>.() -> Unit)? = null): RequestBuilder<GW2v2MapChest> = request(
    path = "/v2/mapchests",
    parameters = mapOf("id" to id.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2MapChest.serializer(),
    configure = configure
)

/**
 * Creates a request used to query one or more [items](GW2v2MapChest) by their IDs.
 *
 * Returns information about the Hero's Choice Chests that can be acquired once per day.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60.0m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/mapchests]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2MapChestsByIDs(ids: Collection<Int>, configure: (RequestBuilder<List<GW2v2MapChest>>.() -> Unit)? = null): RequestBuilder<List<GW2v2MapChest>> = request(
    path = "/v2/mapchests",
    parameters = mapOf("ids" to ids.joinToString(","), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2MapChest.serializer()),
    configure = configure
)

/**
 * Creates a request used to query all available [items](GW2v2MapChest).
 *
 * Returns information about the Hero's Choice Chests that can be acquired once per day.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60.0m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/mapchests]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2MapChestsAll(configure: (RequestBuilder<List<GW2v2MapChest>>.() -> Unit)? = null): RequestBuilder<List<GW2v2MapChest>> = request(
    path = "/v2/mapchests",
    parameters = mapOf("ids" to "all", "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2MapChest.serializer()),
    configure = configure
)

/**
 * Creates a request used to query one or more [items](GW2v2MapChest) by page.
 *
 * Returns information about the Hero's Choice Chests that can be acquired once per day.
 *
 * ```
 * Authenticated:       No
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Localized:           No
 * Cache time:          60.0m
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/mapchests]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2MapChestsByPage(page: Int, pageSize: Int = 200, configure: (RequestBuilder<List<GW2v2MapChest>>.() -> Unit)? = null): RequestBuilder<List<GW2v2MapChest>> = request(
    path = "/v2/mapchests",
    parameters = mapOf("page" to page.toString(), "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = ListSerializer(GW2v2MapChest.serializer()),
    configure = configure
)

/**
 * Information about a Hero's Choice Chests that can be acquired once per day.
 *
 * @param id the ID of the mapchest
 */
@Serializable
public data class GW2v2MapChest(
    val id: Int
)