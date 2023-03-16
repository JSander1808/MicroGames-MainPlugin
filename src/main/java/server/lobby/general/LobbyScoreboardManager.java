package server.lobby.general;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import server.general.Coins;
import server.general.Config;
import server.main.Main;

public class LobbyScoreboardManager {

    public static int TaskID;

    public LobbyScoreboardManager(){
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), ()->{
            for(Player player : Bukkit.getWorld("world").getPlayers()){
                Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                Objective objective = scoreboard.registerNewObjective("lobbyScoreboard","lobbyScoreboard");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"MicroGames");
                Score score1 = objective.getScore(" ");
                score1.setScore(9);
                Score score2;
                if(player.isOp()){
                    score2 = objective.getScore(ChatColor.BLUE+"Rank: "+ChatColor.RED+"Operator");
                    score2.setScore(8);
                }else{
                    score2 = objective.getScore(ChatColor.BLUE+"Rank: "+ChatColor.GREEN+"User");
                    score2.setScore(8);
                }
                Score score3 = objective.getScore("  ");
                score3.setScore(7);
                Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
                Score score4 = objective.getScore(ChatColor.BLUE+"Level: "+ChatColor.GOLD+playerConfig.get("level"));
                score4.setScore(6);
                int xp = Integer.valueOf(playerConfig.get("xp"));
                int xpNextLevel = Integer.valueOf(playerConfig.get("xpNextLevel"));
                StringBuilder xpView = new StringBuilder(ChatColor.BLUE+"XP: ");
                for(int i = 0;i<=45;i++){
                    if(((xpNextLevel/45)*i)<xp){
                        xpView.append(ChatColor.GREEN+"|");
                    }else{
                        xpView.append(ChatColor.GRAY+"|");
                    }
                }
                Score score5 = objective.getScore(xpView.toString());
                score5.setScore(5);
                Score score6 = objective.getScore("      ");
                score6.setScore(4);
                Score score7 = objective.getScore(ChatColor.BLUE+"Coins: "+ChatColor.GREEN+ Coins.getCoins(player));
                score7.setScore(3);
                Score score8 = objective.getScore("    ");
                score8.setScore(2);
                Score score9 = objective.getScore(ChatColor.GOLD+"microgames.duckdns.org");
                score9.setScore(1);
                player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                player.setScoreboard(scoreboard);
            }
        },0,20);
    }
}
