package com.viktor.event;

import com.viktor.registry.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

/** Додає наші таблички до ванільних блок-сутностей табличок (вони дозволяють писати текст). */
public class SignSetup {
    public static void onAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.SIGN,
                ModBlocks.MANGO_SIGN.get(), ModBlocks.MANGO_WALL_SIGN.get(),
                ModBlocks.OLIVE_SIGN.get(), ModBlocks.OLIVE_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN,
                ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(),
                ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get());
    }
}
