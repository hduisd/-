package com.viktor.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

/** Тип матеріалу мангового дерева (звуки дверей, люків, кнопок, хвірток). */
public class ModWoodTypes {
    public static final BlockSetType MANGO_SET = BlockSetType.register(new BlockSetType("viktor_mango"));
    public static final WoodType MANGO = WoodType.register(new WoodType("viktor_mango", MANGO_SET));
}
