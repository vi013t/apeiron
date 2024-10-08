package violet.apeiron.branches.mining;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

public class OpalUtils {
	public static MutableComponent component(String name) {
		return component(name, Style.EMPTY);
    }

	public static MutableComponent component(String name, Style style) {
		Optional<MutableComponent> characterComponent = Optional.empty();
		for (int index = 0; index < name.length(); index++) {
			Color color = Color.getHSBColor(((float) index) / ((float) name.length()), 0.15f, 1);
			MutableComponent newCharacterComponent = Component.literal(Character.toString(name.charAt(index)))
				.withStyle(
					style
					.withColor(color.getRGB())
				);
			if (characterComponent.isEmpty()) characterComponent = Optional.of(newCharacterComponent);
			else characterComponent = Optional.of(characterComponent.get().append(newCharacterComponent));
		}
		return characterComponent.get();
    }

	public static FormattedText formattedText(String name, Style style) {
		List<FormattedText> texts = new ArrayList<>();
		for (int index = 0; index < name.length(); index++) {
			Color color = Color.getHSBColor(((float) index) / ((float) name.length()), 0.15f, 1);
			FormattedText character = FormattedText.of(Character.toString(name.charAt(index)), style.withColor(color.getRGB()));
			texts.add(character);
		}
		return FormattedText.composite(texts);
	}

	public static FormattedText formattedText(String name) {
		return formattedText(name, Style.EMPTY);
	}
}
