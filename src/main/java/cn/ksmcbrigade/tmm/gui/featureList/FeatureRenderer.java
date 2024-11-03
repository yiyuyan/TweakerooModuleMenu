package cn.ksmcbrigade.tmm.gui.featureList;

import fi.dy.masa.malilib.config.IConfigBoolean;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class FeatureRenderer {

    public final int x;
    public final int y;
    public final int width;
    public final int height;
    public int backgroundColor;
    public int curBackgroundColor;
    public int textColor;
    public int enabledColor;
    public final String title;

    public final IConfigBoolean feature;

    public boolean cur = false;

    public FeatureRenderer(int x, int y, int width, int height, int backgroundColor, int curBackgroundColor, int textColor, int enabledTextColor, String title, IConfigBoolean feature){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.curBackgroundColor = curBackgroundColor;
        this.textColor = textColor;
        this.enabledColor = enabledTextColor;
        this.title = title;

        this.feature = feature;
    }

    public void render(DrawContext context, TextRenderer renderer){
        context.fillGradient(x,y,x+width,y+height,cur?curBackgroundColor:backgroundColor,cur?curBackgroundColor:backgroundColor);
        context.drawTextWithShadow(renderer,title,x,y+2, feature.getBooleanValue()?enabledColor:textColor);
    }
}
