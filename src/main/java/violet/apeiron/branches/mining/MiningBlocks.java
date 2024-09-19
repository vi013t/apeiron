package violet.apeiron.branches.mining;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.Apeiron.ApeironCreativeTab;
import violet.apeiron.api.ApeironMaterial;
import violet.apeiron.api.MaterialBlock;
import violet.apeiron.api.MaterialBlockItem;

public class MiningBlocks {
	
	public static final DeferredBlock<MaterialBlock> ANDALUSITE_ORE = materialBlock("andalusite_ore", MiningMaterial.ANDALUSITE);
	public static final DeferredBlock<MaterialBlock> DANBURITE_ORE = materialBlock("danburite_ore", MiningMaterial.DANBURITE);
	public static final DeferredBlock<MaterialBlock> CHROMITE_ORE = materialBlock("chromite_ore", MiningMaterial.CHROMITE);
	public static final DeferredBlock<MaterialBlock> CUPRITE_ORE = materialBlock("cuprite_ore", MiningMaterial.CUPRITE);
	public static final DeferredBlock<MaterialBlock> TUGTUPITE_ORE = materialBlock("tugtupite_ore", MiningMaterial.TUGTUPITE);
	public static final DeferredBlock<MaterialBlock> KYANITE_ORE = materialBlock("kyanite_ore", MiningMaterial.KYANITE);
	public static final DeferredBlock<MaterialBlock> KUNZITE_ORE = materialBlock("kunzite_ore", MiningMaterial.KUNZITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_SPHALERITE_ORE = materialBlock("deepslate_sphalerite_ore", MiningMaterial.SPHALERITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_ADAMITE_ORE = materialBlock("deepslate_adamite_ore", MiningMaterial.ADAMITE);
	public static final DeferredBlock<MaterialBlock> DEEPSLATE_OPAL_ORE = materialBlock("deepslate_opal_ore", MiningMaterial.OPAL);

	/**
	 * Creates and returns a block, while also registering an item for it.
	 *
	 * @param <T> The type of block to create
	 * 
	 * @param name The name of the block and item in the registries; This must be unique for each block, and the corresponding `BlockItem` will be registered with the same name.
	 * @param supplier A supplier that returns a new instance of the block each time it is called.
	 *
	 * @return The created block
	 */
	private static <T extends Block> DeferredBlock<T> block(String name, Supplier<T> supplier) {
		DeferredBlock<T> registryBlock = Apeiron.BLOCKS.register(name, supplier);
		DeferredItem<BlockItem> blockItem = Apeiron.ITEMS.registerSimpleBlockItem(name, registryBlock);
		ApeironCreativeTab.MINING.add(blockItem);
		return registryBlock;
	}

	private static DeferredBlock<MaterialBlock> materialBlock(String name, ApeironMaterial material) {
		DeferredBlock<MaterialBlock> registryBlock = Apeiron.BLOCKS.register(name, () -> new MaterialBlock(material));
		DeferredItem<BlockItem> blockItem = Apeiron.ITEMS.register(name, () -> new MaterialBlockItem(registryBlock.get()));
		ApeironCreativeTab.MINING.add(blockItem);
		return registryBlock;
	}

	public static void load() {}
}
