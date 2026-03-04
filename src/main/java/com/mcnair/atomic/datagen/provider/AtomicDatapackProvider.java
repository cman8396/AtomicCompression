package com.mcnair.atomic.datagen.provider;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.worldgen.AtomicBiomeModifiers;
import com.mcnair.atomic.worldgen.AtomicConfiguredFeatures;
import com.mcnair.atomic.worldgen.AtomicPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AtomicDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
//            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
//            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, AtomicConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, AtomicPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AtomicBiomeModifiers::bootstrap);

    public AtomicDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AtomicCompression.MOD_ID));
    }
}
