package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class SilkTouchModifier extends Modifier implements ToolModifier {
	
	public static final SilkTouchModifier INSTANCE = new SilkTouchModifier();

	public SilkTouchModifier() {
		super("silk_touch", MiningMaterial.KYANITE);
	}
	
}
