package com.mcnair.atomic.worldgen.tree;

import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.util.parsing.packrat.Atom;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AtomicTreeConfiguration {

    // net.minecraft.data.worldgen.features.TreeFeatures

    public static TreeConfiguration.TreeConfigurationBuilder createAshenwood() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AtomicBlocks.ASHENWOOD_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                new WeightedStateProvider(
                        WeightedList.<BlockState>builder()
                                .add(AtomicBlocks.ASHENWOOD_LEAVES.get().defaultBlockState(), 4)
                                .add(AtomicBlocks.ASHENWOOD_LEAVES_FLOWERING.get().defaultBlockState(), 1)),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        );
    }
}
