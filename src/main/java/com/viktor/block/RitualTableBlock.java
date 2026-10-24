package com.viktor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Optional;

/**
 * Ритуальний стіл. Тримайте два предмети в руках (основна й ліва) і клацніть по столу:
 * якщо є ритуал для цієї пари, обидва предмети витрачаються і ви отримуєте результат.
 */
public class RitualTableBlock extends Block {
    public RitualTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (hand != InteractionHand.MAIN_HAND) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        Optional<Rituals.Match> match = Rituals.find(main, off);
        if (match.isEmpty()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (!level.isClientSide) {
            ItemStack result = match.get().ritual().result().get();
            if (!player.getAbilities().instabuild) {
                main.shrink(1);
                off.shrink(1);
            }
            if (!player.getInventory().add(result)) {
                player.drop(result, false);
            }
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CHERRY_LEAVES,
                        pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, 24, 0.35, 0.3, 0.35, 0.05);
                serverLevel.sendParticles(ParticleTypes.ENCHANT,
                        pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 30, 0.4, 0.4, 0.4, 0.6);
            }
            level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.7F);
            level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.8F, 1.1F);
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
                                               BlockHitResult hitResult) {
        if (player.getMainHandItem().isEmpty()) {
            if (!level.isClientSide) {
                player.displayClientMessage(Component.translatable("message.viktor.ritual_hint"), true);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
