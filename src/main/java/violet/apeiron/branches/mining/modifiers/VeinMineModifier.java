package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class VeinMineModifier extends Modifier implements ToolModifier {

	public static final VeinMineModifier INSTANCE = new VeinMineModifier();

	private VeinMineModifier() {
		super("veinmine", 9, Style.EMPTY.withColor(0xCCCCEE));
	}
	
}
