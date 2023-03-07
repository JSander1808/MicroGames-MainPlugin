package server.lobby.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import server.general.InitPlayerStats;

import java.io.*;
import java.util.Calendar;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD+player.getName()+ChatColor.GREEN+" ist dem Server beigetreten. ");
        Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);

        player.teleport(spawnLocation);
        player.getInventory().clear();
        player.setMaxHealth(20);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        if(player.isOp()){
            player.setAllowFlight(true);
        }
        player.setFlying(false);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
        player.sendTitle(ChatColor.GREEN+"Herzlich Willkommen",ChatColor.GOLD+player.getName());
        player.setBedSpawnLocation(spawnLocation);
        player.getInventory().clear();
        for(PotionEffect effect : player.getActivePotionEffects()){
            player.removePotionEffect(effect.getType());
        }
        player.setFireTicks(0);
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        Calendar calendar = Calendar.getInstance();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        player.setExp(0.002f*dayOfYear);
        player.setLevel(year);

        new InitPlayerStats(player);

        ItemStack teleporter = new ItemStack(Material.COMPASS);
        ItemMeta teleporterMeta = teleporter.getItemMeta();
        teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
        teleporter.setItemMeta(teleporterMeta);

        Inventory inv = player.getInventory();
        inv.setItem(0,teleporter);
    }
}
