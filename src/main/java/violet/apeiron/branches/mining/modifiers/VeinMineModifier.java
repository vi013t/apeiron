package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class VeinMineModifier extends Modifier implements ToolModifier {

	public static final VeinMineModifier INSTANCE = new VeinMineModifier();

	private VeinMineModifier() {
		super("veinmine", MiningMaterial.SPHALERITE);
	}
	
}
