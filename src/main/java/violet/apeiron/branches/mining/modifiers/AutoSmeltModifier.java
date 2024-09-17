package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class AutoSmeltModifier extends Modifier implements ToolModifier {

	public static final AutoSmeltModifier INSTANCE = new AutoSmeltModifier();

	private AutoSmeltModifier() {
		super("autosmelt", 8, Style.EMPTY.withColor(0xFFCC00));
	}

	// TODO: functionality

}