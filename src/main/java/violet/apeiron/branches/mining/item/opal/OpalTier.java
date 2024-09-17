package violet.apeiron.branches.mining.item.opal;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import violet.apeiron.branches.mining.MiningItems;

public class OpalTier implements Tier {

	public static final OpalTier INSTANCE = new OpalTier();

	private OpalTier() {}

	@Override
	public float getAttackDamageBonus() {
		return 100;
	}

	@Override
	public float getSpeed() {
		return 100;
	}

	@Override
	public int getUses() {
		return 10000;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(new ItemLike[] { MiningItems.OPAL_INGOT });
	}

	@Override
	public int getEnchantmentValue() {
		return 0;
	}

	@Override
	public TagKey<Block> getIncorrectBlocksForDrops() {
		return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
	}

}
