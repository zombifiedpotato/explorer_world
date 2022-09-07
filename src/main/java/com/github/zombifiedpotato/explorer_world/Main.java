package com.github.zombifiedpotato.explorer_world;

import com.github.zombifiedpotato.explorer_world.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static String MOD_ID = "explorer_world";
	public static final Logger LOGGER = LoggerFactory.getLogger("explorer_world");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello from Explorer World!");
		ModDimensions.registerDimensions();
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.AMETHYST_BLOCK)
				.destDimID(new Identifier(MOD_ID, "explorer_world"))
				.tintColor(255, 246, 168)
				.registerPortal();
	}


}
