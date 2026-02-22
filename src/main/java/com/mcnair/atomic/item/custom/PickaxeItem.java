package com.mcnair.atomic.item.custom;

import com.google.common.collect.ImmutableMap;

import java.util.Optional;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;
import org.jspecify.annotations.Nullable;

public class PickaxeItem extends Item {

    public PickaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.pickaxe(material, attackDamage, attackSpeed));
    }
//
//    public InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        BlockPos blockpos = context.getClickedPos();
//        Player player = context.getPlayer();
//        if (playerHasBlockingItemUseIntent(context)) {
//            return InteractionResult.PASS;
//        } else {
//            Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), context);
//            if (optional.isEmpty()) {
//                return InteractionResult.PASS;
//            } else {
//                ItemStack itemstack = context.getItemInHand();
//                if (player instanceof ServerPlayer) {
//                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
//                }
//
//                level.setBlock(blockpos, (BlockState)optional.get(), 11);
//                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, Context.of(player, (BlockState)optional.get()));
//                if (player != null) {
//                    itemstack.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
//                }
//
//                return InteractionResult.SUCCESS;
//            }
//        }
//    }
//
//    private static boolean playerHasBlockingItemUseIntent(UseOnContext context) {
//        Player player = context.getPlayer();
//        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().has(DataComponents.BLOCKS_ATTACKS) && !player.isSecondaryUseActive();
//    }
//
//    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state, UseOnContext p_40529_) {
//        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(p_40529_, ItemAbilities.AXE_STRIP, false));
//        if (optional.isPresent()) {
//            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
//            return optional;
//        } else {
//            Optional<BlockState> optional1 = Optional.ofNullable(state.getToolModifiedState(p_40529_, ItemAbilities.AXE_SCRAPE, false));
//            if (optional1.isPresent()) {
//                spawnSoundAndParticle(level, pos, player, state, SoundEvents.AXE_SCRAPE, 3005);
//                return optional1;
//            } else {
//                Optional<BlockState> optional2 = Optional.ofNullable(state.getToolModifiedState(p_40529_, ItemAbilities.AXE_WAX_OFF, false));
//                if (optional2.isPresent()) {
//                    spawnSoundAndParticle(level, pos, player, state, SoundEvents.AXE_WAX_OFF, 3004);
//                    return optional2;
//                } else {
//                    return Optional.empty();
//                }
//            }
//        }
//    }
//
//    private static void spawnSoundAndParticle(Level level, BlockPos pos, @Nullable Player player, BlockState state, SoundEvent sount, int event) {
//        level.playSound(player, pos, sount, SoundSource.BLOCKS, 1.0F, 1.0F);
//        level.levelEvent(player, event, pos, 0);
//        if (state.getBlock() instanceof ChestBlock && state.getValue(ChestBlock.TYPE) != ChestType.SINGLE) {
//            BlockPos blockpos = ChestBlock.getConnectedBlockPos(pos, state);
//            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, Context.of(player, level.getBlockState(blockpos)));
//            level.levelEvent(player, event, blockpos, 0);
//        }
//
//    }


// I THINK THIS BELOW IS NOT NEEDED

//    public static @Nullable BlockState getAxeStrippingState(BlockState originalState) {
//        Strippable strippable = (Strippable)originalState.getBlock().builtInRegistryHolder().getData(NeoForgeDataMaps.STRIPPABLES);
//        if (strippable != null) {
//            return strippable.strippedBlock().withPropertiesOf(originalState);
//        } else {
//            Block block = (Block)STRIPPABLES.get(originalState.getBlock());
//            return block != null ? (BlockState)block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)originalState.getValue(RotatedPillarBlock.AXIS)) : null;
//        }
//    }
//
//    private Optional<BlockState> getStripped(BlockState unstrippedState) {
//        Strippable strippable = (Strippable)unstrippedState.getBlock().builtInRegistryHolder().getData(NeoForgeDataMaps.STRIPPABLES);
//        return strippable != null ? Optional.of(strippable.strippedBlock().withPropertiesOf(unstrippedState)) : Optional.ofNullable((Block)STRIPPABLES.get(unstrippedState.getBlock())).map((p_360012_) -> (BlockState)p_360012_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, (Direction.Axis)unstrippedState.getValue(RotatedPillarBlock.AXIS)));
//    }
//
//    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
//        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
//    }
//
//    static {
//        STRIPPABLES = (new ImmutableMap.Builder()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD).put(Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD).put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD).put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK).build();
//    }
}
