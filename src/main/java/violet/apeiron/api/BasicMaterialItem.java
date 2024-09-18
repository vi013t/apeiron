package violet.apeiron.api;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class BasicMaterialItem extends Item implements MaterialItem {

	private final ApeironMaterial material;

	private BasicMaterialItem(ApeironMaterial material) {
		super(new Item.Properties());
		this.material = material;
	}

	@Override
	public ApeironMaterial getMaterial() {
		return this.material;
	}

	public static Supplier<BasicMaterialItem> create(ApeironMaterial material) {
		return () -> new BasicMaterialItem(material);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(this.material.component(I18n.get(this.getDescriptionId())));
	}
}
