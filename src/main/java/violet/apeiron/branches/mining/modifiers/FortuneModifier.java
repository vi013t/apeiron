package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class FortuneModifier extends Modifier implements ToolModifier {

	public static final FortuneModifier INSTANCE = new FortuneModifier();
	
	public FortuneModifier() {
		super("fortune", MiningMaterial.KUNZITE);
	}
}
