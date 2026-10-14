package com.viktor.registry;

import com.viktor.ViktorMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ViktorMod.MODID);

    public static final FoodProperties BEANS_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4F)
            .build();

    /** Боби: їжа і насіння одночасно (як морква чи картопля). */
    public static final DeferredItem<Item> BEANS = ITEMS.register("beans",
            () -> new ItemNameBlockItem(ModBlocks.BEAN_CROP.get(), new Item.Properties().food(BEANS_FOOD)));

    public static final DeferredItem<Item> BEAN_BLOCK_ITEM = ITEMS.register("bean_block",
            () -> new BlockItem(ModBlocks.BEAN_BLOCK.get(), new Item.Properties()));
}
