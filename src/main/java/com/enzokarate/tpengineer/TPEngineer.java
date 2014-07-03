package com.enzokarate.tpengineer;

import com.enzokarate.tpengineer.blocks.BasePadBlock;
import com.enzokarate.tpengineer.blocks.BasicTPConnector;
import com.enzokarate.tpengineer.blocks.BasicTPStation;
import com.enzokarate.tpengineer.handlers.ConfigHandler;
import com.enzokarate.tpengineer.handlers.Events;
import com.enzokarate.tpengineer.reference.GeneralReference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by enzokarate on 25/06/2014.
 */
@Mod(modid = GeneralReference.MOD_ID, name = GeneralReference.MOD_NAME, version = GeneralReference.VERSION, guiFactory = GeneralReference.MOD_GUI_FACTORY)
public class TPEngineer {
    @Mod.Instance(GeneralReference.MOD_ID)
    public static TPEngineer instance;
    public static Block basePadBlock;
    public static Block basicTPStation;
    public static Block basicTPConnector;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        basePadBlock  = new BasePadBlock(3001, Material.clay).setBlockName("basePad");
        basicTPStation  = new BasicTPStation(3002, Material.clay).setBlockName("basicTPStation");
        basicTPConnector = new BasicTPConnector(3003, Material.clay).setBlockName("basicTPConnector");
        GameRegistry.registerBlock(basePadBlock, "basePad");
        GameRegistry.registerBlock(basicTPStation, "basicTPStation");
        GameRegistry.registerBlock(basicTPConnector, "basicTPConnector");


        GameRegistry.addRecipe(new ItemStack(basicTPConnector),"AXA","XXX", "AXA", 'A', Items.brick, 'X', Items.redstone );
        GameRegistry.addRecipe(new ItemStack(basicTPStation),"AXA","XOX", "AXA", 'A', Blocks.obsidian, 'X', Items.redstone, 'O', Items.ender_pearl );

        ConfigHandler.Init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new Events());

    }



    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

}
