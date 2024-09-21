package violet.apeiron.branches.base.modifiers;

import violet.apeiron.api.modifiers.ArmorModifier;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class FlightModifier extends Modifier implements ArmorModifier {

	public static final FlightModifier INSTANCE = new FlightModifier();

	public FlightModifier() {
		super("flight", MiningMaterial.OPAL);
	}

	// TODO: functionality
}
