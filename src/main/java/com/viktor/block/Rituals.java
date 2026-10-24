package com.viktor.block;

import com.viktor.ViktorMod;
import com.viktor.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Рецепти ритуального столу. Гравець тримає два предмети в руках (порядок неважливий).
 * Щоб додати новий рожевий предмет, достатньо додати його в тег viktor:pink_raw
 * (і рядок «сире -> заряджене» нижче) або в тег viktor:pink_charged.
 */
public class Rituals {
    public static final TagKey<Item> PINK_RAW = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, "pink_raw"));
    public static final TagKey<Item> PINK_CHARGED = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(ViktorMod.MODID, "pink_charged"));

    public record Ritual(Predicate<ItemStack> first, Predicate<ItemStack> second, Supplier<ItemStack> result) {
    }

    public static final List<Ritual> ALL = List.of(
            // 1) рожева есенція + гниле манго -> заряджена рожева есенція
            new Ritual(s -> s.is(ModItems.PINK_ESSENCE.get()), s -> s.is(ModItems.ROTTEN_MANGO.get()),
                    () -> new ItemStack(ModItems.CHARGED_PINK_ESSENCE.get())),
            // 2) нейтральний кристал + будь-який заряджений рожевий предмет -> рожевий енергетичний кристал
            new Ritual(s -> s.is(ModItems.NEUTRAL_CRYSTAL.get()), s -> s.is(PINK_CHARGED),
                    () -> new ItemStack(ModItems.PINK_ENERGY_CRYSTAL.get())),
            // 3) блок гнилого манго + рожевий енергетичний кристал -> збагачений блок гнилого манго
            new Ritual(s -> s.is(ModItems.ROTTEN_MANGO_BLOCK_ITEM.get()), s -> s.is(ModItems.PINK_ENERGY_CRYSTAL.get()),
                    () -> new ItemStack(ModItems.ENRICHED_ROTTEN_MANGO_BLOCK_ITEM.get()))
    );

    /** Результат ритуалу для двох предметів, якщо рецепт знайдено (будь-який порядок). */
    public static Optional<Match> find(ItemStack a, ItemStack b) {
        if (a.isEmpty() || b.isEmpty()) {
            return Optional.empty();
        }
        for (Ritual ritual : ALL) {
            if (ritual.first().test(a) && ritual.second().test(b)) {
                return Optional.of(new Match(ritual, false));
            }
            if (ritual.first().test(b) && ritual.second().test(a)) {
                return Optional.of(new Match(ritual, true));
            }
        }
        return Optional.empty();
    }

    /** swapped = true, якщо перший інгредієнт рецепта лежить у другій руці. */
    public record Match(Ritual ritual, boolean swapped) {
    }
}
