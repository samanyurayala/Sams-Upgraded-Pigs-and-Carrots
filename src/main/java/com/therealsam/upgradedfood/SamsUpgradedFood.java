package com.therealsam.upgradedfood;

import com.therealsam.upgradedfood.block.ModBlocks;
import com.therealsam.upgradedfood.item.ModItemGroups;
import com.therealsam.upgradedfood.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsUpgradedFood implements ModInitializer {
	public static final String MOD_ID = "upgradedfood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}