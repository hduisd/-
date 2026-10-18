package com.viktor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/** Звичайний блок, який горить (дошки тощо). */
public class FlammableBlock extends Block {
    private final int fireSpread;
    private final int flammability;

    public FlammableBlock(Properties properties, int fireSpread, int flammability) {
        super(properties);
        this.fireSpread = fireSpread;
        this.flammability = flammability;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return fireSpread;
    }
}
