package com.mcnair.atomic.utility;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.AtomicConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
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
                event.getToolTip().add(baseItemTooltipBehaviour(createFuelTooltip(1, AtomicConfig.machineAll_FuelConversion_Tier1.getAsInt())));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T2))) {
                event.getToolTip().add(baseItemTooltipBehaviour(createFuelTooltip(2, AtomicConfig.machineAll_FuelConversion_Tier2.getAsInt())));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T3))) {
                event.getToolTip().add(baseItemTooltipBehaviour(createFuelTooltip(3, AtomicConfig.machineAll_FuelConversion_Tier3.getAsInt())));
            } else if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_FUEL_T4))) {
                event.getToolTip().add(baseItemTooltipBehaviour(createFuelTooltip(4, AtomicConfig.machineAll_FuelConversion_Tier4.getAsInt())));
            }
        }

        if (AtomicConfig.general_ShowMachineIgnitionSourceTooltips.getAsBoolean()) {
            if (event.getItemStack().getTags().anyMatch(x -> x.equals(AtomicTags.Items.MACHINE_IGNITION))) {
                event.getToolTip().add(baseItemTooltipBehaviour(translatableTooltip("tooltip.atomiccompression.item.ignition_source")));
            }
        }
    }

    public static Component createFuelTooltip(int tier, int value) {
        return Component.translatable("tooltip.atomiccompression.item.fuel_t" + tier).append(String.format(" - [%s]", value)).withColor(CommonColors.SOFT_YELLOW);
    }

    /* SYSTEM */
    public static Component baseItemTooltipBehaviour(Component tooltip) {
        if (isShiftDown())
            return tooltip;
        else
            return translatableTooltip("tooltip.atomiccompression.item.hold_shift");
    }

    public static Component translatableTooltip(String key) {
        return Component.translatable(key).withColor(CommonColors.SOFT_YELLOW);
    }



    public static boolean isShiftDown() {
        return Minecraft.getInstance().hasShiftDown();
    }
}
