package server.lobby.listeners;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("world")){
            event.setCancelled(true);
        }
    }
}
