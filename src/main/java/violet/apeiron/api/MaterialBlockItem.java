package violet.apeiron.api;

import java.util.List;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class MaterialBlockItem extends BlockItem implements Materialed {

	public MaterialBlockItem(MaterialBlock block) {
		super(block, new Item.Properties());
	}

	@Override
	public ApeironMaterial getMaterial() {
		return ((MaterialBlock) this.getBlock()).getMaterial();
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(this.getMaterial().component(I18n.get(this.getDescriptionId())));
	}

}
