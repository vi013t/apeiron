package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class SilkTouchModifier extends Modifier implements ToolModifier {
	
	public static final SilkTouchModifier INSTANCE = new SilkTouchModifier();

	public SilkTouchModifier() {
		super("silk_touch", 6, Style.EMPTY.withColor(0xFFFFAA));
	}
	
}
