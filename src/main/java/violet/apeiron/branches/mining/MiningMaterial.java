package violet.apeiron.branches.mining;

import violet.apeiron.Apeiron.Branch;
import violet.apeiron.api.ApeironMaterial;

public class MiningMaterial extends ApeironMaterial {

	public static final ApeironMaterial ANDALUSITE = new MiningMaterial(1, 0x774433);
	public static final ApeironMaterial DANBURITE = new MiningMaterial(2, 0xFFFF55);
	public static final ApeironMaterial CHROMITE = new MiningMaterial(3, 0x55FF55);
	public static final ApeironMaterial CUPRITE = new MiningMaterial(4, 0xFF6666);
	public static final ApeironMaterial TUGTUPITE = new MiningMaterial(5, 0xFFAACC);
	public static final ApeironMaterial KYANITE = new MiningMaterial(6, 0x7799FF);
	public static final ApeironMaterial KUNZITE = new MiningMaterial(7, 0x7733FF);
	public static final ApeironMaterial SPHALERITE = new MiningMaterial(8, 0xFF9944, 0xFFDD99);
	public static final ApeironMaterial ADAMITE = new MiningMaterial(9, 0xAAFFEE, 0xDDFFFF);
	public static final ApeironMaterial OPAL = new MiningMaterial(10, 0xDDFFFF, 0xDDDDFF);

	private MiningMaterial(int tier, int color) {
		super(tier, Branch.MINING, color);
	}

	private MiningMaterial(int tier, int color, int secondaryColor) {
		super(tier, Branch.MINING, color, secondaryColor);
	}
}
