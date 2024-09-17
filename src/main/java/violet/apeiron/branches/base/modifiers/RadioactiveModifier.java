package violet.apeiron.branches.base.modifiers;

import java.util.List;

import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import violet.apeiron.branches.base.modifiers.types.ArmorModifier;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class RadioactiveModifier extends Modifier implements ArmorModifier {

	public static final RadioactiveModifier INSTANCE = new RadioactiveModifier();

	private RadioactiveModifier() {
		super("radioactive", 3, Style.EMPTY.withColor(0xAAFF00));
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