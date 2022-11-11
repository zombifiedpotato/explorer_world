package com.github.zombifiedpotato.explorer_world.world;

import com.github.zombifiedpotato.explorer_world.Main;
import com.github.zombifiedpotato.explorer_world.world.dimension.ModDimensions;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InstableWorldManager {

    public static void worldTick(World world) {
        if (world.getRegistryKey().equals(ModDimensions.EXPLORER_WORLD_DIMENSION_KEY)) {
            //This is a world to check for instability
            // Temporary disable
                if (false) {
                    resetWorld(world.getServer());
                }

        }
    }

    public static void resetWorld(MinecraftServer server) {
        ServerWorld serverWorld = server.getWorld(ModDimensions.EXPLORER_WORLD_DIMENSION_KEY);
        assert serverWorld != null;
        if (serverWorld.getChunkManager().getLoadedChunkCount() == 0) {
            //Reset World


            Main.LOGGER.info("Resetting world " + serverWorld + "!");
            String saveDir;
            if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT)) {
                // ToDo not working and serverWorld.toString() is world name not world path
                saveDir = FabricLoader.getInstance().getGameDir() + "\\saves\\" + StringUtils.substringBetween(serverWorld.toString(), "[", "]") + "\\dimensions\\" + serverWorld.getChunkManager().threadedAnvilChunkStorage.getSaveDir() + "\\" + serverWorld.getChunkManager().threadedAnvilChunkStorage.getSaveDir() + "/region";
            } else {
                saveDir = FabricLoader.getInstance().getGameDir() + "\\world/dimensions\\" + serverWorld.getChunkManager().threadedAnvilChunkStorage.getSaveDir() + "\\" + serverWorld.getChunkManager().threadedAnvilChunkStorage.getSaveDir() + "/region";
            }
            Main.LOGGER.info("savedir for " + serverWorld + " is " + saveDir);
            try {
                Main.LOGGER.info("Deleting!");
                FileUtils.cleanDirectory(new File(saveDir));
                Main.LOGGER.info("folder cleaned!");

            } catch (Exception e) {
                Main.LOGGER.warn("Exception during cleaning!");
                e.printStackTrace();
            }
        } else {
            Main.LOGGER.warn(serverWorld + " has loaded chunks!");
        }
    }

}
