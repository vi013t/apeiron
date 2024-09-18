package violet.apeiron.branches.base.modifiers;

import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class FlightModifier extends Modifier implements ArmorModifier {

	public static final FlightModifier INSTANCE = new FlightModifier();

	public FlightModifier() {
		super("flight", MiningMaterial.OPAL);
	}

	// TODO: functionality
}
