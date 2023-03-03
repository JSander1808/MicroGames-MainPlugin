package server.general.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                if(args.length==1){
                    File file = new File("warp/"+args[0]);
                    if(file.isDirectory()){
                        World world = new WorldCreator("warp/"+args[0]).createWorld();
                        Location warpLocation = Bukkit.getWorld(world.getUID()).getSpawnLocation();
                        player.teleport(warpLocation);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,40,0);
                    }else{
                        player.sendMessage(ChatColor.RED+"The world don´t exists.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"/warp <worldname>");
                }
            }else{
                player.sendMessage(ChatColor.RED+"You must have Op to use this command.");
            }
        }
        return false;
    }
}
