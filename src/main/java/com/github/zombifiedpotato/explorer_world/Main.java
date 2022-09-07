package com.github.zombifiedpotato.explorer_world;

import net.fabricmc.api.ModInitializer;
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
	}
}
