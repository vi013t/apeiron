package violet.apeiron.branches.mining.modifiers;

import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class MagneticModifier extends Modifier implements ArmorModifier {

	public static final MagneticModifier INSTANCE = new MagneticModifier();

	private MagneticModifier() {
		super("magnetic", 4, Style.EMPTY.withColor(0xFF4444));
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		var items = event.getEntity().level().getEntitiesOfClass(ItemEntity.class, event.getEntity().getBoundingBox().inflate(5));
		for (var item : items) {
			item.setDeltaMovement(event.getEntity().position().subtract(item.position()));
		} 		
	}
}

