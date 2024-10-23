package violet.apeiron;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Apeiron.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.BooleanValue HIDE_SHANKS_WHEN_INFINITE_SATURATION = BUILDER
		.comment("Hide hunger shanks when you have infinite saturation granted from the iris modifier.")
		.define("hideShanksWhenIrisEquipped", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

	private static boolean hideShanksWhenIrisEquipped;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
		hideShanksWhenIrisEquipped = HIDE_SHANKS_WHEN_INFINITE_SATURATION.get();
    }

	public boolean hideShanksWhenIrisEquipped() {
		return hideShanksWhenIrisEquipped;
	}
}
