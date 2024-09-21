package violet.apeiron.branches.base.modifiers;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class TillingModifier extends Modifier implements ToolModifier {

	public static final TillingModifier INSTANCE = new TillingModifier();
	
	private TillingModifier() {
		super("tilling", MiningMaterial.ANDALUSITE);
	}

	@Override
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {}
}

