package com.viktor.client;

import com.mojang.datafixers.util.Pair;
import com.viktor.ViktorMod;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

/** Рендер човна з власною деревиною: своя текстура й власна модель-шар. */
public class ModBoatRenderer extends BoatRenderer {
    private final Pair<ResourceLocation, ListModel<Boat>> resources;

    public ModBoatRenderer(EntityRendererProvider.Context context, String wood, boolean chest) {
        super(context, chest);
        String folder = chest ? "chest_boat/" : "boat/";
        ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID,
                "textures/entity/" + folder + wood + ".png");
        ModelLayerLocation layer = layer(wood, chest);
        ListModel<Boat> model = chest
                ? new ChestBoatModel(context.bakeLayer(layer))
                : new BoatModel(context.bakeLayer(layer));
        this.resources = Pair.of(texture, model);
    }

    public static ModelLayerLocation layer(String wood, boolean chest) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID,
                (chest ? "chest_boat/" : "boat/") + wood), "main");
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        return this.resources;
    }
}
