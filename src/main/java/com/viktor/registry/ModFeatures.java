package com.viktor.registry;

import com.viktor.ViktorMod;
import com.viktor.worldgen.VillageBeanFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, ViktorMod.MODID);

    public static final DeferredHolder<Feature<?>, VillageBeanFeature> VILLAGE_BEANS = FEATURES.register(
            "village_beans", () -> new VillageBeanFeature(NoneFeatureConfiguration.CODEC));
}
