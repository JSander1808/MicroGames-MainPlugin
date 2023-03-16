package server.general.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import server.games.bedwars.BedwarsManager;
import server.games.skywars.SkywarsManager;
import server.lobby.general.Matchmaking;

import java.util.Calendar;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Matchmaking.removePlayerFromMatchmaking(player);
            Matchmaking.removePlayerFromSpectator(player);
            if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
                SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
            }
            if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                BedwarsManager.updateBedwarsLobby(player.getWorld().getName());
            }
            Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
            player.teleport(spawnLocation);
            player.setMaxHealth(20);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.ADVENTURE);
            if(player.isOp()){
                player.setAllowFlight(true);
            }
            player.setFlying(false);
            for(PotionEffect effect : player.getActivePotionEffects()){
                player.removePotionEffect(effect.getType());
            }
            player.setFireTicks(0);
            player.getInventory().clear();
            player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
            Calendar calendar = Calendar.getInstance();
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            int year = calendar.get(Calendar.YEAR);
            player.setExp(0.002f*dayOfYear);
            player.setLevel(year);

            ItemStack teleporter = new ItemStack(Material.COMPASS);
            ItemMeta teleporterMeta = teleporter.getItemMeta();
            teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
            teleporter.setItemMeta(teleporterMeta);

            ItemStack kits = new ItemStack(Material.CHEST);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Kit Menu");
            kits.setItemMeta(kitsMeta);

            Inventory inv = player.getInventory();
            inv.setItem(0,teleporter);
            inv.setItem(4,kits);
        }
        return false;
    }
}
