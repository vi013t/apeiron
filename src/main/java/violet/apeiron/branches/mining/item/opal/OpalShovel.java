package violet.apeiron.branches.mining.item.opal;

import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.base.data.ModifierDataComponent;
import violet.apeiron.branches.base.item.ModifierItem;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.OpalUtils;

public class OpalShovel extends ShovelItem implements ModifierItem {

	public OpalShovel() {
		super(OpalTier.INSTANCE, new Item.Properties().component(ApeironDataComponents.MODIFIERS.value(), new ModifierDataComponent(Modifier.SIGHT)));
	}

	@Override
	public Modifier getModifier() {
		return Modifier.SIGHT;
	}

	public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
	}
	
}