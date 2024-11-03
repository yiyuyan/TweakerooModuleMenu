package cn.ksmcbrigade.tmm.ex;

import cn.ksmcbrigade.tmm.gui.featureList.FeatureList;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.event.TickHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static cn.ksmcbrigade.tmm.TweakerooModuleMenu.Ex;

public class ExGroupUtil {

    public static ArrayList<ExFeatureInfo> featureInfos = new ArrayList<>();

    public static void init() {

        for (Field declaredField : ExFeatures.class.getDeclaredFields()) {
            if(declaredField.getType().equals(ExFeatureInfo.class)){
                declaredField.setAccessible(true);
                try {
                    featureInfos.add((ExFeatureInfo) declaredField.get(null));
                } catch (Exception e) {
                    System.out.println("Failed to add a feature to ex group: "+declaredField.getName());
                    e.printStackTrace();
                }
            }
        }

        for (ExFeatureInfo featureInfo : featureInfos) {
            addToEx(featureInfo.setter());
        }

        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TickHandler.getInstance().registerClientTickHandler(minecraftClient -> featureInfos.stream().filter(info -> info.setter().getBooleanValue()).forEach(info -> info.enabledTick().accept(minecraftClient,info)));
    }

    public static void addToEx(ConfigBoolean config){
        ArrayList<IConfigBase> or = new ArrayList<>(Ex.features);
        or.add(config);
        Ex.features = ImmutableList.copyOf(or);
        Ex.featureList = new FeatureList(Ex);
    }

    public static ExFeatureInfo has(String name){
        for (ExFeatureInfo featureInfo : featureInfos) {
            if(name.equals(featureInfo.setter().getName())){
                return featureInfo;
            }
        }
        return null;
    }

    public static void save() throws IOException {
        JsonObject object = new JsonObject();
        for (ExFeatureInfo featureInfo : featureInfos) {
            object.addProperty(featureInfo.setter().getName(),featureInfo.setter().getBooleanValue());
        }
        FileUtils.writeStringToFile(new File("config/tmm-ex-config.json"),object.toString());
    }

    public static void load() throws IOException {
        if(!new File("config/tmm-ex-config.json").exists()) return;
        JsonObject object = JsonParser.parseString(FileUtils.readFileToString(new File("config/tmm-ex-config.json"))).getAsJsonObject();
        for (String s : object.keySet()) {
            ExFeatureInfo has = has(s);
            if(has!=null) has.setter().setBooleanValue(object.get(s).getAsBoolean());
        }
    }
}
