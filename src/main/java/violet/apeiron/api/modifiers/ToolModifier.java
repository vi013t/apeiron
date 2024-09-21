package violet.apeiron.api.modifiers;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * A tool modifier. This is an interface implemented by some classes that extend {@link violet.apeiron.api.modifiers.data.Modifier Modifier}, specifically those that can be applied to tools.
 * For example, the auto-smelt modifier is a modifier that can only be applied to tools, so it implements this interface. The interface provides methods called by event listeners
 * that fire based on certain conditions. For example, it provides a method that fires when the player breaks the block with a tool with this modifier, so that modifiers like
 * auto-smelt can listen in on that event and smelt the output item. All of the event listener methods in this interface have a default empty implementation, so they can be selectively 
 * implemented as needed.
 * 
 * <br></br>
 * 
 * The events are called in Apeiron's {@link violet.apeiron.event.ForgeEventHandler Forge event handler}.
 */
public interface ToolModifier {

	/**
	 * Called when the player breaks a block with a tool that has this modifier applied. This only fires when the player actually finishes breaking a block, not just when they left-click
	 * on the block. The event given is cancellable, so one could "un-break" the block if necessary.
	 * 
	 * @param event The block break event. This is a generic block break event, but this method is guaranteed to only be called when the block is broken with a tool that has this
	 * modifier applied.
	 */
	public default void onBlockBreak(BlockEvent.BreakEvent event) {}

	/**
	 * Called when the player right clicks a block with a tool that has the given modifier. This is used, for example, on modifiers like tilling, which tills dirt when a dirt block is
	 * right-clicked.
	 * 
	 * @param event The block right-click event. This is a generic block-click event, but this method is guaranteed to only be called when the block clicked is done so with a tool in
	 * hand that has this modifier applied to it.
	 */
	public default void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {}
}
