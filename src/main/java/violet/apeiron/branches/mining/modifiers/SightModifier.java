package violet.apeiron.branches.mining.modifiers;

import violet.apeiron.api.modifiers.ArmorModifier;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class SightModifier extends Modifier implements ArmorModifier {

	public static final SightModifier INSTANCE = new SightModifier();

	public SightModifier() {
		super("sight", MiningMaterial.OPAL);
	}
	
}
