package server.lobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChanceListener implements Listener {

    @EventHandler
    public void onFoodChance(FoodLevelChangeEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                event.setCancelled(true);
            }
        }
    }
}
