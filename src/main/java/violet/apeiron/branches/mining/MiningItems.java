package violet.apeiron.branches.mining;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.api.ApeironToolTiers.GearType;
import violet.apeiron.api.GearItem;
import violet.apeiron.api.materials.MaterialItem;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ModifierItem;

public class MiningItems {

	// Tier 1
	public static final DeferredItem<MaterialItem> RAW_ANDALUSITE = item("raw_andalusite", MaterialItem.create(MiningMaterial.ANDALUSITE));
	public static final DeferredItem<ModifierItem> ANDALUSITE_INGOT = item("andalusite_ingot", ModifierItem.create(Modifier.BREAKING));
	public static final DeferredItem<Item> ANDALUSITE_PICKAXE = item("andalusite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_AXE = item("andalusite_axe", GearItem.create(GearType.AXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SHOVEL = item("andalusite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SWORD = item("andalusite_sword", GearItem.create(GearType.SWORD, MiningMaterial.ANDALUSITE));

	// Tier 2
	public static final DeferredItem<MaterialItem> RAW_DANBURITE = item("raw_danburite", MaterialItem.create(MiningMaterial.DANBURITE));
	public static final DeferredItem<ModifierItem> DANBURITE_INGOT = item("danburite_ingot", ModifierItem.create(Modifier.LIGHTING));
	public static final DeferredItem<Item> DANBURITE_PICKAXE = item("danburite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.DANBURITE));
	public static final DeferredItem<Item> DANBURITE_AXE = item("danburite_axe", GearItem.create(GearType.AXE, MiningMaterial.DANBURITE));
	public static final DeferredItem<Item> DANBURITE_SHOVEL = item("danburite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.DANBURITE));
	public static final DeferredItem<Item> DANBURITE_SWORD = item("danburite_sword", GearItem.create(GearType.SWORD, MiningMaterial.DANBURITE));

	// Tier 3
	public static final DeferredItem<MaterialItem> RAW_CHROMITE = item("raw_chromite", MaterialItem.create(MiningMaterial.CHROMITE));
	public static final DeferredItem<ModifierItem> CHROMITE_INGOT = item("chromite_ingot", ModifierItem.create(Modifier.AUTO_SMELT));
	public static final DeferredItem<Item> CHROMITE_PICKAXE = item("chromite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.CHROMITE));
	public static final DeferredItem<Item> CHROMITE_AXE = item("chromite_axe", GearItem.create(GearType.AXE, MiningMaterial.CHROMITE));
	public static final DeferredItem<Item> CHROMITE_SHOVEL = item("chromite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.CHROMITE));
	public static final DeferredItem<Item> CHROMITE_SWORD = item("chromite_sword", GearItem.create(GearType.SWORD, MiningMaterial.CHROMITE));

	// Tier 4
	public static final DeferredItem<MaterialItem> RAW_CUPRITE = item("raw_cuprite", MaterialItem.create(MiningMaterial.CUPRITE));
	public static final DeferredItem<ModifierItem> CUPRITE_INGOT = item("cuprite_ingot", ModifierItem.create(Modifier.MAGNETIC));
	public static final DeferredItem<Item> CUPRITE_PICKAXE = item("cuprite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.CUPRITE));
	public static final DeferredItem<Item> CUPRITE_AXE = item("cuprite_axe", GearItem.create(GearType.AXE, MiningMaterial.CUPRITE));
	public static final DeferredItem<Item> CUPRITE_SHOVEL = item("cuprite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.CUPRITE));
	public static final DeferredItem<Item> CUPRITE_SWORD = item("cuprite_sword", GearItem.create(GearType.SWORD, MiningMaterial.CUPRITE));
	
	// Tier 5
	public static final DeferredItem<MaterialItem> RAW_TUGTUPITE = item("raw_tugtupite", MaterialItem.create(MiningMaterial.TUGTUPITE));
	public static final DeferredItem<ModifierItem> TUGTUPITE_INGOT = item("tugtupite_ingot", ModifierItem.create(Modifier.MAGNETIC));
	public static final DeferredItem<Item> TUGTUPITE_PICKAXE = item("tugtupite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.TUGTUPITE));
	public static final DeferredItem<Item> TUGTUPITE_AXE = item("tugtupite_axe", GearItem.create(GearType.AXE, MiningMaterial.TUGTUPITE));
	public static final DeferredItem<Item> TUGTUPITE_SHOVEL = item("tugtupite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.TUGTUPITE));
	public static final DeferredItem<Item> TUGTUPITE_SWORD = item("tugtupite_sword", GearItem.create(GearType.SWORD, MiningMaterial.TUGTUPITE));

	// Tier 6
	public static final DeferredItem<MaterialItem> RAW_KYANITE = item("raw_kyanite", MaterialItem.create(MiningMaterial.KYANITE));
	public static final DeferredItem<ModifierItem> KYANITE_INGOT = item("kyanite_ingot", ModifierItem.create(Modifier.SILK_TOUCH));
	public static final DeferredItem<Item> KYANITE_PICKAXE = item("kyanite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.KYANITE));
	public static final DeferredItem<Item> KYANITE_AXE = item("kyanite_axe", GearItem.create(GearType.AXE, MiningMaterial.KYANITE));
	public static final DeferredItem<Item> KYANITE_SHOVEL = item("kyanite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.KYANITE));
	public static final DeferredItem<Item> KYANITE_SWORD = item("kyanite_sword", GearItem.create(GearType.SWORD, MiningMaterial.KYANITE));

	// Tier 7
	public static final DeferredItem<MaterialItem> RAW_TANZANITE = item("raw_tanzanite", MaterialItem.create(MiningMaterial.TANZANITE));
	public static final DeferredItem<ModifierItem> TANZANITE_INGOT = item("tanzanite_ingot", ModifierItem.create(Modifier.FORTUNE));
	public static final DeferredItem<Item> TANZANITE_PICKAXE = item("tanzanite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.TANZANITE));
	public static final DeferredItem<Item> TANZANITE_AXE = item("tanzanite_axe", GearItem.create(GearType.AXE, MiningMaterial.TANZANITE));
	public static final DeferredItem<Item> TANZANITE_SHOVEL = item("tanzanite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.TANZANITE));
	public static final DeferredItem<Item> TANZANITE_SWORD = item("tanzanite_sword", GearItem.create(GearType.SWORD, MiningMaterial.TANZANITE));

	// Tier 8
	public static final DeferredItem<MaterialItem> RAW_SPHALERITE = item("raw_sphalerite", MaterialItem.create(MiningMaterial.SPHALERITE));
	public static final DeferredItem<ModifierItem> SPHALERITE_INGOT = item("sphalerite_ingot", ModifierItem.create(Modifier.VEIN_MINE));
	public static final DeferredItem<Item> SPHALERITE_PICKAXE = item("sphalerite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_AXE = item("sphalerite_axe", GearItem.create(GearType.AXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SHOVEL = item("sphalerite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SWORD = item("sphalerite_sword", GearItem.create(GearType.SWORD, MiningMaterial.SPHALERITE));

	// Tier 9
	public static final DeferredItem<MaterialItem> RAW_ADAMITE = item("raw_adamite", MaterialItem.create(MiningMaterial.ADAMITE));
	public static final DeferredItem<ModifierItem> ADAMITE_INGOT = item("adamite_ingot", ModifierItem.create(Modifier.RETRIEVING));
	public static final DeferredItem<Item> ADAMITE_PICKAXE = item("adamite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_AXE = item("adamite_axe", GearItem.create(GearType.AXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SHOVEL = item("adamite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SWORD = item("adamite_sword", GearItem.create(GearType.SWORD, MiningMaterial.ADAMITE));

	// Tier 10 - Opal
	public static final DeferredItem<MaterialItem> OPAL_DUST_CLUMP = item("opal_dust_clump", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_DUST = item("opal_dust", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<ModifierItem> OPAL_INGOT = item("opal_ingot", ModifierItem.create(Modifier.SIGHT));
	public static final DeferredItem<Item> OPAL_PICKAXE = item("opal_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_AXE = item("opal_axe", GearItem.create(GearType.AXE, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_SHOVEL = item("opal_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.OPAL));
	public static final DeferredItem<Item> OPAL_SWORD = item("opal_sword", GearItem.create(GearType.SWORD, MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_HELMET = item("opal_helmet", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_CHESTPLATE = item("opal_chestplate", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_LEGGINGS = item("opal_leggings", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_BOOTS = item("opal_boots", MaterialItem.create(MiningMaterial.OPAL));

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
