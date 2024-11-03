package cn.ksmcbrigade.tmm.info;

import cn.ksmcbrigade.tmm.TweakerooModuleMenu;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Info {
    public boolean onGroup = true;
    public final CurGroupInfo groupInfo;

    public Info(CurGroupInfo groupInfo){
        this.groupInfo = groupInfo;
    }

    public void onGroup(boolean onGroup){
        this.onGroup = onGroup;
    }

    public void last(){
        if(this.onGroup){
            this.groupInfo.last();
        }
        else{
            this.groupInfo.cur.featureList.renderer.last();
        }
    }

    public void next(){
        if(this.onGroup){
            this.groupInfo.next();
        }
        else{
            this.groupInfo.cur.featureList.renderer.next();
        }
    }

    public void render(DrawContext context, TextRenderer textRenderer){
        TweakerooModuleMenu.Disable.render(context,textRenderer);
        TweakerooModuleMenu.Fixes.render(context,textRenderer);
        TweakerooModuleMenu.Generic.render(context,textRenderer);
        TweakerooModuleMenu.Tweaks.render(context,textRenderer);
        TweakerooModuleMenu.Ex.render(context,textRenderer);
        if(!this.onGroup){
            if(this.groupInfo.cur.features.isEmpty()) this.onGroup(false);
            this.groupInfo.cur.featureList.render(context, textRenderer);
        }
    }
}
