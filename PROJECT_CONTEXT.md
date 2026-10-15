# PROJECT_CONTEXT — Minecraft-мод «Віктор»

## Технічні дані
- Назва: Viktor / «Віктор», mod id `viktor`, пакет `com.viktor`
- Minecraft Java 1.21.1, NeoForge 21.1.172, Java 21
- Збірка: ModDevGradle 2.0.78, Gradle 8.10.2 через GitHub Actions (wrapper відсутній)
- Робота: GitHub у браузері (Android-планшет). Оновлення файлів: ZIP `viktor-starter.zip` + workflow `unpack.yml`

## Підтверджений стан (версія 0.1.1, перевірено користувачем у грі)
Боби, рослина (4 стадії), блок бобів, рецепти 9↔1, торгівля фермера бобами, творча вкладка.

## Версія 0.2.0 (написано, НЕ ПЕРЕВІРЕНО: збірка не запускалась, у грі не тестувалось)
- Поля сіл: `VillageBeanFeature` (feature на кроці top_layer_modification) замінює ~35% пшениці на ріллі на боби.
  Підключено через biome modifier `viktor:village_beans` для біомів сіл (тег `viktor:village_biomes`).
  Діє лише на НОВО згенерованих чанках.
- Фермери: access transformer відкриває `Villager.WANTED_ITEMS`, у `VillagerSetup` до списку додано боби,
  щоб жителі підбирали боби. Боби в тезі `villager_plantable_seeds`, тож фермери з бобами в інвентарі їх садять.

## Правила
- Моделі з прозорістю (рослини, скло, решітки) завжди з `render_type` (cutout/translucent).
- Нічого не позначати готовим без збірки й перевірки в грі.

## Можливі ризики 0.2.0
- Назва поля `WANTED_ITEMS` або синтаксис `accessTransformers.from(...)` у build.gradle можуть бути невірні.
- Феature може не спрацювати на деяких шаблонах полів (перевірити в грі).

## Наступний крок
Запустити Build, перевірити в новому світі: /locate structure #minecraft:village.
