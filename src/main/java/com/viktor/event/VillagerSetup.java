package com.viktor.event;

import com.google.common.collect.ImmutableSet;
import com.viktor.registry.ModItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashSet;
import java.util.Set;

/** Додає боби до списку предметів, які жителі підбирають (потрібно, щоб фермери мали що садити). */
public class VillagerSetup {

    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Set<Item> wanted = new HashSet<>(Villager.WANTED_ITEMS);
            wanted.add(ModItems.BEANS.get());
            Villager.WANTED_ITEMS = ImmutableSet.copyOf(wanted);
        });
    }
}
