package server.lobby.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import server.lobby.general.Matchmaking;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(player.isOp()){
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(Matchmaking.skywarsServer1.contains(player.getUniqueId())){
                        if(Matchmaking.skywarsServer1.size()==Matchmaking.skywarsServer1MaxPlayer){
                            Matchmaking.skywarsServer1Countdown=6;
                        }else{
                            player.sendMessage(ChatColor.RED+"In your Queue are not enough Player.");
                        }
                    }else if(Matchmaking.skywarsServer2.contains(player.getUniqueId())){
                        if(Matchmaking.skywarsServer2.size()==Matchmaking.skywarsServer2MaxPlayer){
                            Matchmaking.skywarsServer2Countdown=6;
                        }else{
                            player.sendMessage(ChatColor.RED+"In your Queue are not enough Player.");
                        }
                    }else if(Matchmaking.skywarsServer3.contains(player.getUniqueId())){
                        if(Matchmaking.skywarsServer3.size()>=Matchmaking.skywarsServer3MaxPlayer/2){
                            Matchmaking.skywarsServer3Countdown=6;
                        }else{
                            player.sendMessage(ChatColor.RED+"In your Queue are not enough Player.");
                        }
                    }else if(Matchmaking.skywarsServer4.contains(player.getUniqueId())){
                        if(Matchmaking.skywarsServer4.size()>=Matchmaking.skywarsServer4MaxPlayer/2){
                            Matchmaking.skywarsServer4Countdown=6;
                        }else{
                            player.sendMessage(ChatColor.RED+"In your Queue are not enough Player.");
                        }
                    }else{
                        player.sendMessage(ChatColor.RED+"You are not in a Queue.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"You are not in lobby.");
                }
            }else{
                player.sendMessage(ChatColor.RED+"You don´t have permission to perform this Connand.");
            }
        }
        return false;
    }
}
