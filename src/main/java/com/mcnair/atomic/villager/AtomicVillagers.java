package com.mcnair.atomic.villager;

import com.google.common.collect.ImmutableSet;
import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, AtomicCompression.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, AtomicCompression.MOD_ID);

    public static final Holder<PoiType> COMPRESSIONIST_POI = POI_TYPES.register("compressionist_poi",
            () -> new PoiType(ImmutableSet.copyOf(AtomicBlocks.BUNGERITE_ORE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> COMPRESSIONIST = VILLAGER_PROFESSIONS.register("compressionist",
            () -> new VillagerProfession(Component.literal("compressionist") , holder -> holder.value() == COMPRESSIONIST_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == COMPRESSIONIST_POI.value(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.AMBIENT_UNDERWATER_ENTER));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
