package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Scoreboard;
import server.main.Main;

public class BedwarsRespawnPlayer {

    public int TaskID;
    public int time = 5;

    public BedwarsRespawnPlayer(Player player, int serverMap){
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(),()->{
            if(!(time==0)){
                player.sendTitle(ChatColor.RED+""+time+" Sekunden",ChatColor.RED+"Bis zum Respawn");
                time--;
            }else{
                Bukkit.getScheduler().runTask(Main.getPlugin(),()->{respawnPlayer(player,serverMap); });
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
    }

    public void respawnPlayer(Player player, int serverMap){
        String team = getTeamColor(player);
        player.getInventory().clear();
        if(serverMap==1){
            if(team.equalsIgnoreCase("red")){
                player.teleport(new Location(player.getWorld(), 97.5,3,88.5,90,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.RED);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.RED);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.RED);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.RED);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }else if(team.equalsIgnoreCase("yellow")){
                player.teleport(new Location(player.getWorld(), -78.5,3,88.5,-90,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.YELLOW);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.YELLOW);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.YELLOW);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.YELLOW);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }else if(team.equalsIgnoreCase("blue")){
                player.teleport(new Location(player.getWorld(), 9.5,3,176.5,180,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.BLUE);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.BLUE);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.BLUE);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.BLUE);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }else if(team.equalsIgnoreCase("green")){
                player.teleport(new Location(player.getWorld(), 9.5,3,0.5,0,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.GREEN);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.GREEN);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.GREEN);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.GREEN);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }
        }
        if(serverMap==2){
            if(team.equalsIgnoreCase("red")){
                player.teleport(new Location(player.getWorld(), 8.5,0,-94.5,0,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.RED);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.RED);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.RED);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.RED);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }else if(team.equalsIgnoreCase("yellow")){
                player.teleport(new Location(player.getWorld(), 8.5,0,11.5,180,0));
                player.setGameMode(GameMode.SURVIVAL);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                helmetMeta.setColor(Color.YELLOW);
                helmet.setItemMeta(helmetMeta);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                chestplateMeta.setColor(Color.YELLOW);
                chestplate.setItemMeta(chestplateMeta);
                ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                legginsMeta.setColor(Color.YELLOW);
                leggins.setItemMeta(legginsMeta);
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                bootsMeta.setColor(Color.YELLOW);
                boots.setItemMeta(bootsMeta);
                player.getInventory().setItem(36,boots);
                player.getInventory().setItem(37,leggins);
                player.getInventory().setItem(38,chestplate);
                player.getInventory().setItem(39,helmet);
            }
        }
        player.setHealth(20);
        player.setFoodLevel(20);
        ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
        player.getInventory().setItem(0,woodenSword);
    }

    public String getTeamColor(Player player){
        String team = null;
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }
        return team;
    }
}
