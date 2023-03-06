package server.lobby.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import server.games.skywars.SkywarsManager;
import server.lobby.general.Matchmaking;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.GOLD+player.getName()+ChatColor.RED+" hat den Server verlassen.");
        Matchmaking.removePlayerFromMatchmaking(player);
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
            SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
        }
    }
}
