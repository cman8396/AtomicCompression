package com.mcnair.atomic.worldgen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.worldgen.system.AtomicOrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AtomicPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BUNGERITE_ORE_PLACED_KEY = registerKey("bungerite_ore_placed");
    public static final ResourceKey<PlacedFeature> ATOMIC_ORE_PLACED_KEY = registerKey("atomic_ore_placed");
    public static final ResourceKey<PlacedFeature> DENSE_BASALT_PLACED_KEY = registerKey("dense_basalt_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        var netherFullHeightSpawnRange = HeightRangePlacement.uniform(VerticalAnchor.absolute(7), VerticalAnchor.absolute(120));

        register(context, BUNGERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.BUNGERITE_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(4, netherFullHeightSpawnRange));
        register(context, ATOMIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.BUNGERITE_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(6, netherFullHeightSpawnRange));
        register(context, DENSE_BASALT_PLACED_KEY, configuredFeatures.getOrThrow(AtomicConfiguredFeatures.BUNGERITE_ORE_KEY),
                AtomicOrePlacement.commonOrePlacement(8, netherFullHeightSpawnRange));


//        register(context, BLOODWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOODWOOD_KEY),
//                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
//                        ModBlocks.BLOODWOOD_SAPLING.get()));
//
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
