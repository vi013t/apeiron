package violet.apeiron.branches.base.modifiers;

import java.util.List;

import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class RadioactiveModifier extends Modifier implements ArmorModifier {

	public static final RadioactiveModifier INSTANCE = new RadioactiveModifier();

	private RadioactiveModifier() {
		super("radioactive", MiningMaterial.CHROMITE);
	}

	@Override
	public void onWearingTick(PlayerTickEvent event) {
		List<Entity> entities = event.getEntity().level().getEntities(event.getEntity(), event.getEntity().getBoundingBox().inflate(10));
		for (Entity entity : entities) {
			if (event.getEntity().level().getGameTime() % 60 == 0) {
				entity.hurt(event.getEntity().damageSources().playerAttack(event.getEntity()), 1);
			}
		} 		
	}

}