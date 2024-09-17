package violet.apeiron.branches.base.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class FlightModifier extends Modifier implements ArmorModifier {

	public static final FlightModifier INSTANCE = new FlightModifier();

	public FlightModifier() {
		super("flight", 10, Style.EMPTY.withBold(true).withColor(0xAAAAFF));
	}

	// TODO: functionality
}
