package com.mcnair.atomic.worldgen.tree;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.worldgen.AtomicConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AtomicTreeGrower {
    public static final TreeGrower ASHENWOOD = new TreeGrower(AtomicCompression.MOD_ID + ":ashenwood",
            Optional.empty(), Optional.of(AtomicConfiguredFeatures.ASHENWOOD_KEY), Optional.empty());

}