package com.viktor.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

/** Човен зі скринею із власної деревини. */
public class ModChestBoatEntity extends ChestBoat {
    private final Supplier<Item> dropItem;

    public ModChestBoatEntity(EntityType<? extends ChestBoat> type, Level level, Supplier<Item> dropItem) {
        super(type, level);
        this.dropItem = dropItem;
    }

    @Override
    public Item getDropItem() {
        return dropItem.get();
    }
}
