package com.viktor.registry;

import com.viktor.ViktorMod;
import com.viktor.block.BeanCropBlock;
import com.viktor.block.FlammableBlock;
import com.viktor.block.FlammableLeavesBlock;
import com.viktor.block.MangoLeavesBlock;
import com.viktor.block.MangoLogBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
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
}
