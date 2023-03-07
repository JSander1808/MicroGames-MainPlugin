package server.lobby.general;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import server.games.skywars.SkywarsHandler;
import server.games.skywars.SkywarsServer;
import server.general.Config;
import server.lobby.Lootbox.Lootbox;
import server.lobby.hologram.skywars.SkywarsHologram;
import server.main.Main;

import java.io.File;
import java.util.ArrayList;

public class Initial {

    public static ArrayList<SkywarsServer> skywarsServers = new ArrayList<SkywarsServer>();
    public static Lootbox lootbox1;
    public static Lootbox lootbox2;

    public Initial(){
        Config config = new Config("gamestats/skywars/ranklist.conf");
        config.init();
        try{
            File skywarsRanklistConfig = new File("gamestats/skywars/ranklist.conf");
            skywarsRanklistConfig.delete();
        }catch(Exception e){};

        World world = Bukkit.getWorld("world");
        Block skywarsServer1 = world.getBlockAt(60,-41,-9);
        org.bukkit.block.Sign skywarsServer1Sign = (Sign) skywarsServer1.getState();
        skywarsServer1Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1");
        skywarsServer1Sign.setLine(2,ChatColor.GREEN+"0 / "+Matchmaking.skywarsServer1MaxPlayer);
        skywarsServer1Sign.update();

        Block skywarsServer2 = world.getBlockAt(59,-41,-9);
        org.bukkit.block.Sign skywarsServer2Sign = (Sign) skywarsServer2.getState();
        skywarsServer2Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2");
        skywarsServer2Sign.setLine(2,ChatColor.GREEN+"0 / "+Matchmaking.skywarsServer2MaxPlayer);
        skywarsServer2Sign.update();

        Block skywarsServer3Block = world.getBlockAt(58,-41,-9);
        org.bukkit.block.Sign skywarsServer3Sign = (Sign) skywarsServer3Block.getState();
        skywarsServer3Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer3Sign.setLine(1,ChatColor.GREEN+"Server 3");
        skywarsServer3Sign.setLine(2,ChatColor.GREEN+""+Matchmaking.skywarsServer3.size()+" / "+Matchmaking.skywarsServer3MaxPlayer);
        if(Matchmaking.skywarsServer3Running){
            skywarsServer3Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer3Sign.setLine(3,"");
        }
        skywarsServer3Sign.update();

        Block skywarsServer4Block = world.getBlockAt(57,-41,-9);
        org.bukkit.block.Sign skywarsServer4Sign = (Sign) skywarsServer4Block.getState();
        skywarsServer4Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer4Sign.setLine(1,ChatColor.GREEN+"Server 4");
        skywarsServer4Sign.setLine(2,ChatColor.GREEN+""+Matchmaking.skywarsServer4.size()+" / "+Matchmaking.skywarsServer4MaxPlayer);
        if(Matchmaking.skywarsServer4Running){
            skywarsServer4Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer4Sign.setLine(3,"");
        }
        skywarsServer4Sign.update();

        skywarsServers.add(new SkywarsServer(8,new File("preServer/Skywars/skywars1")));
        skywarsServers.add(new SkywarsServer(4,new File("preServer/Skywars/skywars2")));
        skywarsServers.add(new SkywarsServer(4,new File("preServer/Skywars/skywars3")));

        new LobbyScoreboardManager();
        lootbox1 = new Lootbox(new Location(Bukkit.getWorld("world"),17.5,-58,-3.5));
        lootbox2 = new Lootbox(new Location(Bukkit.getWorld("world"),-0.5,-58,20.5));
        new SkywarsHologram(new Location(Bukkit.getWorld("world"),-3,-58,-3));


        Matchmaking.MATCHMAKINGPROCESSID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), ()->{Matchmaking.MatchmakingHandle();},1,20);

    }
}
