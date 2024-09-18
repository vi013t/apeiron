package violet.apeiron.branches.base.item;

import violet.apeiron.api.ApeironMaterial;
import violet.apeiron.api.MaterialItem;
import violet.apeiron.branches.base.modifiers.types.Modifier;

public interface ModifierItem extends MaterialItem{
	public abstract Modifier getModifier();	

	@Override
	public default ApeironMaterial getMaterial() {
		return this.getModifier().getMaterial();
	}
}
