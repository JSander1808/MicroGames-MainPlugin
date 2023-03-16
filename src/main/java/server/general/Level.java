package server.general;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Level {

    public static void addLevel(Player player, int amount){
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        int level = Integer.valueOf(playerConfig.get("level"));
        level+=amount;
        playerConfig.set("level",String.valueOf(level));
        int xpNextLevel = (int) ((30*level)/1.05)+30;
        playerConfig.set("xpNextLevel",String.valueOf(xpNextLevel));
        player.sendMessage(ChatColor.BLUE+"Glückwunsch du hast "+ChatColor.GOLD+"Level "+level+ChatColor.BLUE+" erreicht.");
        playerConfig.set("shop.lootbox.amount",String.valueOf(Integer.valueOf(playerConfig.get("shop.lootbox.amount"))+1));
        player.sendMessage(ChatColor.BLUE+"Glückwunsch du hast "+ChatColor.GOLD+"1 Lootbox "+ChatColor.BLUE+" erhalten.");
    }

    public static int getLevel(Player player){
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        return Integer.valueOf(playerConfig.get("level"));
    }

    public static void addXp(Player player, int amount){
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        int xp = Integer.valueOf(playerConfig.get("xp"));
        int xpNextLevel = Integer.valueOf(playerConfig.get("xpNextLevel"));
        if((xp+amount)>=xpNextLevel){
            addLevel(player, 1);
            xp=(xp+amount)-xpNextLevel;
        }else{
            xp+=amount;
        }
        playerConfig.set("xp",String.valueOf(xp));
        player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+amount+" XP "+ChatColor.BLUE+"erhalten.");
    }

    public static int getXp(Player player){
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        return Integer.valueOf(playerConfig.get("xp"));
    }
}
