package com.therealsam.upgradedfood;

import com.therealsam.upgradedfood.datagen.ModBlockTagProvider;
import com.therealsam.upgradedfood.datagen.ModLootTableProvider;
import com.therealsam.upgradedfood.datagen.ModModelProvider;
import com.therealsam.upgradedfood.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SamsUpgradedFoodDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
    }
}
