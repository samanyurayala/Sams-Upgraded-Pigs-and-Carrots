package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.block.ModBlocks;
import com.therealsam.upgradedfood.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_CARROT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DENSE_BLOCK_OF_CARROT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PACKED_CARROTS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRESSED_CARROTS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_CARROTS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CARROTS_ON_A_STICK, Models.HANDHELD_ROD);
        itemModelGenerator.register(ModItems.NETHERITE_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK, Models.HANDHELD_ROD);
    }
}
