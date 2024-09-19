package violet.apeiron.api;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/**
 * A basic intersection of the {@link Item} class and the {@link Materialed} interface. This class is an item subclass
 * that stores a single immutable {@link ApeironMaterial} to implement {@link Materialed} with.
 */
public class MaterialItem extends Item implements Materialed {

	private final ApeironMaterial material;

	private MaterialItem(ApeironMaterial material) {
		super(new Item.Properties());
		this.material = material;
	}

	@Override
	public ApeironMaterial getMaterial() {
		return this.material;
	}

	public static Supplier<MaterialItem> create(ApeironMaterial material) {
		return () -> new MaterialItem(material);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
		components.clear();
		components.add(this.material.component(I18n.get(this.getDescriptionId())));
	}
}
