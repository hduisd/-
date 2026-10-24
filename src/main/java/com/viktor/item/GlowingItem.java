package com.viktor.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/** Предмет із ефектом чарів (блиск), для заряджених рожевих речей. */
public class GlowingItem extends Item {
    public GlowingItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
