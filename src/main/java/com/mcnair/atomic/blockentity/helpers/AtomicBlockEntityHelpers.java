package com.mcnair.atomic.blockentity.helpers;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.AtomicConfig;
import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.world.item.ItemStack;

public class AtomicBlockEntityHelpers {

    public static class MachineFuel {

        public static int getFuelValue(ItemStack itemStack) {
            AtomicCompression.LOGGER.info(String.valueOf(itemStack.getDisplayName()));
            AtomicCompression.LOGGER.info(AtomicTags.Values.MACHINE_FUEL_T2);
            AtomicCompression.LOGGER.info(String.valueOf(AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL_T2, itemStack)));


            if (AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL_T4, itemStack)) {
                return AtomicConfig.machineAll_FuelConversion_Tier4.getAsInt();
            } else if (AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL_T3, itemStack)) {
                return AtomicConfig.machineAll_FuelConversion_Tier3.getAsInt();
            } else if (AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL_T2, itemStack)) {
                return AtomicConfig.machineAll_FuelConversion_Tier2.getAsInt();
            } else if (AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL_T1, itemStack)) {
                return AtomicConfig.machineAll_FuelConversion_Tier1.getAsInt();
            } else {
                return 0;
            }
        }

    }

}
