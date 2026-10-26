package com.viktor.client;

import com.viktor.ViktorMod;
import com.viktor.registry.ModEntities;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/** Клієнтські реєстрації: моделі-шари й рендери човнів. */
@EventBusSubscriber(modid = ViktorMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (String wood : new String[]{"mango", "olive"}) {
            event.registerLayerDefinition(ModBoatRenderer.layer(wood, false), BoatModel::createBodyModel);
            event.registerLayerDefinition(ModBoatRenderer.layer(wood, true), ChestBoatModel::createBodyModel);
        }
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.MANGO_BOAT.get(), ctx -> new ModBoatRenderer(ctx, "mango", false));
        event.registerEntityRenderer(ModEntities.MANGO_CHEST_BOAT.get(), ctx -> new ModBoatRenderer(ctx, "mango", true));
        event.registerEntityRenderer(ModEntities.OLIVE_BOAT.get(), ctx -> new ModBoatRenderer(ctx, "olive", false));
        event.registerEntityRenderer(ModEntities.OLIVE_CHEST_BOAT.get(), ctx -> new ModBoatRenderer(ctx, "olive", true));
        event.registerEntityRenderer(ModEntities.PINK_ZOMBIE.get(), PinkZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.PINK_SKELETON.get(), PinkSkeletonRenderer::new);
        event.registerEntityRenderer(ModEntities.PINK_CREEPER.get(), PinkCreeperRenderer::new);
    }
}
