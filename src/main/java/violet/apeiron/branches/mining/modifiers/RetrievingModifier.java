package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class RetrievingModifier extends Modifier implements ToolModifier{

	public static final RetrievingModifier INSTANCE = new RetrievingModifier();

	public RetrievingModifier() {
		super("retrieving", 10, Style.EMPTY.withColor(0xAAFFAA));
	}
	
}
