package com.viktor.registry;

import com.viktor.ViktorMod;
import com.viktor.item.GlowingItem;
import com.viktor.item.ModBoatItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ViktorMod.MODID);

    private static DeferredItem<Item> blockItem(String name, DeferredBlock<? extends Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // ---- Боби ----
    public static final FoodProperties BEANS_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4F)
            .build();

    /** Боби: їжа і насіння одночасно (як морква чи картопля). */
    public static final DeferredItem<Item> BEANS = ITEMS.register("beans",
            () -> new ItemNameBlockItem(ModBlocks.BEAN_CROP.get(), new Item.Properties().food(BEANS_FOOD)));

    public static final DeferredItem<Item> BEAN_BLOCK_ITEM = blockItem("bean_block", ModBlocks.BEAN_BLOCK);

    // ---- Манго ----
    public static final FoodProperties MANGO_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .build();

    public static final DeferredItem<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(MANGO_FOOD)));

    public static final DeferredItem<Item> MANGO_BLOCK_ITEM = blockItem("mango_block", ModBlocks.MANGO_BLOCK);
    public static final DeferredItem<Item> MANGO_LOG_ITEM = blockItem("mango_log", ModBlocks.MANGO_LOG);
    public static final DeferredItem<Item> STRIPPED_MANGO_LOG_ITEM = blockItem("stripped_mango_log", ModBlocks.STRIPPED_MANGO_LOG);
    public static final DeferredItem<Item> MANGO_WOOD_ITEM = blockItem("mango_wood", ModBlocks.MANGO_WOOD);
    public static final DeferredItem<Item> STRIPPED_MANGO_WOOD_ITEM = blockItem("stripped_mango_wood", ModBlocks.STRIPPED_MANGO_WOOD);
    public static final DeferredItem<Item> MANGO_PLANKS_ITEM = blockItem("mango_planks", ModBlocks.MANGO_PLANKS);
    public static final DeferredItem<Item> MANGO_LEAVES_ITEM = blockItem("mango_leaves", ModBlocks.MANGO_LEAVES);
    public static final DeferredItem<Item> MANGO_SAPLING_ITEM = blockItem("mango_sapling", ModBlocks.MANGO_SAPLING);

    public static final DeferredItem<Item> MANGO_STAIRS_ITEM = blockItem("mango_stairs", ModBlocks.MANGO_STAIRS);
    public static final DeferredItem<Item> MANGO_SLAB_ITEM = blockItem("mango_slab", ModBlocks.MANGO_SLAB);
    public static final DeferredItem<Item> MANGO_FENCE_ITEM = blockItem("mango_fence", ModBlocks.MANGO_FENCE);
    public static final DeferredItem<Item> MANGO_FENCE_GATE_ITEM = blockItem("mango_fence_gate", ModBlocks.MANGO_FENCE_GATE);
    public static final DeferredItem<Item> MANGO_DOOR_ITEM = ITEMS.register("mango_door",
            () -> new DoubleHighBlockItem(ModBlocks.MANGO_DOOR.get(), new Item.Properties()));
    public static final DeferredItem<Item> MANGO_TRAPDOOR_ITEM = blockItem("mango_trapdoor", ModBlocks.MANGO_TRAPDOOR);
    public static final DeferredItem<Item> MANGO_BUTTON_ITEM = blockItem("mango_button", ModBlocks.MANGO_BUTTON);
    public static final DeferredItem<Item> MANGO_PRESSURE_PLATE_ITEM = blockItem("mango_pressure_plate", ModBlocks.MANGO_PRESSURE_PLATE);

    // ---- Гниле манго ----
    /** Гниле манго: майже не насичує і отруює на 10 секунд (200 тіків). */
    public static final FoodProperties ROTTEN_MANGO_FOOD = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1.0F)
            .build();

    public static final DeferredItem<Item> ROTTEN_MANGO = ITEMS.register("rotten_mango",
            () -> new Item(new Item.Properties().food(ROTTEN_MANGO_FOOD)));
    public static final DeferredItem<Item> ROTTEN_MANGO_BLOCK_ITEM = blockItem("rotten_mango_block", ModBlocks.ROTTEN_MANGO_BLOCK);

    // ---- Оливки ----
    public static final FoodProperties GREEN_OLIVE_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3F)
            .build();

    public static final FoodProperties BLACK_OLIVE_FOOD = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.4F)
            .build();

    /** Оливки: їжа і «насіння» одночасно (клік по землі садить саджанець оливкового дерева). */
    public static final DeferredItem<Item> GREEN_OLIVE = ITEMS.register("green_olive",
            () -> new ItemNameBlockItem(ModBlocks.GREEN_OLIVE_SAPLING.get(), new Item.Properties().food(GREEN_OLIVE_FOOD)));

    public static final DeferredItem<Item> BLACK_OLIVE = ITEMS.register("black_olive",
            () -> new ItemNameBlockItem(ModBlocks.BLACK_OLIVE_SAPLING.get(), new Item.Properties().food(BLACK_OLIVE_FOOD)));

    public static final DeferredItem<Item> OLIVE_LOG_ITEM = blockItem("olive_log", ModBlocks.OLIVE_LOG);
    public static final DeferredItem<Item> OLIVE_PLANKS_ITEM = blockItem("olive_planks", ModBlocks.OLIVE_PLANKS);
    public static final DeferredItem<Item> GREEN_OLIVE_LEAVES_ITEM = blockItem("green_olive_leaves", ModBlocks.GREEN_OLIVE_LEAVES);
    public static final DeferredItem<Item> BLACK_OLIVE_LEAVES_ITEM = blockItem("black_olive_leaves", ModBlocks.BLACK_OLIVE_LEAVES);
    public static final DeferredItem<Item> GREEN_OLIVE_BLOCK_ITEM = blockItem("green_olive_block", ModBlocks.GREEN_OLIVE_BLOCK);
    public static final DeferredItem<Item> BLACK_OLIVE_BLOCK_ITEM = blockItem("black_olive_block", ModBlocks.BLACK_OLIVE_BLOCK);

    // ---- Набір оливкової деревини ----
    public static final DeferredItem<Item> STRIPPED_OLIVE_LOG_ITEM = blockItem("stripped_olive_log", ModBlocks.STRIPPED_OLIVE_LOG);
    public static final DeferredItem<Item> OLIVE_WOOD_ITEM = blockItem("olive_wood", ModBlocks.OLIVE_WOOD);
    public static final DeferredItem<Item> STRIPPED_OLIVE_WOOD_ITEM = blockItem("stripped_olive_wood", ModBlocks.STRIPPED_OLIVE_WOOD);
    public static final DeferredItem<Item> OLIVE_STAIRS_ITEM = blockItem("olive_stairs", ModBlocks.OLIVE_STAIRS);
    public static final DeferredItem<Item> OLIVE_SLAB_ITEM = blockItem("olive_slab", ModBlocks.OLIVE_SLAB);
    public static final DeferredItem<Item> OLIVE_FENCE_ITEM = blockItem("olive_fence", ModBlocks.OLIVE_FENCE);
    public static final DeferredItem<Item> OLIVE_FENCE_GATE_ITEM = blockItem("olive_fence_gate", ModBlocks.OLIVE_FENCE_GATE);
    public static final DeferredItem<Item> OLIVE_DOOR_ITEM = ITEMS.register("olive_door",
            () -> new DoubleHighBlockItem(ModBlocks.OLIVE_DOOR.get(), new Item.Properties()));
    public static final DeferredItem<Item> OLIVE_TRAPDOOR_ITEM = blockItem("olive_trapdoor", ModBlocks.OLIVE_TRAPDOOR);
    public static final DeferredItem<Item> OLIVE_BUTTON_ITEM = blockItem("olive_button", ModBlocks.OLIVE_BUTTON);
    public static final DeferredItem<Item> OLIVE_PRESSURE_PLATE_ITEM = blockItem("olive_pressure_plate", ModBlocks.OLIVE_PRESSURE_PLATE);

    // ---- Рожеві землі ----
    public static final DeferredItem<Item> PINK_GRASS_BLOCK_ITEM = blockItem("pink_grass_block", ModBlocks.PINK_GRASS_BLOCK);
    public static final DeferredItem<Item> PINK_DIRT_ITEM = blockItem("pink_dirt", ModBlocks.PINK_DIRT);

    public static final DeferredItem<Item> MANGO_SIGN_ITEM = ITEMS.register("mango_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MANGO_SIGN.get(), ModBlocks.MANGO_WALL_SIGN.get()));
    public static final DeferredItem<Item> MANGO_HANGING_SIGN_ITEM = ITEMS.register("mango_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MANGO_HANGING_SIGN.get(), ModBlocks.MANGO_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> OLIVE_SIGN_ITEM = ITEMS.register("olive_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.OLIVE_SIGN.get(), ModBlocks.OLIVE_WALL_SIGN.get()));
    public static final DeferredItem<Item> OLIVE_HANGING_SIGN_ITEM = ITEMS.register("olive_hanging_sign",
            () -> new HangingSignItem(ModBlocks.OLIVE_HANGING_SIGN.get(), ModBlocks.OLIVE_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> MANGO_BOAT = ITEMS.register("mango_boat",
            () -> new ModBoatItem(() -> ModEntities.MANGO_BOAT.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MANGO_CHEST_BOAT = ITEMS.register("mango_chest_boat",
            () -> new ModBoatItem(() -> ModEntities.MANGO_CHEST_BOAT.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> OLIVE_BOAT = ITEMS.register("olive_boat",
            () -> new ModBoatItem(() -> ModEntities.OLIVE_BOAT.get(), new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> OLIVE_CHEST_BOAT = ITEMS.register("olive_chest_boat",
            () -> new ModBoatItem(() -> ModEntities.OLIVE_CHEST_BOAT.get(), new Item.Properties().stacksTo(1)));

    // ---- Рожева енергія ----
    public static final DeferredItem<Item> NEUTRAL_CRYSTAL = ITEMS.register("neutral_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_ENERGY_CRYSTAL = ITEMS.register("pink_energy_crystal",
            () -> new GlowingItem(new Item.Properties()));
    /** Заглушка першого рожевого предмета (пізніше випадатиме з рожевих мобів або руди). */
    public static final DeferredItem<Item> PINK_ESSENCE = ITEMS.register("pink_essence",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHARGED_PINK_ESSENCE = ITEMS.register("charged_pink_essence",
            () -> new GlowingItem(new Item.Properties()));
    public static final DeferredItem<Item> RITUAL_TABLE_ITEM = blockItem("ritual_table", ModBlocks.RITUAL_TABLE);
    public static final DeferredItem<Item> ENRICHED_ROTTEN_MANGO_BLOCK_ITEM = blockItem("enriched_rotten_mango_block", ModBlocks.ENRICHED_ROTTEN_MANGO_BLOCK);

    // ---- Рожева руда ----
    public static final DeferredItem<Item> PINK_ORE_ITEM = blockItem("pink_ore", ModBlocks.PINK_ORE);
    public static final DeferredItem<Item> DEEPSLATE_PINK_ORE_ITEM = blockItem("deepslate_pink_ore", ModBlocks.DEEPSLATE_PINK_ORE);
}
