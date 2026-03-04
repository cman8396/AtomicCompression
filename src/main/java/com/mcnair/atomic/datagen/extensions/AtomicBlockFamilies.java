package com.mcnair.atomic.datagen.extensions;

import com.google.common.collect.Maps;
import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class AtomicBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    private static final String GROUP_PREFIX_WOODEN = "wooden";
    private static final String UNLOCKED_BY_WOODEN = "has_planks";

    public static final BlockFamily FIR_PLANKS = familyBuilder(AtomicBlocks.ASHENWOOD_PLANKS.get())
            .stairs(AtomicBlocks.ASHENWOOD_STAIRS.get())
            .slab(AtomicBlocks.ASHENWOOD_SLAB.get())
            .pressurePlate(AtomicBlocks.ASHENWOOD_PRESSURE_PLATE.get())
            .button(AtomicBlocks.ASHENWOOD_BUTTON.get())
            .fence(AtomicBlocks.ASHENWOOD_FENCE.get())
            .fenceGate(AtomicBlocks.ASHENWOOD_FENCE_GATE.get())
            .wall(AtomicBlocks.ASHENWOOD_WALL.get())
            .door(AtomicBlocks.ASHENWOOD_DOOR.get())
            .trapdoor(AtomicBlocks.ASHENWOOD_TRAPDOOR.get())
            .recipeGroupPrefix(GROUP_PREFIX_WOODEN)
            .recipeUnlockedBy(UNLOCKED_BY_WOODEN)
            .getFamily();


    private static BlockFamily.Builder familyBuilder(Block block) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(block);
        BlockFamily blockfamily = MAP.put(block, blockfamily$builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(block));
        } else {
            return blockfamily$builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}