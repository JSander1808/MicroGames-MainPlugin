package server.general.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(args.length==1){
                if(Bukkit.getPlayer(args[0]) !=null){
                    Inventory inv = Bukkit.createInventory(null, 6*9, ChatColor.GOLD+"Invsee");
                    inv.setContents(Bukkit.getPlayer(args[0]).getInventory().getContents());
                    player.openInventory(inv);
                }else{
                    player.sendMessage(ChatColor.RED+"The player doesn´t exist.");
                }
            }else{
                player.sendMessage(ChatColor.RED+"/invsee <playername>");
            }
        }else{
            sender.sendMessage("You are not a player");
        }
        return false;
    }
}
