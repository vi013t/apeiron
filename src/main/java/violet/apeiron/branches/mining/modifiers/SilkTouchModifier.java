package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class SilkTouchModifier extends Modifier implements ToolModifier {
	
	public static final SilkTouchModifier INSTANCE = new SilkTouchModifier();

	public SilkTouchModifier() {
		super("silk_touch", MiningMaterial.KYANITE);
	}
	
}
