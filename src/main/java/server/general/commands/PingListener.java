package server.general.commands;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMotd(ChatColor.GOLD+"MircroGames  "+ChatColor.GREEN+"+1.19.3");
    }
}
