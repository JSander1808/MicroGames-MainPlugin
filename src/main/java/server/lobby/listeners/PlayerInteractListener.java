package server.lobby.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import server.lobby.general.Initial;
import server.lobby.general.Matchmaking;
import server.lobby.menus.KitManagerMenu;
import server.lobby.menus.TeleporterMenu;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("world")){
            try{
                if(event.getAction()== Action.PHYSICAL){
                    if(event.getClickedBlock().getType().equals(Material.FARMLAND)){
                        event.setCancelled(true);
                    }
                }
                if(event.getClickedBlock().getType()==Material.CHEST){
                    event.setCancelled(true);
                    if(event.getClickedBlock().getX()==17&&event.getClickedBlock().getY()==-58&&event.getClickedBlock().getZ()==-4){
                        Initial.lootbox1.openLootBox(player);
                    }
                    if(event.getClickedBlock().getX()==-1&&event.getClickedBlock().getY()==-58&&event.getClickedBlock().getZ()==20){
                        Initial.lootbox2.openLootBox(player);
                    }
                }
            }catch(Exception e){}
            try{
                if(event.getItem()!=null){
                    switch(event.getItem().getType()){
                        case COMPASS:
                            new TeleporterMenu(player);
                            break;
                        case CHEST:
                            new KitManagerMenu(player);
                            break;
                    }
                }
            }catch(Exception e){}
            try{
                if(event.getClickedBlock().getType()==Material.SPRUCE_WALL_SIGN){
                    org.bukkit.block.Sign sign = (Sign) event.getClickedBlock().getState();
                    if(sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD+"Skywars")){
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 1 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "skywarsServer1");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 2 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "skywarsServer2");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 3 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "skywarsServer3");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 4 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "skywarsServer4");
                        }
                    }else if(sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD+"Bedwars")){
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 1 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "bedwarsServer1");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 2 | SOLO")){
                            Matchmaking.addPlayerToMatchmaking(player, "bedwarsServer2");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 3 | DUO")){
                            Matchmaking.addPlayerToMatchmaking(player, "bedwarsServer3");
                        }
                        if(sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN+"Server 4 | TEAM")){
                            Matchmaking.addPlayerToMatchmaking(player, "bedwarsServer4");
                        }
                    }
                } else if (event.getClickedBlock().getType()==Material.ENDER_CHEST||event.getClickedBlock().getType()==Material.OAK_DOOR||event.getClickedBlock().getType()==Material.ANVIL||event.getClickedBlock().getType()==Material.FURNACE||event.getClickedBlock().getType()==Material.ENCHANTING_TABLE||event.getClickedBlock().getType()==Material.OAK_TRAPDOOR||event.getClickedBlock().getType()==Material.SPRUCE_TRAPDOOR) {
                    event.setCancelled(true);
                }
            }catch(Exception e){}
        }
    }
}
