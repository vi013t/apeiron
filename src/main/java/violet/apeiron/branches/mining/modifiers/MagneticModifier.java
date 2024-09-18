package violet.apeiron.branches.mining.modifiers;

import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class MagneticModifier extends Modifier implements ArmorModifier {

	public static final MagneticModifier INSTANCE = new MagneticModifier();

	private MagneticModifier() {
		super("magnetic", MiningMaterial.CUPRITE);
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		var items = event.getEntity().level().getEntitiesOfClass(ItemEntity.class, event.getEntity().getBoundingBox().inflate(5));
		for (var item : items) {
			item.setDeltaMovement(event.getEntity().position().subtract(item.position()));
		} 		
	}
}

