package violet.apeiron.branches.mining;

import java.util.function.Supplier;

import violet.apeiron.Apeiron.Branch;
import violet.apeiron.api.materials.ApeironMaterial;
import violet.apeiron.api.modifiers.Modifier;

public class MiningMaterial extends ApeironMaterial {

	public static final ApeironMaterial ANDALUSITE = new MiningMaterial(1, () -> Modifier.BREAKING, 0x774433);
	public static final ApeironMaterial DANBURITE = new MiningMaterial(2, () -> Modifier.LIGHTING, 0xFFFF55);
	public static final ApeironMaterial CHROMITE = new MiningMaterial(3, () -> Modifier.AUTO_SMELT, 0x55FF55);
	public static final ApeironMaterial CUPRITE = new MiningMaterial(4, () -> Modifier.MAGNETIC, 0xFF6666);
	public static final ApeironMaterial TUGTUPITE = new MiningMaterial(5, () -> Modifier.MAGNETIC, 0xFFB2EE);
	public static final ApeironMaterial KYANITE = new MiningMaterial(6, () -> Modifier.SILK_TOUCH, 0x7799FF);
	public static final ApeironMaterial TANZANITE = new MiningMaterial(7, () -> Modifier.FORTUNE, 0x7733FF);
	public static final ApeironMaterial SPHALERITE = new MiningMaterial(8, () -> Modifier.VEIN_MINE, 0xFF9944, 0xFFDD99);
	public static final ApeironMaterial ADAMITE = new MiningMaterial(9, () -> Modifier.RETRIEVING, 0xAAFFEE, 0xDDFFFF);
	public static final ApeironMaterial OPAL = new MiningMaterial(10, () -> Modifier.SIGHT, 0xDDFFFF, 0xDDDDFF);

	private MiningMaterial(int tier, Supplier<Modifier> modifier, int color) {
		super(tier, Branch.MINING, modifier, color);
	}

	private MiningMaterial(int tier, Supplier<Modifier> modifier, int color, int secondaryColor) {
		super(tier, Branch.MINING, modifier, color, secondaryColor);
	}
}
