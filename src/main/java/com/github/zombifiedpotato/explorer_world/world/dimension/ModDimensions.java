package com.github.zombifiedpotato.explorer_world.world.dimension;

import com.github.zombifiedpotato.explorer_world.Main;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> EXPLORER_WORLD_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(Main.MOD_ID, "explorer_world"));
    public static final RegistryKey<DimensionType> EXPLORER_WORLD_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            EXPLORER_WORLD_DIMENSION_KEY.getValue());

    public static void registerDimensions() {
        Main.LOGGER.debug("Registering dimensions for " + Main.MOD_ID);
    }
}
