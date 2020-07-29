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
import kotlinx.serialization.json.*
import kotlin.jvm.*

fun GW2APIClient.gw2v2CharactersInventory(id: String, configure: (RequestBuilder<GW2v2CharactersInventory>.() -> Unit)? = null): RequestBuilder<GW2v2CharactersInventory> = request(
    path = "/v2/characters/:id/inventory",
    parameters = mapOf("v" to "2019-12-19T00:00:00.000Z"),
    replaceInPath = mapOf(":id" to id),
    requiresAuthentication = true,
    requiredPermissions = emptySet(),
    supportedLanguages = emptySet(),
    serializer = GW2v2CharactersInventory.serializer(),
    configure = configure
)

@Serializable
data class GW2v2CharactersInventory(
    val bags: List<Bags>
) {

    @Serializable
    data class Bags(
        val id: Int,
        val size: Int,
        val inventory: List<Inventory?>
    ) {
    
        @Serializable
        data class Inventory(
            val id: Int,
            val count: Int,
            val charges: Int? = null,
            val skin: Int? = null,
            val upgrades: List<Int>? = null,
            @SerialName("upgrade_slot_indices")
            val upgradeSlotIndices: List<Int>? = null,
            val infusions: List<Int>? = null,
            val stats: Stats? = null,
            val binding: String? = null,
            @SerialName("bound_to")
            val boundTo: String? = null
        ) {
    
            @Serializable
            data class Stats(
                val id: Int,
                @SerialName("Power")
                val power: Int? = null,
                @SerialName("Precision")
                val precision: Int? = null,
                @SerialName("Toughness")
                val toughness: Int? = null,
                @SerialName("Vitality")
                val vitality: Int? = null,
                @SerialName("ConditionDamage")
                val conditionDamage: Int? = null,
                @SerialName("ConditionDuration")
                val conditionDuration: Int? = null,
                @SerialName("Healing")
                val healing: Int? = null,
                @SerialName("BoonDuration")
                val boonDuration: Int? = null
            )
    
        }
    
    }

}