package com.mcnair.atomic.utility.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class CommonItemTags {
    private CommonItemTags() {}

    public static final TagKey<Item> ORES_SULFUR = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ores/sulfur"));
    public static final TagKey<Item> ORES_SALTPETER = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ores/saltpeter"));
    public static final TagKey<Item> ORES_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ores/lead"));
    public static final TagKey<Item> ORES_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ores/bungerite"));
    public static final TagKey<Item> ORES_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ores/atomic"));

    public static final TagKey<Item> STORAGE_BLOCKS_RAW_SULFUR = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_sulfur"));
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_SALTPETER = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_saltpeter"));
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_lead"));
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_bungerite"));

    public static final TagKey<Item> STORAGE_BLOCKS_GUNPOWDER = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/gunpowder"));
    public static final TagKey<Item> STORAGE_BLOCKS_SULFUR_DUST = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/sulfur"));
    public static final TagKey<Item> STORAGE_BLOCKS_SALTPETER_DUST = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/saltpeter"));

    public static final TagKey<Item> STORAGE_BLOCKS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/lead"));
    public static final TagKey<Item> STORAGE_BLOCKS_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/refined_bungerite"));
    public static final TagKey<Item> STORAGE_BLOCKS_BUNGERITE_ALLOY = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/bungerite_alloy"));
    public static final TagKey<Item> STORAGE_BLOCKS_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/atomic"));
    public static final TagKey<Item> STORAGE_BLOCKS_EMPOWERED_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/empowered_atomic"));

    public static final TagKey<Item> RAW_MATERIALS_SULFUR = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "raw_materials/sulfur"));
    public static final TagKey<Item> RAW_MATERIALS_SALTPETER = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "raw_materials/saltpeter"));
    public static final TagKey<Item> RAW_MATERIALS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "raw_materials/lead"));
    public static final TagKey<Item> RAW_MATERIALS_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "raw_materials/bungerite"));

    public static final TagKey<Item> DUSTS_WOOD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/wood"));

    public static final TagKey<Item> DUSTS_SULFUR = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/sulfur"));
    public static final TagKey<Item> DUSTS_SALTPETER = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/saltpeter"));
    public static final TagKey<Item> DUSTS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/lead"));
    public static final TagKey<Item> DUSTS_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/refined_bungerite"));
    public static final TagKey<Item> DUSTS_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "dusts/atomic"));

    public static final TagKey<Item> NUGGETS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "nuggets/lead"));
    public static final TagKey<Item> NUGGETS_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "nuggets/refined_bungerite"));
    public static final TagKey<Item> NUGGETS_BUNGERITE_ALLOY = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "nuggets/bungerite_alloy"));

    public static final TagKey<Item> CHUNKS = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "chunks"));
    public static final TagKey<Item> CHUNKS_OBSIDIAN = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "chunks/obsidian"));

    public static final TagKey<Item> SHARDS = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "shards"));
    public static final TagKey<Item> SHARDS_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "shards/atomic"));

    public static final TagKey<Item> GEMS_ATOMIC = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "gems/atomic"));

    public static final TagKey<Item> INGOTS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ingots/lead"));
    public static final TagKey<Item> INGOTS_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ingots/refined_bungerite"));
    public static final TagKey<Item> INGOTS_BUNGERITE_ALLOY = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "ingots/bungerite_alloy"));

    public static final TagKey<Item> PLATES = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "plates"));
    public static final TagKey<Item> PLATES_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "plates/lead"));
    public static final TagKey<Item> PLATES_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "plates/refined_bungerite"));
    public static final TagKey<Item> PLATES_BUNGERITE_ALLOY = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "plates/bungerite_alloy"));

    public static final TagKey<Item> RODS = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "rods"));
    public static final TagKey<Item> RODS_LEAD = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "rods/lead"));
    public static final TagKey<Item> RODS_REFINED_BUNGERITE = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "rods/refined_bungerite"));
    public static final TagKey<Item> RODS_BUNGERITE_ALLOY = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath("c", "rods/bungerite_alloy"));

//    public static final TagKey<Item> GEARS = TagKey.create(Registries.ITEM,
//            Identifier.fromNamespaceAndPath("c", "gears"));
//    public static final TagKey<Item> GEARS_IRON = TagKey.create(Registries.ITEM,
//            Identifier.fromNamespaceAndPath("c", "gears/iron"));

}