package violet.apeiron.branches.base.modifiers;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent.BlockToolModificationEvent;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.base.modifiers.types.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class TillingModifier extends Modifier implements ToolModifier {

	public static final TillingModifier INSTANCE = new TillingModifier();
	
	private TillingModifier() {
		super("tilling", MiningMaterial.ANDALUSITE);
	}

	@Override
	@SuppressWarnings("null")
	public void onRightClickBlock(BlockToolModificationEvent event) {
		event.setFinalState(event.getState().getToolModifiedState(null, ItemAbilities.HOE_TILL, false));
	}
}

