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
package com.gw2tb.gw2api.types.v1

import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.json.*

@Suppress("ClassName")
private object __JsonParametricSerializer_GW2v1SkinDetails : JsonContentPolymorphicSerializer<GW2v1SkinDetails>(GW2v1SkinDetails::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out GW2v1SkinDetails> {
        return when (element.jsonObject["type"]!!.jsonPrimitive.content) {
            "Armor" -> GW2v1SkinDetails.Armor.serializer()
            "Back" -> GW2v1SkinDetails.Back.serializer()
            "Gathering" -> GW2v1SkinDetails.Gathering.serializer()
            "Weapon" -> GW2v1SkinDetails.Weapon.serializer()
            else -> TODO()
        }
    }
}

/**
 * Information about a skin.
 *
 * @property skinID 
 * @property name the skin's localized name
 * @property type the skin's type
 * @property rarity the skin's rarity
 * @property flags additional skin flags (ShowInWardrobe, NoCost, HideIfLocked, OverrideRarity)
 * @property restrictions the IDs of the races that can use this skin, or empty if it can be used by any race
 * @property iconFileID the icon's file ID to be used with the render service
 * @property iconFileSignature the icon's file signature to be used with the render service
 */
@Serializable(with = __JsonParametricSerializer_GW2v1SkinDetails::class)
public sealed class GW2v1SkinDetails {

    public abstract val skinID: Int
    public abstract val name: String
    public abstract val type: String
    public abstract val rarity: String
    public abstract val flags: List<String>
    public abstract val restrictions: List<String>
    public abstract val iconFileID: String
    public abstract val iconFileSignature: String

    @Suppress("ClassName")
    @Serializer(forClass = Armor::class)
    private object __ArmorGeneratedSerializer : KSerializer<Armor>

    @Suppress("ClassName")
    private object __ArmorSerializer : JsonTransformingSerializer<Armor>(__ArmorGeneratedSerializer) {
        override fun transformDeserialize(element: JsonElement): JsonElement =
            JsonObject(element.jsonObject - "__virtualType")
    }

    /**
     * Additional information about an armor skin.
     *
     * @param armorType the skin's armor slot
     * @param weightClass the skin's armor weight
     * @param dyeSlots the skin's dye slots
     */
    @Serializable(with = __ArmorSerializer::class)
    public data class Armor(
        @SerialName("skin_id")
        override val skinID: Int,
        override val name: String,
        override val type: String,
        override val rarity: String,
        override val flags: List<String>,
        override val restrictions: List<String>,
        @SerialName("icon_file_id")
        override val iconFileID: String,
        @SerialName("icon_file_signature")
        override val iconFileSignature: String,
        val armor: Armor
    ) : GW2v1SkinDetails() {

        /**
         * Additional information about an armor skin.
         *
         * @param armorType the skin's armor slot
         * @param weightClass the skin's armor weight
         * @param dyeSlots the skin's dye slots
         */
        @Serializable
        public data class Armor(
            @SerialName("type")
            val armorType: String,
            @SerialName("weight_class")
            val weightClass: String,
            @SerialName("dye_slots")
            val dyeSlots: DyeSlots
        )

        /**
         * Information about a skin's sye slots.
         *
         * @param asuraMale the dye slot overrides for asuarn male characters
         * @param asuraFemale the dye slot overrides for asuarn female characters
         * @param charrMale the dye slot overrides for charr male characters
         * @param charrFemale the dye slot overrides for charr female characters
         * @param humanMale the dye slot overrides for human male characters
         * @param humanFemale the dye slot overrides for human female characters
         * @param nornMale the dye slot overrides for norn male characters
         * @param nornFemale the dye slot overrides for norn female characters
         * @param sylvariMale the dye slot overrides for sylvari male characters
         * @param sylvariFemale the dye slot overrides for sylvari female characters
         */
        @Serializable
        public data class DyeSlots(
            @SerialName("asura_male")
            val asuraMale: List<DyeSlot?>,
            @SerialName("asura_female")
            val asuraFemale: List<DyeSlot?>,
            @SerialName("charr_male")
            val charrMale: List<DyeSlot?>,
            @SerialName("charr_female")
            val charrFemale: List<DyeSlot?>,
            @SerialName("human_male")
            val humanMale: List<DyeSlot?>,
            @SerialName("human_female")
            val humanFemale: List<DyeSlot?>,
            @SerialName("norn_male")
            val nornMale: List<DyeSlot?>,
            @SerialName("norn_female")
            val nornFemale: List<DyeSlot?>,
            @SerialName("sylvari_male")
            val sylvariMale: List<DyeSlot?>,
            @SerialName("sylvari_female")
            val sylvariFemale: List<DyeSlot?>
        ) {

            /**
             * Information about a dye slot.
             *
             * @param colorID the default color's ID
             * @param material the material type
             */
            @Serializable
            public data class DyeSlot(
                @SerialName("color_id")
                val colorID: Int,
                val material: String
            )

        }

    }

