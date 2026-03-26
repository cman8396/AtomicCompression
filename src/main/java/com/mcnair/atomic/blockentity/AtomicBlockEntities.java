package com.mcnair.atomic.blockentity;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.blockentity.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

    public final class AtomicBlockEntities {
        private AtomicBlockEntities() {}

        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AtomicCompression.MOD_ID);

        public static final Supplier<BlockEntityType<ExplosiveMillBlockEntity>> EXPLOSIVE_MILL =
                BLOCK_ENTITIES.register("explosive_mill", () -> new BlockEntityType<>(
                        ExplosiveMillBlockEntity::new, AtomicBlocks.EXPLOSIVE_MILL.get()));
        public static final Supplier<BlockEntityType<ExplosiveCompactorBlockEntity>> EXPLOSIVE_COMPACTOR =
                BLOCK_ENTITIES.register("explosive_compactor", () -> new BlockEntityType<>(
                        ExplosiveCompactorBlockEntity::new, AtomicBlocks.EXPLOSIVE_COMPACTOR.get()));
        public static final Supplier<BlockEntityType<ExplosiveSeparatorBlockEntity>> EXPLOSIVE_SEPARATOR =
                BLOCK_ENTITIES.register("explosive_separator", () -> new BlockEntityType<>(
                        ExplosiveSeparatorBlockEntity::new, AtomicBlocks.EXPLOSIVE_SEPARATOR.get()));
        public static final Supplier<BlockEntityType<ExplosiveSmelterBlockEntity>> EXPLOSIVE_SMELTER =
                BLOCK_ENTITIES.register("explosive_smelter", () -> new BlockEntityType<>(
                        ExplosiveSmelterBlockEntity::new, AtomicBlocks.EXPLOSIVE_SMELTER.get()));
        public static final Supplier<BlockEntityType<ExplosiveRefinerBlockEntity>> EXPLOSIVE_REFINER =
                BLOCK_ENTITIES.register("explosive_refiner", () -> new BlockEntityType<>(
                        ExplosiveRefinerBlockEntity::new, AtomicBlocks.EXPLOSIVE_REFINER.get()));


        public static void register(IEventBus modEventBus) {
            BLOCK_ENTITIES.register(modEventBus);
        }

    }