package violet.apeiron.api;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import violet.apeiron.Apeiron.Branch;
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

	private static final Map<MaterialKey, ApeironMaterial> TIERS = new HashMap<>();
	
	private final int color;
	private final int secondaryColor;
	private final int tier;
	private final Branch branch;

	public ApeironMaterial(int tier, Branch branch, int color, int secondaryColor) {
		this.color = color;
		this.secondaryColor = secondaryColor;
		this.tier = tier;
		this.branch = branch;
		TIERS.put(new MaterialKey(branch, tier), this);
	}

	public ApeironMaterial(int tier, Branch branch, int color) {
		this(tier, branch, color, color);
	}

	public int tier() {
		return this.tier;
	}

	public MutableComponent component(String text) {
		if (this.tier() == 10) return OpalUtils.component(text, Style.EMPTY.withBold(true));
		return Component.literal(text).withColor(this.color);
	}

	public FormattedText formattedText(String text) {
		if (this.tier() == 10) return OpalUtils.formattedText(text, Style.EMPTY.withBold(true));
		return FormattedText.of(text, Style.EMPTY.withColor(this.color));
	}

	public int colorWithAlpha() {
		return (255 << 24) | (this.color & 0x00FFFFFF);
	}

	public int color() {
		return this.color;
	}

	public int secondaryColor() {
		return this.secondaryColor;
	}

	public int secondaryColorWithAlpha() {
		return (255 << 24) | (this.secondaryColor & 0x00FFFFFF);
	}
	
	public Branch branch() {
		return this.branch;
	}

	public static ApeironMaterial get(Branch branch, int tier) {
		return TIERS.get(new MaterialKey(branch, tier));
	}

	private static record MaterialKey(Branch branch, int tier) {}
}
