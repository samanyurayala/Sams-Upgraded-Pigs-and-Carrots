package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.BLOCK_OF_CARROT)
                .add(ModBlocks.DENSE_BLOCK_OF_CARROT)
                .add(ModBlocks.PACKED_CARROTS)
                .add(ModBlocks.PRESSED_CARROTS)
                .add(ModBlocks.COMPRESSED_CARROTS);
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PACKED_CARROTS);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PRESSED_CARROTS);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.COMPRESSED_CARROTS);
    }
}
