package com.viktor.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

/**
 * Регіон TerraBlender: у частині світу рівнини й ліси замінюються на «Рожеві землі».
 * Решта біомів лишається ванільною.
 */
public class PinkLandsRegion extends Region {
    public PinkLandsRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.PLAINS, ModBiomes.PINK_LANDS);
            builder.replaceBiome(Biomes.FOREST, ModBiomes.PINK_LANDS);
        });
    }
}
