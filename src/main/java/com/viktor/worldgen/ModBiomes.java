package com.viktor.worldgen;

import com.viktor.ViktorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    private static ResourceKey<Biome> key(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, name));
    }

    /** Біом «Рожеві землі» (data/viktor/worldgen/biome/pink_lands.json). */
    public static final ResourceKey<Biome> PINK_LANDS = key("pink_lands");

    /** Біом «Байківецька земля» (data/viktor/worldgen/biome/baykivetska_land.json). */
    public static final ResourceKey<Biome> BAYKIVETSKA_LAND = key("baykivetska_land");
}
