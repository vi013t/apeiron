package violet.apeiron.branches.mining;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.api.BasicMaterialItem;
import violet.apeiron.api.ToolItem;
import violet.apeiron.branches.base.ApeironMaterials.ItemType;
import violet.apeiron.branches.base.item.BasicModifierItem;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class MiningItems {

	// Tier 1
	public static final DeferredItem<BasicMaterialItem> RAW_ANDALUSITE = item("raw_andalusite", BasicMaterialItem.create(MiningMaterial.ANDALUSITE));
	public static final DeferredItem<BasicModifierItem> ANDALUSITE_INGOT = item("andalusite_ingot", BasicModifierItem.create(Modifier.BREAKING));
	public static final DeferredItem<Item> ANDALUSITE_PICKAXE = item("andalusite_pickaxe", ToolItem.create(ItemType.PICKAXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_AXE = item("andalusite_axe", ToolItem.create(ItemType.AXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SHOVEL = item("andalusite_shovel", ToolItem.create(ItemType.SHOVEL, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SWORD = item("andalusite_sword", ToolItem.create(ItemType.SWORD, MiningMaterial.ANDALUSITE));

	// Tier 2
	public static final DeferredItem<BasicMaterialItem> RAW_DANBURITE = item("raw_danburite", BasicMaterialItem.create(MiningMaterial.DANBURITE));
	public static final DeferredItem<BasicModifierItem> DANBURITE_INGOT = item("danburite_ingot", BasicModifierItem.create(Modifier.LIGHTING));

	// Tier 3
	public static final DeferredItem<BasicMaterialItem> RAW_CHROMITE = item("raw_chromite", BasicMaterialItem.create(MiningMaterial.CHROMITE));
	public static final DeferredItem<BasicModifierItem> CHROMITE_INGOT = item("chromite_ingot", BasicModifierItem.create(Modifier.AUTO_SMELT));

	// Tier 4
	public static final DeferredItem<BasicMaterialItem> RAW_CUPRITE = item("raw_cuprite", BasicMaterialItem.create(MiningMaterial.CUPRITE));
	public static final DeferredItem<BasicModifierItem> CUPRITE_INGOT = item("cuprite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));
	
	// Tier 5
	public static final DeferredItem<BasicMaterialItem> RAW_TUGTUPITE = item("raw_tugtupite", BasicMaterialItem.create(MiningMaterial.TUGTUPITE));
	public static final DeferredItem<BasicModifierItem> TUGTUPITE_INGOT = item("tugtupite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));

	// Tier 6
	public static final DeferredItem<BasicMaterialItem> RAW_KYANITE = item("raw_kyanite", BasicMaterialItem.create(MiningMaterial.KYANITE));
	public static final DeferredItem<BasicModifierItem> KYANITE_INGOT = item("kyanite_ingot", BasicModifierItem.create(Modifier.SILK_TOUCH));
	
	// Tier 7
	public static final DeferredItem<BasicMaterialItem> RAW_KUNZITE = item("raw_kunzite", BasicMaterialItem.create(MiningMaterial.KUNZITE));
	public static final DeferredItem<BasicModifierItem> KUNZITE_INGOT = item("kunzite_ingot", BasicModifierItem.create(Modifier.FORTUNE));

	// Tier 8
	public static final DeferredItem<BasicMaterialItem> RAW_SPHALERITE = item("raw_sphalerite", BasicMaterialItem.create(MiningMaterial.SPHALERITE));
	public static final DeferredItem<BasicModifierItem> SPHALERITE_INGOT = item("sphalerite_ingot", BasicModifierItem.create(Modifier.VEIN_MINE));
	public static final DeferredItem<Item> SPHALERITE_PICKAXE = item("sphalerite_pickaxe", ToolItem.create(ItemType.PICKAXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_AXE = item("sphalerite_axe", ToolItem.create(ItemType.AXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SHOVEL = item("sphalerite_shovel", ToolItem.create(ItemType.SHOVEL, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SWORD = item("sphalerite_sword", ToolItem.create(ItemType.SWORD, MiningMaterial.SPHALERITE));

	// Tier 9
	public static final DeferredItem<BasicMaterialItem> RAW_ADAMITE = item("raw_adamite", BasicMaterialItem.create(MiningMaterial.ADAMITE));
	public static final DeferredItem<BasicModifierItem> ADAMITE_INGOT = item("adamite_ingot", BasicModifierItem.create(Modifier.RETRIEVING));
	public static final DeferredItem<Item> ADAMITE_PICKAXE = item("adamite_pickaxe", ToolItem.create(ItemType.PICKAXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_AXE = item("adamite_axe", ToolItem.create(ItemType.AXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SHOVEL = item("adamite_shovel", ToolItem.create(ItemType.SHOVEL, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SWORD = item("adamite_sword", ToolItem.create(ItemType.SWORD, MiningMaterial.ADAMITE));

	// Tier 10 - Opal
	public static final DeferredItem<BasicMaterialItem> OPAL_DUST_CLUMP = item("opal_dust_clump", BasicMaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicMaterialItem> OPAL_DUST = item("opal_dust", BasicMaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicModifierItem> OPAL_INGOT = item("opal_ingot", BasicModifierItem.create(Modifier.SIGHT));
	public static final DeferredItem<Item> OPAL_PICKAXE = item("opal_pickaxe", ToolItem.create(ItemType.PICKAXE, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_AXE = item("opal_axe", ToolItem.create(ItemType.AXE, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_SHOVEL = item("opal_shovel", ToolItem.create(ItemType.SHOVEL, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_SWORD = item("opal_sword", ToolItem.create(ItemType.SWORD, MiningMaterial.OPAL));
	public static final DeferredItem<BasicMaterialItem> OPAL_HELMET = item("opal_helmet", BasicMaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicMaterialItem> OPAL_CHESTPLATE = item("opal_chestplate", BasicMaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicMaterialItem> OPAL_LEGGINGS = item("opal_leggings", BasicMaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicMaterialItem> OPAL_BOOTS = item("opal_boots", BasicMaterialItem.create(MiningMaterial.OPAL));

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
