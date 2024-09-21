package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class FortuneModifier extends Modifier implements ToolModifier {

	public static final FortuneModifier INSTANCE = new FortuneModifier();
	
	public FortuneModifier() {
		super("fortune", MiningMaterial.TANZANITE);
	}
}
