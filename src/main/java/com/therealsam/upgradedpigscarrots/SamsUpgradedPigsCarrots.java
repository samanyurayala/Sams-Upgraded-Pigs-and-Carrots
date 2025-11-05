package com.therealsam.upgradedpigscarrots;

import com.therealsam.upgradedpigscarrots.item.ModItemGroups;
import com.therealsam.upgradedpigscarrots.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsUpgradedPigsCarrots implements ModInitializer {
	public static final String MOD_ID = "upgradedpigscarrots";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
	}
}