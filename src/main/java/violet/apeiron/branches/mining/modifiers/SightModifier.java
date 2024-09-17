package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class SightModifier extends Modifier implements ArmorModifier {

	public static final SightModifier INSTANCE = new SightModifier();

	public SightModifier() {
		super("sight", 10, Style.EMPTY.withBold(true).withColor(0xFFFFFF));
	}
	
}
