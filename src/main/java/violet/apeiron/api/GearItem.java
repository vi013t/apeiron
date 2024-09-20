package violet.apeiron.api;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.google.common.base.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.api.ApeironToolTiers.GearType;

public class GearItem {

	/**
	 * Creates a new gear item supplier with the given gear type and material.
	 * 
	 * @param gearType The type of gear the item is
	 * @param material The material the item is made out of
	 * 
	 * @return A supplier for the item. This should be passed to {@code Apeiron.ITEMS.register(name, supplier)}.
	 */
	public static Supplier<Item> create(GearType gearType, ApeironMaterial material) {
		return switch(gearType) {
			case GearType.PICKAXE -> () -> new GearItem.Pickaxe(material);
			case GearType.AXE -> () -> new GearItem.Axe(material);
			case GearType.SHOVEL -> () -> new GearItem.Shovel(material);
			case GearType.SWORD -> () -> new GearItem.Sword(material);
			default -> throw new NotImplementedException("Armor materials are not yet implemented");
		};
	}

	private static class Pickaxe extends PickaxeItem implements HasMaterial {

		private final ApeironMaterial material;

		public Pickaxe(ApeironMaterial material) {
			super(ApeironToolTiers.getToolTier(GearType.PICKAXE, material), new Item.Properties());
			this.material = material;
		}

		@Override
		public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
			components.clear();
			components.add(this.material.component(I18n.get(this.getDescriptionId())));
		}

		@Override
		public ApeironMaterial getMaterial() {
			return this.material;
		}
	}

	private static class Axe extends AxeItem implements HasMaterial {

		private final ApeironMaterial material;

		public Axe(ApeironMaterial material) {
			super(ApeironToolTiers.getToolTier(GearType.AXE, material), new Item.Properties());
			this.material = material;
		}

		@Override
		public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
			components.clear();
			components.add(this.material.component(I18n.get(this.getDescriptionId())));
		}

		@Override
		public ApeironMaterial getMaterial() {
			return this.material;
		}
	}

	private static class Shovel extends ShovelItem implements HasMaterial {

		private final ApeironMaterial material;

		public Shovel(ApeironMaterial material) {
			super(ApeironToolTiers.getToolTier(GearType.SHOVEL, material), new Item.Properties());
			this.material = material;
		}

		@Override
		public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
			components.clear();
			components.add(this.material.component(I18n.get(this.getDescriptionId())));
		}

		@Override
		public ApeironMaterial getMaterial() {
			return this.material;
		}
	}

	private static class Sword extends SwordItem implements HasMaterial {

		private final ApeironMaterial material;

		public Sword(ApeironMaterial material) {
			super(ApeironToolTiers.getToolTier(GearType.SWORD, material), new Item.Properties().attributes(SwordItem.createAttributes(ApeironToolTiers.getToolTier(GearType.SWORD, material), 0, -2F)));
			this.material = material;
		}

		@Override
		public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
			components.clear();
			components.add(this.material.component(I18n.get(this.getDescriptionId())));
		}

		@Override
		public ApeironMaterial getMaterial() {
			return this.material;
		}
	}
}