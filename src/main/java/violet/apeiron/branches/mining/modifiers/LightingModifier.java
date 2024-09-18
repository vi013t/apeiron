package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class LightingModifier extends Modifier implements ToolModifier {

	public static final LightingModifier INSTANCE = new LightingModifier();

	public LightingModifier() {
		super("lighting", MiningMaterial.DANBURITE);
	}
	
}
