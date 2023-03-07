package server.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import server.games.skywars.SkywarsEntityDamageListener;
import server.general.commands.InvseeCommand;
import server.general.commands.LobbyCommand;
import server.general.PingListener;
import server.general.commands.WarpCommand;
import server.general.listeners.InvseeInventoryClickListener;
import server.lobby.commands.StartCommand;
import server.lobby.general.Initial;
import server.lobby.general.LobbyScoreboardManager;
import server.lobby.general.Matchmaking;
import server.lobby.hologram.skywars.SkywarsHologram;
import server.lobby.listeners.*;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin=this;
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(),this);
        pluginManager.registerEvents(new EntityDamageListener(),this);
        pluginManager.registerEvents(new InventoryClickListener(),this);
        pluginManager.registerEvents(new PlayerInteractListener(),this);
        pluginManager.registerEvents(new PingListener(),this);
        pluginManager.registerEvents(new QuitListener(),this);
        pluginManager.registerEvents(new SkywarsEntityDamageListener(),this);
        pluginManager.registerEvents(new PlayerDropListener(),this);
        pluginManager.registerEvents(new ArmorStandMalipulateListener(),this);
        pluginManager.registerEvents(new InvseeInventoryClickListener(),this);

        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());

        new Initial();
    }

    @Override
    public void onDisable() {
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                player.kickPlayer(ChatColor.RED+"Server is reloading.");
            }
        }
        Bukkit.getScheduler().cancelTask(Matchmaking.MATCHMAKINGPROCESSID);
        Bukkit.getScheduler().cancelTask(LobbyScoreboardManager.TaskID);
        SkywarsHologram.removeSkywarsHologram();
        Initial.lootbox1.remove();
        Initial.lootbox2.remove();
    }

    public static Main getPlugin(){
        return plugin;
    }
}
