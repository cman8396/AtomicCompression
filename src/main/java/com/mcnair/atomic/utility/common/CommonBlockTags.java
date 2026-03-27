package com.mcnair.atomic.utility.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class CommonBlockTags {
    private CommonBlockTags() {}

    public static final TagKey<Block> ORES_SULFUR = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "ores/sulfur"));
    public static final TagKey<Block> ORES_SALTPETER = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "ores/saltpeter"));
    public static final TagKey<Block> ORES_LEAD = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "ores/lead"));
    public static final TagKey<Block> ORES_BUNGERITE = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "ores/bungerite"));
    public static final TagKey<Block> ORES_ATOMIC = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "ores/atomic"));

    public static final TagKey<Block> STORAGE_BLOCKS_RAW_SULFUR = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_sulfur"));
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_SALTPETER = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_saltpeter"));
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_LEAD = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_lead"));
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_BUNGERITE = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_bungerite"));

    public static final TagKey<Block> STORAGE_BLOCKS_GUNPOWDER = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/gunpowder"));
    public static final TagKey<Block> STORAGE_BLOCKS_SULFUR_DUST = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/sulfur"));
    public static final TagKey<Block> STORAGE_BLOCKS_SALTPETER_DUST = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/saltpeter"));

    public static final TagKey<Block> STORAGE_BLOCKS_LEAD = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/lead"));
    public static final TagKey<Block> STORAGE_BLOCKS_REFINED_BUNGERITE = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/refined_bungerite"));
    public static final TagKey<Block> STORAGE_BLOCKS_BUNGERITE_ALLOY = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/bungerite_alloy"));
    public static final TagKey<Block> STORAGE_BLOCKS_ATOMIC = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/atomic"));
    public static final TagKey<Block> STORAGE_BLOCKS_EMPOWERED_ATOMIC = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath("c", "storage_blocks/empowered_atomic"));
}