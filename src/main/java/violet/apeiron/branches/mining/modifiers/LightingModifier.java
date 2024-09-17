package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class LightingModifier extends Modifier implements ToolModifier {

	public static final LightingModifier INSTANCE = new LightingModifier();

	public LightingModifier() {
		super("lighting", 2, Style.EMPTY.withColor(0xFFFFAA));
	}
	
}
