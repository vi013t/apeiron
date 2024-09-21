package violet.apeiron.branches.mining;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.Apeiron.ApeironCreativeTab;
import violet.apeiron.api.materials.ApeironMaterial;
import violet.apeiron.api.materials.MaterialBlock;
import violet.apeiron.api.materials.MaterialBlockItem;

public class MiningBlocks {
	
	public static final DeferredBlock<MaterialBlock> ANDALUSITE_ORE = materialBlock("andalusite_ore", MiningMaterial.ANDALUSITE);
	public static final DeferredBlock<MaterialBlock> DANBURITE_ORE = materialBlock("danburite_ore", MiningMaterial.DANBURITE);
	public static final DeferredBlock<MaterialBlock> CHROMITE_ORE = materialBlock("chromite_ore", MiningMaterial.CHROMITE);
	public static final DeferredBlock<MaterialBlock> CUPRITE_ORE = materialBlock("cuprite_ore", MiningMaterial.CUPRITE);
	public static final DeferredBlock<MaterialBlock> TUGTUPITE_ORE = materialBlock("tugtupite_ore", MiningMaterial.TUGTUPITE);
	public static final DeferredBlock<MaterialBlock> KYANITE_ORE = materialBlock("kyanite_ore", MiningMaterial.KYANITE);
	public static final DeferredBlock<MaterialBlock> TANZANITE_ORE = materialBlock("tanzanite_ore", MiningMaterial.TANZANITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_SPHALERITE_ORE = materialBlock("deepslate_sphalerite_ore", MiningMaterial.SPHALERITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_ADAMITE_ORE = materialBlock("deepslate_adamite_ore", MiningMaterial.ADAMITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_OPAL_ORE = materialBlock("deepslate_opal_ore", MiningMaterial.OPAL);

	/**
	 * Creates and returns a material block, while also registering an item for it.
	 *
	 * @param name The name of the block and item in the registries; This must be unique for each block, and the corresponding `BlockItem` will be registered with the same name.
	 * @param material The material that the block is related to.
	 *
	 * @return The created block
	 */
	private static DeferredBlock<MaterialBlock> materialBlock(String name, ApeironMaterial material) {
		DeferredBlock<MaterialBlock> registryBlock = Apeiron.BLOCKS.register(name, () -> new MaterialBlock(material));
		DeferredItem<BlockItem> blockItem = Apeiron.ITEMS.register(name, () -> new MaterialBlockItem(registryBlock.get()));
		ApeironCreativeTab.MINING.add(blockItem);
		return registryBlock;
	}

	public static void load() {}
}
