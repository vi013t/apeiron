package violet.apeiron.branches.base.data;

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

	public static final Codec<ModifierDataComponent> BASIC_CODEC = RecordCodecBuilder.create(instance ->
		instance.group(Codec.INT.fieldOf("modifiers").forGetter(ModifierDataComponent::toInt)).apply(instance, ModifierDataComponent::fromInt)
	);

	public static final StreamCodec<ByteBuf, ModifierDataComponent> BASIC_STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, ModifierDataComponent::toInt,
		ModifierDataComponent::fromInt
	);

	public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Apeiron.MODID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<ModifierDataComponent>> MODIFIERS = DATA_COMPONENTS.registerComponentType(
		"modifier",
		builder -> builder.persistent(BASIC_CODEC).networkSynchronized(BASIC_STREAM_CODEC)
	);

	public static void register(IEventBus bus) {
		DATA_COMPONENTS.register(bus);
	}
}
