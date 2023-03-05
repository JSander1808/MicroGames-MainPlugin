package server.general.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import server.lobby.general.Matchmaking;

import java.util.Calendar;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Location spawnLocation = new Location(Bukkit.getWorld("world"),26.5,63,-24.5);
            player.teleport(spawnLocation);
            player.setMaxHealth(20);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.ADVENTURE);
            if(player.isOp()){
                player.setAllowFlight(true);
            }
            player.setFlying(false);
            player.getActivePotionEffects().clear();
            player.setFireTicks(0);
            player.getInventory().clear();
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,4);
            Matchmaking.removePlayerFromMatchmaking(player);
            Calendar calendar = Calendar.getInstance();
            int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
            int year = calendar.get(Calendar.YEAR);
            player.setExp(0.002f*dayOfYear);
            player.setLevel(year);

            ItemStack teleporter = new ItemStack(Material.COMPASS);
            ItemMeta teleporterMeta = teleporter.getItemMeta();
            teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
            teleporter.setItemMeta(teleporterMeta);

            Inventory inv = player.getInventory();
            inv.setItem(0,teleporter);
        }
        return false;
    }
}
