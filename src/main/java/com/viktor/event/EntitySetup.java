package com.viktor.event;

import com.viktor.registry.ModEntities;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

/** Атрибути й правила появи рожевих мобів. */
public class EntitySetup {

    public static void onAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PINK_ZOMBIE.get(), Zombie.createAttributes().build());
        event.put(ModEntities.PINK_SKELETON.get(), Skeleton.createAttributes().build());
        event.put(ModEntities.PINK_CREEPER.get(), Creeper.createAttributes().build());
    }

    public static void onSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.PINK_ZOMBIE.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ModEntities.PINK_SKELETON.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ModEntities.PINK_CREEPER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
    }
}
