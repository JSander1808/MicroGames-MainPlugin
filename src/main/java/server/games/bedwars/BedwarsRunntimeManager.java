package server.games.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import server.main.Main;

import java.util.ArrayList;

public class BedwarsRunntimeManager {

    private int TaskID;
    private int ironSpawnDelay = 0;
    private int goldSpawnDelay = 0;
    private int diamondSpawnDelay = 0;
    public int ironLevel = 1;
    public int goldLevel = 1;
    public int diaLevel = 1;
    private ArrayList<Location> ironSpawnLocation = new ArrayList<Location>();
    private ArrayList<Location> goldSpawnLocation = new ArrayList<Location>();
    private ArrayList<Location> diamondSpawnLocation = new ArrayList<Location>();

    public BedwarsRunntimeManager(World world){
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),()->{
            if(world.getPlayers().size()==0){
                Bukkit.getScheduler().cancelTask(TaskID);
            }else{
                if(ironLevel==1){
                    if(ironSpawnDelay>=4){
                        for(int i = 0;i<ironSpawnLocation.size();i++){
                            world.dropItem(ironSpawnLocation.get(i),new ItemStack(Material.IRON_INGOT));
                        }
                        ironSpawnDelay=0;
                    }
                }else if(ironLevel==2){
                    if(ironSpawnDelay>=2){
                        for(int i = 0;i<ironSpawnLocation.size();i++){
                            world.dropItem(ironSpawnLocation.get(i),new ItemStack(Material.IRON_INGOT));
                        }
                        ironSpawnDelay=0;
                    }
                }else{
                    if(ironSpawnDelay>=1){
                        for(int i = 0;i<ironSpawnLocation.size();i++){
                            world.dropItem(ironSpawnLocation.get(i),new ItemStack(Material.IRON_INGOT));
                        }
                        ironSpawnDelay=0;
                    }
                }
                ironSpawnDelay++;
                if(goldLevel==1){
                    if(goldSpawnDelay>=60){
                        for(int i = 0;i<goldSpawnLocation.size();i++){
                            world.dropItem(goldSpawnLocation.get(i),new ItemStack(Material.GOLD_INGOT));
                        }
                        goldSpawnDelay=0;
                    }
                }else if(goldLevel==2){
                    if(goldSpawnDelay>=30){
                        for(int i = 0;i<goldSpawnLocation.size();i++){
                            world.dropItem(goldSpawnLocation.get(i),new ItemStack(Material.GOLD_INGOT));
                        }
                        goldSpawnDelay=0;
                    }
                }else{
                    if(goldSpawnDelay>=15){
                        for(int i = 0;i<goldSpawnLocation.size();i++){
                            world.dropItem(goldSpawnLocation.get(i),new ItemStack(Material.GOLD_INGOT));
                        }
                        goldSpawnDelay=0;
                    }
                }
                goldSpawnDelay++;
                if(diaLevel==1){
                    if(diamondSpawnDelay>=200){
                        for(int i = 0;i<diamondSpawnLocation.size();i++){
                            world.dropItem(diamondSpawnLocation.get(i),new ItemStack(Material.DIAMOND));
                        }
                        diamondSpawnDelay=0;
                    }
                }else if(diaLevel==2){
                    if(diamondSpawnDelay>=100){
                        for(int i = 0;i<diamondSpawnLocation.size();i++){
                            world.dropItem(diamondSpawnLocation.get(i),new ItemStack(Material.DIAMOND));
                        }
                        diamondSpawnDelay=0;
                    }
                }else{
                    if(diamondSpawnDelay>=50){
                        for(int i = 0;i<diamondSpawnLocation.size();i++){
                            world.dropItem(diamondSpawnLocation.get(i),new ItemStack(Material.DIAMOND));
                        }
                        diamondSpawnDelay=0;
                    }
                }
                diamondSpawnDelay++;
            }
        },0,5);
    }

    public void addIronSpawn(Location location){
        ironSpawnLocation.add(location);
    }

    public void addGoldSpawn(Location location){
        goldSpawnLocation.add(location);
    }

    public void addDiamondSpawn(Location location){
        diamondSpawnLocation.add(location);
    }

    public void setDiamondSpawnDelay(int diamondSpawnDelay) {
        this.diamondSpawnDelay = diamondSpawnDelay;
    }

    public void setGoldSpawnDelay(int goldSpawnDelay) {
        this.goldSpawnDelay = goldSpawnDelay;
    }

    public void setIronSpawnDelay(int ironSpawnDelay) {
        this.ironSpawnDelay = ironSpawnDelay;
    }

}
