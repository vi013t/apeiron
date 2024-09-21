package violet.apeiron.branches.mining.modifiers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import violet.apeiron.api.modifiers.Modifier;
import violet.apeiron.api.modifiers.ToolModifier;
import violet.apeiron.branches.mining.MiningMaterial;

public class LightingModifier extends Modifier implements ToolModifier {

	public static final LightingModifier INSTANCE = new LightingModifier();

	public LightingModifier() {
		super("lighting", MiningMaterial.DANBURITE);
	}
	
	@Override
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		BlockPos position = event.getPos().offset(event.getFace().getNormal());
		if (event.getLevel().getBlockState(position).getBlock() == Blocks.AIR) {
			event.getLevel().setBlock(position, Blocks.TORCH.defaultBlockState(), 3);
		}
	}
}
