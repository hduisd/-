package com.viktor.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

/** Рожевий гнилий зомбі: поведінка ванільного зомбі, власна текстура. */
public class PinkZombie extends Zombie {
    public PinkZombie(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }
}
