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
import gw2api.extra.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlin.jvm.*

fun GW2APIClient.gw2v2CommerceListingsIds(configure: (RequestBuilder<List<Int>>.() -> Unit)? = null): RequestBuilder<List<Int>> = request(
    path = "/v2/commerce/listings",
    parameters = mapOf("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = emptyMap(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = Int.serializer().list,
    configure = configure
)

fun GW2APIClient.gw2v2CommerceListingsById(id: Int, configure: (RequestBuilder<GW2v2CommerceListings>.() -> Unit)? = null): RequestBuilder<GW2v2CommerceListings> = request(
    path = "/v2/commerce/listings",
    parameters = mapOf("id" to id.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = emptyMap(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2CommerceListings.serializer(),
    configure = configure
)

fun GW2APIClient.gw2v2CommerceListingsByIds(ids: Collection<Int>, configure: (RequestBuilder<List<GW2v2CommerceListings>>.() -> Unit)? = null): RequestBuilder<List<GW2v2CommerceListings>> = request(
    path = "/v2/commerce/listings",
    parameters = mapOf("ids" to ids.joinToString(","), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = emptyMap(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2CommerceListings.serializer().list,
    configure = configure
)

fun GW2APIClient.gw2v2CommerceListingsByPage(page: Int, pageSize: Int, configure: (RequestBuilder<List<GW2v2CommerceListings>>.() -> Unit)? = null): RequestBuilder<List<GW2v2CommerceListings>> = request(
    path = "/v2/commerce/listings",
    parameters = mapOf("page" to page.toString(), "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }.toString(), "v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = emptyMap(),
    requiresAuthentication = false,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2CommerceListings.serializer().list,
    configure = configure
)

@Serializable
data class GW2v2CommerceListings(
    val id: Int,
    val buys: List<Buys>,
    val sells: List<Sells>
) {

    @Serializable
    data class Buys(
        val listings: Int,
        @SerialName("unit_price")
        val unitPrice: Int,
        val quantity: Int
    )

    @Serializable
    data class Sells(
        val listings: Int,
        @SerialName("unit_price")
        val unitPrice: Int,
        val quantity: Int
    )

}