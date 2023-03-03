package server.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                if(player.getHealth() - event.getDamage()<=0){
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),26.5,63,-24.5);
                    player.teleport(spawnLocation);
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setGameMode(GameMode.ADVENTURE);
                    player.setAllowFlight(true);
                    player.setFlying(false);
                    event.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
                }
            }
        }
    }
}