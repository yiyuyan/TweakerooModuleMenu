package cn.ksmcbrigade.tmm.mixin;

import cn.ksmcbrigade.tmm.ex.ExGroupUtil;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(MinecraftClient.class)
public class MinecraftMixin {
    @Inject(method = "close",at = @At("HEAD"))
    public void close(CallbackInfo ci) throws IOException {
        ExGroupUtil.save();
    }
}
