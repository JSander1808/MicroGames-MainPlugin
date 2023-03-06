package server.lobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ArmorStandMalipulateListener implements Listener {

    @EventHandler
    public void onManipulate(PlayerArmorStandManipulateEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("world")){
            event.setCancelled(true);
        }
    }
}
