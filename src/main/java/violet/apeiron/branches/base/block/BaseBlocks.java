package violet.apeiron.branches.base.block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import violet.apeiron.Apeiron;

public class BaseBlocks {
	
	public static final DeferredBlock<TinkerTable> TINKER_TABLE = block("tinker_table", TinkerTable::new);

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
		Apeiron.ITEMS.registerSimpleBlockItem(name, registryBlock);
		return registryBlock;
	}

	public static void load() {}
}
