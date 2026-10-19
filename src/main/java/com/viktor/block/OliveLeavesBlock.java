package com.viktor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

/**
 * Оливкове листя (зелене або чорне дерево): fruit 0 = немає, 1 = недозріла, 2 = дозріла.
 * Дозріла олива збирається правим кліком руки (2-4 шт.).
 */
public class OliveLeavesBlock extends FlammableLeavesBlock {
    public static final IntegerProperty FRUIT = IntegerProperty.create("fruit", 0, 2);
    public static final int RIPE = 2;

    private final Supplier<? extends Item> oliveItem;

    public OliveLeavesBlock(Properties properties, Supplier<? extends Item> oliveItem) {
        super(properties);
        this.oliveItem = oliveItem;
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
        if (fruit < RIPE && level.isEmptyBlock(pos.below()) && random.nextInt(6) == 0) {
            level.setBlock(pos, current.setValue(FRUIT, fruit + 1), 2);
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (state.getValue(FRUIT) == RIPE) {
            if (!level.isClientSide) {
                int count = 2 + level.random.nextInt(3);
                Block.popResource(level, pos.below(), new ItemStack(oliveItem.get(), count));
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                        1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlock(pos, state.setValue(FRUIT, 0), 2);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
