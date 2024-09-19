package violet.apeiron.api;

/**
 * Indicates that an object (typically an item or block) relates in some way to a material. Generally, for items,
 * this means the item is made of the material, such as "opal pickaxe" or "sphalerite axe". For blocks, this generally
 * means something similar, such as "opal ore" or "kyanite block". The exact meaning of implementing this interface is
 * defined by the implementor; It generally just means that objects of a certain class are constrained in some way to
 * a single material in the mod.
 * 
 * <br/><br/>
 * 
 * This is used, for example, by the event handler when rendering tooltips; Tooltips for {@code Materialed} items
 * will be rendered in the color of the material.
 */
public interface Materialed {

	/**
	 * Returns the material associated with this {@link Materialed}. For a more thorough explanation on what
	 * "associated" means exactly, see the {@link Materialed} documentation.
	 * 
	 * @return The material associated with this {@link Materialed}.
	 */
	public abstract ApeironMaterial getMaterial();
}