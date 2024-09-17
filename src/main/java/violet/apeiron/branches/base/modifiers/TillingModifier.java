package violet.apeiron.branches.base.modifiers;

import net.minecraft.network.chat.Style;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent.BlockToolModificationEvent;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;

public class TillingModifier extends Modifier implements ToolModifier {

	public static final TillingModifier INSTANCE = new TillingModifier();
	
	private TillingModifier() {
		super("tilling", 1, Style.EMPTY.withColor(0x5B3428));
	}

	@Override
	@SuppressWarnings("null")
	public void onRightClickBlock(BlockToolModificationEvent event) {
		event.setFinalState(event.getState().getToolModifiedState(null, ItemAbilities.HOE_TILL, false));
	}
}

