package com.enzokarate.tpengineer.utilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;


/**
 * Created by enzo.rugai on 29/06/2014.
 */
public class TeleportUtil {
    public static String placeToString(int x, int y, int z,World world){
            return x + "," + y + "," + z  + "," + world.hashCode();

    }

    public static boolean tpPlayerToString(String mixLoc, EntityPlayer player){
        boolean success = false;
        String[] split = mixLoc.split(",");
        if(split.length == 4){
            System.out.println("4");
            System.out.println(split[3]);
          if(player.getEntityWorld().hashCode() + "" == split[3]){
              System.out.println("Tp");
              player.setPositionAndUpdate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
              success = true;
          }else{
              String curWorldName;
              World curWorld;
              for(int i = 0; i< MinecraftServer.getServer().worldServers.length; i++) {

                  curWorld = MinecraftServer.getServer().worldServers[i];
                  curWorldName = curWorld.hashCode() + "";
                  if(curWorldName == split[3]){
                      success = true;
                    player.setWorld(curWorld);
                    player.setPositionAndUpdate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                  }
              }
          }
        }
        return success;
    }
}
