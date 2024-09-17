package violet.apeiron.branches.base.item;

import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.base.data.ModifierDataComponent;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class BasicModifierItem extends Item {

	private final Modifier modifier;

	public BasicModifierItem(Modifier modifier) {
		super(new Item.Properties().component(ApeironDataComponents.MODIFIERS.value(), new ModifierDataComponent(modifier)));
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return this.modifier;
	}

	public static Supplier<BasicModifierItem> create(Modifier modifier) {
		return () -> new BasicModifierItem(modifier);
	}
}
