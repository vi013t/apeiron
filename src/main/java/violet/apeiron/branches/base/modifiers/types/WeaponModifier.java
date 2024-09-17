package violet.apeiron.branches.base.modifiers.types;

import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

/**
 * A weapon modifier. This is an interface implemented by some classes that extend {@link violet.apeiron.branches.base.modifiers.types.data.Modifier Modifier}, specifically those that can be applied to weapons.
 * For example, the charged modifier is a modifier that can only be applied to weapons, so it implements this interface. The interface provides methods called by event listeners
 * that fire based on certain conditions. For example, it provides a method that fires when the player attacks an entity with a weapon with this modifier, so that modifiers like
 * charged can listen in on that event and lightning-strike the enemy. All of the event listener methods in this interface have a default empty implementation, so they can be selectively 
 * implemented as needed.
 * 
 * <br></br>

 * The events are called in Apeiron's {@link violet.branches.base.apeiron.event.ForgeEventHandler Forge event handler}.
 */
public interface WeaponModifier {

	/**
	 * Called when the player attacks an entity while the player is holding a weapon with this modifier. This is used, for example, by modifiers such as charged, will will listen in
	 * on this event and strike the enemy with lightning.
	 * 
	 * @param event The entity attack event. This is a generic entity attack event passed to the method call, but it is guaranteed that the attacker is a player and that they attacked
	 * with a weapon holding this modifier.
	 */
	public default void onAttack(AttackEntityEvent event) {}
}
