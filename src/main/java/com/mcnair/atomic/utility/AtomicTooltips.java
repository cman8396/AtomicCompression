package com.mcnair.atomic.utility;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.AtomicConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = AtomicCompression.MOD_ID, value = Dist.CLIENT)
public class AtomicTooltips {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if (AtomicConfig.general_ShowMachineFuelTierTooltips.getAsBoolean()) {
            if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T1))) {
                event.getToolTip().add(createFuelTooltip(1, AtomicConfig.machineAll_FuelConversion_Tier1.getAsInt()));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T2))) {
                event.getToolTip().add(createFuelTooltip(2, AtomicConfig.machineAll_FuelConversion_Tier2.getAsInt()));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T3))) {
                event.getToolTip().add(createFuelTooltip(3, AtomicConfig.machineAll_FuelConversion_Tier3.getAsInt()));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T4))) {
                event.getToolTip().add(createFuelTooltip(4, AtomicConfig.machineAll_FuelConversion_Tier4.getAsInt()));
            }
        }
    }

    public static Component createFuelTooltip(int tier, int value) {
        if (isShiftDown())
            return Component.translatable("tooltip.atomiccompression.item.fuel_t" + tier).append(String.format(" - [%s]", value)).withStyle(ChatFormatting.YELLOW);
        else
            return Component.translatable("tooltip.atomiccompression.item.hold_shift").withStyle(ChatFormatting.YELLOW);
    }


    public static boolean isShiftDown() {
        return Minecraft.getInstance().hasShiftDown();
    }


}
