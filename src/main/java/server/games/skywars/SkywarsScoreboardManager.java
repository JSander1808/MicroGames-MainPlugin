package server.games.skywars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import server.lobby.general.Matchmaking;
import server.main.Main;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class SkywarsScoreboardManager {

    public int TaskID;
    public Scoreboard scoreboard;
    public Objective objective;
    public int time = 0;

    public SkywarsScoreboardManager(String server, ArrayList<UUID> players){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        String[] names = new String[players.size()];
        for(int i = 0;i< players.size();i++){
            names[i]=Bukkit.getPlayer(players.get(i)).getName();
        }

        Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
            scoreboard = manager.getNewScoreboard();
        });


        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),()->{
            time++;
            try{
                if(Bukkit.getWorld(server).getPlayers().size()==0){
                    Bukkit.getScheduler().cancelTask(TaskID);
                }
            }catch(Exception e){
                Bukkit.getScheduler().cancelTask(TaskID);
            }
            if(server.equalsIgnoreCase("GameServer/Skywars/Server1/server/")){
                if(scoreboard.getObjective("skywarsinfo1")!=null){
                    scoreboard.getObjective("skywarsinfo1").unregister();
                }
                objective = scoreboard.registerNewObjective("skywarsinfo1","skywarsinfo1");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Skywars - Info");
                Score score1 = objective.getScore(" ");
                score1.setScore(names.length+1+4);
                Score score2 = objective.getScore("  ");
                score2.setScore(1);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score3 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score3.setScore(2);
                Score score4 = objective.getScore("   ");
                score4.setScore(3);
                for(int i = 0;i< names.length;i++){
                    Score score;
                    try{
                        if(Matchmaking.skywarsServer1.contains(Bukkit.getPlayer(names[i]).getUniqueId())){
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.GREEN+"✔");
                            score.setScore(i+4);
                        }else{
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                            score.setScore(i+4);
                        }
                    }catch(Exception e){
                        score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                        score.setScore(i+4);
                    }
                }
            }else if(server.equalsIgnoreCase("GameServer/Skywars/Server2/server/")){
                if(scoreboard.getObjective("skywarsinfo2")!=null){
                    scoreboard.getObjective("skywarsinfo2").unregister();
                }
                objective = scoreboard.registerNewObjective("skywarsinfo2","skywarsinfo2");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Skywars - Info");
                Score score1 = objective.getScore(" ");
                score1.setScore(names.length+1+4);
                Score score2 = objective.getScore("  ");
                score2.setScore(1);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score3 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score3.setScore(2);
                Score score4 = objective.getScore("   ");
                score4.setScore(3);
                for(int i = 0;i< names.length;i++){
                    Score score;
                    try{
                        if(Matchmaking.skywarsServer2.contains(Bukkit.getPlayer(names[i]).getUniqueId())){
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.GREEN+"✔");
                            score.setScore(i+4);
                        }else{
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                            score.setScore(i+4);
                        }
                    }catch(Exception e){
                        score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                        score.setScore(i+4);
                    }
                }
            }else if(server.equalsIgnoreCase("GameServer/Skywars/Server3/server/")){
                if(scoreboard.getObjective("skywarsinfo3")!=null){
                    scoreboard.getObjective("skywarsinfo3").unregister();
                }
                objective = scoreboard.registerNewObjective("skywarsinfo3","skywarsinfo3");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Skywars - Info");
                Score score1 = objective.getScore(" ");
                score1.setScore(names.length+1+4);
                Score score2 = objective.getScore("  ");
                score2.setScore(1);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score3 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score3.setScore(2);
                Score score4 = objective.getScore("   ");
                score4.setScore(3);
                for(int i = 0;i< names.length;i++){
                    Score score;
                    try{
                        if(Matchmaking.skywarsServer3.contains(Bukkit.getPlayer(names[i]).getUniqueId())){
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.GREEN+"✔");
                            score.setScore(i+4);
                        }else{
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                            score.setScore(i+4);
                        }
                    }catch(Exception e){
                        score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                        score.setScore(i+4);
                    }
                }
            }else if(server.equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
                if(scoreboard.getObjective("skywarsinfo4")!=null){
                    scoreboard.getObjective("skywarsinfo4").unregister();
                }
                objective = scoreboard.registerNewObjective("skywarsinfo4","skywarsinfo4");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Skywars - Info");
                Score score1 = objective.getScore(" ");
                score1.setScore(names.length+4);
                Score score2 = objective.getScore("  ");
                score2.setScore(1);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score3 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score3.setScore(2);
                Score score4 = objective.getScore("   ");
                score4.setScore(3);
                for(int i = 0;i< names.length;i++){
                    Score score;
                    try{
                        if(Matchmaking.skywarsServer4.contains(Bukkit.getPlayer(names[i]).getUniqueId())){
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.GREEN+"✔");
                            score.setScore(i+4);
                        }else{
                            score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                            score.setScore(i+4);
                        }
                    }catch(Exception e){
                        score = objective.getScore(ChatColor.GOLD+names[i]+" "+ChatColor.RED+"❌");
                        score.setScore(i+4);
                    }
                }
            }
            try{
                for(Player player : Bukkit.getWorld(server).getPlayers()){
                    player.setScoreboard(scoreboard);
                }
            }catch(Exception e){};
        },0,20);
    }
}
