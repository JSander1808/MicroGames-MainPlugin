package server.lobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import server.lobby.menus.TeleporterMenu;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("world")){
            switch(event.getItem().getType()){
                default:
                    break;
                case COMPASS:
                    new TeleporterMenu(player);
                    break;
            }
        }
    }
}
