package com.viktor.block;

import com.viktor.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Мангове листя: на ньому росте манго (fruit: 0 = немає, 1 = зелене, 2 = стигле жовте).
 * Манго з'являється лише на листі, під яким є вільне місце (плід «висить»).
 * Стигле манго збирається правим кліком руки.
 */
public class MangoLeavesBlock extends FlammableLeavesBlock {
    public static final IntegerProperty FRUIT = IntegerProperty.create("fruit", 0, 2);
    public static final int RIPE = 2;

    public MangoLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FRUIT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FRUIT);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return super.isRandomlyTicking(state) || state.getValue(FRUIT) < RIPE;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        BlockState current = level.getBlockState(pos);
        if (!current.is(this)) {
            return; // листя могло опасти
        }
        int fruit = current.getValue(FRUIT);
        if (fruit < RIPE && level.isEmptyBlock(pos.below()) && random.nextInt(3) == 0) {
            level.setBlock(pos, current.setValue(FRUIT, fruit + 1), 2);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(FRUIT) == RIPE) {
            if (!level.isClientSide) {
                int count = 1 + level.random.nextInt(2);
                Block.popResource(level, pos.below(), new ItemStack(ModItems.MANGO.get(), count));
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                        1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlock(pos, state.setValue(FRUIT, 0), 2);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
