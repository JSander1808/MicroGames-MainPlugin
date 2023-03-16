package server.general;

import org.bukkit.entity.Player;
import server.general.Config;

public class Coins {

    public static void setCoins(Player player, int coins){
        Config config = new Config("playerstats/"+player.getName()+".conf");
        config.set("coins",String.valueOf(coins));
    }

    public static void addCoins(Player player, int coins){
        Config config = new Config("playerstats/"+player.getName()+".conf");
        int nowCoins = Integer.valueOf(config.get("coins"));
        nowCoins+=coins;
        config.set("coins",String.valueOf(nowCoins));
    }

    public static int getCoins(Player player){
        Config config = new Config("playerstats/"+player.getName()+".conf");
        return Integer.valueOf(config.get("coins"));
    }
     public static boolean hasCoins(Player player, int coins){
         Config config = new Config("playerstats/"+player.getName()+".conf");
         if(Integer.valueOf(config.get("coins"))>=coins){
             return true;
         }else{
             return false;
         }
     }
}
