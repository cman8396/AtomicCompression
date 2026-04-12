package com.mcnair.atomic.block.custom.compressor;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nullable;

public class AtomicCompressorDirectionalBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<AtomicCompressorDirectionalBlock> CODEC = simpleCodec(AtomicCompressorDirectionalBlock::new);

    public AtomicCompressorDirectionalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}