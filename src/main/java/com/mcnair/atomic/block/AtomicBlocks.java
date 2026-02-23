package com.mcnair.atomic.block;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.custom.AtomicLeavesBlock;
import com.mcnair.atomic.block.custom.AtomicLogsBlock;
import com.mcnair.atomic.block.custom.AtomicPlanksBlock;
import com.mcnair.atomic.block.custom.AtomicSaplingBlock;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.worldgen.tree.AtomicTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Function;

public class AtomicBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AtomicCompression.MOD_ID);

    /* ORE BLOCKS */
    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SALTPETER_ORE = registerBlock("saltpeter_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SALTPETER_ORE = registerBlock("deepslate_saltpeter_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LEAD_ORE = registerBlock("lead_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ATOMIC_ORE = registerBlock("atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_ATOMIC_ORE = registerBlock("deepslate_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(10f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BUNGERITE_ORE = registerBlock("bungerite_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().ignitedByLava().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> NETHER_ATOMIC_ORE = registerBlock("nether_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> END_ATOMIC_ORE = registerBlock("end_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    /* UTILITY BLOCKS */
    public static final DeferredBlock<Block> ATOMIC_GLASS = registerBlock("atomic_glass",
            (properties) -> new TransparentBlock(
                    properties.strength(0.3f).noOcclusion().sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> ATOMIC_GLASS_PANE = registerBlock("atomic_glass_pane",
            (properties) -> new IronBarsBlock(
                    properties.strength(0.3f).noOcclusion().sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> DENSE_BASALT = registerBlock("dense_basalt",
            (properties) -> new RotatedPillarBlock(
                    properties.strength(1.75f, 6f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<Block> GUNPOWDER_BLOCK = registerBlock("gunpowder_block",
            (properties) -> new ColoredFallingBlock(new ColorRGBA(-8356741),
                    properties.strength(0.6f).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> RAW_SULFUR_BLOCK = registerBlock("raw_sulfur_block",
            (properties) -> new Block(
                    properties.strength(4f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAW_SALTPETER_BLOCK = registerBlock("raw_saltpeter_block",
            (properties) -> new Block(
                    properties.strength(4f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RAW_BUNGERITE_BLOCK = registerBlock("raw_bungerite_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.IRON)));
    public static final DeferredBlock<Block> SULFUR_DUST_BLOCK = registerBlock("sulfur_dust_block",
            (properties) -> new Block(
                    properties.strength(4f, 6f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> SALTPETER_DUST_BLOCK = registerBlock("saltpeter_dust_block",
            (properties) -> new Block(
                    properties.strength(4f, 6f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> LEAD_BLOCK = registerBlock("lead_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.IRON)));
    public static final DeferredBlock<Block> REFINED_BUNGERITE_BLOCK = registerBlock("refined_bungerite_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.IRON)));
    public static final DeferredBlock<Block> BUNGERITE_ALLOY_BLOCK = registerBlock("bungerite_alloy_block",
            (properties) -> new Block(
                    properties.strength(50f, 1200f).sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> ATOMIC_BLOCK = registerBlock("atomic_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> EMPOWERED_ATOMIC_BLOCK = registerBlock("empowered_atomic_block",
            (properties) -> new Block(
                    properties.strength(5f, 6f).sound(SoundType.STONE)));


    /* ASHENWOOD BLOCKS */
    public static final DeferredBlock<Block> ASHENWOOD_LOG = registerBlock("ashenwood_log",
            (properties) -> new AtomicLogsBlock(
                    properties.strength(2.0f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHENWOOD_WOOD = registerBlock("ashenwood_wood",
            (properties) -> new AtomicLogsBlock(
                    properties.strength(2.0f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASHENWOOD_LOG = registerBlock("stripped_ashenwood_log",
            (properties) -> new AtomicLogsBlock(
                    properties.strength(2.0f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASHENWOOD_WOOD = registerBlock("stripped_ashenwood_wood",
            (properties) -> new AtomicLogsBlock(
                    properties.strength(2.0f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHENWOOD_PLANKS = registerBlock("ashenwood_planks",
            (properties) -> new AtomicPlanksBlock(
                    properties.strength(2.0f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASHENWOOD_LEAVES = registerBlock("ashenwood_leaves",
            (properties) -> new AtomicLeavesBlock(0.02f, ParticleTypes.SMOKE,
                    properties.strength(0.2F).sound(SoundType.CHERRY_LEAVES).ignitedByLava()
                            .mapColor(MapColor.PLANT).randomTicks().noOcclusion()
                            .isValidSpawn(Blocks::ocelotOrParrot).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHENWOOD_LEAVES_FLOWERING = registerBlock("ashenwood_leaves_flowering",
            (properties) -> new AtomicLeavesBlock(0.02f, ParticleTypes.SMOKE,
                    properties.strength(0.2F).sound(SoundType.CHERRY_LEAVES).ignitedByLava()
                            .mapColor(MapColor.PLANT).randomTicks().noOcclusion()
                            .isValidSpawn(Blocks::ocelotOrParrot).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ASHENWOOD_SAPLING = registerBlock("ashenwood_sapling",
            (properties) -> new AtomicSaplingBlock(AtomicTreeGrower.ASHENWOOD,
                    properties.instabreak().sound(SoundType.GRASS)
                            .mapColor(MapColor.PLANT).randomTicks().noCollision()
                            .pushReaction(PushReaction.DESTROY)));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AtomicItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}