package violet.apeiron.branches.base.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.util.Serializer;

public class ModifierDataComponent {

	private final Modifier[] modifiers;

	public static final ModifierDataComponent EMPTY = new ModifierDataComponent();

	public ModifierDataComponent(Modifier... modifiers) {
		this.modifiers = modifiers;
	}

	public Modifier[] getModifiers() {
		return this.modifiers.clone();
	}

	public ModifierDataComponent addModifier(Modifier modifier) {
		List<Modifier> modifiers = new ArrayList<>(Arrays.asList(this.modifiers));
		modifiers.add(modifier);
		return new ModifierDataComponent(modifiers.toArray(Modifier[]::new));
	}

	public int toInt() {
		return Serializer.intListToInt(Arrays.stream(this.modifiers).mapToInt(modifier -> modifier.id()).toArray());
	}

	public static ModifierDataComponent fromInt(int modifierDataComponentId) {
		return new ModifierDataComponent(Arrays.stream(Serializer.intToIntList(modifierDataComponentId)).<Modifier>mapToObj(id -> Modifier.fromId(id).get()).toArray(Modifier[]::new));
	}

	@Override
	public boolean equals(@Nullable Object other) {
		if (other instanceof ModifierDataComponent otherModifierDataComponent) {
			return otherModifierDataComponent.toInt() == this.toInt();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(this.toInt());
	}
}
