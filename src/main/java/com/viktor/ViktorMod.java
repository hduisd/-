package com.viktor;

import com.viktor.event.SignSetup;
import com.viktor.event.VillagerSetup;
import com.viktor.worldgen.WorldgenSetup;
import com.viktor.registry.ModBlocks;
import com.viktor.registry.ModCreativeTabs;
import com.viktor.registry.ModFeatures;
import com.viktor.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ViktorMod.MODID)
public class ViktorMod {
    public static final String MODID = "viktor";

    public ViktorMod(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        modEventBus.addListener(VillagerSetup::onCommonSetup);
        modEventBus.addListener(SignSetup::onAddBlocks);
        modEventBus.addListener(WorldgenSetup::onCommonSetup);
    }
}
