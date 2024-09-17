package violet.apeiron.branches.base.event;

import com.mojang.datafixers.util.Either;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import violet.apeiron.Apeiron;
import violet.apeiron.branches.base.data.ApeironDataComponents;
import violet.apeiron.branches.base.data.ModifierDataComponent;
import violet.apeiron.branches.base.modifiers.types.Modifier;

@EventBusSubscriber(modid = Apeiron.MODID)
public class ForgeEventHandler {

	@SubscribeEvent
	public static void renderTooltip(RenderTooltipEvent.GatherComponents event) {

		// Get the modifiers; if there are none, do nothing
		ModifierDataComponent dataComponent = event.getItemStack().get(ApeironDataComponents.MODIFIERS);
		if (dataComponent == null) return;
		Modifier[] modifiers = dataComponent.getModifiers();
		if (modifiers.length == 0) return;

		// Display the modifiers
		event.getTooltipElements().add(Either.left(FormattedText.of("")));
		event.getTooltipElements().add(Either.left(FormattedText.of("Modifiers:")));
		for (Modifier modifier : modifiers) {
			FormattedText text = FormattedText.of("    " + I18n.get(modifier.nameTranslationKey()), modifier.style());
			if (Screen.hasShiftDown()) text = FormattedText.composite(text, FormattedText.of(" - " + I18n.get(modifier.descriptionTranslationKey()), Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
			event.getTooltipElements().add(Either.left(text));
		}

		// Add the "Hold shift for more information" message
		if (!Screen.hasShiftDown()) {
			event.getTooltipElements().add(Either.left(FormattedText.of("    ")));
			event.getTooltipElements().add(Either.left(FormattedText.of("Hold SHIFT for more information...", Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true))));
		}
	}
}