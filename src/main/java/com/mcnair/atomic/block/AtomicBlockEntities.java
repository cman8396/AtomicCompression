package com.mcnair.atomic.block;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.entity.ExplosiveCompactorBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AtomicBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AtomicCompression.MOD_ID);

    public static final Supplier<BlockEntityType<ExplosiveCompactorBlockEntity>> EXPLOSIVE_COMPACTOR_BE =
            BLOCK_ENTITIES.register("explosive_compactor_be", () -> new BlockEntityType<>(ExplosiveCompactorBlockEntity::new, AtomicBlocks.EXPLOSIVE_COMPACTOR.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
