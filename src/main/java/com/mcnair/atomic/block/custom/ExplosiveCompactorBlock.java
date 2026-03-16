package com.mcnair.atomic.block.custom;

import com.mcnair.atomic.block.extensions.entity.AbstractMachineBlock;
import com.mcnair.atomic.blockentity.AtomicBlockEntities;
import com.mcnair.atomic.blockentity.custom.ExplosiveCompactorBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class ExplosiveCompactorBlock extends AbstractMachineBlock {
    public static final MapCodec<ExplosiveCompactorBlock> CODEC = simpleCodec(ExplosiveCompactorBlock::new);

    public ExplosiveCompactorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<ExplosiveCompactorBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ExplosiveCompactorBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof ExplosiveCompactorBlockEntity) {
            player.openMenu((MenuProvider)blockentity);
        }
    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                          Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof ExplosiveCompactorBlockEntity ExplosiveCompactorBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(ExplosiveCompactorBlockEntity, Component.literal("Explosive Compactor")), pPos);
            } else {
                throw new IllegalStateException("Container provider missing!");
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, AtomicBlockEntities.EXPLOSIVE_COMPACTOR.get(), ExplosiveCompactorBlockEntity::tick);
    }
}
