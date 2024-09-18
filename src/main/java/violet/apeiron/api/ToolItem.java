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
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.branches.base.ApeironMaterials;
import violet.apeiron.branches.base.ApeironMaterials.ItemType;

public class ToolItem {

	public static Supplier<Item> create(ItemType itemType, ApeironMaterial material) {
		return switch(itemType) {
			case ItemType.PICKAXE -> () -> new ToolItem.Pickaxe(ApeironMaterials.getToolTier(material.branch(), itemType, material.tier()), material);
			case ItemType.AXE -> () -> new ToolItem.Axe(ApeironMaterials.getToolTier(material.branch(), itemType, material.tier()), material);
			case ItemType.SHOVEL -> () -> new ToolItem.Shovel(ApeironMaterials.getToolTier(material.branch(), itemType, material.tier()), material);
			case ItemType.SWORD -> () -> new ToolItem.Sword(ApeironMaterials.getToolTier(material.branch(), itemType, material.tier()), material);
			default -> throw new NotImplementedException("Armor materials are not yet implemented");
		};
	}

	private static class Pickaxe extends PickaxeItem implements MaterialItem {

		private final ApeironMaterial material;

		public Pickaxe(Tier material, ApeironMaterial apeironMaterial) {
			super(material, new Item.Properties());
			this.material = apeironMaterial;
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

	private static class Axe extends AxeItem implements MaterialItem {

		private final ApeironMaterial material;

		public Axe(Tier material, ApeironMaterial apeironMaterial) {
			super(material, new Item.Properties());
			this.material = apeironMaterial;
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

	private static class Shovel extends ShovelItem implements MaterialItem {

		private final ApeironMaterial material;

		public Shovel(Tier material, ApeironMaterial apeironMaterial) {
			super(material, new Item.Properties());
			this.material = apeironMaterial;
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

	private static class Sword extends SwordItem implements MaterialItem {

		private final ApeironMaterial material;

		public Sword(Tier material, ApeironMaterial apeironMaterial) {
			super(material, new Item.Properties().attributes(SwordItem.createAttributes(material, 0, -2F)));
			this.material = apeironMaterial;
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