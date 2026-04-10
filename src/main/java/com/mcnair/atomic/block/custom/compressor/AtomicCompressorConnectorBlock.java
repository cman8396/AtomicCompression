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

public class AtomicCompressorConnectorBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<AtomicCompressorConnectorBlock> CODEC = simpleCodec(AtomicCompressorConnectorBlock::new);
    private static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    public AtomicCompressorConnectorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH -> {
                return AtomicVoxelHelper.CONNECTOR_NORTH;
            }
            case SOUTH -> {
                return AtomicVoxelHelper.CONNECTOR_SOUTH;
            }
            case EAST -> {
                return AtomicVoxelHelper.CONNECTOR_EAST;
            }
            case WEST -> {
                return AtomicVoxelHelper.CONNECTOR_WEST;
            }
            default -> {
                return AtomicVoxelHelper.CONNECTOR_NONE;
            }
        }
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