    @Suppress("ClassName")
    @Serializer(forClass = Back::class)
    private object __BackGeneratedSerializer : KSerializer<Back>

    @Suppress("ClassName")
    private object __BackSerializer : JsonTransformingSerializer<Back>(__BackGeneratedSerializer) {
        override fun transformDeserialize(element: JsonElement): JsonElement =
            JsonObject(element.jsonObject - "__virtualType")
    }

    /** Additional information about a backpack skin. */
    @Serializable(with = __BackSerializer::class)
    public data class Back(
        @SerialName("skin_id")
        override val skinID: Int,
        override val name: String,
        override val type: String,
        override val rarity: String,
        override val flags: List<String>,
        override val restrictions: List<String>,
        @SerialName("icon_file_id")
        override val iconFileID: String,
        @SerialName("icon_file_signature")
        override val iconFileSignature: String,
        val back: Back
    ) : GW2v1SkinDetails() {

        /** Additional information about a backpack skin. */
        @Serializable
        public object Back

    }

    @Suppress("ClassName")
    @Serializer(forClass = Gathering::class)
    private object __GatheringGeneratedSerializer : KSerializer<Gathering>

    @Suppress("ClassName")
    private object __GatheringSerializer : JsonTransformingSerializer<Gathering>(__GatheringGeneratedSerializer) {
        override fun transformDeserialize(element: JsonElement): JsonElement =
            JsonObject(element.jsonObject - "__virtualType")
    }

    /** Additional information about a gathering tool skin. */
    @Serializable(with = __GatheringSerializer::class)
    public data class Gathering(
        @SerialName("skin_id")
        override val skinID: Int,
        override val name: String,
        override val type: String,
        override val rarity: String,
        override val flags: List<String>,
        override val restrictions: List<String>,
        @SerialName("icon_file_id")
        override val iconFileID: String,
        @SerialName("icon_file_signature")
        override val iconFileSignature: String,
        val gathering: Gathering
    ) : GW2v1SkinDetails() {

        /** Additional information about a gathering tool skin. */
        @Serializable
        public object Gathering

    }

    @Suppress("ClassName")
    @Serializer(forClass = Weapon::class)
    private object __WeaponGeneratedSerializer : KSerializer<Weapon>

    @Suppress("ClassName")
    private object __WeaponSerializer : JsonTransformingSerializer<Weapon>(__WeaponGeneratedSerializer) {
        override fun transformDeserialize(element: JsonElement): JsonElement =
            JsonObject(element.jsonObject - "__virtualType")
    }

    /**
     * Additional information about a gathering tool skin.
     *
     * @param weaponType the skin's weapon type
     * @param damageType the skin's damage type
     */
    @Serializable(with = __WeaponSerializer::class)
    public data class Weapon(
        @SerialName("skin_id")
        override val skinID: Int,
        override val name: String,
        override val type: String,
        override val rarity: String,
        override val flags: List<String>,
        override val restrictions: List<String>,
        @SerialName("icon_file_id")
        override val iconFileID: String,
        @SerialName("icon_file_signature")
        override val iconFileSignature: String,
        val weapon: Weapon
    ) : GW2v1SkinDetails() {

        /**
         * Additional information about a gathering tool skin.
         *
         * @param weaponType the skin's weapon type
         * @param damageType the skin's damage type
         */
        @Serializable
        public data class Weapon(
            @SerialName("type")
            val weaponType: String,
            @SerialName("damage_type")
            val damageType: String
        )

    }

}