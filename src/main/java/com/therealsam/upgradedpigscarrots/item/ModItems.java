package com.therealsam.upgradedpigscarrots.item;

import com.therealsam.upgradedpigscarrots.SamsUpgradedPigsCarrots;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NETHERITE_CARROT = registerItem("netherite_carrot", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID,"netherite_carrot"))).food(ModFoodComponents.NETHERITE_CARROT)));
    public static final Item ENCHANTED_GOLDEN_APPLE_ON_A_STICK = registerItem("enchanted_golden_apple_on_a_stick", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID,"enchanted_golden_apple_on_a_stick")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SamsUpgradedPigsCarrots.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SamsUpgradedPigsCarrots.LOGGER.info("Registering Mod Items for " + SamsUpgradedPigsCarrots.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(NETHERITE_CARROT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        });
    }
}
