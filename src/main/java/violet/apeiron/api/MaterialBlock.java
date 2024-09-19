package violet.apeiron.api;

import net.minecraft.world.level.block.Block;

public class MaterialBlock extends Block implements Materialed {

	private final ApeironMaterial material;

	public MaterialBlock(ApeironMaterial material) {
		super(Block.Properties.of().strength(25 * (int) Math.pow(2, material.tier())).requiresCorrectToolForDrops());
		this.material = material;
	}

	@Override
	public ApeironMaterial getMaterial() {
		return this.material;
	}
	
}
