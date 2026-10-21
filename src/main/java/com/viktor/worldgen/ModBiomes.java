package com.viktor.worldgen;

import com.viktor.ViktorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    /** Біом «Рожеві землі» (описаний у data/viktor/worldgen/biome/pink_lands.json). */
    public static final ResourceKey<Biome> PINK_LANDS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, "pink_lands"));
}
