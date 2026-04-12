package com.mcnair.atomic.block.custom.compressor;

import com.mcnair.atomic.utility.AtomicVoxelHelper;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nullable;

public class AtomicCompressorControllerBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<AtomicCompressorControllerBlock> CODEC = simpleCodec(AtomicCompressorControllerBlock::new);

    public AtomicCompressorControllerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        VoxelShape port = AtomicVoxelHelper.FULL_BLOCK;
        switch (state.getValue(FACING)) {
            case NORTH -> {
                port = AtomicVoxelHelper.CONTROLLER_PORT_NORTH;
            }
            case SOUTH -> {
                port = AtomicVoxelHelper.CONTROLLER_PORT_SOUTH;
            }
            case EAST -> {
                port = AtomicVoxelHelper.CONTROLLER_PORT_WEST;
            }
            case WEST -> {
                port = AtomicVoxelHelper.CONTROLLER_PORT_EAST;
            }
        }
        return AtomicVoxelHelper.combine(AtomicVoxelHelper.CONTROLLER_BASE, port);
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