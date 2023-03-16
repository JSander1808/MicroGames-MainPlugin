package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import server.lobby.general.Matchmaking;
import server.main.Main;

public class BedwarsScorebaordManager {

    public int time = 0;
    public int TaskID;

    public BedwarsScorebaordManager(String server, Scoreboard scoreboard){
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),()->{
            time++;
            try{
                if(Bukkit.getWorld(server).getPlayers().size()==0){
                    Bukkit.getScheduler().cancelTask(TaskID);
                }
            }catch(Exception e){
                Bukkit.getScheduler().cancelTask(TaskID);
            }
            if(server.equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
                Objective objective = null;
                if(scoreboard.getObjective("bedwarsinfo1")!=null) {
                    scoreboard.getObjective("bedwarsinfo1").unregister();
                }
                for(Player player : Bukkit.getWorld(server).getPlayers()){
                    player.setScoreboard(scoreboard);
                }
                objective = scoreboard.registerNewObjective("bedwarsinfo1","bedwarsinfo1");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Bedwars - Info");
                Score score4 = objective.getScore("    ");
                score4.setScore(8);
                if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer1TeamRed"), Bukkit.getWorld(server), 1,BedwarsHandler.BedwarsServerMap[0])){
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamRed"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(7);
                    }else{
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamRed"), server)+ChatColor.RED+" ❌");
                        score.setScore(7);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer1TeamYellow"), Bukkit.getWorld(server), 1,BedwarsHandler.BedwarsServerMap[0])){
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamYellow"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(6);
                    }else{
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamYellow"), server)+ChatColor.RED+" ❌");
                        score.setScore(6);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer1TeamGreen"), Bukkit.getWorld(server), 1,BedwarsHandler.BedwarsServerMap[0])){
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamGreen"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(5);
                    }else{
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamGreen"), server)+ChatColor.RED+" ❌");
                        score.setScore(5);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer1TeamBlue"), Bukkit.getWorld(server), 1,BedwarsHandler.BedwarsServerMap[0])){
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamBlue"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(4);
                    }else{
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer1TeamBlue"), server)+ChatColor.RED+" ❌");
                        score.setScore(4);
                    }
                }
                Score score1 = objective.getScore(" ");
                score1.setScore(3);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score2 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score2.setScore(2);
                Score score3 = objective.getScore("  ");
                score3.setScore(1);
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
                Objective objective = null;
                if(scoreboard.getObjective("bedwarsinfo2")!=null) {
                    scoreboard.getObjective("bedwarsinfo2").unregister();
                }
                objective = scoreboard.registerNewObjective("bedwarsinfo2","bedwarsinfo2");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Bedwars - Info");
                Score score4 = objective.getScore("    ");
                score4.setScore(8);
                if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer2TeamRed"), Bukkit.getWorld(server), 2,BedwarsHandler.BedwarsServerMap[1])){
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamRed"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(7);
                    }else{
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamRed"), server)+ChatColor.RED+" ❌");
                        score.setScore(7);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer2TeamYellow"), Bukkit.getWorld(server), 2,BedwarsHandler.BedwarsServerMap[1])){
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamYellow"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(6);
                    }else{
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamYellow"), server)+ChatColor.RED+" ❌");
                        score.setScore(6);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer2TeamGreen"), Bukkit.getWorld(server), 2,BedwarsHandler.BedwarsServerMap[1])){
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamGreen"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(5);
                    }else{
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamGreen"), server)+ChatColor.RED+" ❌");
                        score.setScore(5);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer2TeamBlue"), Bukkit.getWorld(server), 2,BedwarsHandler.BedwarsServerMap[1])){
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamBlue"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(4);
                    }else{
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer2TeamBlue"), server)+ChatColor.RED+" ❌");
                        score.setScore(4);
                    }
                }
                Score score1 = objective.getScore(" ");
                score1.setScore(3);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score2 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score2.setScore(2);
                Score score3 = objective.getScore("  ");
                score3.setScore(1);
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
                Objective objective = null;
                if(scoreboard.getObjective("bedwarsinfo3")!=null) {
                    scoreboard.getObjective("bedwarsinfo3").unregister();
                }
                objective = scoreboard.registerNewObjective("bedwarsinfo3","bedwarsinfo3");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Bedwars - Info");
                Score score4 = objective.getScore("    ");
                score4.setScore(8);
                if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer3TeamRed"), Bukkit.getWorld(server), 3,BedwarsHandler.BedwarsServerMap[2])){
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamRed"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(7);
                    }else{
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamRed"), server)+ChatColor.RED+" ❌");
                        score.setScore(7);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer3TeamYellow"), Bukkit.getWorld(server), 3,BedwarsHandler.BedwarsServerMap[2])){
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamYellow"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(6);
                    }else{
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamYellow"), server)+ChatColor.RED+" ❌");
                        score.setScore(6);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer3TeamGreen"), Bukkit.getWorld(server), 3,BedwarsHandler.BedwarsServerMap[2])){
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamGreen"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(5);
                    }else{
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamGreen"), server)+ChatColor.RED+" ❌");
                        score.setScore(5);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer3TeamBlue"), Bukkit.getWorld(server), 3,BedwarsHandler.BedwarsServerMap[2])){
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamBlue"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(4);
                    }else{
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer3TeamBlue"), server)+ChatColor.RED+" ❌");
                        score.setScore(4);
                    }
                }
                Score score1 = objective.getScore(" ");
                score1.setScore(3);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score2 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score2.setScore(2);
                Score score3 = objective.getScore("  ");
                score3.setScore(1);
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                Objective objective = null;
                if(scoreboard.getObjective("bedwarsinfo4")!=null) {
                    scoreboard.getObjective("bedwarsinfo4").unregister();
                }
                objective = scoreboard.registerNewObjective("bedwarsinfo4","bedwarsinfo4");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GOLD+"Bedwars - Info");
                Score score4 = objective.getScore("    ");
                score4.setScore(8);
                if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer4TeamRed"), Bukkit.getWorld(server), 4,BedwarsHandler.BedwarsServerMap[3])){
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamRed"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(7);
                    }else{
                        Score score = objective.getScore(ChatColor.RED+"Team Rot "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamRed"), server)+ChatColor.RED+" ❌");
                        score.setScore(7);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer4TeamYellow"), Bukkit.getWorld(server), 4,BedwarsHandler.BedwarsServerMap[3])){
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamYellow"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(6);
                    }else{
                        Score score = objective.getScore(ChatColor.YELLOW+"Team Gelb "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamYellow"), server)+ChatColor.RED+" ❌");
                        score.setScore(6);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer4TeamGreen"), Bukkit.getWorld(server), 4,BedwarsHandler.BedwarsServerMap[3])){
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamGreen"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(5);
                    }else{
                        Score score = objective.getScore(ChatColor.GREEN+"Team Grün "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamGreen"), server)+ChatColor.RED+" ❌");
                        score.setScore(5);
                    }
                }
                if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().size()>=1){
                    if(existBed(scoreboard.getTeam("bedwarsServer4TeamBlue"), Bukkit.getWorld(server), 4,BedwarsHandler.BedwarsServerMap[3])){
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamBlue"), server)+ChatColor.GREEN+" ✔");
                        score.setScore(4);
                    }else{
                        Score score = objective.getScore(ChatColor.BLUE+"Team Blau "+ChatColor.GRAY+getAlivePlayerFromTeam(scoreboard.getTeam("bedwarsServer4TeamBlue"), server)+ChatColor.RED+" ❌");
                        score.setScore(4);
                    }
                }
                Score score1 = objective.getScore(" ");
                score1.setScore(3);
                StringBuilder timeString = new StringBuilder();
                timeString.append(String.format("%02d", time / 60)).append(":");
                timeString.append(String.format("%02d", time % 60));
                Score score2 = objective.getScore(ChatColor.BLUE+"Time: "+ChatColor.GOLD+timeString.toString());
                score2.setScore(2);
                Score score3 = objective.getScore("  ");
                score3.setScore(1);
            }
        },0,20);
    }

    public int getTeams(Scoreboard scoreboard, int server){
        int teams = 0;
        if(scoreboard.getTeam("bedwarsServer"+server+"TeamRed").getPlayers().size()>=1){
            teams++;
        }
        if(scoreboard.getTeam("bedwarsServer"+server+"TeamYellow").getPlayers().size()>=1){
            teams++;
        }
        if(scoreboard.getTeam("bedwarsServer"+server+"TeamGreen").getPlayers().size()>=1){
            teams++;
        }
        if(scoreboard.getTeam("bedwarsServer"+server+"TeamBlue").getPlayers().size()>=1){
            teams++;
        }
        return teams;
    }

    public int getAlivePlayerFromTeam(Team team, String server){
        int alivePlayer = 0;
        for(OfflinePlayer offPlayer : team.getPlayers()){
            Player player = offPlayer.getPlayer();
            try{
                if(server.equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
                    if(Matchmaking.bedwarsServer1.contains(player.getUniqueId())){
                        alivePlayer++;
                    }
                }
                if(server.equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
                    if(Matchmaking.bedwarsServer2.contains(player.getUniqueId())){
                        alivePlayer++;
                    }
                }
                if(server.equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
                    if(Matchmaking.bedwarsServer3.contains(player.getUniqueId())){
                        alivePlayer++;
                    }
                }
                if(server.equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                    if(Matchmaking.bedwarsServer4.contains(player.getUniqueId())){
                        alivePlayer++;
                    }
                }
            }catch(Exception e){}
        }
        return alivePlayer;
    }

    public boolean existBed(Team team, World world, int server, int serverMap){
        if(serverMap==1){
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamRed")){
                if(world.getBlockAt(88,3,88).getType()==Material.RED_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamYellow")){
                if(world.getBlockAt(-70,3,88).getType()==Material.YELLOW_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamGreen")){
                if(world.getBlockAt(9,3,9).getType()==Material.GREEN_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamBlue")){
                if(world.getBlockAt(9,3,167).getType()==Material.BLUE_BED){
                    return true;
                }
            }
        }
        if(serverMap==2){
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamRed")){
                if(world.getBlockAt(8,0,-91).getType()==Material.RED_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamYellow")){
                if(world.getBlockAt(8,0,7).getType()==Material.YELLOW_BED){
                    return true;
                }
            }
        }
        if(serverMap==3){
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamRed")){
                if(world.getBlockAt(5,-1,1).getType()==Material.RED_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamYellow")){
                if(world.getBlockAt(-19,-1,-189).getType()==Material.YELLOW_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamGreen")){
                if(world.getBlockAt(-102,-1,-82).getType()==Material.GREEN_BED){
                    return true;
                }
            }
            if(team.getName().equalsIgnoreCase("bedwarsServer"+server+"TeamBlue")){
                if(world.getBlockAt(88,-1,-106).getType()==Material.BLUE_BED){
                    return true;
                }
            }
        }
        return false;
    }
}
