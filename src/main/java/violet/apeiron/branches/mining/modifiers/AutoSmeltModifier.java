package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class AutoSmeltModifier extends Modifier implements ToolModifier {

	public static final AutoSmeltModifier INSTANCE = new AutoSmeltModifier();

	private AutoSmeltModifier() {
		super("autosmelt", MiningMaterial.CHROMITE);
	}

	// TODO: functionality

}