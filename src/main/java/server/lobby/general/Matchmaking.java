package server.lobby.general;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.UUID;

public class Matchmaking {

    public static ArrayList<UUID> skywarsServer1 = new ArrayList<UUID>();
    public static ArrayList<UUID> skywarsServer2 = new ArrayList<UUID>();

    public static void removePlayerFromMatchmaking(Player player){
        if(skywarsServer1.contains(player.getUniqueId())){
            skywarsServer1.remove(player.getUniqueId());
            updateSigns();
        }else if(skywarsServer2.contains(player.getUniqueId())){
            skywarsServer2.remove(player.getUniqueId());
            updateSigns();
        }
    }

    public static void addPlayerToMatchmaking(Player player, String server){
        if(server.equalsIgnoreCase("skywarsServer1")){
            if((skywarsServer1.size()+1)<=4){
                if(!skywarsServer1.contains(player.getUniqueId())){
                    removePlayerFromMatchmaking(player);
                    skywarsServer1.add(player.getUniqueId());
                    updateSigns();
                }else{
                    skywarsServer1.remove(player.getUniqueId());
                    updateSigns();
                }
            }else{
                player.sendMessage(ChatColor.RED+"The Server is allready full.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer2")){
            if((skywarsServer2.size()+1)<=8){
                if(!skywarsServer2.contains(player.getUniqueId())){
                    removePlayerFromMatchmaking(player);
                    skywarsServer2.add(player.getUniqueId());
                    updateSigns();
                }else{
                    skywarsServer2.remove(player.getUniqueId());
                    updateSigns();
                }
            }else{
                player.sendMessage(ChatColor.RED+"The Server is allready full.");
            }
        }
    }

    public static void updateSigns(){
        World world = Bukkit.getWorld("world");

        Block skywarsServer1Block = world.getBlockAt(-32,61,-30);
        org.bukkit.block.Sign skywarsServer1Sign = (Sign) skywarsServer1Block.getState();
        skywarsServer1Sign.setLine(0, ChatColor.GOLD+"Skywars");
        skywarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1");
        skywarsServer1Sign.setLine(2,ChatColor.GREEN+""+skywarsServer1.size()+" / 4");
        skywarsServer1Sign.update();

        Block skywarsServer2Block = world.getBlockAt(-28,61,-34);
        org.bukkit.block.Sign skywarsServer2Sign = (Sign) skywarsServer2Block.getState();
        skywarsServer2Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2");
        skywarsServer2Sign.setLine(2,ChatColor.GREEN+""+skywarsServer2.size()+" / 8");
        skywarsServer2Sign.update();
    }

    public static void MatchmakingHandle(){
        while(true){
            if(skywarsServer1.size()>=1){
                for(int i = 0;i<skywarsServer1.size();i++){
                    Bukkit.getPlayer(skywarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD+"Skywars  "+ChatColor.GREEN+"Server1  "+skywarsServer1.size()+" / 4"));
                }
            }
            if(skywarsServer2.size()>=1){
                for(int i = 0;i<skywarsServer2.size();i++){
                    Bukkit.getPlayer(skywarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD+"Skywars  "+ChatColor.GREEN+"Server2  "+skywarsServer2.size()+" / 8"));
                }
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
