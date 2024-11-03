package cn.ksmcbrigade.tmm.ex;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.MaceItem;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

import java.util.Objects;

public class ExFeatures {
    public static ExFeatureInfo NO_FALL = new ExFeatureInfo(new ConfigBoolean("NoFall",false,"make player can't hurt by fall."),null,-1,(client, instance)->{
        if(MinecraftClient.getInstance().player!=null && MinecraftClient.getInstance().player.fallDistance>=3){
            if(MinecraftClient.getInstance().player.isFallFlying()){
                return;
            }
            if(MinecraftClient.getInstance().player.isCreative()){
                return;
            }
            if(MinecraftClient.getInstance().player.getAbilities().allowFlying){
                return;
            }
            if(MinecraftClient.getInstance().player.getStackInHand(MinecraftClient.getInstance().player.getActiveHand()).getItem() instanceof MaceItem){
                return;
            }
            try {
                Objects.requireNonNull(client.getNetworkHandler()).sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    public static ExFeatureInfo AIR_JUMP = new ExFeatureInfo(new ConfigBoolean("AirJump",false,""),null,-1,((minecraftClient, exFeatureInfo) -> {
        if(minecraftClient.player!=null && minecraftClient.options.jumpKey.isPressed()){
            minecraftClient.player.jump();
        }
    }));

    public static ExFeatureInfo ENTITY_CHAMS = new ExFeatureInfo(new ConfigBoolean("Chams",false,""),null, InputUtil.GLFW_KEY_F12,((minecraftClient, exFeatureInfo) -> {}));

}
