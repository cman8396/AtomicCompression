package com.mcnair.atomic.utility;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class AtomicTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BUNGERITE_ALLOY_TOOL = createTag("needs_bungerite_alloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_BUNGERITE_ALLOY_TOOL = createTag("incorrect_for_bungerite_alloy_tool");

        public static final TagKey<Block> MACHINE = createTag("machine");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> BUNGERITE_ALLOY_REPAIRABLE = createTag("bungerite_alloy_repairable");

        public static final TagKey<Item> MACHINE = createTag("machine");

        public static final TagKey<Item> MACHINE_FUEL = createTag("machine_fuel");
        public static final TagKey<Item> MACHINE_FUEL_T1 = createTag("machine_fuel/t1");
        public static final TagKey<Item> MACHINE_FUEL_T2 = createTag("machine_fuel/t2");
        public static final TagKey<Item> MACHINE_FUEL_T3 = createTag("machine_fuel/t3");
        public static final TagKey<Item> MACHINE_FUEL_T4 = createTag("machine_fuel/t4");

        public static final TagKey<Item> MACHINE_CASING = createTag("machine_casing");
        public static final TagKey<Item> MACHINE_CASING_REFINED_BUNGERITE = createTag("machine_casing/refined_bungerite");
        public static final TagKey<Item> MACHINE_IGNITION = createTag("machine_ignition");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
        }
    }

    public static class Helpers {
        public static boolean doesTagMatch(String name, TagKey<?> tag) {
            if (tag != null && tag.location() != null) {
                return tag.location().toString().toLowerCase().contains(name);
            }
            return false;
        }

        public static boolean doesItemStackTagMatch(String tagName, ItemStack stack) {
            return stack.getTags().anyMatch((tag) -> doesTagMatch(tagName, tag));
        }
    }

    public static class Values {
        public static String MACHINE_FUEL = "atomiccompression:machine_fuel";
        public static String MACHINE_FUEL_T1 = "atomiccompression:machine_fuel/t1";
        public static String MACHINE_FUEL_T2 = "atomiccompression:machine_fuel/t2";
        public static String MACHINE_FUEL_T3 = "atomiccompression:machine_fuel/t3";
        public static String MACHINE_FUEL_T4 = "atomiccompression:machine_fuel/t4";

        public static String MACHINE_CASING = "atomiccompression:machine_casing";
        public static String MACHINE_CASING_REFINED_BUNGERITE = "atomiccompression:machine_casing/refined_bungerite";
        public static String MACHINE_IGNITION = "atomiccompression:machine_ignition";
    }
}
