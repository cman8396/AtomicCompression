package com.mcnair.atomic.particle;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AtomicParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, AtomicCompression.MOD_ID);

    public static final Supplier<SimpleParticleType> SHARD_PARTICLES = PARTICLE_TYPES.register("shard_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

    public static class SpawnInBlock {
        public static void Good(Level level, BlockPos pos){
            ParticleUtils.spawnParticleInBlock(level, pos, 8, AtomicParticles.SHARD_PARTICLES.get());
        }

        public static void Bad(Level level, BlockPos pos){
            ParticleUtils.spawnParticleInBlock(level, pos, 6, ParticleTypes.ANGRY_VILLAGER);
        }
    }
}
