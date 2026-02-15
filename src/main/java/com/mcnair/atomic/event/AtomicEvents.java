package com.mcnair.atomic.event;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.villager.AtomicVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = AtomicCompression.MOD_ID, value = Dist.CLIENT)
public class AtomicEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
//    @SubscribeEvent
//    public static void onHammerUsage(BlockEvent.BreakEvent event) {
//        Player player = event.getPlayer();
//        ItemStack mainHandItem = player.getMainHandItem();
//
//        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
//            BlockPos initialBlockPos = event.getPos();
//            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
//                return;
//            }
//
//            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
//                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
//                    continue;
//                }
//
//                HARVESTED_BLOCKS.add(pos);
//                serverPlayer.gameMode.destroyBlock(pos);
//                HARVESTED_BLOCKS.remove(pos);
//            }
//        }
//    }

//    @SubscribeEvent
//    public static void livingDamage(LivingDamageEvent.Pre event) {
//        if(event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
//            if(player.getMainHandItem().getItem() == Items.END_ROD) {
//                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with an END ROD? YOU SICK FRICK!"));
//                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 6));
//                player.getMainHandItem().shrink(1);
//            }
//        }
//    }

//    @SubscribeEvent
//    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
//        PotionBrewing.Builder builder = event.getBuilder();
//
//        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
//    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == AtomicVillagers.COMPRESSIONIST.getKey()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

//            trades.get(1).add((serverLevel, entity, randomSource) -> new MerchantOffer(
//                    new ItemCost(Items.MILK_BUCKET, 1),
//                    new ItemStack(AtomicItems.RAW_BUNGERITE.get(), 9), 6, 3, 0.05f));
//
//            trades.get(1).add((serverLevel, entity, randomSource) -> new MerchantOffer(
//                    new ItemCost(AtomicItems.RAW_BUNGERITE, 9),
//                    new ItemStack(AtomicItems.BUNGERITE_ORE.get(), 1), 3, 3, 0.05f));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

//        genericTrades.add((serverLevel, entity, randomSource) -> new MerchantOffer(
//                new ItemCost(Items.MILK_BUCKET, 1),
//                new ItemStack(AtomicItems.RAW_BUNGERITE.get(), 12), 2, 6, 0.05f));
//
//        rareTrades.add((serverLevel, entity, randomSource) -> new MerchantOffer(
//                new ItemCost(Items.EMERALD, 1),
//                new ItemStack(AtomicItems.BUNGERITE_ORE.get(), 4), 1, 10, 0.05f));

    }
}