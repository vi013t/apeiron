package violet.apeiron.branches.base.modifiers.types;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * An armor modifier. This is an interface implemented by some classes that extend {@link violet.apeiron.branches.base.modifiers.types.data.Modifier Modifier}, specifically those that can be applied to armor.
 * For example, the fire resistance modifier is a modifier that can only be applied to armor, so it implements this interface. The interface provides methods called by event listeners
 * that fire based on certain conditions. For example, it provides a method that fires every tick while the player is wearing the armor, so modifiers like fire resistance can apply
 * their affect every tick. All of the event listener methods in this interface have a default empty implementation, so they can be selectively implemented as needed.
 * 
 * <br></br>
 * 
 * The events are called in Apeiron's {@link violet.apeiron.event.ForgeEventHandler Forge event handler}.
 */
public interface ArmorModifier {

	/**
	 * Called every tick while a player is wearing armor with this modifier applied. This is used by modifiers to handle applying their effects, such as applying fire
	 * resistance every tick the armor is worn, for example.
	 * 
	 * @param event The underlying tick event that was fired while the player was wearing the armor. Although this is a generic tick event, it is guaranteed that the
	 * player is wearing some piece of armor with the modifier when this is called.
	 */
	public default void onWearingTick(PlayerTickEvent event) {}

	/**
	 * Called when the player takes damage while wearing an armor piece with this modifier. This is used by modifiers to handle effects that affect damage taken; For example,
	 * the thorns modifier will hurt the attacker in this method.
	 * 
	 * @param event The underlying hurt even that was fired while the player was wearing the armor. Although this is a generic hurt event, it is guaranteed that the 
	 * event entity is a player, and that the player is wearing some piece of armor with the modifier present.
	 */
	public default void onDamageTakenWhileWearing(LivingDamageEvent event) {}
}