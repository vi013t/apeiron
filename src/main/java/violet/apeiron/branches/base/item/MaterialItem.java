package violet.apeiron.branches.base.item;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.google.common.base.Supplier;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import violet.apeiron.Apeiron.Branch;
import violet.apeiron.branches.base.ApeironMaterials;
import violet.apeiron.branches.base.ApeironMaterials.ItemType;
import violet.apeiron.branches.mining.OpalUtils;

public class MaterialItem {
	public static Supplier<Item> create(ItemType itemType, Branch branch, int tier) {
		return switch(itemType) {
			case ItemType.PICKAXE -> () -> new PickaxeItem(ApeironMaterials.getTier(branch, itemType, tier), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
					if (tier == 10) {
						components.clear();
						components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
					} else {
						super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
					}
				}
			};
			case ItemType.AXE -> () -> new AxeItem(ApeironMaterials.getTier(branch, itemType, tier), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
					if (tier == 10) {
						components.clear();
						components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
					} else {
						super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
					}
				}
			};
			case ItemType.SHOVEL -> () -> new ShovelItem(ApeironMaterials.getTier(branch, itemType, tier), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
					if (tier == 10) {
						components.clear();
						components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
					} else {
						super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
					}
				}
			};
			case ItemType.SWORD -> () -> new SwordItem(ApeironMaterials.getTier(branch, itemType, tier), new Item.Properties()) {
				@Override
				public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
					if (tier == 10) {
						components.clear();
						components.add(OpalUtils.colorize(I18n.get(this.getDescriptionId()), Style.EMPTY.withBold(true)));
					} else {
						super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
					}
				}
			};
			default -> throw new NotImplementedException("Armor materials are not yet implemented");
		};
	}
}