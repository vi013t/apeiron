package violet.apeiron.branches.mining;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.Apeiron.ApeironCreativeTab;

public class MiningBlocks {
	
	public static final DeferredBlock<Block> DEEPSLATE_OPAL_ORE = block("deepslate_opal_ore", () -> new Block(Block.Properties.of()));

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

	public static void load() {}
}
