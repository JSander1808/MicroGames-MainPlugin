package server.general;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMotd(ChatColor.GREEN+"-----------------"+ChatColor.GOLD+"MicroGames"+ChatColor.GREEN+"-----------------   "+ChatColor.BLUE+"NEU Bedwars Update                         "+ChatColor.RED+"[+1.19.3]");
    }
}
