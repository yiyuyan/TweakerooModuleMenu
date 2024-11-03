package cn.ksmcbrigade.tmm.gui.featureList;

import cn.ksmcbrigade.tmm.gui.group.Group;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;

public class FeatureListRenderer {

    public final int x;
    public final int y;
    public final int width;
    public final int height;
    public int backgroundColor;
    public int curBackgroundColor;
    public int textColor;
    public int enabledColor;

    public final Group group;

    public ArrayList<FeatureRenderer> featureRenderers = new ArrayList<>();
    public FeatureRenderer cur;

    public final int min = 0;
    public final int max;

    public FeatureListRenderer(int x, int y, int height, int backgroundColor, int curBackgroundColor, int textColor, int enabledTextColor, Group group){
        this.group = group;

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = this.getWidth(MinecraftClient.getInstance().textRenderer);
        this.backgroundColor = backgroundColor;
        this.curBackgroundColor = curBackgroundColor;
        this.textColor = textColor;
        this.enabledColor = enabledTextColor;

        int done = 0;
        for (int i = 0; i < this.group.features.size(); i++) {
            IConfigBoolean feature;
            try {
                feature = (IConfigBoolean) this.group.features.get(i);
            } catch (Exception e) {
                continue;
            }
            FeatureRenderer featureRenderer = new FeatureRenderer(this.x,this.y+done*12-12,this.width,height,this.group.renderer.backgroundColor,this.group.renderer.curBackgroundColor, this.textColor,this.enabledColor,feature.getName(), feature);
            if(done==0){
                cur = featureRenderer;
                featureRenderer.cur = true;
            }
            featureRenderers.add(featureRenderer);
            done++;
        }

        this.max = featureRenderers.size()-1;
    }

    public void render(DrawContext context, TextRenderer renderer){
        for (FeatureRenderer featureRenderer : featureRenderers) {
            featureRenderer.render(context, renderer);
        }
    }

    public void cur(FeatureRenderer renderer){
        if(featureRenderers.contains(renderer)){
            FeatureRenderer featureRenderer = featureRenderers.get(featureRenderers.indexOf(renderer));
            featureRenderer.cur = !featureRenderer.cur;
            cur = featureRenderer;
        }
    }

    public void next(){
        int next = featureRenderers.indexOf(cur)+1;
        if(next>max){
            next = min;
        }
        FeatureRenderer renderer = featureRenderers.get(next);
        this.cur = renderer;
        renderer.cur = true;

        for (int i = 0; i < featureRenderers.size(); i++) {
            if(i!=next){
                featureRenderers.get(i).cur = false;
            }
        }
    }

    public void last(){
        int next = featureRenderers.indexOf(cur)-1;
        if(next<min){
            next = max;
        }
        FeatureRenderer renderer = featureRenderers.get(next);
        this.cur = renderer;
        renderer.cur = true;

        for (int i = 0; i < featureRenderers.size(); i++) {
            if(i!=next){
                featureRenderers.get(i).cur = false;
            }
        }
    }

    public int getWidth(TextRenderer textRenderer){
        int length = 0;
        for (IConfigBase feature : this.group.features) {
            int len = textRenderer.getWidth(feature.getName());
            if(len>length){
                length = len;
            }
        }
        return length;
    }
}
