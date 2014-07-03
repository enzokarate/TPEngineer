package com.enzokarate.tpengineer.handlers;

import com.enzokarate.tpengineer.TPEngineer;
import com.enzokarate.tpengineer.utilities.TeleportUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by enzokarate on 27/06/2014.
 */
public class Events {
    HashMap<UUID,String> playerLocation1 = new HashMap<UUID,String>();
    HashMap<String,String> location1Location2 = new HashMap<String,String>();
    HashMap<String,String> location2Location1 = new HashMap<String,String>();
    @SubscribeEvent(receiveCanceled = false)
    public void onPlayerInteract(PlayerInteractEvent event){

        if(event.action.equals(event.action.RIGHT_CLICK_BLOCK)){
            if(event.world.getBlock(event.x,event.y,event.z).equals(TPEngineer.basicTPStation)){
              /*  System.out.println("BasePad");
                EntityPlayer player = event.entityPlayer;
                String tpstring = TeleportUtil.placeToString(event.x, event.y, event.z, player.getEntityWorld());
                if(player.isSneaking()){
                    if(playerLocation1.containsKey(player.getUniqueID()) && (playerLocation1.get(player.getUniqueID())!= tpstring)){
                       location1Location2.put(playerLocation1.get(player.getUniqueID()), tpstring);
                        playerLocation1.remove(player.getUniqueID());
                        System.out.println("Both Loc");
                    }else{
                        playerLocation1.put(player.getUniqueID(), tpstring);
                        System.out.println("Player Loc1");
                    }
                }else{
                    System.out.println("Else");
                    if(location1Location2.containsKey(tpstring)){
                        System.out.println(tpstring);
                        System.out.println(TeleportUtil.tpPlayerToString(location1Location2.get(tpstring), player));
                    }else if(location2Location1.containsKey(tpstring)){
                        System.out.println(TeleportUtil.tpPlayerToString(location2Location1.get(tpstring), player));

                    }
                }
            }*/

                EntityPlayer player = event.entityPlayer;
                int x = event.x;
                int y = event.y;
                int z = event.z;
                World world = event.world;
                boolean done = false;
                if(world.getBlock(x+1,y,z).equals(TPEngineer.basicTPConnector)){
                    while(world.getBlock(x+1,y,z).equals(TPEngineer.basicTPConnector)){
                        x++;
                    }
                    x++;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }
                }

                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

                if(world.getBlock(x,y+1,z).equals(TPEngineer.basicTPConnector) && !done){
                    while(world.getBlock(x,y+1,z).equals(TPEngineer.basicTPConnector)){
                        y++;
                    }
                    y++;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }
                }

                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

                if (world.getBlock(x,y,z+1).equals(TPEngineer.basicTPConnector) && !done){
                    while(world.getBlock(x,y,z+1).equals(TPEngineer.basicTPConnector)){
                        z++;
                    }
                    z++;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }

                }

                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

                if(world.getBlock(x-1,y,z).equals(TPEngineer.basicTPConnector) && !done){
                    while(world.getBlock(x-1,y,z).equals(TPEngineer.basicTPConnector)){
                        x--;
                    }
                    x--;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }

                }

                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

                if(world.getBlock(x,y-1,z).equals(TPEngineer.basicTPConnector) && !done){
                    while(world.getBlock(x,y-1,z).equals(TPEngineer.basicTPConnector)){
                        y--;
                    }
                    y--;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }
                    y -= 2.5;
                }


                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

                if (world.getBlock(x,y,z-1).equals(TPEngineer.basicTPConnector) && !done){
                    while(world.getBlock(x,y,z-1).equals(TPEngineer.basicTPConnector)){
                        z--;
                    }
                    z--;
                    if (world.getBlock(x,y,z).equals(TPEngineer.basicTPStation)){
                        done = true;
                    }
                }

                if(!done || !isInRange(event.x, event.y, event.z, x, y, z)){
                    x = event.x;
                    y = event.y;
                    z = event.z;
                }

            }
        }
    }

    private boolean isInRange(int ex, int ey, int ez, int x, int y, int z) {
        System.out.println(ConfigHandler.basicRange);
        boolean returnVal = true;
        if((ex + x > ConfigHandler.basicRange) || (ex - x < ConfigHandler.basicRange * -1)){
            returnVal = false;
        }else if((ey + y > ConfigHandler.basicRange) || (ey - y < ConfigHandler.basicRange * -1)){
            returnVal = false;
        }else if((ez + z > ConfigHandler.basicRange) || (ez - z < ConfigHandler.basicRange * -1)){
            returnVal = false;
        }
        return returnVal;
    }


}
