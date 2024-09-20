package violet.apeiron.api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import violet.apeiron.Apeiron.Branch;
import violet.apeiron.branches.base.modifiers.types.Modifier;
import violet.apeiron.branches.mining.OpalUtils;

/**
 * A "material" in the mod. This is a tier of a branch; i.e., opal, terrio, dragon scale, etc. {@link ApeironMaterial}s store
 * their respective tier number (1 - 10) and {@link Branch}, as well as a color and optionally a secondary color.
 * 
 * <br/><br/>
 * 
 * These materials are used in various parts of the code, such as creating {@link GearItem}s, {@link MaterialBlock}s, and more.
 * 
 * <br/><br/>
 * 
 * All {@link ApeironMaterial}s are completely immutable.
 */
public class ApeironMaterial {

	/**
	 * A map of all materials in the mod. The map uses {@link MaterialKey}s as keys, and {@link ApeironMaterial}s as values.
	 * This allows any material to be retrieved by its {@link Branch} and tier using {@link ApeironMaterial#get(Branch, int)}.
	 * 
	 * <br/></br>
	 * 
	 * Materials are added to this map when they're constructed. This map is guaranteed to contain all materials if and only if
	 * all materials have finished being constructed. Due to unreliability of construction order, do not attempt to access this
	 * map in static contexts or during construction of materials.
	 */
	private static final Map<MaterialKey, ApeironMaterial> MATERIALS = new HashMap<>();
	
	/**
	 * The primary color of this material. 
	 * 
	 * This color is used when rendering the name of items (in 
	 * {@link ModifierItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * ModifierItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)}), rendering tooltip borders for {@link HasMaterial} items (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}),
	 * and rendering modifier names (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#renderTooltip(net.neoforged.neoforge.client.event.RenderTooltipEvent.GatherComponents) ForgeEventHandler.renderTooltip(RenderTooltipEvent.GatherComponents)}).
	 */
	private final int color;

	/**
	 * The secondary color of this material. Not all materials have a "secondary color"; For those, this is simply the same value as {@link #color}. This
	 * can be retrieved publicly with {@link #secondaryColor()}, or retrieved with alpha with {@link #secondaryColorWithAlpha()}.
	 * 
	 * This color is used when rendering the name of items (in 
	 * {@link ModifierItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * ModifierItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)}), rendering tooltip borders for {@link HasMaterial} items (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}),
	 * and rendering modifier names (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#renderTooltip(net.neoforged.neoforge.client.event.RenderTooltipEvent.GatherComponents) ForgeEventHandler.renderTooltip(RenderTooltipEvent.GatherComponents)}).
	 */
	private final int secondaryColor;

	/**
	 * The tier of this material. This is guaranteed to be in [1, 10], and can be retrieved publicly with {@link #tier()}.
	 */
	private final int tier;

	/**
	 * The {@link Branch} of the mod this material is from. For more information on branches, see the mod's README. This can be retrieved publicly with {@link #branch()}.
	 */
	private final Branch branch;

	/**
	 * THe {@link Modifier} this material is associated with. Modifiers are added to tools by applying a specific material to them, so each modifier
	 * is associated with exactly one material and vice versa. This is the modifier associated with this material. This can be retrieved publicly with
	 * {@link #modifier()}.
	 */
	private final Supplier<Modifier> modifier;

