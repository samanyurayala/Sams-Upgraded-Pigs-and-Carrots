package com.therealsam.upgradedpigscarrots.util;

import com.therealsam.upgradedpigscarrots.SamsUpgradedPigsCarrots;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENCHANTED_APPLE_STICK_TOOL = createTag("needs_enchanted_apple_stick_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENCHANTED_APPLE_STICK_TOOL = createTag("incorrect_for_enchanted_apple_stick_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ENCHANTED_APPLE_STICK_TOOL_REPAIR = createTag("enchanted_apple_stick_tool_repair");
        public static final TagKey<Item> NETHERITE_CARROT_STICK_TOOL_REPAIR = createTag("netherite_stick_stick_tool_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID, name));
        }
    }
}
