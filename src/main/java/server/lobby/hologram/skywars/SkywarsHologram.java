package server.lobby.hologram.skywars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import server.main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SkywarsHologram {
    public static ArmorStand skywarsHeadlineArmorStand;
    private int TaskID;
    public static ArmorStand skywarsScoreArmorStands[] = new ArmorStand[5];

    public SkywarsHologram(Location location){
        Location headlineLocation = new Location(location.getWorld(),location.getBlockX(),location.getBlockY()+1.0,location.getBlockZ());
        skywarsHeadlineArmorStand = (ArmorStand) location.getWorld().spawnEntity(headlineLocation, EntityType.ARMOR_STAND);
        skywarsHeadlineArmorStand.setGravity(false);
        skywarsHeadlineArmorStand.setVisible(false);
        skywarsHeadlineArmorStand.setCanPickupItems(false);
        skywarsHeadlineArmorStand.setCustomNameVisible(true);
        skywarsHeadlineArmorStand.setCustomName(ChatColor.GOLD+"Skywars - Bestlist");

        Location score1 = new Location(location.getWorld(),location.getBlockX(),location.getBlockY()+0.8,location.getBlockZ());
        skywarsScoreArmorStands[0] = (ArmorStand) location.getWorld().spawnEntity(score1, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[0].setGravity(false);
        skywarsScoreArmorStands[0].setVisible(false);
        skywarsScoreArmorStands[0].setCanPickupItems(false);

        Location score2 = new Location(location.getWorld(),location.getBlockX(),location.getBlockY()+0.6,location.getBlockZ());
        skywarsScoreArmorStands[1] = (ArmorStand) location.getWorld().spawnEntity(score2, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[1].setGravity(false);
        skywarsScoreArmorStands[1].setVisible(false);
        skywarsScoreArmorStands[1].setCanPickupItems(false);

        Location score3 = new Location(location.getWorld(),location.getBlockX(),location.getBlockY()+0.4,location.getBlockZ());
        skywarsScoreArmorStands[2] = (ArmorStand) location.getWorld().spawnEntity(score3, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[2].setGravity(false);
        skywarsScoreArmorStands[2].setVisible(false);
        skywarsScoreArmorStands[2].setCanPickupItems(false);

        Location score4 = new Location(location.getWorld(),location.getBlockX(),location.getBlockY()+0.2,location.getBlockZ());
        skywarsScoreArmorStands[3] = (ArmorStand) location.getWorld().spawnEntity(score4, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[3].setGravity(false);
        skywarsScoreArmorStands[3].setVisible(false);
        skywarsScoreArmorStands[3].setCanPickupItems(false);

        Location score5 = new Location(location.getWorld(),location.getBlockX(),location.getBlockY(),location.getBlockZ());
        skywarsScoreArmorStands[4] = (ArmorStand) location.getWorld().spawnEntity(score5, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[4].setGravity(false);
        skywarsScoreArmorStands[4].setVisible(false);
        skywarsScoreArmorStands[4].setCanPickupItems(false);

        updateHologram();
    }

    public void updateHologram(){
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(),()->{
            for(int i = 0;i<5;i++){
                skywarsScoreArmorStands[i].setCustomNameVisible(false);
            }
            File[] scoresRaw = new File("gamestats/skywars/").listFiles();
            ArrayList<File> scores = new ArrayList<File>();
            for(int i = 0;i<scoresRaw.length;i++){
                scores.add(scoresRaw[i]);
            }
            Collections.sort(scores);
            Collections.reverse(scores);
            if(scores.size()<=5){
                for(int i = 0;i< scores.size();i++){
                    File tempFile = scores.get(i);
                    String playerName = tempFile.getName().split("[.]]")[0];
                    int score = 0;
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
                        score = Integer.valueOf(reader.readLine());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    skywarsScoreArmorStands[i].setCustomNameVisible(true);
                    skywarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+playerName+": "+ChatColor.GREEN+score);
                }
            }else{
                for(int i = 0;i<5;i++){
                    File tempFile = scores.get(i);
                    String playerName = tempFile.getName().split(".")[0];
                    int score = 0;
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
                        score = Integer.valueOf(reader.readLine());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    skywarsScoreArmorStands[i].setCustomNameVisible(true);
                    skywarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+playerName+": "+ChatColor.GREEN+score);
                }
            }
        },0,20);
    }

    public static void removeSkywarsHologram(){
        skywarsHeadlineArmorStand.remove();
        for(int i = 0;i<5;i++){
            skywarsScoreArmorStands[i].remove();
        }
    }
}
