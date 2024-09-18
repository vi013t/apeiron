package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class RetrievingModifier extends Modifier implements ToolModifier{

	public static final RetrievingModifier INSTANCE = new RetrievingModifier();

	public RetrievingModifier() {
		super("retrieving", MiningMaterial.ADAMITE);
	}
	
}
