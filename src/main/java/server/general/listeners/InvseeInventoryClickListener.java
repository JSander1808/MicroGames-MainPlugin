package server.general.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import server.lobby.listeners.InventoryClickListener;

public class InvseeInventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Invsee")){
            event.setCancelled(true);
        }
    }
}
