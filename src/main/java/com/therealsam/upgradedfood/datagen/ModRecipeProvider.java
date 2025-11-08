package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.FOOD, ModItems.NETHERITE_CARROT)
                        .pattern(" #%")
                        .pattern("   ")
                        .pattern("   ")
                        .input('#', Items.CARROT)
                        .input('%', Items.NETHERITE_INGOT)
                        .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                        .offerTo(recipeExporter, getRecipeName(ModItems.NETHERITE_CARROT));
                createShaped(RecipeCategory.TOOLS, ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK)
                        .pattern(" #%")
                        .pattern("   ")
                        .pattern("   ")
                        .input('#', Items.FISHING_ROD)
                        .input('%', Items.ENCHANTED_GOLDEN_APPLE)
                        .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.TOOLS, ModItems.NETHERITE_CARROT_ON_A_STICK)
                        .pattern(" #%")
                        .pattern("   ")
                        .pattern("   ")
                        .input('#', Items.FISHING_ROD)
                        .input('%', ModItems.NETHERITE_CARROT)
                        .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.FOOD, ModItems.NETHERITE_CARROT)
                        .pattern("###")
                        .pattern("#%#")
                        .pattern("###")
                        .input('#', Items.CARROT)
                        .input('%', ModItems.NETHERITE_CARROT)
                        .criterion(hasItem(ModItems.NETHERITE_CARROT), conditionsFromItem(ModItems.NETHERITE_CARROT))
                        .offerTo(recipeExporter, "netherite_carrot_alt");
            }

        };
    }

    @Override
    public String getName() {
        return "";
    }
}
