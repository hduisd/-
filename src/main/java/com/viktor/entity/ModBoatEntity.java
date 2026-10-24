package com.viktor.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

/** Човен із власної деревини (манго, олива). Зовнішній вигляд задає ModBoatRenderer. */
public class ModBoatEntity extends Boat {
    private final Supplier<Item> dropItem;

    public ModBoatEntity(EntityType<? extends Boat> type, Level level, Supplier<Item> dropItem) {
        super(type, level);
        this.dropItem = dropItem;
    }

    @Override
    public Item getDropItem() {
        return dropItem.get();
    }
}
