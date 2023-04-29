package server.games.tntrun;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import server.main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class TntrunWorldInitialer {

    public TntrunWorldInitialer(ArrayList<UUID> players, int server, TntrunServer serverMap){
        copyWorld(serverMap.getWorldFolder(),new File("GameServer/Tntrun/Server"+server+"/server/"));
        Bukkit.getScheduler().runTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                World world = new WorldCreator("GameServer/Tntrun/Server"+server+"/server/").createWorld();
                world.setAutoSave(false);
                if(serverMap.getWorldFolder().getName().equalsIgnoreCase("tntrun1")){
                    initTntrun1(players, world);
                }
            }
        });
    }

    public void initTntrun1(ArrayList<UUID> players, World world){
        int playerCount = players.size();
        if(playerCount>=1){
            Bukkit.getPlayer(players.get(0)).teleport(new Location(world,6.5,164,-7.5,45,0));
            Bukkit.getPlayer(players.get(0)).setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
        if(playerCount>=2){
            Bukkit.getPlayer(players.get(1)).teleport(new Location(world,6.5,164,6.5,140,0));
            Bukkit.getPlayer(players.get(1)).setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
        if(playerCount>=3){
            Bukkit.getPlayer(players.get(2)).teleport(new Location(world,-7.5,164,6.5,-140,0));
            Bukkit.getPlayer(players.get(2)).setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
        if(playerCount>=4){
            Bukkit.getPlayer(players.get(3)).teleport(new Location(world,-7.5,164,-7.5,-40,0));
            Bukkit.getPlayer(players.get(3)).setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
    }

    public void copyWorld(File source, File target){
        try {
            ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
            if(!ignore.contains(source.getName())) {
                if(source.isDirectory()) {
                    if(!target.exists())
                        target.mkdirs();
                    String files[] = source.list();
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyWorld(srcFile, destFile);
                    }
                } else {
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0)
                        out.write(buffer, 0, length);
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {

        }
    }
}
