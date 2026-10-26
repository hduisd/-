package com.viktor.registry;

import com.viktor.ViktorMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ViktorMod.MODID);

    public static final Supplier<CreativeModeTab> VIKTOR_TAB = TABS.register("viktor_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.viktor"))
                    .icon(() -> new ItemStack(ModItems.BEANS.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BEANS.get());
                        output.accept(ModItems.BEAN_BLOCK_ITEM.get());
                        output.accept(ModItems.MANGO.get());
                        output.accept(ModItems.MANGO_BLOCK_ITEM.get());
                        output.accept(ModItems.MANGO_LOG_ITEM.get());
                        output.accept(ModItems.STRIPPED_MANGO_LOG_ITEM.get());
                        output.accept(ModItems.MANGO_WOOD_ITEM.get());
                        output.accept(ModItems.STRIPPED_MANGO_WOOD_ITEM.get());
                        output.accept(ModItems.MANGO_PLANKS_ITEM.get());
                        output.accept(ModItems.MANGO_LEAVES_ITEM.get());
                        output.accept(ModItems.MANGO_SAPLING_ITEM.get());
                        output.accept(ModItems.MANGO_STAIRS_ITEM.get());
                        output.accept(ModItems.MANGO_SLAB_ITEM.get());
                        output.accept(ModItems.MANGO_FENCE_ITEM.get());
                        output.accept(ModItems.MANGO_FENCE_GATE_ITEM.get());
                        output.accept(ModItems.MANGO_DOOR_ITEM.get());
                        output.accept(ModItems.MANGO_TRAPDOOR_ITEM.get());
                        output.accept(ModItems.MANGO_BUTTON_ITEM.get());
                        output.accept(ModItems.MANGO_PRESSURE_PLATE_ITEM.get());
                        output.accept(ModItems.MANGO_SIGN_ITEM.get());
                        output.accept(ModItems.MANGO_HANGING_SIGN_ITEM.get());
                        output.accept(ModItems.MANGO_BOAT.get());
                        output.accept(ModItems.MANGO_CHEST_BOAT.get());
                        output.accept(ModItems.ROTTEN_MANGO.get());
                        output.accept(ModItems.ROTTEN_MANGO_BLOCK_ITEM.get());
                        output.accept(ModItems.GREEN_OLIVE.get());
                        output.accept(ModItems.BLACK_OLIVE.get());
                        output.accept(ModItems.GREEN_OLIVE_BLOCK_ITEM.get());
                        output.accept(ModItems.BLACK_OLIVE_BLOCK_ITEM.get());
                        output.accept(ModItems.OLIVE_LOG_ITEM.get());
                        output.accept(ModItems.OLIVE_PLANKS_ITEM.get());
                        output.accept(ModItems.STRIPPED_OLIVE_LOG_ITEM.get());
                        output.accept(ModItems.OLIVE_WOOD_ITEM.get());
                        output.accept(ModItems.STRIPPED_OLIVE_WOOD_ITEM.get());
                        output.accept(ModItems.OLIVE_STAIRS_ITEM.get());
                        output.accept(ModItems.OLIVE_SLAB_ITEM.get());
                        output.accept(ModItems.OLIVE_FENCE_ITEM.get());
                        output.accept(ModItems.OLIVE_FENCE_GATE_ITEM.get());
                        output.accept(ModItems.OLIVE_DOOR_ITEM.get());
                        output.accept(ModItems.OLIVE_TRAPDOOR_ITEM.get());
                        output.accept(ModItems.OLIVE_BUTTON_ITEM.get());
                        output.accept(ModItems.OLIVE_PRESSURE_PLATE_ITEM.get());
                        output.accept(ModItems.OLIVE_SIGN_ITEM.get());
                        output.accept(ModItems.OLIVE_HANGING_SIGN_ITEM.get());
                        output.accept(ModItems.OLIVE_BOAT.get());
                        output.accept(ModItems.OLIVE_CHEST_BOAT.get());
                        output.accept(ModItems.PINK_GRASS_BLOCK_ITEM.get());
                        output.accept(ModItems.PINK_DIRT_ITEM.get());
                        output.accept(ModItems.NEUTRAL_CRYSTAL.get());
                        output.accept(ModItems.PINK_ESSENCE.get());
                        output.accept(ModItems.CHARGED_PINK_ESSENCE.get());
                        output.accept(ModItems.PINK_ENERGY_CRYSTAL.get());
                        output.accept(ModItems.RITUAL_TABLE_ITEM.get());
                        output.accept(ModItems.ENRICHED_ROTTEN_MANGO_BLOCK_ITEM.get());
                        output.accept(ModItems.PINK_ORE_ITEM.get());
                        output.accept(ModItems.DEEPSLATE_PINK_ORE_ITEM.get());
                        output.accept(ModItems.PINK_ZOMBIE_SPAWN_EGG.get());
                        output.accept(ModItems.PINK_SKELETON_SPAWN_EGG.get());
                        output.accept(ModItems.PINK_CREEPER_SPAWN_EGG.get());
                        output.accept(ModItems.GREEN_OLIVE_LEAVES_ITEM.get());
                        output.accept(ModItems.BLACK_OLIVE_LEAVES_ITEM.get());
                    })
                    .build());
}
