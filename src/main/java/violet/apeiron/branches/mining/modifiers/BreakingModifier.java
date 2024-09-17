package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class BreakingModifier extends Modifier implements ToolModifier {

	public static final BreakingModifier INSTANCE = new BreakingModifier();

	private BreakingModifier() {
		super("breaking", 1, Style.EMPTY.withColor(0x888888));
	}
	
}
