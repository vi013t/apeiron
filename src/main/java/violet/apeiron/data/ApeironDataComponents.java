package violet.apeiron.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import violet.apeiron.Apeiron;

public class ApeironDataComponents {

	/**
	 * The registry of all data components in the mod. This is similar to a block or item registry, but instead it registers data components.
	 * See <a href="https://docs.neoforged.net/docs/items/datacomponents/">the NeoForge docs on data components</a> for more information.
	 */
	public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Apeiron.MODID);

	private static final Codec<ModifierDataComponent> MODIFIER_CODEC = RecordCodecBuilder.create(instance ->
		instance.group(Codec.INT.fieldOf("modifiers").forGetter(ModifierDataComponent::toInt)).apply(instance, ModifierDataComponent::fromInt)
	);

	private static final StreamCodec<ByteBuf, ModifierDataComponent> MODIFIER_STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, 
		ModifierDataComponent::toInt,
		ModifierDataComponent::fromInt
	);

	/**
	 * The modifiers data component. This is the data component that gets applied to item stacks that have modifiers on them.
	 * See <a href="https://docs.neoforged.net/docs/items/datacomponents/">the NeoForge docs on data components</a> for more information.
	 */
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<ModifierDataComponent>> MODIFIERS = DATA_COMPONENTS.registerComponentType(
		"modifier",
		builder -> builder.persistent(MODIFIER_CODEC).networkSynchronized(MODIFIER_STREAM_CODEC)
	);

	/**
	 * Registers the data components for the Apeiron mod.
	 * See <a href="https://docs.neoforged.net/docs/items/datacomponents/">the NeoForge docs on data components</a> for more information.
	 * 
	 * @param bus The event bus to register the components on.
	 */
	public static void register(IEventBus bus) {
		DATA_COMPONENTS.register(bus);
	}
}
