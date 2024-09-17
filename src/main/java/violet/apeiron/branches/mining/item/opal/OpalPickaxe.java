package violet.apeiron.branches.mining.item.opal;

import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.base.data.ModifierDataComponent;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.OpalUtils;

public class OpalPickaxe extends PickaxeItem {

	public OpalPickaxe() {
		super(OpalTier.INSTANCE, new Item.Properties().component(ApeironDataComponents.MODIFIERS.value(), new ModifierDataComponent(Modifier.SIGHT)));
	}

	public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
	}
	
}
