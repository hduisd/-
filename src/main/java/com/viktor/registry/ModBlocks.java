package com.viktor.registry;

import com.viktor.ViktorMod;
import com.viktor.block.BeanCropBlock;
import com.viktor.block.FlammableBlock;
import com.viktor.block.FlammableFenceBlock;
import com.viktor.block.FlammableFenceGateBlock;
import com.viktor.block.FlammableSlabBlock;
import com.viktor.block.FlammableStairBlock;
import com.viktor.block.MangoLeavesBlock;
import com.viktor.block.MangoLogBlock;
import com.viktor.block.OliveLeavesBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ViktorMod.MODID);

    // ---- Боби ----
    public static final DeferredBlock<BeanCropBlock> BEAN_CROP = BLOCKS.register("bean_crop",
            () -> new BeanCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> BEAN_BLOCK = BLOCKS.register("bean_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(1.0F)
                    .sound(SoundType.WOOD)));

    // ---- Мангове дерево ----
    public static final DeferredBlock<MangoLogBlock> STRIPPED_MANGO_LOG = BLOCKS.register("stripped_mango_log",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG), null));

    public static final DeferredBlock<MangoLogBlock> STRIPPED_MANGO_WOOD = BLOCKS.register("stripped_mango_wood",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD), null));

    public static final DeferredBlock<MangoLogBlock> MANGO_LOG = BLOCKS.register("mango_log",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG),
                    () -> ModBlocks.STRIPPED_MANGO_LOG.get()));

    public static final DeferredBlock<MangoLogBlock> MANGO_WOOD = BLOCKS.register("mango_wood",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    () -> ModBlocks.STRIPPED_MANGO_WOOD.get()));

    public static final DeferredBlock<FlammableBlock> MANGO_PLANKS = BLOCKS.register("mango_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), 5, 20));

    public static final DeferredBlock<MangoLeavesBlock> MANGO_LEAVES = BLOCKS.register("mango_leaves",
            () -> new MangoLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<SaplingBlock> MANGO_SAPLING = BLOCKS.register("mango_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MANGO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    // ---- Набір мангової деревини ----
    public static final DeferredBlock<FlammableStairBlock> MANGO_STAIRS = BLOCKS.register("mango_stairs",
            () -> new FlammableStairBlock(MANGO_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

    public static final DeferredBlock<FlammableSlabBlock> MANGO_SLAB = BLOCKS.register("mango_slab",
            () -> new FlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final DeferredBlock<FlammableFenceBlock> MANGO_FENCE = BLOCKS.register("mango_fence",
            () -> new FlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));

    public static final DeferredBlock<FlammableFenceGateBlock> MANGO_FENCE_GATE = BLOCKS.register("mango_fence_gate",
            () -> new FlammableFenceGateBlock(ModWoodTypes.MANGO,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> MANGO_DOOR = BLOCKS.register("mango_door",
            () -> new DoorBlock(ModWoodTypes.MANGO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));

    public static final DeferredBlock<TrapDoorBlock> MANGO_TRAPDOOR = BLOCKS.register("mango_trapdoor",
            () -> new TrapDoorBlock(ModWoodTypes.MANGO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final DeferredBlock<ButtonBlock> MANGO_BUTTON = BLOCKS.register("mango_button",
            () -> new ButtonBlock(ModWoodTypes.MANGO_SET, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<PressurePlateBlock> MANGO_PRESSURE_PLATE = BLOCKS.register("mango_pressure_plate",
            () -> new PressurePlateBlock(ModWoodTypes.MANGO_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

    // ---- Гниле манго ----
    public static final DeferredBlock<Block> ROTTEN_MANGO_BLOCK = BLOCKS.register("rotten_mango_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(0.6F)
                    .sound(SoundType.MUD)));

    // ---- Блок манго ----
    public static final DeferredBlock<Block> MANGO_BLOCK = BLOCKS.register("mango_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .strength(0.6F)
                    .sound(SoundType.WART_BLOCK)));

    // ---- Оливки ----
    public static final DeferredBlock<MangoLogBlock> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG), null));

    public static final DeferredBlock<MangoLogBlock> STRIPPED_OLIVE_WOOD = BLOCKS.register("stripped_olive_wood",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD), null));

    public static final DeferredBlock<MangoLogBlock> OLIVE_LOG = BLOCKS.register("olive_log",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG),
                    () -> ModBlocks.STRIPPED_OLIVE_LOG.get()));

    public static final DeferredBlock<MangoLogBlock> OLIVE_WOOD = BLOCKS.register("olive_wood",
            () -> new MangoLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),
                    () -> ModBlocks.STRIPPED_OLIVE_WOOD.get()));

    public static final DeferredBlock<FlammableBlock> OLIVE_PLANKS = BLOCKS.register("olive_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), 5, 20));

    public static final DeferredBlock<OliveLeavesBlock> GREEN_OLIVE_LEAVES = BLOCKS.register("green_olive_leaves",
            () -> new OliveLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),
                    () -> ModItems.GREEN_OLIVE.get()));

    public static final DeferredBlock<OliveLeavesBlock> BLACK_OLIVE_LEAVES = BLOCKS.register("black_olive_leaves",
            () -> new OliveLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES),
                    () -> ModItems.BLACK_OLIVE.get()));

    public static final DeferredBlock<SaplingBlock> GREEN_OLIVE_SAPLING = BLOCKS.register("green_olive_sapling",
            () -> new SaplingBlock(ModTreeGrowers.GREEN_OLIVE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<SaplingBlock> BLACK_OLIVE_SAPLING = BLOCKS.register("black_olive_sapling",
            () -> new SaplingBlock(ModTreeGrowers.BLACK_OLIVE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> GREEN_OLIVE_BLOCK = BLOCKS.register("green_olive_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(0.6F)
                    .sound(SoundType.WART_BLOCK)));

    public static final DeferredBlock<Block> BLACK_OLIVE_BLOCK = BLOCKS.register("black_olive_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(0.6F)
                    .sound(SoundType.WART_BLOCK)));

    // ---- Набір оливкової деревини ----
    public static final DeferredBlock<FlammableStairBlock> OLIVE_STAIRS = BLOCKS.register("olive_stairs",
            () -> new FlammableStairBlock(OLIVE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

    public static final DeferredBlock<FlammableSlabBlock> OLIVE_SLAB = BLOCKS.register("olive_slab",
            () -> new FlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final DeferredBlock<FlammableFenceBlock> OLIVE_FENCE = BLOCKS.register("olive_fence",
            () -> new FlammableFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));

    public static final DeferredBlock<FlammableFenceGateBlock> OLIVE_FENCE_GATE = BLOCKS.register("olive_fence_gate",
            () -> new FlammableFenceGateBlock(ModWoodTypes.OLIVE,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> OLIVE_DOOR = BLOCKS.register("olive_door",
            () -> new DoorBlock(ModWoodTypes.OLIVE_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));

    public static final DeferredBlock<TrapDoorBlock> OLIVE_TRAPDOOR = BLOCKS.register("olive_trapdoor",
            () -> new TrapDoorBlock(ModWoodTypes.OLIVE_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final DeferredBlock<ButtonBlock> OLIVE_BUTTON = BLOCKS.register("olive_button",
            () -> new ButtonBlock(ModWoodTypes.OLIVE_SET, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<PressurePlateBlock> OLIVE_PRESSURE_PLATE = BLOCKS.register("olive_pressure_plate",
            () -> new PressurePlateBlock(ModWoodTypes.OLIVE_SET, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

    // ---- Рожеві землі ----
    public static final DeferredBlock<Block> PINK_GRASS_BLOCK = BLOCKS.register("pink_grass_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PINK)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> PINK_DIRT = BLOCKS.register("pink_dirt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(0.5F)
                    .sound(SoundType.GRAVEL)));
}
