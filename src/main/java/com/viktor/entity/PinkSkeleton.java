package com.viktor.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;

/** Рожевий гнилий скелет: поведінка ванільного скелета, власна текстура. */
public class PinkSkeleton extends Skeleton {
    public PinkSkeleton(EntityType<? extends Skeleton> type, Level level) {
        super(type, level);
    }
}
