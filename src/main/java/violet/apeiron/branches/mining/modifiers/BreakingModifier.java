package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class BreakingModifier extends Modifier implements ToolModifier {

	public static final BreakingModifier INSTANCE = new BreakingModifier();

	private BreakingModifier() {
		super("breaking", MiningMaterial.ANDALUSITE);
	}
	
}
