package com.mcnair.atomic.worldgen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.worldgen.system.AtomicOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AtomicPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registerKey("sulfur_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_SULFUR_ORE_PLACED_KEY = registerKey("deepslate_sulfur_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPCOAL_ORE_PLACED_KEY = registerKey("deepcoal_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_DEEPCOAL_ORE_PLACED_KEY = registerKey("deepslate_deepcoal_ore_placed");
    public static final ResourceKey<PlacedFeature> SALTPETER_ORE_PLACED_KEY = registerKey("saltpeter_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_SALTPETER_ORE_PLACED_KEY = registerKey("deepslate_saltpeter_ore_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_LEAD_ORE_PLACED_KEY = registerKey("deepslate_lead_ore_placed");
    public static final ResourceKey<PlacedFeature> BRIGHTSILVER_ORE_PLACED_KEY = registerKey("brightsilver_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_BRIGHTSILVER_ORE_PLACED_KEY = registerKey("deepslate_brightsilver_ore_placed");
    public static final ResourceKey<PlacedFeature> BUNGERITE_ORE_PLACED_KEY = registerKey("bungerite_ore_placed");
    public static final ResourceKey<PlacedFeature> SOULSTEEL_ORE_PLACED_KEY = registerKey("soulsteel_ore_placed");

    public static final ResourceKey<PlacedFeature> ATOMIC_ORE_PLACED_KEY = registerKey("atomic_ore_placed");
    public static final ResourceKey<PlacedFeature> DEEPSLATE_ATOMIC_ORE_PLACED_KEY = registerKey("deepslate_atomic_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ATOMIC_ORE_PLACED_KEY = registerKey("nether_atomic_ore_placed");
    public static final ResourceKey<PlacedFeature> END_ATOMIC_ORE_PLACED_KEY = registerKey("end_atomic_ore_placed");


    public static final ResourceKey<PlacedFeature> ASHENWOOD_PLACED_KEY = registerKey("ashenwood_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        var netherFullHeightSpawnRange = HeightRangePlacement.uniform(VerticalAnchor.absolute(7), VerticalAnchor.absolute(120));
        var endFullHeightSpawnRange = HeightRangePlacement.uniform(VerticalAnchor.absolute(7), VerticalAnchor.absolute(120));


        register(context, DEEPCOAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPCOAL_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_DEEPCOAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_DEEPCOAL_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.SULFUR_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_SULFUR_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, SALTPETER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.SALTPETER_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_SALTPETER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_SALTPETER_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.LEAD_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_LEAD_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, BRIGHTSILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.BRIGHTSILVER_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_BRIGHTSILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_BRIGHTSILVER_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, BUNGERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.BUNGERITE_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(6, netherFullHeightSpawnRange));
        register(context, SOULSTEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.SOULSTEEL_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(4, netherFullHeightSpawnRange));

        register(context, ATOMIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.ATOMIC_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, DEEPSLATE_ATOMIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.DEEPSLATE_ATOMIC_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(90))));
        register(context, NETHER_ATOMIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.NETHER_ATOMIC_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(3, netherFullHeightSpawnRange));
        register(context, END_ATOMIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.END_ATOMIC_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(3, endFullHeightSpawnRange));


        register(context, ASHENWOOD_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.ASHENWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05f, 1),
                        AtomicBlocks.ASHENWOOD_SAPLING.get()));

//        register(context, GOJI_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GOJI_BERRY_BUSH_KEY),
//                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
