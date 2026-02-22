package com.mcnair.atomic.utility;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class AtomicTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BUNGERITE_ALLOY_TOOL = createTag("needs_bungerite_alloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_BUNGERITE_ALLOY_TOOL = createTag("incorrect_for_bungerite_alloy_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> BUNGERITE_ALLOY_REPAIRABLE = createTag("bungerite_alloy_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, name));
        }
    }
}
