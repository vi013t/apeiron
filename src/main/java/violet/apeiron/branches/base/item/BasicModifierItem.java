package violet.apeiron.branches.base.item;

import java.util.List;

import com.google.common.base.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.base.data.ModifierDataComponent;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class BasicModifierItem extends Item implements ModifierItem {

	private final Modifier modifier;

	public BasicModifierItem(Modifier modifier) {
		super(new Item.Properties().component(ApeironDataComponents.MODIFIERS.value(), new ModifierDataComponent(modifier)));
		this.modifier = modifier;
	}

	@Override
	public Modifier getModifier() {
		return this.modifier;
	}

	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(this.modifier.getMaterial().component(I18n.get(getDescriptionId())));
	}

	public static Supplier<BasicModifierItem> create(Modifier modifier) {
		return () -> new BasicModifierItem(modifier);
	}
}
