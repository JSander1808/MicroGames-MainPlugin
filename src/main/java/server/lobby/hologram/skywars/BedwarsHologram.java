package server.lobby.hologram.skywars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import server.main.Main;

import java.io.*;
import java.util.ArrayList;

public class BedwarsHologram {
    public static ArmorStand bedwarsHeadlineArmorStand;
    private int TaskID;
    public static ArmorStand bedwarsScoreArmorStands[] = new ArmorStand[5];

    public BedwarsHologram(Location location){
        Location headlineLocation = new Location(location.getWorld(),location.getX(),location.getY()+1.25,location.getZ());
        bedwarsHeadlineArmorStand = (ArmorStand) location.getWorld().spawnEntity(headlineLocation, EntityType.ARMOR_STAND);
        bedwarsHeadlineArmorStand.setGravity(false);
        bedwarsHeadlineArmorStand.setVisible(false);
        bedwarsHeadlineArmorStand.setCanPickupItems(false);
        bedwarsHeadlineArmorStand.setCustomNameVisible(true);
        bedwarsHeadlineArmorStand.setCustomName(ChatColor.GOLD+"Bedwars - Siege");

        Location score1 = new Location(location.getWorld(),location.getX(),location.getY()+1,location.getZ());
        bedwarsScoreArmorStands[0] = (ArmorStand) location.getWorld().spawnEntity(score1, EntityType.ARMOR_STAND);
        bedwarsScoreArmorStands[0].setGravity(false);
        bedwarsScoreArmorStands[0].setVisible(false);
        bedwarsScoreArmorStands[0].setCanPickupItems(false);

        Location score2 = new Location(location.getWorld(),location.getX(),location.getY()+0.75,location.getZ());
        bedwarsScoreArmorStands[1] = (ArmorStand) location.getWorld().spawnEntity(score2, EntityType.ARMOR_STAND);
        bedwarsScoreArmorStands[1].setGravity(false);
        bedwarsScoreArmorStands[1].setVisible(false);
        bedwarsScoreArmorStands[1].setCanPickupItems(false);

        Location score3 = new Location(location.getWorld(),location.getX(),location.getY()+0.5,location.getZ());
        bedwarsScoreArmorStands[2] = (ArmorStand) location.getWorld().spawnEntity(score3, EntityType.ARMOR_STAND);
        bedwarsScoreArmorStands[2].setGravity(false);
        bedwarsScoreArmorStands[2].setVisible(false);
        bedwarsScoreArmorStands[2].setCanPickupItems(false);

        Location score4 = new Location(location.getWorld(),location.getX(),location.getY()+0.25,location.getZ());
        bedwarsScoreArmorStands[3] = (ArmorStand) location.getWorld().spawnEntity(score4, EntityType.ARMOR_STAND);
        bedwarsScoreArmorStands[3].setGravity(false);
        bedwarsScoreArmorStands[3].setVisible(false);
        bedwarsScoreArmorStands[3].setCanPickupItems(false);

        Location score5 = new Location(location.getWorld(),location.getX(),location.getY(),location.getZ());
        bedwarsScoreArmorStands[4] = (ArmorStand) location.getWorld().spawnEntity(score5, EntityType.ARMOR_STAND);
        bedwarsScoreArmorStands[4].setGravity(false);
        bedwarsScoreArmorStands[4].setVisible(false);
        bedwarsScoreArmorStands[4].setCanPickupItems(false);

        updateHologram();
    }

    public void updateHologram(){
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(),()->{
            for(int i = 0;i<5;i++){
                bedwarsScoreArmorStands[i].setCustomNameVisible(false);
            }
            File[] filesRaw = new File("gamestats/bedwars/").listFiles();
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
                                    bedwarsScoreArmorStands[i].setCustomNameVisible(true);
                                    bedwarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+name+": "+ChatColor.GREEN+score);
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
                                    bedwarsScoreArmorStands[i].setCustomNameVisible(true);
                                    bedwarsScoreArmorStands[i].setCustomName(ChatColor.GOLD+name+": "+ChatColor.GREEN+score);
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

    public static void removeBedwarsHologram(){
        bedwarsHeadlineArmorStand.remove();
        for(int i = 0;i<5;i++){
            bedwarsScoreArmorStands[i].remove();
        }
    }
}
