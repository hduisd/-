package com.viktor.event;

import com.viktor.ViktorMod;
import com.viktor.registry.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
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
        trades.get(1).add((trader, random) -> new MerchantOffer(
                new ItemCost(ModItems.BEANS.get(), 22),
                new ItemStack(Items.EMERALD, 1),
                16, 2, 0.05F));

        // Рівень 1: фермер продає 4 боби за 1 смарагд.
        trades.get(1).add((trader, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.BEANS.get(), 4),
                16, 2, 0.05F));
    }
}
