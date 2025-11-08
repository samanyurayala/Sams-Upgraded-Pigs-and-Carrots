package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.item.ModItems;
import com.therealsam.upgradedfood.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.ENCHANTED_APPLE_STICK_TOOL_REPAIR)
                .add(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        valueLookupBuilder(ModTags.Items.NETHERITE_CARROT_STICK_TOOL_REPAIR)
                .add(ModItems.NETHERITE_CARROT_ON_A_STICK);
    }
}
