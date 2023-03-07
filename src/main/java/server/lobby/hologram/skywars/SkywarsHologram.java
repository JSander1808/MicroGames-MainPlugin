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
        Location headlineLocation = new Location(location.getWorld(),location.getX(),location.getY()+1.25,location.getZ());
        skywarsHeadlineArmorStand = (ArmorStand) location.getWorld().spawnEntity(headlineLocation, EntityType.ARMOR_STAND);
        skywarsHeadlineArmorStand.setGravity(false);
        skywarsHeadlineArmorStand.setVisible(false);
        skywarsHeadlineArmorStand.setCanPickupItems(false);
        skywarsHeadlineArmorStand.setCustomNameVisible(true);
        skywarsHeadlineArmorStand.setCustomName(ChatColor.GOLD+"Skywars - Siege");

        Location score1 = new Location(location.getWorld(),location.getX(),location.getY()+1,location.getZ());
        skywarsScoreArmorStands[0] = (ArmorStand) location.getWorld().spawnEntity(score1, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[0].setGravity(false);
        skywarsScoreArmorStands[0].setVisible(false);
        skywarsScoreArmorStands[0].setCanPickupItems(false);

        Location score2 = new Location(location.getWorld(),location.getX(),location.getY()+0.75,location.getZ());
        skywarsScoreArmorStands[1] = (ArmorStand) location.getWorld().spawnEntity(score2, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[1].setGravity(false);
        skywarsScoreArmorStands[1].setVisible(false);
        skywarsScoreArmorStands[1].setCanPickupItems(false);

        Location score3 = new Location(location.getWorld(),location.getX(),location.getY()+0.5,location.getZ());
        skywarsScoreArmorStands[2] = (ArmorStand) location.getWorld().spawnEntity(score3, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[2].setGravity(false);
        skywarsScoreArmorStands[2].setVisible(false);
        skywarsScoreArmorStands[2].setCanPickupItems(false);

        Location score4 = new Location(location.getWorld(),location.getX(),location.getY()+0.25,location.getZ());
        skywarsScoreArmorStands[3] = (ArmorStand) location.getWorld().spawnEntity(score4, EntityType.ARMOR_STAND);
        skywarsScoreArmorStands[3].setGravity(false);
        skywarsScoreArmorStands[3].setVisible(false);
        skywarsScoreArmorStands[3].setCanPickupItems(false);

        Location score5 = new Location(location.getWorld(),location.getX(),location.getY(),location.getZ());
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
            File[] filesRaw = new File("gamestats/skywars/").listFiles();
            ArrayList<File> files = new ArrayList<File>();
            for(int i = 0;i<filesRaw.length;i++){
                files.add(filesRaw[i]);
            }
            int highestScore = 0;
            for(int i = 0;i< files.size();i++){
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(files.get(i)));
                    int score = Integer.valueOf(reader.readLine());

                    if(highestScore<score){
                        highestScore=score;
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            int loops = files.size();
            if(files.size()<=5){
                for(int i = 0;i< loops;i++){
                    int secondHighestScore = 0;
                    for(int j = 0;j< files.size();j++){
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(files.get(j)));
                            int score = Integer.valueOf(reader.readLine());
                            if(secondHighestScore<=score && highestScore>=score){
                                secondHighestScore=score;
                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    for(int j = 0;j< files.size();j++){
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(files.get(j)));
                            int score = Integer.valueOf(reader.readLine());
                            if(score==secondHighestScore){
                                if(score!=0){
                                    String name = files.get(j).getName().replaceFirst("[.][^.]+$", "");
                                    skywarsScoreArmorStands[i].setCustomNameVisible(true);
                                    skywarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+name+": "+ChatColor.GREEN+score);
                                    files.remove(j);
                                    break;
                                }
                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    highestScore=secondHighestScore;
                }
            }else{
                for(int i = 0;i< 5;i++){
                    int secondHighestScore = 0;
                    for(int j = 0;j< files.size();j++){
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(files.get(j)));
                            int score = Integer.valueOf(reader.readLine());
                            if(secondHighestScore<=score && highestScore>=score){
                                secondHighestScore=score;
                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    for(int j = 0;j< files.size();j++){
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(files.get(j)));
                            int score = Integer.valueOf(reader.readLine());
                            if(score==secondHighestScore){
                                if(score!=0){
                                    String name = files.get(j).getName().replaceFirst("[.][^.]+$", "");
                                    skywarsScoreArmorStands[i].setCustomNameVisible(true);
                                    skywarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+name+": "+ChatColor.GREEN+score);
                                    files.remove(j);
                                    break;
                                }
                            }
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    highestScore=secondHighestScore;
                }
            }
        },0,10*20);
    }

    public static void removeSkywarsHologram(){
        skywarsHeadlineArmorStand.remove();
        for(int i = 0;i<5;i++){
            skywarsScoreArmorStands[i].remove();
        }
    }
}
