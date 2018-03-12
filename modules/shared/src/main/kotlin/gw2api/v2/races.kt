/*
 * Copyright 2018 Leon Linhart
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gw2api.v2

import gw2api.*
import gw2api.misc.*
import kotlinx.serialization.*

/**
 * Queries the `/v2/races` endpoint.
 *
 * ## The /v2/races endpoint
 *
 * > Information about races and their available skills.
 *
 * ```
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Authenticated:       No
 * Localized:           Yes (Chinese, English, French, German, Spanish)
 * Cache time:          24 hours
 * ```
 *
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @return  the request that is used to query the API
 *
 * @see gw2v2RacesById
 * @see gw2v2RacesByIds
 * @see gw2v2RacesByPage
 * @see gw2v2RacesAll
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Suppress("UNUSED")
fun gw2v2RacesIds(): RequestBuilder<Collection<Int>> = query(
    endpoint = "/v2/races",
    isLocalized = true,
    supportedLanguages = API_V2_LANGS,
    converter = jsonArrayParser(JSONIntParser)
).setCacheTime(60 * 60 * 24, false)

/**
 * Queries the `/v2/races` endpoint.
 *
 * ## The /v2/races endpoint
 *
 * > Information about races and their available skills.
 *
 * ```
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Authenticated:       No
 * Localized:           Yes (Chinese, English, French, German, Spanish)
 * Cache time:          24 hours
 * ```
 *
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @param id    the id for the race to query
 *
 * @return  the request that is used to query the API
 *
 * @see gw2v2RacesIds
 * @see gw2v2RacesByIds
 * @see gw2v2RacesByPage
 * @see gw2v2RacesAll
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Suppress("UNUSED")
fun gw2v2RacesById(id: String): RequestBuilder<Race> = query(
    endpoint = "/v2/races",
    isLocalized = true,
    supportedLanguages = API_V2_LANGS,
    converter = jsonParser<Race>(),
    params = mapOf("id" to id)
).setCacheTime(60 * 60 * 24, false)

/**
 * Queries the `/v2/races` endpoint.
 *
 * ## The /v2/races endpoint
 *
 * > Information about races and their available skills.
 *
 * ```
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Authenticated:       No
 * Localized:           Yes (Chinese, English, French, German, Spanish)
 * Cache time:          24 hours
 * ```
 *
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @param ids   the ids for the races to query
 *
 * @return  the request that is used to query the API
 *
 * @see gw2v2RacesIds
 * @see gw2v2RacesById
 * @see gw2v2RacesByPage
 * @see gw2v2RacesAll
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Suppress("UNUSED")
fun gw2v2RacesByIds(ids: Collection<String>): RequestBuilder<Collection<Race>> = query(
    endpoint = "/v2/races",
    isLocalized = true,
    supportedLanguages = API_V2_LANGS,
    converter = jsonArrayParser<Race>(),
    params = mapOf("ids" to ids.joinToString(","))
).setCacheTime(60 * 60 * 24, false)

/**
 * Queries the `/v2/races` endpoint.
 *
 * ## The /v2/races endpoint
 *
 * > Information about races and their available skills.
 *
 * ```
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Authenticated:       No
 * Localized:           Yes (Chinese, English, French, German, Spanish)
 * Cache time:          24 hours
 * ```
 *
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @param page      the index of the page
 * @param pageSize  the size of the page (must be in the range `[1,200]`)
 *
 * @return  the request that is used to query the API
 *
 * @see gw2v2RacesIds
 * @see gw2v2RacesById
 * @see gw2v2RacesByIds
 * @see gw2v2RacesAll
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Suppress("UNUSED")
fun gw2v2RacesByPage(page: Int, pageSize: Int): RequestBuilder<Collection<Race>> = query(
    endpoint = "/v2/races",
    isLocalized = true,
    supportedLanguages = API_V2_LANGS,
    converter = jsonArrayParser<Race>(),
    params = mapOf(
        "page" to page,
        "page_size" to pageSize.let { if (it < 1 || it > 200) throw IllegalArgumentException("Illegal page size") else it }
    )
).setCacheTime(60 * 60 * 24, false)

/**
 * Queries the `/v2/races` endpoint.
 *
 * ## The /v2/races endpoint
 *
 * > Information about races and their available skills.
 *
 * ```
 * Paginated:           Yes
 * Bulk expanded:       Yes
 * Authenticated:       No
 * Localized:           Yes (Chinese, English, French, German, Spanish)
 * Cache time:          24 hours
 * ```
 *
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @return  the request that is used to query the API
 *
 * @see gw2v2RacesIds
 * @see gw2v2RacesById
 * @see gw2v2RacesByIds
 * @see gw2v2RacesByPage
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Suppress("UNUSED")
fun gw2v2RacesAll(): RequestBuilder<Collection<Race>> = query(
    endpoint = "/v2/races",
    converter = jsonArrayParser<Race>(),
    params = mapOf("ids" to "all")
).setCacheTime(60 * 60 * 24, false)

/**
 * Information about races and their available skills.
 *
 * Read more: [https://wiki.guildwars2.com/wiki/API:2/races]
 *
 * @param id        the id of the race
 * @param name      the name of the race
 * @param skills    an array of skill ids resolvable against /v2/skills
 *
 * @see gw2v2RacesIds
 * @see gw2v2RacesById
 * @see gw2v2RacesByIds
 * @see gw2v2RacesByPage
 * @see gw2v2RacesAll
 *
 * @since   0.1.0 (API: 2017-01-20)
 */
@Serializable
data class Race(
    /** @since  0.1.0 (API: 2017-20-01) */
    @Suppress("MemberVisibilityCanBePrivate")
    val id: String,
    /** @since  0.1.0 (API: 2017-20-01) */
    @Suppress("MemberVisibilityCanBePrivate")
    val name: String,
    /** @since  0.1.0 (API: 2017-20-01) */
    @Suppress("MemberVisibilityCanBePrivate")
    val skills: Collection<Int>
)