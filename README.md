# Apeiron

![badge](https://img.shields.io/badge/Minecraft-1.21-00cc00)
![badge](https://img.shields.io/badge/NeoForge-21.0.167-ff7700)
![badge](https://img.shields.io/badge/Mod-0.1.0-7700ff)

Apeiron is a Minecraft mod for Neoforge, starting at version 1.21. The mod adds a slow progression system that takes place after Vanilla progression, including 8 different branches, 80 materials and modifiers, tons of utility items, and more.

Apeiron is *not* designed to be used with other progression/gear mods. If so, you will find almost any other mod quickly outpace Apeiron, because it is designed to be slower and last longer than existing progression mods.

## Branches

Apeiron has 8 branches, each of which has 10 tiers of material. The branches are as follows:

- Tech
- Magic
- Mining
- Exploration
- Farming
- Boss
- Drops
- Building

Below is a table of the material tiers for each branch:

| Tier    | Mining     | Tech      | Boss             | Magic    | Exploration | Farming   | Drops   | Building |
|---------|------------|-----------|------------------|----------|-------------|-----------|---------|----------|
| Tier 1  | Andalusite | Rhenium   | Jackalope Antler | Terrio   | Brenim      | Dahlus    | Dumion  |
| Tier 2  | Danburite  | Yttrium   |                  | Electrio | Amarim      | Sonchus   | Cherion |
| Tier 3  | Chromite   | Uranium   | Basilisk Scale   | Vitalio  | Vernim      | Acanthus  | Lainion |
| Tier 4  | Cuprite    | Osmium    | Karkinos Claw    | Magnio   | Rosim       | Gladiolus | Kion    |
| Tier 5  | Tugtupite  | Germanium | Unicorn Horn     | Lushio   | Lupim       | Dianthus  | Lovion  |
| Tier 6  | Kyanite    | Lutetium  | Kraken Tentacle  | Aquio    | Azim        | Hibiscus  | Frion   |
| Tier 7  | Tanzanite  | Titanium  | Griffin Talon    | Tenebrio | Purpim      | Crocus    | Purpion |
| Tier 8  | Sphalerite | Niobium   | Phoenix Feather  | Flario   | Fueim       | Vibrus    | Burnion |
| Tier 9  | Adamite    | Chromium  | Cyclops Eye      | Tranquio | Aquim       | Hydrangus | Cypion  |
| Tier 10 | Opal       | Iridium   | Dragon Scale     | Infinio  | Arcim       | Iris      | Ultion  | 

## Modifiers

Each of the 80 materials is associated with a specific *modifier*. Modifiers are effects that can be added to tools, weapons, or armor, that improve it in some way; i.e., auto-smelt, fortune, fire aspect, etc. They are similar to enchantments.

Below is a list of all modifiers, materials, and effects.

| Modifier    | Description                                                                                  | Material         | Tier | Branch      | 
|-------------|----------------------------------------------------------------------------------------------|------------------|------|-------------|
| Breaking    | Tools, instead of vanishing, convert into "broken tools" upon running out of durability.     | Andalusite       | 1    | Mining      |
| Tilling     | Allows a tool to be used as a hoe.                                                           | Terrio           | 1    | Magic       |
|             |                                                                                              | Rhenium          | 1    | Tech        |
| Step Assist | Increase step height to 1 block.                                                             | Jackalope Antler | 1    | Boss        |
|             |                                                                                              | Brenim           | 1    | Exploration |
|             |                                                                                              | Dahlus           | 1    | Farming     |
|             |                                                                                              |                  | 1    | Drops       |
|             |                                                                                              |                  | 1    | Building    |
| Lighting    | Right clicking on a block places a torch.                                                    | Danburite        | 2    | Mining      |
| Charged     | Enemies hit have a chance to be struck by lightning.                                         | Electrio         | 2    | Magic       |
|             |                                                                                              | Yttrium          | 2    | Tech        |
|             |                                                                                              |                  | 2    | Boss        |
|             |                                                                                              | Amarim           | 2    | Exploration |
|             |                                                                                              | Sonchus          | 2    | Farming     |
|             |                                                                                              |                  | 2    | Drops       |
|             |                                                                                              |                  | 2    | Building    |
| Auto-Smelt  | Blocks mined drop their smelted variants.                                                    | Chromite         | 3    | Mining      |
| Healing     | Striking an entity heals them instead of damaging them.                                      | Vitalio          | 3    | Magic       |
| Radioactive | Passively damage entities nearby.                                                            | Uranium          | 3    | Tech        |
|             |                                                                                              | Basilisk Scale   | 3    | Boss        |
|             |                                                                                              | Vernim           | 3    | Exploration |
|             |                                                                                              | Acanthus         | 3    | Farming     |
|             |                                                                                              |                  | 3    | Drops       |
|             |                                                                                              |                  | 3    | Building    |
|             |                                                                                              | Cuprite          | 4    | Mining      |
| Magnetic    | Nearby ground items move towards the player.                                                 | Magnio           | 4    | Magic       |
| Powering    | Right click powerable blocks to apply a redstone pulse to them.                              | Osmium           | 4    | Tech        |
| Shearing    | Right click shearable entities to shear them.                                                | Karkinos Claw    | 4    | Boss        |
|             |                                                                                              | Rosim            | 4    | Exploration |
|             |                                                                                              | Gladiolus        | 4    | Farming     |
|             |                                                                                              |                  | 4    | Drops       |
|             |                                                                                              |                  | 4    | Building    |
|             |                                                                                              | Tugtupite        | 5    | Mining      |
|             |                                                                                              | Lushio           | 5    | Magic       |
|             |                                                                                              | Germanium        | 5    | Tech        |
|             |                                                                                              | Unicorn Horn     | 5    | Boss        |
|             |                                                                                              | Lupim            | 5    | Exploration |
|             |                                                                                              | Dianthus         | 5    | Farming     |
|             |                                                                                              |                  | 5    | Drops       |
|             |                                                                                              |                  | 5    | Building    |
| Silk Touch  | Some blocks that normally wouldn't, drop themselves when mined.                              | Kyanite          | 6    | Mining      |
|             |                                                                                              | Aquio            | 6    | Magic       |
|             |                                                                                              | Lutetium         | 6    | Tech        |
|             |                                                                                              | Kraken Tentacle  | 6    | Boss        |
| Speed Swim  | Increase swim speed.                                                                         | Azim             | 6    | Exploration |
|             |                                                                                              | Hibiscus         | 6    | Farming     |
|             |                                                                                              |                  | 6    | Drops       |
|             |                                                                                              |                  | 6    | Building    |
| Fortune     | Some blocks drop extra items when mined.                                                     | Tanzanite        | 7    | Mining      |
|             |                                                                                              | Tenebrio         | 7    | Magic       |
|             |                                                                                              | Titanium         | 7    | Tech        |
|             |                                                                                              | Griffin Talon    | 7    | Boss        |
|             |                                                                                              | Purpim           | 7    | Exploration |
|             |                                                                                              | Crocus           | 7    | Farming     |
|             |                                                                                              |                  | 7    | Drops       |
|             |                                                                                              |                  | 7    | Building    |
| Vein-Mine   | Hold a key to mine adjacent blocks of the same type all at once.                             | Sphalerite       | 8    | Mining      |
|             |                                                                                              | Flario           | 8    | Magic       |
|             |                                                                                              | Niobium          | 8    | Tech        |
|             |                                                                                              | Phoenix Feather  | 8    | Boss        |
|             |                                                                                              | Fueim            | 8    | Exploration |
|             |                                                                                              | Vibrus           | 8    | Farming     |
|             |                                                                                              |                  | 8    | Drops       |
|             |                                                                                              |                  | 8    | Building    |
| Retrieving  | All blocks are breakable and drop themselves.                                                | Adamite          | 9    | Mining      |
|             |                                                                                              | Tranquio         | 9    | Magic       |
|             |                                                                                              | Chromium         | 9    | Tech        |
|             |                                                                                              | Cyclops Eye      | 9    | Boss        |
|             |                                                                                              | Aquim            | 9    | Exploration |
|             |                                                                                              | Hydrangus        | 9    | Farming     |
|             |                                                                                              |                  | 9    | Drops       |
|             |                                                                                              |                  | 9    | Building    |
| Sight       | Shift-right clicking on a block highlights all nearby instances of that block through walls. | Opal             | 10   | Mining      |
| Infinity    | Entities move slower the closer they get to the player.                                      | Infinio          | 10   | Magic       |
|             | Gain infinite player-bound storage.                                                          | Iridium          | 10   | Tech        |
| Flight      | Allows the player to fly.                                                                    | Dragon Scale     | 10   | Boss        |
|             | Teleport to any coordinates, including saved presets.                                        | Arcim            | 10   | Exploration |
| Angelic     | Right click crops to grow them instantly.                                                    | Iris             | 10   | Farming     |
| Blessed     | Mobs drop massive amounts of valuable loot.                                                  | Ultion           | 10   | Drops       |
| Fabrication | Duplicate most blocks.                                                                       |                  | 10   | Building    |

### Core Modifiers

Apeiron has 4 "core modifiers". Core modifiers are special modifiers that can't be obtained through a single material; They require one material from each branch to create. The core modifiers are:

- Protection (armor)
- Efficiency (tools)
- Sharpness (sword)
- Durability (all)

Each core modifier has 10 tiers, and each tier is made up of the 8 items of that tier of each branch. The table below shows the required materials for each core modifier.

### Inert modifiers

When making a gear item out of a modifier material, the gear item will *always* get the modifier from that material automatically. This means sometimes tools will get armor modifiers, or vice versa. These modifiers are called *inert modifiers*. This means, essentially, that they don't do anything. In other words, you're encouraged to make tools and armor out of materials that have modifiers that can be applied to them.

## Material Specialties

Late game, you'll probably be interested in the *best* materials. Each of the tier 10 materials is the best material for a certain type of item. Specifically:

- Opal pickaxes, from the mining branch, are the fastest pickaxes.
- swords, from the drops branch, are the highest damage swords.
- shovels, from the farming branch, are the fastest shovels.
- axes, from the exploration branch, are the fastest axes.
- Iridium helmets, from the tech branch, are the most protective helmets.
- Dragon scale chestplates, from the boss branch, are the most protective chestplates.
- Infinio leggings, from the magic branch, are the most protective leggings.
- boots, from the building branch, are the most protective boots.

Specifically, below is a chart of best-to-worst for each material and tool type.

|       | Sword       | Pickaxe     | Axe         | Shovel      | Helmet      | Chestplate  | Leggings    | Boots       | 
|-------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|-------------|
| Best  | Drops       | Mining      | Exploration | Farming     | Tech        | Boss        | Magic       | Building    |
|       | Boss        | Magic       | Building    | Drops       | Mining      | Exploration | Farming     | Tech        |
|       | Magic       | Building    | Drops       | Mining      | Exploration | Farming     | Tech        | Boss        |
|       | Mining      | Exploration | Farming     | Tech        | Boss        | Magic       | Building    | Drops       |
|       | Tech        | Boss        | Magic       | Building    | Drops       | Mining      | Exploration | Farming     |
|       | Exploration | Farming     | Tech        | Boss        | Magic       | Building    | Drops       | Mining      |
|       | Farming     | Tech        | Boss        | Magic       | Building    | Drops       | Mining      | Exploration |
| Worst | Building    | Drops       | Mining      | Exploration | Farming     | Tech        | Boss        | Magic       |

In this chart, each tier within each row uses the same "material" in terms of base durability, protection, damage, efficiency, etc. For example, A tier 7 magic pickaxe will have the same durability and break speed as a tier 7 building axe, because magic pickaxe and building axe are in the same row. However, a magic pickaxe will have more durability and a faster break speed than a magic axe, because magic is in row 2 of the pickaxe column, but row 5 of the axe column.

## Accessibility

Apeiron is designed with accessibility in mind.

### Languages

Apeiron supports the following languages:

- English (US)
- Espa&ntilde;ol (Espa&ntilde;a)
- LOLCAT (Kingdom of Cats)
- Pirate Speak (The Seven Seas)
- Shakespearean English (Kingdom of England)

## Contributing

Apeiron is accepting contributions in the form of issues and pull requests.

### Issues

### Pull Requests

#### Items

When creating a pull request for a new item, please ensure all of the following steps are completed

- The item name has correct translation in all supported languages (see [languages](#languages))
- The item has a 16x16 texture in `src/main/resources/assets/apeiron/textures/item`
- The item has a model in `src/main/resources/assets/apeiron/models/item`