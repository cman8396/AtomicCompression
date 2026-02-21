package com.mcnair.atomic.worldgen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class AtomicConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfurc_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALTPETER_ORE_KEY = registerKey("saltpeter_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ATOMIC_ORE_KEY = registerKey("atomic_ore_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUNGERITE_ORE_KEY = registerKey("bungerite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ATOMIC_ORE_KEY = registerKey("nether_atomic_ore_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ATOMIC_ORE_KEY = registerKey("end_atomic_ore_placed");

//    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODWOOD_KEY = registerKey("bloodwood");
//    public static final ResourceKey<ConfiguredFeature<?, ?>> GOJI_BERRY_BUSH_KEY = registerKey("goji_berry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.SULFUR_ORE.get().defaultBlockState(), 9));
        register(context, SALTPETER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.SALTPETER_ORE.get().defaultBlockState(), 6));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.LEAD_ORE.get().defaultBlockState(), 9));
        register(context, ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.ATOMIC_ORE.get().defaultBlockState(), 2));


        register(context, BUNGERITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                AtomicBlocks.BUNGERITE_ORE.get().defaultBlockState(), 6));
        register(context, NETHER_ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                AtomicBlocks.NETHER_ATOMIC_ORE.get().defaultBlockState(), 2));


        register(context, END_ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                AtomicBlocks.END_ATOMIC_ORE.get().defaultBlockState(), 2));




//        List<OreConfiguration.TargetBlockState> overworldBismuthOres = List.of(
//                OreConfiguration.target(stoneReplaceables, AtomicBlocks.BISMUTH_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceables, AtomicBlocks.BISMUTH_DEEPSLATE_ORE.get().defaultBlockState()));
//
//        register(context, OVERWORLD_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBismuthOres, 9));
//        register(context, NETHER_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
//                AtomicBlocks.BISMUTH_NETHER_ORE.get().defaultBlockState(), 9));
//        register(context, END_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
//                AtomicBlocks.BISMUTH_END_ORE.get().defaultBlockState(), 9));
//
//
//        register(context, BLOODWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                BlockStateProvider.simple(AtomicBlocks.BLOODWOOD_LOG.get()),
//                new ForkingTrunkPlacer(4, 4, 3),
//
//                BlockStateProvider.simple(AtomicBlocks.BLOODWOOD_LEAVES.get()),
//                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
//
//                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.NETHERRACK)).build());
//
//        register(context, GOJI_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
//                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
//                        new SimpleBlockConfiguration(BlockStateProvider.simple(AtomicBlocks.GOJI_BERRY_BUSH.get()
//                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
//                        ), List.of(Blocks.GRASS_BLOCK)));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
