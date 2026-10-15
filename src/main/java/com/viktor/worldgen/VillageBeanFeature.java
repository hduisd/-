package com.viktor.worldgen;

import com.mojang.serialization.Codec;
import com.viktor.block.BeanCropBlock;
import com.viktor.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * Працює один раз на чанк після будівництва структур. Знаходить пшеницю на ріллі
 * (у природі таке є лише на полях сіл) і замінює частину на боби.
 */
public class VillageBeanFeature extends Feature<NoneFeatureConfiguration> {
    private static final float REPLACE_CHANCE = 0.35F;

    public VillageBeanFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int minX = origin.getX() & ~15;
        int minZ = origin.getZ() & ~15;
        boolean placedAny = false;

        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int x = minX + dx;
                int z = minZ + dz;
                int top = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
                for (int y = top + 1; y >= top - 3 && y > level.getMinBuildHeight(); y--) {
                    BlockPos pos = new BlockPos(x, y, z);
                    if (level.getBlockState(pos).is(Blocks.WHEAT)
                            && level.getBlockState(pos.below()).is(Blocks.FARMLAND)) {
                        if (random.nextFloat() < REPLACE_CHANCE) {
                            int age = random.nextInt(4) == 0 ? 2 : BeanCropBlock.BEAN_MAX_AGE;
                            BlockState beans = ModBlocks.BEAN_CROP.get().defaultBlockState()
                                    .setValue(BeanCropBlock.BEAN_AGE, age);
                            level.setBlock(pos, beans, 2);
                            placedAny = true;
                        }
                        break;
                    }
                }
            }
        }
        return placedAny;
    }
}
