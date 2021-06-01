/*
 * Copyright (c) 2018-2021 Leon Linhart
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
@file:Suppress("PackageDirectoryMismatch", "UnusedImport")
package com.gw2tb.gw2api.types.v2

import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.json.*

/**
 * Information about an account's PvP game.
 *
 * @param id the game's ID
 * @param mapID the map's ID
 * @param started the ISO-8601 standard timestamp of when the game started
 * @param ended the ISO-8601 standard timestamp of when the game ended
 * @param result the game's result for the account ("Victory" or "Defeat")
 * @param team the player's team ("Blue" or "Red")
 * @param profession the ID of the player's profession
 * @param ratingType the type of rating of the game
 * @param ratingChange the change in rating for the account
 * @param season the ID of the game's PvP season
 * @param scores the game's final scores
 */
@Serializable
public data class GW2v2PvPGame(
    val id: String,
    @SerialName("map_id")
    val mapID: Int,
    val started: String,
    val ended: String,
    val result: String,
    val team: String,
    val profession: String,
    @SerialName("rating_type")
    val ratingType: String,
    @SerialName("rating_change")
    val ratingChange: Int? = null,
    val season: String? = null,
    val scores: Scores
) {

    /**
     * Information about a PvP game's scores.
     *
     * @param red the red team's score
     * @param blue the blue team's score
     */
    @Serializable
    public data class Scores(
        val red: Int,
        val blue: Int
    )

}