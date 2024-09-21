package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class RetrievingModifier extends Modifier implements ToolModifier{

	public static final RetrievingModifier INSTANCE = new RetrievingModifier();

	public RetrievingModifier() {
		super("retrieving", MiningMaterial.ADAMITE);
	}
	
}
