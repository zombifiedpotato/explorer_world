package com.github.zombifiedpotato.explorer_world.world.dimension;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class InstableWorldManager {

    public static void worldTick(World world) {
        if (world.getRegistryKey().equals(ModDimensions.EXPLORER_WORLD_DIMENSION_KEY)) {
            //This is a world to check for instability
            for (PlayerEntity p :
                    world.getPlayers()) {
                if (!p.hasStatusEffect(StatusEffects.HUNGER)) {
                    p.setStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30), null);
                }
            }
        }
    }
}
