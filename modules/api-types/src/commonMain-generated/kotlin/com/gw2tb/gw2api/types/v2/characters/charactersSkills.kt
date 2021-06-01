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
 * Information about a character's equipped skills.
 *
 * @param skills the character's equipped skills
 */
@Serializable
public data class GW2v2CharactersSkills(
    val skills: Skills
) {

    /**
     * Information about a character's equipped skills.
     *
     * @param pve the character's PvE skills
     * @param pvp the character's PvP skills
     * @param wvw the character's WvW skills
     */
    @Serializable
    public data class Skills(
        val pve: Skills,
        val pvp: Skills,
        val wvw: Skills
    ) {

        /**
         * Information about a character's equipped skills.
         *
         * @param heal the heal skill's ID
         * @param utilities the IDs of the utility skills
         * @param elite the elite skill's ID
         * @param legends the legend IDs
         */
        @Serializable
        public data class Skills(
            val heal: Int? = null,
            val utilities: List<Int?>,
            val elite: Int? = null,
            val legends: List<String?>? = null
        )

    }

}