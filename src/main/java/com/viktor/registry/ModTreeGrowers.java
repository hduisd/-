package com.viktor.registry;

import com.viktor.ViktorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class ModTreeGrowers {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, "mango_tree"));

    public static final TreeGrower MANGO = new TreeGrower("viktor_mango",
            Optional.empty(), Optional.of(MANGO_TREE_KEY), Optional.empty());
}
