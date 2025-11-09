package com.therealsam.upgradedfood.block;

import com.therealsam.upgradedfood.SamsUpgradedFood;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLOCK_OF_CARROT = registerBlock("block_of_carrot", AbstractBlock.Settings.create().strength(0F).sounds(BlockSoundGroup.NETHERRACK));
    public static final Block DENSE_BLOCK_OF_CARROT = registerBlock("dense_block_of_carrot", AbstractBlock.Settings.create().strength(0.5F).sounds(BlockSoundGroup.NETHERRACK));
    public static final Block PACKED_CARROTS = registerBlock("packed_carrots", AbstractBlock.Settings.create().strength(2F).sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block PRESSED_CARROTS = registerBlock("pressed_carrots", AbstractBlock.Settings.create().strength(3.5F).sounds(BlockSoundGroup.BONE));
    public static final Block COMPRESSED_CARROTS = registerBlock("compressed_carrots", AbstractBlock.Settings.create().strength(5F).sounds(BlockSoundGroup.DEEPSLATE));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SamsUpgradedFood.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SamsUpgradedFood.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        SamsUpgradedFood.LOGGER.info("Registering Mod Blocks for " + SamsUpgradedFood.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.BLOCK_OF_CARROT);
            fabricItemGroupEntries.add(ModBlocks.DENSE_BLOCK_OF_CARROT);
            fabricItemGroupEntries.add(ModBlocks.PACKED_CARROTS);
            fabricItemGroupEntries.add(ModBlocks.PRESSED_CARROTS);
            fabricItemGroupEntries.add(ModBlocks.COMPRESSED_CARROTS);
        });
    }
}
