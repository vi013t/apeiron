package violet.apeiron.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import violet.apeiron.Apeiron.Branch;

public class ApeironToolTiers {

	private static final Branch[][] BRANCH_TIERS = new Branch[][] {
		/* Sword      */ { Branch.DROPS, Branch.BOSS, Branch.MAGIC, Branch.MINING, Branch.TECH, Branch.EXPLORATION, Branch.FARMING, Branch.BUILDING },
		/* Pickaxe    */ { Branch.MINING, Branch.MAGIC, Branch.BUILDING, Branch.EXPLORATION, Branch.BOSS, Branch.FARMING, Branch.TECH, Branch.DROPS },
		/* Axe        */ { Branch.EXPLORATION, Branch.BUILDING, Branch.DROPS, Branch.FARMING, Branch.MAGIC, Branch.TECH, Branch.BOSS, Branch.MINING },
		/* Shovel     */ { Branch.FARMING, Branch.DROPS, Branch.MINING, Branch.TECH, Branch.BUILDING, Branch.BOSS, Branch.MAGIC, Branch.EXPLORATION },
		/* Helmet     */ { Branch.TECH, Branch.MINING, Branch.EXPLORATION, Branch.BOSS, Branch.DROPS, Branch.MAGIC, Branch.BUILDING, Branch.FARMING },
		/* Chestplate */ { Branch.BOSS, Branch.EXPLORATION, Branch.FARMING, Branch.MAGIC, Branch.MINING, Branch.BUILDING, Branch.DROPS, Branch.TECH },
		/* Leggings   */ { Branch.MAGIC, Branch.FARMING, Branch.TECH, Branch.BUILDING, Branch.EXPLORATION, Branch.DROPS, Branch.MINING, Branch.BOSS },
		/* Boots      */ { Branch.BUILDING, Branch.TECH, Branch.BOSS, Branch.DROPS, Branch.FARMING, Branch.MINING, Branch.EXPLORATION, Branch.MAGIC }
	};

	/**
	 * A type of "gear item" in the mod. These are the types of items that the mod adds progression for, such as "sword", "pickaxe", etc.
	 */
	public static enum GearType {
		SWORD,
		PICKAXE,
		AXE,
		SHOVEL,
		HELMET,
		CHESTPLATE,
		LEGGINGS,
		BOOTS
	}

	private static record TierKey(Branch branch, int tier) {}

	private static final Map<TierKey, Tier> TIERS = new HashMap<>();

	public static Tier getToolTier(GearType itemType, ApeironMaterial material) {
		int row = Arrays.asList(BRANCH_TIERS[itemType.ordinal()]).indexOf(material.branch()) + 1;
		return TIERS.computeIfAbsent(new TierKey(material.branch(), material.tier()), tierKey -> new Tier() {
			@Override
			public float getAttackDamageBonus() {
				double base = Math.pow(1.62, material.tier() - 9.5) + 1.22;
				double exponentOffset = 27 - 1.75 * material.tier();
				double constantOffset = Math.pow(2, material.tier() + 1.25);

				return (float) (Math.pow(base, exponentOffset - row) + constantOffset + 4);
			}

			@Override
			public float getSpeed() {
				double base = Math.pow(1.62, material.tier() - 9.5) + 1.22;
				double exponentOffset = 27 - 1.75 * material.tier();
				double constantOffset = Math.pow(2, material.tier() + 1.25);

				return (float) (Math.pow(base, exponentOffset - row) + constantOffset + 9);
			}

			@Override
			public int getUses() {
				double base = Math.pow(1.62, material.tier() - 9.5) + 1.22;
				double exponentOffset = 27 - 1.75 * material.tier();
				double constantOffset = Math.pow(2, material.tier() + 1.25);

				return (int) (Math.pow(base, exponentOffset - row) + constantOffset + 2500);
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemLike[] { });
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public TagKey<Block> getIncorrectBlocksForDrops() {
				return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
			}
		});
	}
}
