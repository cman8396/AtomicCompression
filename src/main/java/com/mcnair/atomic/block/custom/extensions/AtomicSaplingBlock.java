package com.mcnair.atomic.block.custom.extensions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class AtomicSaplingBlock extends SaplingBlock {
    private final @Nullable Supplier<Block> blockToSurviveOn;

    public AtomicSaplingBlock(TreeGrower treeGrower, Properties properties, @Nullable Supplier<Block> block) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
    }

    public AtomicSaplingBlock(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
        this.blockToSurviveOn = null;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        if (blockToSurviveOn != null)
            return blockToSurviveOn.get() == state.getBlock();

        return state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK);
    }
}