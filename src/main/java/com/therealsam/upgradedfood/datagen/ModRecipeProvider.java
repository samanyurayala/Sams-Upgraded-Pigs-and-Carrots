package com.therealsam.upgradedfood.datagen;

import com.therealsam.upgradedfood.block.ModBlocks;
import com.therealsam.upgradedfood.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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
                createShaped(RecipeCategory.TOOLS, ModItems.CARROTS_ON_A_STICK)
                        .pattern("   ")
                        .pattern("%#%")
                        .pattern("   ")
                        .input('#', Items.FISHING_ROD)
                        .input('%', ModBlocks.COMPRESSED_CARROTS)
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
                createShaped(RecipeCategory.FOOD, ModBlocks.BLOCK_OF_CARROT)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', Items.CARROT)
                        .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                        .offerTo(recipeExporter, "block_of_carrot");
                createShaped(RecipeCategory.FOOD, Items.CARROT, 9)
                        .pattern("   ")
                        .pattern(" % ")
                        .pattern("   ")
                        .input('%', ModBlocks.BLOCK_OF_CARROT)
                        .criterion(hasItem(ModBlocks.BLOCK_OF_CARROT), conditionsFromItem(ModBlocks.BLOCK_OF_CARROT))
                        .offerTo(recipeExporter, "carrot_alt");
                createShaped(RecipeCategory.FOOD, ModBlocks.DENSE_BLOCK_OF_CARROT)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.BLOCK_OF_CARROT)
                        .criterion(hasItem(ModBlocks.BLOCK_OF_CARROT), conditionsFromItem(ModBlocks.BLOCK_OF_CARROT))
                        .offerTo(recipeExporter, "dense_block_of_carrot");
                createShaped(RecipeCategory.FOOD, ModBlocks.BLOCK_OF_CARROT, 9)
                        .pattern("   ")
                        .pattern(" % ")
                        .pattern("   ")
                        .input('%', ModBlocks.DENSE_BLOCK_OF_CARROT)
                        .criterion(hasItem(ModBlocks.DENSE_BLOCK_OF_CARROT), conditionsFromItem(ModBlocks.DENSE_BLOCK_OF_CARROT))
                        .offerTo(recipeExporter, "block_of_carrot_alt");
                createShaped(RecipeCategory.FOOD, ModBlocks.PACKED_CARROTS)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.DENSE_BLOCK_OF_CARROT)
                        .criterion(hasItem(ModBlocks.DENSE_BLOCK_OF_CARROT), conditionsFromItem(ModBlocks.DENSE_BLOCK_OF_CARROT))
                        .offerTo(recipeExporter, "packed_carrots");
                createShaped(RecipeCategory.FOOD, ModBlocks.DENSE_BLOCK_OF_CARROT, 9)
                        .pattern("   ")
                        .pattern(" % ")
                        .pattern("   ")
                        .input('%', ModBlocks.PACKED_CARROTS)
                        .criterion(hasItem(ModBlocks.PACKED_CARROTS), conditionsFromItem(ModBlocks.PACKED_CARROTS))
                        .offerTo(recipeExporter, "dense_block_of_carrot_alt");
                createShaped(RecipeCategory.FOOD, ModBlocks.PRESSED_CARROTS)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.PACKED_CARROTS)
                        .criterion(hasItem(ModBlocks.PACKED_CARROTS), conditionsFromItem(ModBlocks.PACKED_CARROTS))
                        .offerTo(recipeExporter, "pressed_carrots");
                createShaped(RecipeCategory.FOOD, ModBlocks.PACKED_CARROTS, 9)
                        .pattern("   ")
                        .pattern(" % ")
                        .pattern("   ")
                        .input('%', ModBlocks.PRESSED_CARROTS)
                        .criterion(hasItem(ModBlocks.PRESSED_CARROTS), conditionsFromItem(ModBlocks.PRESSED_CARROTS))
                        .offerTo(recipeExporter, "packed_carrots_alt");
                createShaped(RecipeCategory.FOOD, ModBlocks.COMPRESSED_CARROTS)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.PRESSED_CARROTS)
                        .criterion(hasItem(ModBlocks.PRESSED_CARROTS), conditionsFromItem(ModBlocks.PRESSED_CARROTS))
                        .offerTo(recipeExporter, "compressed_carrots");
                createShaped(RecipeCategory.FOOD, ModBlocks.PRESSED_CARROTS, 9)
                        .pattern("   ")
                        .pattern(" % ")
                        .pattern("   ")
                        .input('%', ModBlocks.COMPRESSED_CARROTS)
                        .criterion(hasItem(ModBlocks.COMPRESSED_CARROTS), conditionsFromItem(ModBlocks.COMPRESSED_CARROTS))
                        .offerTo(recipeExporter, "pressed_carrots_alt");
            }


        };
    }

    @Override
    public String getName() {
        return "";
    }
}
