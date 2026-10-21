package com.viktor.worldgen;

import com.viktor.ViktorMod;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

/** Підключення біома до світу через TerraBlender. */
public class WorldgenSetup {
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new PinkLandsRegion(ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, "overworld"), 4));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ViktorMod.MODID, ModSurfaceRules.makeRules());
        });
    }
}
