package com.viktor.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

/** Типи матеріалів дерев мода (звуки дверей, люків, кнопок, хвірток). */
public class ModWoodTypes {
    public static final BlockSetType MANGO_SET = BlockSetType.register(new BlockSetType("viktor_mango"));
    public static final WoodType MANGO = WoodType.register(new WoodType("viktor_mango", MANGO_SET));

    public static final BlockSetType OLIVE_SET = BlockSetType.register(new BlockSetType("viktor_olive"));
    public static final WoodType OLIVE = WoodType.register(new WoodType("viktor_olive", OLIVE_SET));
}
