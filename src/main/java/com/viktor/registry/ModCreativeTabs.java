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
                    })
                    .build());
}
