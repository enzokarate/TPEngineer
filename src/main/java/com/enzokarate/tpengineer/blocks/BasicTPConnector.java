package com.enzokarate.tpengineer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by enzokarate on 26/06/2014.
 */
public class BasicTPConnector extends Block{

    public BasicTPConnector(int id, Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName("tpengineer:basicTPConnector");
    }
    



}
