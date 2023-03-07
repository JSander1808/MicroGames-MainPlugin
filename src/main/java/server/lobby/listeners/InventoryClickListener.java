package server.lobby.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import server.lobby.menus.TeleporterMenu;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(event.getInventory().getHolder()==player.getInventory().getHolder()){
                        switch(event.getCurrentItem().getType()){
                            default:
                                break;
                            case COMPASS:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                                new TeleporterMenu(player);
                                break;
                        }
                        if(!player.isOp()){
                            event.setCancelled(true);
                        }
                    }
                    if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Teleporter")){
                        switch(event.getCurrentItem().getType()){
                            default:
                                break;
                            case BARRIER:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                                player.closeInventory();
                                break;
                            case COMPASS:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                                Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                                player.teleport(spawnLocation);
                                player.setFlying(false);
                                player.sendMessage(ChatColor.GRAY+"Du wurdest zum Spawn teleportiert");
                                break;
                            case RED_BED:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                                Location bedwarsLocation = new Location(Bukkit.getWorld("world"),-9.5,-38,65.5,-90,0);
                                player.teleport(bedwarsLocation);
                                player.setFlying(false);
                                player.sendMessage(ChatColor.GRAY+"Du wurdest zu Bedwars teleportiert");
                                break;
                            case IRON_SWORD:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                                Location skywarsLocation = new Location(Bukkit.getWorld("world"),59.5,-43,-13.5,0,0);
                                player.teleport(skywarsLocation);
                                player.setFlying(false);
                                player.sendMessage(ChatColor.GRAY+"Du wurdest zu Skywars teleportiert");
                                break;
                        }
                        event.setCancelled(true);
                }
            }
        }
    }
}
