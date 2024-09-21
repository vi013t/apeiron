package violet.apeiron.event;

import com.mojang.datafixers.util.Either;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import violet.apeiron.Apeiron;
import violet.apeiron.api.materials.HasMaterial;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ModifierItem;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.data.ApeironDataComponents;
import violet.apeiron.data.ModifierDataComponent;

/**
 * Apeiron's main event handler for events fired on the Neoforge bus (as opposed to the mod bus). This class contains various methods that are called
 * when certain Minecraft events happen. None of the methods in this class should be called from the mod itself; NeoForge will fire them automatically
 * when appropriate.
 */
@EventBusSubscriber(modid = Apeiron.MODID)
public class ForgeEventHandler {

	/**
	 * Called when tooltips are rendered. This adds modifiers to the tooltips of items that have them. 
	 * 
	 * @param event The tooltip event fired on the Neoforge event bus.
	 */
	@SubscribeEvent
	public static void renderTooltip(RenderTooltipEvent.GatherComponents event) {

		// Get the modifiers; if there are none, exit and do nothing
		ModifierDataComponent dataComponent = event.getItemStack().get(ApeironDataComponents.MODIFIERS);
		if (dataComponent == null) return;
		Modifier[] modifiers = dataComponent.getModifiers();
		if (modifiers.length == 0) return;

		// Display the modifiers
		event.getTooltipElements().add(Either.left(FormattedText.of("")));
		event.getTooltipElements().add(Either.left(FormattedText.of("Modifiers:")));
		for (Modifier modifier : modifiers) {
			FormattedText text = modifier.getMaterial().formattedText("    " + I18n.get(modifier.nameTranslationKey()));
			if (Screen.hasShiftDown()) text = FormattedText.composite(text, FormattedText.of(" - " + I18n.get(modifier.descriptionTranslationKey()), Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));
			event.getTooltipElements().add(Either.left(text));
		}

		// Add the "Hold shift for more information" message
		if (!Screen.hasShiftDown()) {
			event.getTooltipElements().add(Either.left(FormattedText.of("    ")));
			event.getTooltipElements().add(Either.left(FormattedText.of("Hold SHIFT for more information...", Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true))));
		}
	}	
	
	/**
	 * Called when item tooltips are being colored. Used to change the color of tooltip borders for {@link HasMaterial material items} and {@link ModifierItem modifier items}>
	 * 
	 * @param event The tooltip coloring event fired on the Neoforge event bus.
	 */
	@SubscribeEvent
	public static void colorTooltips(RenderTooltipEvent.Color event) {
		if (event.getItemStack().getItem() instanceof HasMaterial materialItem) {
			event.setBorderStart(materialItem.getMaterial().secondaryColorWithAlpha());
			event.setBorderEnd(materialItem.getMaterial().colorWithAlpha());
		}

		if (event.getItemStack().getItem() instanceof ModifierItem modifierItem) {
			event.setBorderStart(modifierItem.getModifier().getMaterial().secondaryColorWithAlpha());
			event.setBorderEnd(modifierItem.getModifier().getMaterial().colorWithAlpha());
		}
	}
	
	/**
	 * Called when the player right clicks a block. This is used to handle tool modifiers that do special things on right-click; Specifically,
	 * this loops through all modifiers on the item in the players hand, and if it's a {@link ToolModifier}, it calls the modifier's
	 * {@link ToolModifier#onRightClickBlock(PlayerInteractEvent.RightClickBlock) onRightClickBlock} method.
	 * 
	 * @param event The right click event fired on the Neoforge event bus.
	 */
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

		// Get the modifiers and do nothing if there are none.
		ModifierDataComponent dataComponent = event.getItemStack().get(ApeironDataComponents.MODIFIERS);
		if (dataComponent == null) return;
		Modifier[] modifiers = dataComponent.getModifiers();
		if (modifiers.length == 0) return;

		// Check for tool modifiers that need to fire onRightClickBlock
		for (Modifier modifier : modifiers) {
			if (modifier instanceof ToolModifier toolModifier) {
				toolModifier.onRightClickBlock(event);
			}
		}
	}
}