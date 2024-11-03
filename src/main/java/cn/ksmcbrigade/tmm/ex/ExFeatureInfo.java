package cn.ksmcbrigade.tmm.ex;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public record ExFeatureInfo(ConfigBoolean setter, @Nullable ForgeConfigSpec configSpec, int key, BiConsumer<MinecraftClient, ExFeatureInfo> enabledTick) {
}
