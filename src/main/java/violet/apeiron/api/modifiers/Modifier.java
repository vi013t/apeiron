package violet.apeiron.api.modifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import violet.apeiron.api.materials.ApeironMaterial;
import violet.apeiron.branches.base.modifiers.FlightModifier;
import violet.apeiron.branches.base.modifiers.TillingModifier;
import violet.apeiron.branches.mining.modifiers.AutoSmeltModifier;
import violet.apeiron.branches.mining.modifiers.BreakingModifier;
import violet.apeiron.branches.mining.modifiers.FortuneModifier;
import violet.apeiron.branches.mining.modifiers.LightingModifier;
import violet.apeiron.branches.mining.modifiers.MagneticModifier;
import violet.apeiron.branches.mining.modifiers.RetrievingModifier;
import violet.apeiron.branches.mining.modifiers.SightModifier;
import violet.apeiron.branches.mining.modifiers.SilkTouchModifier;
import violet.apeiron.branches.mining.modifiers.VeinMineModifier;

public class Modifier {

	/**
	 * The list of all modifiers in the mod. When a modifier is instantiated (which happens exactly once for each modifier), it's added to this list.
	 * The list stores all modifiers and their unique IDs (see {@link Modifier#id()} and {@link Modifier#fromId(int)}), so that when deserializing
	 * modifiers, we can use the ID to retrieve back the original modifier (in other words, {@link Modifier#fromId(int)} relies on this list's existence).
	 * 
	 * <br/><br/>
	 * 
	 * This list should never be modified outside of the {@link Modifier} constructor.
	 */
	private static final List<Modifier> allModifiers = new ArrayList<>();

	// Farming
	public static final TillingModifier TILLING = TillingModifier.INSTANCE;

	// Magic

	// Tech
	public static final FlightModifier FLIGHT = FlightModifier.INSTANCE;

	// Mining
	public static final BreakingModifier BREAKING = BreakingModifier.INSTANCE;
	public static final LightingModifier LIGHTING = LightingModifier.INSTANCE;
	public static final AutoSmeltModifier AUTO_SMELT = AutoSmeltModifier.INSTANCE;
	public static final MagneticModifier MAGNETIC = MagneticModifier.INSTANCE;
	public static final SilkTouchModifier SILK_TOUCH = SilkTouchModifier.INSTANCE;
	public static final FortuneModifier FORTUNE = FortuneModifier.INSTANCE;
	public static final VeinMineModifier VEIN_MINE = VeinMineModifier.INSTANCE;
	public static final RetrievingModifier RETRIEVING = RetrievingModifier.INSTANCE;
	public static final SightModifier SIGHT = SightModifier.INSTANCE;

	private final String nameTranslationKey;
	private final String descriptionTranslationKey;
	private final ApeironMaterial material;
	private final int index;

	public Modifier(String name, ApeironMaterial material) {
		this.nameTranslationKey = "modifier.apeiron." + name + ".name";
		this.descriptionTranslationKey = "modifier.apeiron." + name + ".description";
		this.material = material;

		this.index = allModifiers.size();
		allModifiers.add(this);
	}

	/**
	 * Returns whether this modifier can be applied to the given stack. This will return true if one of the following holds true:
	 * 
	 * <br/><br/>
	 * 
	 * <ul>
	 *	<li>The modifier is a tool modifier and the item stack is a tool.</li> 
	 *	<li>The modifier is an armor modifier and the item stack is an armor item.</li> 
	 *	<li>The modifier is a weapon modifier and the item stack is a weapon item.</li>
	 * </ul>
	 * 
	 * <br/></br>
	 * 
	 * Additionally, <i>all</i> of the following must hold true:
	 * 
	 * <ul>
	 *	<li>The item stack is not empty.</li>
	 *	<li>The item is not at it's max modifiers.</li>
	 *	<li>The item's tier is at least the modifier's tier.</li>
	 *	<li>The item does not have any modifiers incompatible with this modifier.</li>
	 * </ul>
	 * 
	 * <br/></br>
	 * 
	 * This method is used by the tinker table GUI when the player attempts to apply modifiers.
	 * 
	 * @param stack The item stack to check if this modifier can be applied to
	 * 
	 * @return Whether the modifier can be applied to the stack.
	 */
	public boolean canBeAppliedTo(ItemStack stack) {
		if (stack.isEmpty()) return false;

		if (this instanceof ToolModifier && stack.getItem() instanceof DiggerItem) return true;
		if (this instanceof WeaponModifier && stack.getItem() instanceof SwordItem) return true;
		if (this instanceof ArmorModifier && stack.getItem() instanceof ArmorItem) return true;
		
		// TODO: check for incompatible modifiers
		// TODO: check for tier
		// TODO: check for max modifiers

		return false;
	}

	public ApeironMaterial getMaterial() {
		return this.material;
	}

	/**
	 * Returns the translation key for the name of this modifier. To convert this to the user's current language, use
	 * {@code I18n.get(modifier.nameTranslationKey())}, or for use in a {@code Component} (like when rendering a tooltip),
	 * use {@code Component.translatable(modifier.nameTranslationKey())}.
	 */
	public String nameTranslationKey() {
		return this.nameTranslationKey;
	}

	/**
	 * Returns the translation key for the description of this modifier. To convert this to the user's current language, use
	 * {@code I18n.get(modifier.descriptionTranslationKey())}, or for use in a {@code Component} (like when rendering a tooltip),
	 * use {@code Component.translatable(modifier.descriptionTranslationKey())}.
	 */
	public String descriptionTranslationKey() {
		return this.descriptionTranslationKey;
	}
	
	/**
	 * Returns the {@link Modifier} associated with a given ID, if one exists, or {@link Optional#empty()} if not. This is only
	 * guaranteed to return a present {@link Optional} if the given ID is retrieved from {@link Modifier#id()}. This is used to
	 * serialize and deserialize modifiers as ints.
	 * 
	 * @param id The ID of the {@link Modifier}, from some prior call to {@link Modifier#id()}.
	 * 
	 * @return The {@link Modifier} associated with the given ID, or {@link Optional#empty()} if none exists.
	 */
	public static Optional<Modifier> fromId(int id) {
		return id >= 1 && id < allModifiers.size() ? Optional.of(allModifiers.get(id - 1)) : Optional.empty();
	}

	/**
	 * Returns a unique ID for this modifier. This ID is guaranteed to be different to that of all other modifiers. This
	 * ID can be used in {@link Modifier#fromId(int)} to get the {@link Modifier} object back.
	 * 
	 * @return A unique ID for the modifier.
	 */
	public int id() {
		return this.index + 1;
	}
}
