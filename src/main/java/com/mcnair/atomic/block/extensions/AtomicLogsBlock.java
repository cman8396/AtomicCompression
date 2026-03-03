package com.mcnair.atomic.block.extensions;

import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;

import javax.annotation.Nullable;

public class AtomicLogsBlock extends RotatedPillarBlock {
        public AtomicLogsBlock(Properties properties) {
            super(properties);
        }

        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 4;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 4;
        }

        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if(context.getItemInHand().getItem() instanceof AxeItem) {
                if(state.is(AtomicBlocks.ASHENWOOD_LOG)) {
                    return AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }

                if(state.is(AtomicBlocks.ASHENWOOD_WOOD)) {
                    return AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }

            return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    }