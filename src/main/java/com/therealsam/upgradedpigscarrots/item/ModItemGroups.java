package com.therealsam.upgradedpigscarrots.item;

import com.therealsam.upgradedpigscarrots.SamsUpgradedPigsCarrots;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup UPGRADED_PIGS_AND_CARROTS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID, "upgraded_pigs_and_carrots"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NETHERITE_CARROT)).displayName(Text.translatable("itemgroup.upgradedpigscarrots.upgraded_pigs_and_carrots")).entries((displayContext, entries) -> {
        entries.add(ModItems.NETHERITE_CARROT);
        entries.add(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
    }).build());

    public static void registerItemGroups() {
        SamsUpgradedPigsCarrots.LOGGER.info("Registering Item Groups for" + SamsUpgradedPigsCarrots.MOD_ID);
    }
}
