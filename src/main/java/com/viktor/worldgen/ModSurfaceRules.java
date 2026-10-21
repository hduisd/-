package com.viktor.worldgen;

import com.viktor.registry.ModBlocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

/** Поверхня «Рожевих земель»: рожева трава зверху, рожева земля під нею. */
public class ModSurfaceRules {
    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.RuleSource grass = SurfaceRules.state(ModBlocks.PINK_GRASS_BLOCK.get().defaultBlockState());
        SurfaceRules.RuleSource dirt = SurfaceRules.state(ModBlocks.PINK_DIRT.get().defaultBlockState());
        SurfaceRules.RuleSource topLayer = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), grass),
                dirt);
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.PINK_LANDS),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, topLayer),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, dirt)));
    }
}
