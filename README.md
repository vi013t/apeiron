# Apeiron

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

| Tier    | Mining     | Tech      | Boss             | Magic    | Exploration | Farming   | Drops | Building |
|---------|------------|-----------|------------------|----------|-------------|-----------|-------|----------|
| Tier 1  | Andalusite | Rhenium   | Jackalope Antler | Terrio   | Brenim      | Dahlus    | 
| Tier 2  | Danburite  | Yttrium   |                  | Electrio | Amarim      | Sonchus   |
| Tier 3  | Chromite   | Uranium   | Basilisk Scale   | Vitalio  | Vernim      | Acanthus  |
| Tier 4  | Cuprite    | Osmium    | Karkinos Claw    | Magnio   | Rosim       | Gladiolus |
| Tier 5  | Tugtupite  | Germanium | Unicorn Horn     | Lushio   | Lupim       | Dianthus  |
| Tier 6  | Kyanite    | Lutetium  | Kraken Tentacle  | Aquio    | Azim        | Hibiscus  |
| Tier 7  | Kunzite    | Titanium  | Griffin Talon    | Tenebrio | Purpim      | Crocus    |
| Tier 8  | Sphalerite | Niobium   | Phoenix Feather  | Flario   | Fueim       | Vibrus    |
| Tier 9  | Adamite    | Chromium  | Cyclops Eye      | Tranquio | Aquim       | Hydrangus | 
| Tier 10 | Opal       | Iridium   | Dragon Scale     | Infinio  | Arcim       | Iris      |

## Modifiers

Each of the 80 materials is associated with a specific *modifier*. Modifiers are effects that can be added to tools, weapons, or armor, that improve it in some way; i.e., auto-smelt, fortune, fire aspect, etc. They are similar to enchantments.

Below is a list of all modifiers, materials, and effects.

| Modifier   | Description                                                                                  | Material   | Tier | Branch |
|------------|----------------------------------------------------------------------------------------------|------------|------|--------|
| Breaking   | Tools, instead of vanishing, convert into "broken tools" upon running out of durability.     | Andalusite | 1    | Mining |
| Lighting   | Right clicking on a block places a torch.                                                    | Danburite  | 2    | Mining |
| Auto-Smelt | Blocks mined drop their smelted variants.                                                    | Chromite   | 3    | Mining |
| Magnetic   | Nearby ground items move towards the player.                                                 | Cuprite    | 4    | Mining |
| Silk Touch | Some blocks that normally wouldn't, drop themselves when mined.                              | Kyanite    | 6    | Mining |
| Fortune    | Some blocks drop extra items when mined.                                                     | Kunzite    | 7    | Mining |
| Vein-Mine  | Hold a key to mine adjacent blocks of the same type all at once.                             | Sphalerite | 8    | Mining |
| Retrieving | All blocks are breakable and drop themselves.                                                | Adamite    | 9    | Mining |
| Infinity   | Entities move slower the closer they get to the player.                                      | Infinio    | 10   | Magic  |
| Sight      | Shift-right clicking on a block highlights all nearby instances of that block through walls. | Opal       | 10   | Mining |

### Core Modifiers

Apeiron has 4 "core modifiers". Core modifiers are special modifiers that can't be obtained through a single material; They require one material from each branch to create. The core modifiers are:

- Protection (armor)
- Efficiency (tools)
- Sharpness (sword)
- Durability (all)

Each core modifier has 10 tiers, and each tier is made up of the 8 items of that tier of each branch. The table below shows the required materials for each core modifier.

### Inert modifiers

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