package com.viktor.registry;

import com.viktor.ViktorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Optional;

public class ModTreeGrowers {
    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, name));
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE_KEY = key("mango_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_OLIVE_TREE_KEY = key("green_olive_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_OLIVE_TREE_KEY = key("black_olive_tree");

    public static final TreeGrower MANGO = new TreeGrower("viktor_mango",
            Optional.empty(), Optional.of(MANGO_TREE_KEY), Optional.empty());
    public static final TreeGrower GREEN_OLIVE = new TreeGrower("viktor_green_olive",
            Optional.empty(), Optional.of(GREEN_OLIVE_TREE_KEY), Optional.empty());
    public static final TreeGrower BLACK_OLIVE = new TreeGrower("viktor_black_olive",
            Optional.empty(), Optional.of(BLACK_OLIVE_TREE_KEY), Optional.empty());
}
