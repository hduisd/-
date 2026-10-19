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
}
