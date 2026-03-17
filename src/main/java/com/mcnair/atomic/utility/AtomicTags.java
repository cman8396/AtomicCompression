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

        public static final TagKey<Item> MACHINE_CASING = createTag("machine_casing");
        public static final TagKey<Item> MACHINE_CASING_REFINED_BUNGERITE = createTag("machine_casing_refined_bungerite");
        public static final TagKey<Item> MACHINE_IGNITION = createTag("machine_ignition");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
        }
    }

    public static class Helpers {
        public static boolean doesTagMatch(String name, TagKey<?> tag) {
//            AtomicCompression.LOGGER.info(tag.location().toString().toLowerCase() + " - " + name);
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
        public static String GUNPOWDERS = "c:gunpowders";
        public static String MACHINE_CASING = "atomiccompression:machine_casing";
        public static String MACHINE_CASING_REFINED_BUNGERITE = "atomiccompression:machine_casing_refined_bungerite";
        public static String MACHINE_IGNITION = "atomiccompression:machine_ignition";
    }
}
