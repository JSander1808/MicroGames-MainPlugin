package server.general.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent event){
        String message = event.getMessage();
        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append(ChatColor.GOLD+event.getPlayer().getName());
        finalMessage.append(ChatColor.DARK_GRAY+" -> ").append(ChatColor.WHITE+message);
        event.setCancelled(true);
        Bukkit.broadcastMessage(finalMessage.toString());
    }
}
