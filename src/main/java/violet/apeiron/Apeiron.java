package violet.apeiron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import violet.apeiron.branches.base.block.BaseBlocks;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.mining.MiningBlocks;
import violet.apeiron.branches.mining.MiningItems;

@Mod(Apeiron.MODID)
public class Apeiron {
	public static final String MODID = "apeiron";

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Apeiron.MODID);
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Apeiron.MODID);
	private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Apeiron.MODID);

	/** 
	 * A map of all creative tabs in the mod and the items contained within them. This is used when initializing the creative tabs to select which items
	 * to put into which tab. The keys of this map are the creative tabs, and the values are a list of items that belong in that creative tab.
	 */
	public static final Map<ApeironCreativeTab, List<DeferredItem<? extends Item>>> CREATIVE_TAB_ITEMS = new HashMap<>();

	public static enum ApeironCreativeTab {
		MINING;

		public void add(DeferredItem<? extends Item> item) {
			CREATIVE_TAB_ITEMS.computeIfAbsent(this, _tab -> new ArrayList<>()).add(item);
		}
	}

	/**
	 * A branch in the mod. Apeiron has 8 core "branches" which are individual paths of progression, each containing 10 tiers. {@code Branches},
	 * in the code, hold no data; They're simply tags, used for things like calculating sword damage and pickaxe break speed.
	 */
	public static enum Branch {
		MINING,
		MAGIC,
		TECH,
		BOSS,
		DROPS,
		EXPLORATION,
		FARMING,
		BUILDING
	}

	// Register creative tabs
	static {
		CREATIVE_TABS.register("mining", () -> CreativeModeTab
			.builder()
			.title(Component.translatable("itemGroup." + Apeiron.MODID + ".mining"))
			.icon(() -> MiningItems.SPHALERITE_INGOT.get().getDefaultInstance())
			.displayItems((parameters, output) -> {
				for (DeferredItem<? extends Item> item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.MINING)) {
					output.accept(item.get().getDefaultInstance());
				}
			})
			.build()
		);
	}

	public Apeiron(IEventBus modEventBus, ModContainer modContainer) {
		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		MiningItems.load();

		MiningBlocks.load();
		BaseBlocks.load();

		ApeironDataComponents.register(modEventBus);

		ITEMS.register(modEventBus);
		BLOCKS.register(modEventBus);

		CREATIVE_TABS.register(modEventBus);
	}
}
