package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class FortuneModifier extends Modifier implements ToolModifier {

	public static final FortuneModifier INSTANCE = new FortuneModifier();
	
	public FortuneModifier() {
		super("fortune", 7, Style.EMPTY.withColor(0x00FFFF));
	}
}
