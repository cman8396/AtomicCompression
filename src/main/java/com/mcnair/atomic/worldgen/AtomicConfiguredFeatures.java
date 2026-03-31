package com.mcnair.atomic.worldgen;

import com.google.common.collect.ImmutableList;
import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.worldgen.tree.AtomicTreeConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.PaleMossDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class AtomicConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfurc_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_SULFUR_ORE_KEY = registerKey("deepslate_sulfurc_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALTPETER_ORE_KEY = registerKey("saltpeter_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_SALTPETER_ORE_KEY = registerKey("deepslate_saltpeter_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_LEAD_ORE_KEY = registerKey("deepslate_lead_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIGHTSILVER_ORE_KEY = registerKey("brightsilver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_BRIGHTSILVER_ORE_KEY = registerKey("deepslate_brightsilver_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUNGERITE_ORE_KEY = registerKey("bungerite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOULSTEEL_ORE_KEY = registerKey("soulsteel_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ATOMIC_ORE_KEY = registerKey("atomic_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_ATOMIC_ORE_KEY = registerKey("deepslate_atomic_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ATOMIC_ORE_KEY = registerKey("nether_atomic_ore_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ATOMIC_ORE_KEY = registerKey("end_atomic_ore_placed");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHENWOOD_KEY = registerKey("ashenwood_placed");
//    public static final ResourceKey<ConfiguredFeature<?, ?>> GOJI_BERRY_BUSH_KEY = registerKey("goji_berry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        /* ORES */
        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.SULFUR_ORE.get().defaultBlockState(), 9));
        register(context, DEEPSLATE_SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                AtomicBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState(), 9));
        register(context, SALTPETER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.SALTPETER_ORE.get().defaultBlockState(), 6));
        register(context, DEEPSLATE_SALTPETER_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get().defaultBlockState(), 6));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.LEAD_ORE.get().defaultBlockState(), 9));
        register(context, DEEPSLATE_LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                AtomicBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState(), 9));
        register(context, BRIGHTSILVER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.BRIGHTSILVER_ORE.get().defaultBlockState(), 7));
        register(context, DEEPSLATE_BRIGHTSILVER_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                AtomicBlocks.DEEPSLATE_BRIGHTSILVER_ORE.get().defaultBlockState(), 7));
        register(context, BUNGERITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                AtomicBlocks.BUNGERITE_ORE.get().defaultBlockState(), 6));
        register(context, SOULSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                AtomicBlocks.SOULSTEEL_ORE.get().defaultBlockState(), 4));

        register(context, ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                AtomicBlocks.ATOMIC_ORE.get().defaultBlockState(), 2));
        register(context, DEEPSLATE_ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables,
                AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get().defaultBlockState(), 2));
        register(context, NETHER_ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                AtomicBlocks.NETHER_ATOMIC_ORE.get().defaultBlockState(), 2));
        register(context, END_ATOMIC_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                AtomicBlocks.END_ATOMIC_ORE.get().defaultBlockState(), 2));


        /* TREES */
        register(context, ASHENWOOD_KEY, Feature.TREE,
                AtomicTreeConfiguration.createAshenwood().forceDirt().build());


//        List<OreConfiguration.TargetBlockState> overworldBismuthOres = List.of(
//                OreConfiguration.target(stoneReplaceables, AtomicBlocks.BISMUTH_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceables, AtomicBlocks.BISMUTH_DEEPSLATE_ORE.get().defaultBlockState()));
//
//        register(context, OVERWORLD_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBismuthOres, 9));
//        register(context, NETHER_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
//                AtomicBlocks.BISMUTH_NETHER_ORE.get().defaultBlockState(), 9));
//        register(context, END_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
//                AtomicBlocks.BISMUTH_END_ORE.get().defaultBlockState(), 9));

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
