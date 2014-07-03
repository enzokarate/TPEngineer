package com.enzokarate.tpengineer.handlers;

import com.enzokarate.tpengineer.reference.GeneralReference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by enzo.rugai on 3/07/2014.
 */
public class ConfigHandler{
    public static Configuration config;
    public static int basicRange = 50;

    public static void Init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
        }

        loadConfig();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        System.out.println("EVENT!");
        if (event.modID.equalsIgnoreCase(GeneralReference.MOD_ID)){
            loadConfig();
        }
    }

    public static void loadConfig(){
        basicRange = config.getInt("basicRange", Configuration.CATEGORY_GENERAL, 50, 5, 150, "Amount of blocks able to be teleported using a Basic Setup");
        if (config.hasChanged()){
            System.out.println("SAVE");
            config.save();
        }
    }
}
