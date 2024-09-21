package violet.apeiron.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ApeironTags {
	public static final TagKey<Block> FABRICATION_BLACKLIST = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("apeiron", "fabrication_blacklist"));

	public static void load() {}
}
