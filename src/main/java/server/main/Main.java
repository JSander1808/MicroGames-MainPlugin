package server.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import server.general.commands.LobbyCommand;
import server.general.commands.PingListener;
import server.general.commands.WarpCommand;
import server.lobby.general.Initial;
import server.lobby.listeners.*;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(),this);
        pluginManager.registerEvents(new EntityDamageListener(),this);
        pluginManager.registerEvents(new InventoryClickListener(),this);
        pluginManager.registerEvents(new PlayerInteractListener(),this);
        pluginManager.registerEvents(new PingListener(),this);
        pluginManager.registerEvents(new QuitListener(),this);

        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());

        new Initial();
    }

    @Override
    public void onDisable() {
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                player.kickPlayer(ChatColor.RED+"Server ist reloading.");
            }
        }
    }
}
