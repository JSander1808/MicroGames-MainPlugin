package server.lobby.general;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
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
                score1.setScore(6);
                Score score2;
                if(player.isOp()){
                    score2 = objective.getScore(ChatColor.BLUE+"Rank: "+ChatColor.RED+"Operator");
                    score2.setScore(5);
                }else{
                    score2 = objective.getScore(ChatColor.BLUE+"Rank: "+ChatColor.GREEN+"User");
                    score2.setScore(5);
                }
                Score score3 = objective.getScore("  ");
                score3.setScore(4);
                Score score5 = objective.getScore(ChatColor.BLUE+"Coins: "+ChatColor.GREEN+Coins.getCoins(player));
                score5.setScore(3);
                Score score6 = objective.getScore("    ");
                score6.setScore(2);
                Score score7 = objective.getScore(ChatColor.GOLD+"microgames.duckdns.org");
                score7.setScore(1);
                player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                player.setScoreboard(scoreboard);
            }
        },0,20);
    }
}
