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
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
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
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
                                player.closeInventory();
                                break;
                            case COMPASS:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
                                Location spawnLocation = new Location(Bukkit.getWorld("world"),26.5,63,-24.5);
                                player.teleport(spawnLocation);
                                player.setFlying(false);
                                player.sendMessage(ChatColor.GRAY+"Du wurdest zum Spawn teleportiert");
                                break;
                            case RED_BED:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
                                Location bedwarsLocation = new Location(Bukkit.getWorld("world"),-53.5,60,25.5,90,0);
                                player.teleport(bedwarsLocation);
                                player.setFlying(false);
                                player.sendMessage(ChatColor.GRAY+"Du wurdest zu Bedwars teleportiert");
                                break;
                            case IRON_SWORD:
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
                                Location skywarsLocation = new Location(Bukkit.getWorld("world"),-23.5,62,-24.5,140,0);
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
