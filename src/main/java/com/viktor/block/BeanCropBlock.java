package com.viktor.block;

import com.mojang.serialization.MapCodec;
import com.viktor.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Рослина бобів: 4 стадії росту (age 0..3), як у буряка. */
public class BeanCropBlock extends CropBlock {
    public static final MapCodec<BeanCropBlock> CODEC = simpleCodec(BeanCropBlock::new);
    public static final int BEAN_MAX_AGE = 3;
    public static final IntegerProperty BEAN_AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0)
    };

    public BeanCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<BeanCropBlock> codec() {
        return CODEC;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return BEAN_AGE;
    }

    @Override
    public int getMaxAge() {
        return BEAN_MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEANS.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BEAN_AGE);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }
}
