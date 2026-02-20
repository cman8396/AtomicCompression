package com.mcnair.atomic.worldgen;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class AtomicBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_SULFUR_ORE = registerKey("add_sulfur_ore");
    public static final ResourceKey<BiomeModifier> ADD_SALTPETER_ORE = registerKey("add_saltpeter_ore");
    public static final ResourceKey<BiomeModifier> ADD_ATOMIC_ORE = registerKey("add_atomic_ore");

    public static final ResourceKey<BiomeModifier> ADD_BUNGERITE_ORE = registerKey("add_bungerite_ore");
    public static final ResourceKey<BiomeModifier> ADD_ATOMIC_ORE_NETHER = registerKey("add_atomic_ore_nether");

    public static final ResourceKey<BiomeModifier> ADD_ATOMIC_ORE_END = registerKey("add_atomic_ore_end");


//    public static final ResourceKey<BiomeModifier> ADD_TREE_BLOODWOOD = registerKey("add_tree_bloodwood");
//    public static final ResourceKey<BiomeModifier> ADD_GOJI_BERRY_BUSH = registerKey("add_goji_berry_bush");
//    public static final ResourceKey<BiomeModifier> SPAWN_GECKO = registerKey("spawn_gecko");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_SULFUR_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.SULFUR_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_SALTPETER_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.SALTPETER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_ATOMIC_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.ATOMIC_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_BUNGERITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.BUNGERITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_ATOMIC_ORE_NETHER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.ATOMIC_ORE_NETHER_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ATOMIC_ORE_END, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(AtomicPlacedFeatures.ATOMIC_ORE_END_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


//        context.register(ADD_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY)),
//                GenerationStep.Decoration.UNDERGROUND_ORES));

        // Example for individual Biomes!
        // context.register(ADD_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
        //         HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
        //         HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BISMUTH_ORE_PLACED_KEY)),
        //         GenerationStep.Decoration.UNDERGROUND_ORES));

//        context.register(ADD_END_BISMUTH_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(BiomeTags.IS_END),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_BISMUTH_ORE_PLACED_KEY)),
//                GenerationStep.Decoration.UNDERGROUND_ORES));
//
//        context.register(ADD_TREE_BLOODWOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOODWOOD_PLACED_KEY)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_GOJI_BERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
//                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GOJI_BERRY_BUSH_PLACED_KEY)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//
//        context.register(SPAWN_GECKO, new BiomeModifiers.AddSpawnsBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.PLAINS)),
//                WeightedList.of(new MobSpawnSettings.SpawnerData(ModEntities.GECKO.get(), 2, 4))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
    }
}
