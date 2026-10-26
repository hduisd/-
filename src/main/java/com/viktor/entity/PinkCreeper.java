package com.viktor.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

/** Рожевий гнилий кріпер: поведінка ванільного кріпера, власна текстура. */
public class PinkCreeper extends Creeper {
    public PinkCreeper(EntityType<? extends Creeper> type, Level level) {
        super(type, level);
    }
}
