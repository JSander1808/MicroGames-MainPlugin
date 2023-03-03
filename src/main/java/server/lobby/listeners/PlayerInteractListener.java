package server.lobby.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import server.lobby.general.Matchmaking;
import server.lobby.menus.TeleporterMenu;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("world")){
            if(event.getClickedBlock() == null){
                if(event.getItem()!=null){
                    switch(event.getItem().getType()){
                        case COMPASS:
                            new TeleporterMenu(player);
                            break;
                    }
                }
            }else{
                try{
                    if(event.getClickedBlock().getType()==Material.OAK_WALL_SIGN){
                        org.bukkit.block.Sign sign = (Sign) event.getClickedBlock().getState();
                        if(sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD+"Skywars")){
                            if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 1")){
                                Matchmaking.addPlayerToMatchmaking(player, "skywarsServer1");
                            }
                            if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 2")){
                                Matchmaking.addPlayerToMatchmaking(player, "skywarsServer2");
                            }
                        }
                    }
                }catch(Exception e){

                }
            }
        }
    }
}
