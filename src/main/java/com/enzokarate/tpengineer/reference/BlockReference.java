package com.enzokarate.tpengineer.reference;

import net.minecraft.block.material.Material;

/**
 * Created by enzo.rugai on 29/06/2014.
 */
public enum BlockReference {
    BASE_PAD("basePad", 3001, Material.clay, 0.5f, 0.5f);

    private String name;
    private int id;
    private Material material;
    private float hardness;
    private float resistance;

    private BlockReference(String name, int id, Material material, float hardness, float resistance){
        this.name = name;
        this.id = id;
        this.material = material;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public Material getMaterial(){
        return material;
    }
    public float getResistance(){
        return  resistance;
    }

    public float getHardnes(){
        return hardness;
    }
}

