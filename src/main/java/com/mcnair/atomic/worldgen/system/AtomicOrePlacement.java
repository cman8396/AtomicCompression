package com.mcnair.atomic.worldgen.system;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AtomicOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int placementCount, PlacementModifier placementHeightRange) {
        return orePlacement(CountPlacement.of(placementCount), placementHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int placementChance, PlacementModifier placementHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(placementChance), placementHeightRange);
    }
}
