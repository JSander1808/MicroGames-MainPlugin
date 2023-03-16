package server.general.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMotd(ChatColor.GREEN+"-----------------"+ChatColor.GOLD+"MicroGames"+ChatColor.GREEN+"-----------------     "+ChatColor.BLUE+"Lootboxen: "+ChatColor.GOLD+"-13%"+"                 "+ChatColor.RED+"[+1.19 - 1.19.4]");
    }
}
