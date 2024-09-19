package violet.apeiron.branches.mining;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import violet.apeiron.Apeiron;
import violet.apeiron.api.ApeironToolTiers.GearType;
import violet.apeiron.api.GearItem;
import violet.apeiron.api.MaterialItem;
import violet.apeiron.branches.base.item.BasicModifierItem;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public class MiningItems {

	// Tier 1
	public static final DeferredItem<MaterialItem> RAW_ANDALUSITE = item("raw_andalusite", MaterialItem.create(MiningMaterial.ANDALUSITE));
	public static final DeferredItem<BasicModifierItem> ANDALUSITE_INGOT = item("andalusite_ingot", BasicModifierItem.create(Modifier.BREAKING));
	public static final DeferredItem<Item> ANDALUSITE_PICKAXE = item("andalusite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_AXE = item("andalusite_axe", GearItem.create(GearType.AXE, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SHOVEL = item("andalusite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.ANDALUSITE));
	public static final DeferredItem<Item> ANDALUSITE_SWORD = item("andalusite_sword", GearItem.create(GearType.SWORD, MiningMaterial.ANDALUSITE));

	// Tier 2
	public static final DeferredItem<MaterialItem> RAW_DANBURITE = item("raw_danburite", MaterialItem.create(MiningMaterial.DANBURITE));
	public static final DeferredItem<BasicModifierItem> DANBURITE_INGOT = item("danburite_ingot", BasicModifierItem.create(Modifier.LIGHTING));

	// Tier 3
	public static final DeferredItem<MaterialItem> RAW_CHROMITE = item("raw_chromite", MaterialItem.create(MiningMaterial.CHROMITE));
	public static final DeferredItem<BasicModifierItem> CHROMITE_INGOT = item("chromite_ingot", BasicModifierItem.create(Modifier.AUTO_SMELT));

	// Tier 4
	public static final DeferredItem<MaterialItem> RAW_CUPRITE = item("raw_cuprite", MaterialItem.create(MiningMaterial.CUPRITE));
	public static final DeferredItem<BasicModifierItem> CUPRITE_INGOT = item("cuprite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));
	
	// Tier 5
	public static final DeferredItem<MaterialItem> RAW_TUGTUPITE = item("raw_tugtupite", MaterialItem.create(MiningMaterial.TUGTUPITE));
	public static final DeferredItem<BasicModifierItem> TUGTUPITE_INGOT = item("tugtupite_ingot", BasicModifierItem.create(Modifier.MAGNETIC));

	// Tier 6
	public static final DeferredItem<MaterialItem> RAW_KYANITE = item("raw_kyanite", MaterialItem.create(MiningMaterial.KYANITE));
	public static final DeferredItem<BasicModifierItem> KYANITE_INGOT = item("kyanite_ingot", BasicModifierItem.create(Modifier.SILK_TOUCH));
	
	// Tier 7
	public static final DeferredItem<MaterialItem> RAW_KUNZITE = item("raw_kunzite", MaterialItem.create(MiningMaterial.KUNZITE));
	public static final DeferredItem<BasicModifierItem> KUNZITE_INGOT = item("kunzite_ingot", BasicModifierItem.create(Modifier.FORTUNE));

	// Tier 8
	public static final DeferredItem<MaterialItem> RAW_SPHALERITE = item("raw_sphalerite", MaterialItem.create(MiningMaterial.SPHALERITE));
	public static final DeferredItem<BasicModifierItem> SPHALERITE_INGOT = item("sphalerite_ingot", BasicModifierItem.create(Modifier.VEIN_MINE));
	public static final DeferredItem<Item> SPHALERITE_PICKAXE = item("sphalerite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_AXE = item("sphalerite_axe", GearItem.create(GearType.AXE, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SHOVEL = item("sphalerite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.SPHALERITE));
	public static final DeferredItem<Item> SPHALERITE_SWORD = item("sphalerite_sword", GearItem.create(GearType.SWORD, MiningMaterial.SPHALERITE));

	// Tier 9
	public static final DeferredItem<MaterialItem> RAW_ADAMITE = item("raw_adamite", MaterialItem.create(MiningMaterial.ADAMITE));
	public static final DeferredItem<BasicModifierItem> ADAMITE_INGOT = item("adamite_ingot", BasicModifierItem.create(Modifier.RETRIEVING));
	public static final DeferredItem<Item> ADAMITE_PICKAXE = item("adamite_pickaxe", GearItem.create(GearType.PICKAXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_AXE = item("adamite_axe", GearItem.create(GearType.AXE, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SHOVEL = item("adamite_shovel", GearItem.create(GearType.SHOVEL, MiningMaterial.ADAMITE));
	public static final DeferredItem<Item> ADAMITE_SWORD = item("adamite_sword", GearItem.create(GearType.SWORD, MiningMaterial.ADAMITE));

	// Tier 10 - Opal
	public static final DeferredItem<MaterialItem> OPAL_DUST_CLUMP = item("opal_dust_clump", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<MaterialItem> OPAL_DUST = item("opal_dust", MaterialItem.create(MiningMaterial.OPAL));
	public static final DeferredItem<BasicModifierItem> OPAL_INGOT = item("opal_ingot", BasicModifierItem.create(Modifier.SIGHT));
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
