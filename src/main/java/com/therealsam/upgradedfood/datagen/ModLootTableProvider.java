package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOCK_OF_CARROT);
        addDrop(ModBlocks.DENSE_BLOCK_OF_CARROT);
        addDrop(ModBlocks.PACKED_CARROTS);
        addDrop(ModBlocks.PRESSED_CARROTS);
        addDrop(ModBlocks.COMPRESSED_CARROTS);

    }
}
