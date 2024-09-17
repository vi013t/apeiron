package violet.apeiron.branches.base.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TinkerTable extends Block {

	private static final Component CONTAINER_TITLE = Component.translatable("container.apeiron.tinker_table_title");

	public TinkerTable() {
		super(Block.Properties.of());
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPosition, Player player, BlockHitResult hitResult) {
		if (level.isClientSide) return InteractionResult.SUCCESS;

		player.openMenu(blockState.getMenuProvider(level, blockPosition));
		return InteractionResult.CONSUME;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPosition) {
		return new SimpleMenuProvider((containerId, playerInventory, containerAccess) -> new TinkerTableMenu(containerId, playerInventory, ContainerLevelAccess.create(level, blockPosition)), CONTAINER_TITLE);
	}
}
