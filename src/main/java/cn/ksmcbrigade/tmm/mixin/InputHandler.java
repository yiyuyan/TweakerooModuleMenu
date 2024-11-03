package cn.ksmcbrigade.tmm.mixin;

import cn.ksmcbrigade.tmm.TweakerooModuleMenu;
import cn.ksmcbrigade.tmm.config.Config;
import cn.ksmcbrigade.tmm.ex.ExFeatureInfo;
import cn.ksmcbrigade.tmm.ex.ExGroupUtil;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public class InputHandler {
    @Inject(method = "onKeyPressed",at = @At("TAIL"))
    private static void key(InputUtil.Key key, CallbackInfo ci){
        if(Config.UP.isPressed()){
            TweakerooModuleMenu.info.last();
        }
        if(Config.DOWN.isPressed()){
            TweakerooModuleMenu.info.next();
        }

        if(Config.LEFT.isPressed()){
            TweakerooModuleMenu.info.onGroup(true);
        }
        if(Config.RIGHT.isPressed()){
            TweakerooModuleMenu.info.onGroup(false);
        }
        if(Config.SET.isPressed()){
            TweakerooModuleMenu.info.groupInfo.cur.featureList.renderer.cur.feature.setBooleanValue(!TweakerooModuleMenu.info.groupInfo.cur.featureList.renderer.cur.feature.getBooleanValue());
        }
        for (ExFeatureInfo featureInfo : ExGroupUtil.featureInfos) {
            if(key.getCode()==featureInfo.key()){
                featureInfo.setter().setBooleanValue(!featureInfo.setter().getBooleanValue());
            }
        }
    }
}
