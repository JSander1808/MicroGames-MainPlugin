package server.general.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import server.games.bedwars.BedwarsShop;
import server.games.bedwars.BedwarsWorldInitialer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                if(args.length==2){
                    if(args[0].equalsIgnoreCase("unload")){
                        File file = new File("warp/"+args[1]);
                        if(file.exists()){
                            Bukkit.unloadWorld(args[1],true);
                            player.sendMessage(ChatColor.GRAY+args[1]+ChatColor.GOLD+" succesful unloaded.");
                        }else{
                            player.sendMessage(ChatColor.RED+"The world don´t exists.");
                        }
                    }else{
                        player.sendMessage(ChatColor.RED+"/warp unload <worldpath>");
                    }
                }else if(args.length==1){
                    File file = new File("warp/"+args[0]);
                    if(args[0].equalsIgnoreCase("show")){
                        File path = new File("warp\\");
                        File[] warps =path.listFiles();
                        for(int i = 0;i<warps.length;i++){
                            player.sendMessage(ChatColor.GREEN+""+warps[i].getName());
                        }
                    }else if(file.isDirectory()){
                        World world = new WorldCreator("warp/"+args[0]).createWorld();
                        Location warpLocation = Bukkit.getWorld(world.getUID()).getSpawnLocation();
                        player.teleport(warpLocation);
                        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,40,0);
                        player.setGameMode(GameMode.CREATIVE);
                        player.setFlying(true);
                        player.getInventory().clear();
                    }else{
                        player.sendMessage(ChatColor.RED+"The world don´t exists.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"/warp <worldname>");
                    player.sendMessage(ChatColor.RED+"/warp show");
                    player.sendMessage(ChatColor.RED+"/warp unload <worldpath>");
                }
            }else{
                player.sendMessage(ChatColor.RED+"You must have Op to use this command.");
            }
        }
        return false;
    }
}