	/**
	 * Creates a new {@link ApeironMaterial} with the given values. This constructor is for materials that have a secondary color; For materials that don't, use
	 * the other constructor, {@link ApeironMaterial#ApeironMaterial(int, Branch, Modifier, int)}. Note that materials shouldn't be constructed "dynamically", that is,
	 * materials should only be created in a static context.
	 * 
	 * <br/><br/>
	 * 
	 * For simplification, colors are usually passed as a hexadecimal literal, i.e., {@code new ApeironMaterial(10, Branch.MINING, Modifier.SIGHT, 0xDDFFFF, 0xDDDDFF)}.
	 * Do not pass colors with an alpha channel. For example, for blue, use {@code 0x0000FF}, not {@code 0x0000FFFF}.
	 * 
	 * @param tier The tier of the material, which must be in [1, 10].
	 * @param branch The {@link Branch} of the material.
	 * @param modifier The {@code Modifier} associated with this material.
	 * @param color The primary color of the material. See the documentation above for specifications.
	 * @param secondaryColor The secondary color of the material. See the documentation above for specifications.
	 * 
	 * @throws IllegalArgumentException if the given tier is not in [1, 10], or if a material already exists with the same branch AND tier.
	 */
	public ApeironMaterial(int tier, Branch branch, Supplier<Modifier> modifier, int color, int secondaryColor) {

		// Check for argument errors
		if (tier < 1 || tier > 10) throw new IllegalArgumentException("Attempted to create a material with an invalid tier number: Tier " + tier + ": for branch " + branch);
		if (MATERIALS.containsKey(new MaterialKey(branch, tier))) throw new IllegalArgumentException("Duplicate material identifier: There were two materials created for the " + branch + " branch for tier " + tier);
		
		// Check for simplification
		if (color == secondaryColor) {
			System.out.println("[WARNING] An apeiron material (" + branch + " tier " + tier + ") has been created with a primary and secondary color, but they're the same color; Consider using the single-color constructor instead which does this automatically.");
		}

		// Assign fields
		this.color = color;
		this.secondaryColor = secondaryColor;
		this.modifier = modifier;
		this.tier = tier;
		this.branch = branch;

		// Add to master list
		MATERIALS.put(new MaterialKey(branch, tier), this);
	}

	/**
	 * Creates a new {@link ApeironMaterial} with the given values. This constructor is for materials that don't have a secondary color; For materials that do, use
	 * the other constructor, {@link ApeironMaterial#ApeironMaterial(int, Branch, Modifier, int, int)}. Note that materials shouldn't be constructed "dynamically", that is,
	 * materials should only be created in a static context.
	 * 
	 * <br/><br/>
	 * 
	 * For simplification, colors are usually passed as a hexadecimal literal, i.e., {@code new ApeironMaterial(10, Branch.MINING, Modifier.SIGHT, 0xDDFFFF, 0xDDDDFF)}.
	 * Do not pass colors with an alpha channel. For example, for blue, use {@code 0x0000FF}, not {@code 0x0000FFFF}.
	 * 
	 * @param tier The tier of the material, which must be in [1, 10].
	 * @param branch The {@link Branch} of the material.
	 * @param modifier The {@code Modifier} associated with this material.
	 * @param color The primary color of the material. See the documentation above for specifications.
	 * @param secondaryColor The secondary color of the material. See the documentation above for specifications.
	 * 
	 * @throws IllegalArgumentException if the given tier is not in [1, 10], or if a material already exists with the same branch AND tier.
	 */
	public ApeironMaterial(int tier, Branch branch, Supplier<Modifier> modifier, int color) {
		this(tier, branch, modifier, color, color);
	}

	/**
	 * Returns the tier of this material. This is guaranteed to be a number in [1, 10]. 
	 */
	public int tier() {
		return this.tier;
	}

	/**
	 * Creates a {@link net.minecraft.network.chat.Component Component} using this material's style and the given text. This is used by
	 * {@link MaterialItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * MaterialItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)} and
	 * {@link ModifierItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * ModifierItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)} to render the name of a {@link HasMaterial} item.
	 * 
	 * <br/><br/>
	 * 
	 * Note that this creates a {@link net.minecraft.network.chat.Component#literal(String) literal component} out of the given text, not a
	 * {@link net.minecraft.network.chat.Component#translatable(String) translatable component}, though all of the text rendered in the mod
	 * should be translatable. This is because some styles (such as tier 10 styles, see 
	 * {@link violet.apeiron.branches.mining.OpalUtils#component(String) OpalUtils.component(String)}) need to operate on the text on a
	 * character-by-character basis, so they must create individually composed literal components for each character. Because of this,
	 * the returned value is a literal component, not a translatable component. To get around this and make the text translatable,
	 * you should pass a call to {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)} to this,
	 * to get the translated value of a translation key.
	 * 
	 * <br/> </br>
	 * 
	 * Also see {@link #formattedText(String)} for creating a {@link net.minecraft.network.chat.FormattedText FormattedText} object instead.
	 * 
	 * @param text The literal text to get a component for, which should almost always be the result of a call to 
	 * {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)}.
	 * 
	 * @return A literal component, stylized for the given text.
	 * 
	 * @see #formattedText(String)
	 * @see {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)}
	 */
	public MutableComponent component(String text) {
		if (this.tier() == 10) return OpalUtils.component(text, Style.EMPTY.withBold(true));
		return Component.literal(text).withColor(this.color);
	}

