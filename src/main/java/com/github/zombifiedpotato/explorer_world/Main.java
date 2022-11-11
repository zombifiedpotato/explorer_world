package com.github.zombifiedpotato.explorer_world;

import com.github.zombifiedpotato.explorer_world.world.InstableWorldManager;
import com.github.zombifiedpotato.explorer_world.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.literal;


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

		ServerTickEvents.END_WORLD_TICK.register((InstableWorldManager::worldTick));

		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(literal("resetExplorer")
				.requires(source -> source.hasPermissionLevel(4))
				.executes(context -> {


					InstableWorldManager.resetWorld(context.getSource().getWorld().getServer());
					return 1;
				})));
	}


}
