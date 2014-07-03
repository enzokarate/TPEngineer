package com.enzokarate.tpengineer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by enzokarate on 26/06/2014.
 */
public class BasePadBlock extends Block{

    public BasePadBlock(int id, Material material){
        super(material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName("tpengineer:basePadBlock");
    }
    



}
