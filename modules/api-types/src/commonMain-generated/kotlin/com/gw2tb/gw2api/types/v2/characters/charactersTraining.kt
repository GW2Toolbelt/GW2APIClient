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
 * Information about a character's (skill-tree) training.
 *
 * @param training the training information for a character's trained skill-trees
 */
@Serializable
public data class GW2v2CharactersTraining(
    val training: List<Training>
) {

    /**
     * Information about a character's trained skill-tree.
     *
     * @param id the skill tree's ID
     * @param spent the amount of hero points spent in the tree
     * @param done a flag indicating whether or not the tree is fully trained
     */
    @Serializable
    public data class Training(
        val id: Int,
        val spent: Int,
        val done: Boolean
    )

}