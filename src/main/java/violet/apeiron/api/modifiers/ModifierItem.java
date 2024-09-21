package violet.apeiron.api.modifiers;

import java.util.List;

import com.google.common.base.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.data.ApeironDataComponents;
import violet.apeiron.data.ModifierDataComponent;

public class ModifierItem extends Item {

	private final Modifier modifier;

	public ModifierItem(Modifier modifier) {
		super(new Item.Properties().component(ApeironDataComponents.MODIFIERS.value(), new ModifierDataComponent(modifier)));
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return this.modifier;
	}

	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(this.modifier.getMaterial().component(I18n.get(getDescriptionId())));
	}

	public static Supplier<ModifierItem> create(Modifier modifier) {
		return () -> new ModifierItem(modifier);
	}
}
