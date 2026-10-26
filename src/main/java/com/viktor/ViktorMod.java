package com.viktor;

import com.viktor.event.EntitySetup;
import com.viktor.event.SignSetup;
import com.viktor.event.VillagerSetup;
import com.viktor.worldgen.WorldgenSetup;
import com.viktor.registry.ModBlocks;
import com.viktor.registry.ModCreativeTabs;
import com.viktor.registry.ModEntities;
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
        ModEntities.ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(VillagerSetup::onCommonSetup);
        modEventBus.addListener(SignSetup::onAddBlocks);
        modEventBus.addListener(EntitySetup::onAttributes);
        modEventBus.addListener(EntitySetup::onSpawnPlacements);
        modEventBus.addListener(WorldgenSetup::onCommonSetup);
    }
}
