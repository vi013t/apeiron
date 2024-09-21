package violet.apeiron.api;

import static java.util.Map.entry;

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
import violet.apeiron.api.materials.ApeironMaterial;

public class ApeironToolTiers {

	private static final Map<GearType, Branch[]> BRANCH_TIERS = Map.ofEntries(
		entry(GearType.SWORD, new Branch[] { Branch.DROPS, Branch.BOSS, Branch.MAGIC, Branch.MINING, Branch.TECH, Branch.EXPLORATION, Branch.FARMING, Branch.BUILDING }),
		entry(GearType.PICKAXE, new Branch [] { Branch.MINING, Branch.MAGIC, Branch.BUILDING, Branch.EXPLORATION, Branch.BOSS, Branch.FARMING, Branch.TECH, Branch.DROPS }),
		entry(GearType.AXE, new Branch[] { Branch.EXPLORATION, Branch.BUILDING, Branch.DROPS, Branch.FARMING, Branch.MAGIC, Branch.TECH, Branch.BOSS, Branch.MINING }),
		entry(GearType.SHOVEL, new Branch[] { Branch.FARMING, Branch.DROPS, Branch.MINING, Branch.TECH, Branch.BUILDING, Branch.BOSS, Branch.MAGIC, Branch.EXPLORATION }),
		entry(GearType.HELMET, new Branch[] { Branch.TECH, Branch.MINING, Branch.EXPLORATION, Branch.BOSS, Branch.DROPS, Branch.MAGIC, Branch.BUILDING, Branch.FARMING }),
		entry(GearType.CHESTPLATE, new Branch[] { Branch.BOSS, Branch.EXPLORATION, Branch.FARMING, Branch.MAGIC, Branch.MINING, Branch.BUILDING, Branch.DROPS, Branch.TECH }),
		entry(GearType.LEGGINGS, new Branch[] { Branch.MAGIC, Branch.FARMING, Branch.TECH, Branch.BUILDING, Branch.EXPLORATION, Branch.DROPS, Branch.MINING, Branch.BOSS }),
		entry(GearType.BOOTS, new Branch[] { Branch.BUILDING, Branch.TECH, Branch.BOSS, Branch.DROPS, Branch.FARMING, Branch.MINING, Branch.EXPLORATION, Branch.MAGIC })
	);

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

	/**
	 * A unique key for a map of {@link Tier}s. Because records automatically implement {@link Object#equals(Object)} correctly,
	 * this can safely be used as a map key. In this case, it's used for {@link #TIERS} to memoize all created tiers.
	 */
	private static record TierKey(Branch branch, int tier) {}

	/**
	 * The memoized tier map. This stores all tiers that've been created by mapping them from a unique {@link TierKey}.
	 */
	private static final Map<TierKey, Tier> TIERS = new HashMap<>();

	/**
	 * Returns the "tool tier" for the given gear type and material. In vanilla, tool tiers are classes that determine the attack damage,
	 * break speed, durability, etc. of an item, such as diamond, netherite, etc. This uses the chart in the mod's README (also see 
	 * {@link #BRANCH_TIERS}) to create a tier if it doesn't already exist. This is memoized (with {@link #TIERS}), so fetching
	 * the same tier twice won't recalculate or recreate the tier. Otherwise, assuming the tier hasn't been created yet, it'll be created 
	 * and returned. This creates tiers dynamically because there are so many (64, in fact).
	 * 
	 * @param gearType The type of gear to get the tier for. This matters because different materials do better or worse with different gear
	 * types, see the README for the mod and {@link #BRANCH_TIERS}.
	 * @param material The material to get the tier of.
	 * 
	 * @return The tool tier for the given gear type and material.
	 */
	public static Tier getToolTier(GearType gearType, ApeironMaterial material) {

		int row = Arrays.asList(BRANCH_TIERS.get(gearType)).indexOf(material.branch()) + 1;

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
