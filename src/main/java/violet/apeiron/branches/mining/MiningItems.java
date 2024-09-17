package violet.apeiron.branches.mining;

import java.util.ArrayList;

import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.Apeiron.Branch;
import violet.apeiron.branches.base.ApeironMaterials.ItemType;
import violet.apeiron.branches.base.item.BasicModifierItem;
import violet.apeiron.branches.base.item.MaterialItem;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.item.opal.OpalItem;

public class MiningItems {

	// Tier 1
	public static final DeferredItem<Item> RAW_ANDALUSITE = basicItem("raw_andalusite");
	public static final DeferredItem<BasicModifierItem> ANDALUSITE_INGOT = item("andalusite_ingot", BasicModifierItem.create(Modifier.BREAKING));
	public static final DeferredItem<Item> ANDALUSITE_PICKAXE = item("andalusite_pickaxe", MaterialItem.create(ItemType.PICKAXE, Branch.MINING, 1));
	public static final DeferredItem<Item> ANDALUSITE_AXE = item("andalusite_axe", MaterialItem.create(ItemType.AXE, Branch.MINING, 1));
	public static final DeferredItem<Item> ANDALUSITE_SHOVEL = item("andalusite_shovel", MaterialItem.create(ItemType.SHOVEL, Branch.MINING, 1));
	public static final DeferredItem<Item> ANDALUSITE_SWORD = item("andalusite_sword", MaterialItem.create(ItemType.SWORD, Branch.MINING, 1));

	// Tier 2
	public static final DeferredItem<Item> RAW_DANBURITE = basicItem("raw_danburite");
	public static final DeferredItem<BasicModifierItem> DANBURITE_INGOT = item("danburite_ingot", BasicModifierItem.create(Modifier.LIGHTING));

	// Tier 3
	public static final DeferredItem<Item> RAW_CHROMITE = basicItem("raw_chromite");
	public static final DeferredItem<BasicModifierItem> CHROMITE_INGOT = item("chromite_ingot", BasicModifierItem.create(Modifier.AUTO_SMELT));

	// Tier 4
	public static final DeferredItem<Item> RAW_CUPRITE = basicItem("raw_cuprite");
	public static final DeferredItem<BasicModifierItem> CUPRITE_INGOT = item("cuprite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));
	
	// Tier 5
	public static final DeferredItem<Item> RAW_TUGTUPITE = basicItem("raw_tugtupite");
	public static final DeferredItem<BasicModifierItem> TUGTUPITE_INGOT = item("tugtupite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));

	// Tier 6
	public static final DeferredItem<Item> RAW_KYANITE = basicItem("raw_kyanite");
	public static final DeferredItem<BasicModifierItem> KYANITE_INGOT = item("kyanite_ingot", BasicModifierItem.create(Modifier.SILK_TOUCH));
	
	// Tier 7
	public static final DeferredItem<Item> RAW_KUNZITE = basicItem("raw_kunzite");
	public static final DeferredItem<BasicModifierItem> KUNZITE_INGOT = item("kunzite_ingot", BasicModifierItem.create(Modifier.FORTUNE));

	// Tier 8
	public static final DeferredItem<Item> RAW_SPHALERITE = basicItem("raw_sphalerite");
	public static final DeferredItem<BasicModifierItem> SPHALERITE_INGOT = item("sphalerite_ingot", BasicModifierItem.create(Modifier.VEIN_MINE));

	// Tier 9
	public static final DeferredItem<Item> RAW_ADAMITE = basicItem("raw_adamite");
	public static final DeferredItem<BasicModifierItem> ADAMITE_INGOT = item("adamite_ingot", BasicModifierItem.create(Modifier.RETRIEVING));

	// Tier 10 - Opal
	public static final DeferredItem<Item> OPAL_DUST_CLUMP = item("opal_dust_clump", OpalItem::new);
	public static final DeferredItem<Item> OPAL_DUST = item("opal_dust", OpalItem::new);
	public static final DeferredItem<BasicModifierItem> OPAL_INGOT = item("opal_ingot", OpalItem::new);
	public static final DeferredItem<Item> OPAL_PICKAXE = item("opal_pickaxe", MaterialItem.create(ItemType.PICKAXE, Branch.MINING, 10));
	public static final DeferredItem<Item> OPAL_AXE = item("opal_axe", MaterialItem.create(ItemType.AXE, Branch.MINING, 10));
	public static final DeferredItem<Item> OPAL_SHOVEL = item("opal_shovel", MaterialItem.create(ItemType.SHOVEL, Branch.MINING, 10));
	public static final DeferredItem<Item> OPAL_SWORD = item("opal_sword", MaterialItem.create(ItemType.SWORD, Branch.MINING, 10));
	public static final DeferredItem<Item> OPAL_HELMET = item("opal_helmet", OpalItem::new);
	public static final DeferredItem<Item> OPAL_CHESTPLATE = item("opal_chestplate", OpalItem::new);
	public static final DeferredItem<Item> OPAL_LEGGINGS = item("opal_leggings", OpalItem::new);
	public static final DeferredItem<Item> OPAL_BOOTS = item("opal_boots", OpalItem::new);

	public static <T extends Item> DeferredItem<T> item(String id, Supplier<T> supplier) {
		DeferredItem<T> deferredItem = Apeiron.ITEMS.register(id, supplier);
		Apeiron.CREATIVE_TAB_ITEMS.computeIfAbsent(Apeiron.ApeironCreativeTab.MINING, _tab -> new ArrayList<>()).add(deferredItem);
		return deferredItem;
	}

	public static DeferredItem<Item> basicItem(String id) {
		DeferredItem<Item> deferredItem = Apeiron.ITEMS.register(id, () -> new Item(new Item.Properties()));
		Apeiron.CREATIVE_TAB_ITEMS.computeIfAbsent(Apeiron.ApeironCreativeTab.MINING, _tab -> new ArrayList<>()).add(deferredItem);
		return deferredItem;
	}

	public static void load() {}
}