	/**
	 * Creates a {@link net.minecraft.network.chat.FormattedText FormattedText} using this material's style and the given text. This is used by
	 * {@link violet.apeiron.event.ForgeEventHandler#renderTooltip(net.neoforged.neoforge.client.event.RenderTooltipEvent.GatherComponents)
	 * ForgeEventHandler.renderTooltip(RenderTooltipEvent.GatherComponents)} to render modifier name tooltips.
	 * 
	 * <br/><br/>
	 * 
	 * Note that this creates a "literal" formatted text out of the given text, not a translated text object, though all of the text rendered 
	 * in the mod should be translatable. This is because some styles (such as tier 10 styles, see 
	 * {@link violet.apeiron.branches.mining.OpalUtils#formattedText(String) OpalUtils.formattedText(String)}) need to operate on the text on a
	 * character-by-character basis, so they must create individually composed literal components for each character. Because of this,
	 * the returned value is a literal component, not a translatable component. To get around this and make the text translatable,
	 * you should pass a call to {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)} to this,
	 * to get the translated value of a translation key.
	 * 
	 * <br/></br>
	 * 
	 * Also see {@link #component(String)} for creating a {@link net.minecraft.network.chat.Component Component} object instead.
	 * 
	 * @param text The literal text to get a component for, which should almost always be the result of a call to 
	 * {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)}.
	 * 
	 * @return A literal component, stylized for the given text.
	 * 
	 * @see #component(String)
	 * @see {@link net.minecraft.client.resources.language.I18n#get(String, Object...) I18n.get(String)}
	 */
	public FormattedText formattedText(String text) {
		if (this.tier() == 10) return OpalUtils.formattedText(text, Style.EMPTY.withBold(true));
		return FormattedText.of(text, Style.EMPTY.withColor(this.color));
	}

	/**
	 * Returns the {@link #color primary color} of this {@link ApeironMaterial} with an added 100% alpha component. For example, if the color
	 * of this material is {@code #AABBCC}, then this will return {@code #AABBCCFF}. This is used by 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}
	 * when coloring tooltips, because the color functions ({@link net.neoforged.neoforge.client.event.RenderTooltipEvent.Color#setBorderStart(int) RenderTooltipEvent.Color.setBorderStart(int)},
	 * {@link net.neoforged.neoforge.client.event.RenderTooltipEvent.Color#setBorderEnd(int) RenderTooltipEvent.Color.setBorderEnd(int)}, etc.) require a color with an alpha component, and if
	 * the standard {@link #color} is used, it will be rendered with 0% alpha (transparent).
	 * 
	 * @see https://stackoverflow.com/a/19287102
	 * @see #color
	 * @see #secondaryColorWithAlpha()
	 * 
	 * @return The primary color of this material, with a 100% alpha component.
	 */
	public int colorWithAlpha() {
		return (255 << 24) | (this.color & 0x00FFFFFF);
	}

	/**
	 * Returns the primary color of this material. 
	 * 
	 * This color is used when rendering the name of items (in 
	 * {@link ModifierItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * ModifierItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)}), rendering tooltip borders for {@link HasMaterial} items (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}),
	 * and rendering modifier names (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#renderTooltip(net.neoforged.neoforge.client.event.RenderTooltipEvent.GatherComponents) ForgeEventHandler.renderTooltip(RenderTooltipEvent.GatherComponents)}).
	 */
	public int color() {
		return this.color;
	}

