package violet.apeiron.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Class for creating and using custom tags for the mod. Tags are basically... "tags" that can be applied to blocks or items, and then
 * you can check if a block or item has a given tag, or get all blocks/items with a given tag, etc.
 * See <a href="https://docs.neoforged.net/docs/resources/server/tags/">the NeoForge docs on tags</a> for more information.
 */
public class ApeironTags {

	/**
	 * The "fabrication blacklist tag". "Fabrication" is a modifier, specifically the tier 10 modifier for building, that allows block duplication. However,
	 * we don't want the player to be able to duplicate <i>all</i> blocks, because that would break progression for the other branches. So, this tag is applied
	 * to blocks that fabrication can't duplicate.
	 */
	public static final TagKey<Block> FABRICATION_BLACKLIST = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("apeiron", "fabrication_blacklist"));

	public static void load() {}
}
