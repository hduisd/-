package com.viktor.event;

import com.viktor.ViktorMod;
import com.viktor.registry.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = ViktorMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() != VillagerProfession.FARMER) {
            return;
        }
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        // Рівень 1 (Новачок): фермер купує 22 боби за 1 смарагд.
        trades.get(1).add(new VillagerTrades.EmeraldForItems(ModItems.BEANS.get(), 22, 16, 2));
        // Рівень 1: фермер продає 4 боби за 1 смарагд.
        trades.get(1).add(new VillagerTrades.ItemsForEmeralds(ModItems.BEANS.get(), 1, 4, 16, 2));
    }
}