	/**
	 * Returns the secondary color of this material. Not all materials have a "secondary color"; For those, this is simply the same value as {@link #color()}.
	 * 
	 * This color is used when rendering the name of items (in 
	 * {@link ModifierItem#appendHoverText(net.minecraft.world.item.ItemStack, net.minecraft.world.item.Item.TooltipContext, java.util.List, net.minecraft.world.item.TooltipFlag)
	 * ModifierItem.appendHoverText(ItemStack, TooltipContext, List, TooltipFlag)}), rendering tooltip borders for {@link HasMaterial} items (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}),
	 * and rendering modifier names (in 
	 * {@link violet.apeiron.event.ForgeEventHandler#renderTooltip(net.neoforged.neoforge.client.event.RenderTooltipEvent.GatherComponents) ForgeEventHandler.renderTooltip(RenderTooltipEvent.GatherComponents)}).
	 */
	public int secondaryColor() {
		return this.secondaryColor;
	}

	/**
	 * Returns the {@link #secondaryColor secondary color} of this {@link ApeironMaterial} with an added 100% alpha component. For example, if the secondary color
	 * of this material is {@code #AABBCC}, then this will return {@code #AABBCCFF}. This is used by 
	 * {@link violet.apeiron.event.ForgeEventHandler#colorTooltips(net.neoforged.neoforge.client.event.RenderTooltipEvent.Color) ForgeEventHandler.colorTooltips(RenderTooltipEvent.Color)}
	 * when coloring tooltips, because the color functions ({@link net.neoforged.neoforge.client.event.RenderTooltipEvent.Color#setBorderStart(int) RenderTooltipEvent.Color.setBorderStart(int)},
	 * {@link net.neoforged.neoforge.client.event.RenderTooltipEvent.Color#setBorderEnd(int) RenderTooltipEvent.Color.setBorderEnd(int)}, etc.) require a color with an alpha component, and if
	 * the standard {@link #color} is used, it will be rendered with 0% alpha (transparent).
	 * 
	 * @see https://stackoverflow.com/a/19287102
	 * @see #secondaryColor
	 * @see #colorWithAlpha()
	 * 
	 * @return The primary color of this material, with a 100% alpha component.
	 */
	public int secondaryColorWithAlpha() {
		return (255 << 24) | (this.secondaryColor & 0x00FFFFFF);
	}

	/**
	 * Returns the {@link Modifier} of this material. Materials and modifiers are two-way bijectively bound, meaning you can get the modifier
	 * from any material, and you can get the material from any modifier.
	 */
	public Modifier modifier() {
		return this.modifier.get();
	}
	
	/**
	 * Returns the {@link Branch} of this material}.
	 */
	public Branch branch() {
		return this.branch;
	}

	/**
	 * Returns the material of the given branch and tier. See {@link #MATERIALS} for restrictions on when not to call this. The TL;DR is,
	 * don't call this in static contexts or during construction of {@link ApeironMaterial}s.
	 * 
	 * @param branch The branch of the material to get
	 * @param tier The tier of the material to get
	 * 
	 * @return The material with the given branch and tier. This is guaranteed to return a non-null value, assuming the call restrictions outlined
	 * above are followed, because every branch has a material for every tier.
	 * 
	 * @throws IllegalArgumentException if the given tier is less than 1 or more than 10.
	 */
	public static ApeironMaterial get(Branch branch, int tier) {
		if (tier < 1 || tier > 10) throw new IllegalArgumentException("Attempted to get the material of branch " + branch + " and tier " + tier + ", but the tier must be in [1, 10].");
		return MATERIALS.get(new MaterialKey(branch, tier));
	}

	/**
	 * A unique identifier for a {@link ApeironMaterial}, storing the {@link Branch} and tier number. Due to this being a {@code record}, 
	 * it automatically implements {@link Object#equals(Object other) equals} correctly, so it can safely be used as a map key, i.e., in 
	 * {@link ApeironMaterial#MATERIALS}.
	 */
	private static record MaterialKey(Branch branch, int tier) {}
}
