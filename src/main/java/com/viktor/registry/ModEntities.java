package com.viktor.registry;

import com.viktor.ViktorMod;
import com.viktor.entity.ModBoatEntity;
import com.viktor.entity.ModChestBoatEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, ViktorMod.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> MANGO_BOAT = ENTITY_TYPES.register("mango_boat",
            () -> EntityType.Builder.<ModBoatEntity>of(
                            (type, level) -> new ModBoatEntity(type, level, () -> ModItems.MANGO_BOAT.get()), MobCategory.MISC)
                    .sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build("mango_boat"));

    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> MANGO_CHEST_BOAT = ENTITY_TYPES.register("mango_chest_boat",
            () -> EntityType.Builder.<ModChestBoatEntity>of(
                            (type, level) -> new ModChestBoatEntity(type, level, () -> ModItems.MANGO_CHEST_BOAT.get()), MobCategory.MISC)
                    .sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build("mango_chest_boat"));

    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> OLIVE_BOAT = ENTITY_TYPES.register("olive_boat",
            () -> EntityType.Builder.<ModBoatEntity>of(
                            (type, level) -> new ModBoatEntity(type, level, () -> ModItems.OLIVE_BOAT.get()), MobCategory.MISC)
                    .sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build("olive_boat"));

    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> OLIVE_CHEST_BOAT = ENTITY_TYPES.register("olive_chest_boat",
            () -> EntityType.Builder.<ModChestBoatEntity>of(
                            (type, level) -> new ModChestBoatEntity(type, level, () -> ModItems.OLIVE_CHEST_BOAT.get()), MobCategory.MISC)
                    .sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build("olive_chest_boat"));
}
