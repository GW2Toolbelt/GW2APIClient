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
import gw2api.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.json.*
import kotlin.jvm.*

/**
 * Creates a request used to query the resource.
 *
 * Returns information about a player's account.
 *
 * ```
 * Authenticated:       Yes (ACCOUNT)
 * Paginated:           No
 * Bulk expanded:       No
 * Localized:           No
 * Cache time:          N/A
 * ```
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/account]
 *
 * @receiver        the client instance used to make the request
 * @param configure configure action for the request
 *
 * @return  the request that can be executed to query the API
 */
public fun GW2APIClient.gw2v2Account(configure: (RequestBuilder<GW2v2Account>.() -> Unit)? = null): RequestBuilder<GW2v2Account> = request(
    path = "/v2/account",
    parameters = mapOfNonNullValues("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(),
    requiresAuthentication = true,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2Account.serializer(),
    configure = configure
)

/**
 * Information about a player's account.
 *
 * @param id the unique persistent account GUID
 * @param age the age of the account in seconds
 * @param name the unique account name
 * @param world the ID of the home world the account is assigned to
 * @param guilds an array containing the IDs of all guilds the account is a member in
 * @param guildLeader an array containing the IDs of all guilds the account is a leader of
 * @param created the ISO-8601 standard timestamp of when the account was created
 * @param access an array of what content this account has access to
 * @param commander a flag indicating whether or not the commander tag is unlocked for the account
 * @param fractalLevel the account's personal fractal level
 * @param dailyAP the daily AP the account has
 * @param monthlyAP the monthly AP the account has
 * @param wvwRank the account's personal wvw rank
 * @param lastModified the ISO-8601 standard timestamp of when the account information last changed (as perceived by the API)
 */
@Serializable
public data class GW2v2Account(
    val id: String,
    val age: Int,
    val name: String,
    val world: Int,
    val guilds: List<String>,
    @SerialName("guild_leader")
    val guildLeader: List<String>? = null,
    val created: String,
    val access: List<String>,
    val commander: Boolean,
    @SerialName("fractal_level")
    val fractalLevel: Int? = null,
    @SerialName("daily_ap")
    val dailyAP: Int? = null,
    @SerialName("monthly_ap")
    val monthlyAP: Int? = null,
    @SerialName("wvw_rank")
    val wvwRank: Int? = null,
    @SerialName("last_modified")
    val lastModified: String
)