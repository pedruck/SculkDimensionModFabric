package net.mods.sculkdimensionmod;

import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.mods.sculkdimensionmod.block.ModBlocks;
import net.mods.sculkdimensionmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SculkDimensionMod implements ModInitializer {
	public static final String MOD_ID = "sculkdimensionmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.BONE_BLOCK)
				.lightWithItem(ModItems.ALK_INGOT)
				.destDimID(Identifier.of(SculkDimensionMod.MOD_ID, "sculkdim"))
				.tintColor(5, 165, 245)
				.registerPortal();



	}
}