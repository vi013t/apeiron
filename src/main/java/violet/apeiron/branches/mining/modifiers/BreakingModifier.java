package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class BreakingModifier extends Modifier implements ToolModifier {

	public static final BreakingModifier INSTANCE = new BreakingModifier();

	private BreakingModifier() {
		super("breaking", MiningMaterial.ANDALUSITE);
	}
	
}
