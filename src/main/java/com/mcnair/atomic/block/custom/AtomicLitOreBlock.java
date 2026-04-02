package com.mcnair.atomic.block.custom;

import com.mcnair.atomic.particle.AtomicParticles;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class AtomicLitOreBlock extends Block {
    public static final MapCodec<AtomicLitOreBlock> CODEC = simpleCodec(AtomicLitOreBlock::new);
    public static final BooleanProperty LIT;

    public MapCodec<AtomicLitOreBlock> codec() {
        return CODEC;
    }

    public AtomicLitOreBlock(BlockBehaviour.Properties p_55453_) {
        super(p_55453_);
        this.registerDefaultState((BlockState) this.defaultBlockState().setValue(LIT, false));
    }

    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        interact(state, level, pos);
        super.attack(state, level, pos, player);
    }

    public void stepOn(Level p_154299_, BlockPos p_154300_, BlockState p_154301_, Entity p_154302_) {
        if (!p_154302_.isSteppingCarefully()) {
            interact(p_154301_, p_154299_, p_154300_);
        }

        super.stepOn(p_154299_, p_154300_, p_154301_, p_154302_);
    }

    protected InteractionResult useItemOn(ItemStack p_316235_, BlockState p_316208_, Level p_316432_, BlockPos p_316592_, Player p_316564_, InteractionHand p_316389_, BlockHitResult p_316390_) {
        if (p_316432_.isClientSide()) {
            spawnParticles(p_316432_, p_316592_);
        } else {
            interact(p_316208_, p_316432_, p_316592_);
        }

        return (InteractionResult) (p_316235_.getItem() instanceof BlockItem && (new BlockPlaceContext(p_316564_, p_316389_, p_316235_, p_316390_)).canPlace() ? InteractionResult.PASS : InteractionResult.SUCCESS);
    }

    private static void interact(BlockState state, Level level, BlockPos pos) {
        spawnParticles(level, pos);
        if (!(Boolean) state.getValue(LIT)) {
            level.setBlock(pos, (BlockState) state.setValue(LIT, true), 3);
        }

    }

    protected boolean isRandomlyTicking(BlockState state) {
        return (Boolean) state.getValue(LIT);
    }

    protected void randomTick(BlockState p_221918_, ServerLevel p_221919_, BlockPos p_221920_, RandomSource p_221921_) {
        if ((Boolean) p_221918_.getValue(LIT)) {
            p_221919_.setBlock(p_221920_, (BlockState) p_221918_.setValue(LIT, false), 3);
        }

    }

    protected void spawnAfterBreak(BlockState p_221907_, ServerLevel p_221908_, BlockPos p_221909_, ItemStack p_221910_, boolean p_221911_) {
        super.spawnAfterBreak(p_221907_, p_221908_, p_221909_, p_221910_, p_221911_);
    }

    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
        return UniformInt.of(3, 5).sample(level.getRandom());
    }

    public void animateTick(BlockState p_221913_, Level p_221914_, BlockPos p_221915_, RandomSource p_221916_) {
        if ((Boolean) p_221913_.getValue(LIT)) {
            spawnParticles(p_221914_, p_221915_);
        }

    }

    private static void spawnParticles(Level level, BlockPos pos) {
        double d0 = (double) 0.5625F;
        RandomSource randomsource = level.random;

        for (Direction direction : Direction.values()) {
            BlockPos blockpos = pos.relative(direction);
            if (!level.getBlockState(blockpos).isSolidRender()) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? (double) 0.1F + (double) 0.125F * (double) direction.getStepX() : (double) randomsource.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? (double) 0.1F + (double) 0.125F * (double) direction.getStepY() : (double) randomsource.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? (double) 0.1F + (double) 0.125F * (double) direction.getStepZ() : (double) randomsource.nextFloat();
                level.addParticle(AtomicParticles.SHARD_PARTICLES.get(), (double) pos.getX() + d1, (double) pos.getY() + d2, (double) pos.getZ() + d3, (double) 0.0F, (double) 0.0F, (double) 0.0F);
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}