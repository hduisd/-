package com.viktor.block;

import com.viktor.registry.ModItems;
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

/**
 * Мангове листя: на ньому росте манго.
 * fruit: 0 = немає, 1 = зелене, 2 = стигле жовте, 3 = гниле.
 * ripe_age (0..7): «годинник» гниття стиглого плоду. Кожен крок займає в середньому ~9000 тіків,
 * 8 кроків = ~72000 тіків = 3 ігрові доби (при стандартному randomTickSpeed = 3).
 * Плід з'являється лише там, де під листям є вільне місце (він «висить»).
 * Стигле і гниле збираються правим кліком руки.
 */
public class MangoLeavesBlock extends FlammableLeavesBlock {
    public static final IntegerProperty FRUIT = IntegerProperty.create("fruit", 0, 3);
    public static final IntegerProperty RIPE_AGE = IntegerProperty.create("ripe_age", 0, 7);
    public static final int RIPE = 2;
    public static final int ROTTEN = 3;
    public static final int RIPE_AGE_MAX = 7;

    public MangoLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FRUIT, 0).setValue(RIPE_AGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FRUIT, RIPE_AGE);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return super.isRandomlyTicking(state) || state.getValue(FRUIT) < ROTTEN;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        BlockState current = level.getBlockState(pos);
        if (!current.is(this)) {
            return; // листя могло опасти
        }
        int fruit = current.getValue(FRUIT);
        if (fruit < RIPE) {
            // ріст плоду: у середньому ~7 хвилин на стадію
            if (level.isEmptyBlock(pos.below()) && random.nextInt(6) == 0) {
                level.setBlock(pos, current.setValue(FRUIT, fruit + 1).setValue(RIPE_AGE, 0), 2);
            }
        } else if (fruit == RIPE && random.nextInt(20) < 3) {
            int age = current.getValue(RIPE_AGE);
            if (age >= RIPE_AGE_MAX) {
                level.setBlock(pos, current.setValue(FRUIT, ROTTEN).setValue(RIPE_AGE, 0), 2);
            } else {
                level.setBlock(pos, current.setValue(RIPE_AGE, age + 1), 2);
            }
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int fruit = state.getValue(FRUIT);
        if (fruit == RIPE || fruit == ROTTEN) {
            if (!level.isClientSide) {
                Item drop = fruit == RIPE ? ModItems.MANGO.get() : ModItems.ROTTEN_MANGO.get();
                int count = 1 + level.random.nextInt(2);
                Block.popResource(level, pos.below(), new ItemStack(drop, count));
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                        1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                level.setBlock(pos, state.setValue(FRUIT, 0).setValue(RIPE_AGE, 0), 2);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
