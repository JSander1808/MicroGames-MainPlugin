package server.lobby.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import server.lobby.menus.KitManagerMenu;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                if(args.length==0){
                    new KitManagerMenu(player);
                }else{
                    player.sendMessage(ChatColor.RED+"/kit");
                }
            }else{
                player.sendMessage(ChatColor.RED+"Du kannst momentan nicht auf Kits zugreifen.");
            }
        }else{
            sender.sendMessage("You must by a Player!");
        }
        return false;
    }
}
