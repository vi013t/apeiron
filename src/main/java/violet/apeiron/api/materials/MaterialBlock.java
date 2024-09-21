package violet.apeiron.api.materials;

import net.minecraft.world.level.block.Block;

public class MaterialBlock extends Block implements HasMaterial {

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
