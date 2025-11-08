package com.therealsam.upgradedfood.item;

import com.therealsam.upgradedfood.SamsUpgradedFood;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    static ItemStack logo = PotionContentsComponent.createStack(Items.POTION, Potions.STRONG_HEALING);

    public static final ItemGroup UPGRADED_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(SamsUpgradedFood.MOD_ID, "upgraded_food"), FabricItemGroup.builder().icon(() -> logo).displayName(Text.translatable("itemgroup.upgradedfood.upgraded_food")).entries((displayContext, entries) -> {
        entries.add(ModItems.NETHERITE_CARROT);
        entries.add(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        entries.add(ModItems.NETHERITE_CARROT_ON_A_STICK);
    }).build());

    public static void registerItemGroups() {
        SamsUpgradedFood.LOGGER.info("Registering Item Groups for" + SamsUpgradedFood.MOD_ID);
    }
}
