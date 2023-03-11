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
import server.games.bedwars.BedwarsServer;
import server.games.skywars.SkywarsHandler;
import server.games.skywars.SkywarsServer;
import server.general.Config;
import server.lobby.Lootbox.Lootbox;
import server.lobby.hologram.skywars.BedwarsHologram;
import server.lobby.hologram.skywars.SkywarsHologram;
import server.main.Main;

import java.io.File;
import java.util.ArrayList;

public class Initial {

    public static ArrayList<SkywarsServer> skywarsServers = new ArrayList<SkywarsServer>();
    public static ArrayList<BedwarsServer> bedwarsServers = new ArrayList<BedwarsServer>();
    public static Lootbox lootbox1;
    public static Lootbox lootbox2;

    public Initial(){
        Config config = new Config("gamestats/skywars/ranklist.conf");
        config.init();
        try{
            File skywarsRanklistConfig = new File("gamestats/skywars/ranklist.conf");
            skywarsRanklistConfig.delete();
        }catch(Exception e){};
        skywarsServers.add(new SkywarsServer(8,new File("preServer/Skywars/skywars1")));
        skywarsServers.add(new SkywarsServer(4,new File("preServer/Skywars/skywars2")));
        skywarsServers.add(new SkywarsServer(4,new File("preServer/Skywars/skywars3")));
        skywarsServers.add(new SkywarsServer(4,new File("preServer/Skywars/skywars4")));
        skywarsServers.add(new SkywarsServer(2,new File("preServer/Skywars/skywars5")));

        bedwarsServers.add(new BedwarsServer(4,new File("preserver/Bedwars/bedwars1")));
        bedwarsServers.add(new BedwarsServer(2,new File("preserver/Bedwars/bedwars2")));

        new LobbyScoreboardManager();
        lootbox1 = new Lootbox(new Location(Bukkit.getWorld("world"),17.5,-58,-3.5));
        lootbox2 = new Lootbox(new Location(Bukkit.getWorld("world"),-0.5,-58,20.5));

        new SkywarsHologram(new Location(Bukkit.getWorld("world"),-3,-58.5,-3));
        new BedwarsHologram(new Location(Bukkit.getWorld("world"),20,-58.5,20));


        Matchmaking.MATCHMAKINGPROCESSID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), ()->{Matchmaking.MatchmakingHandle();},1,20);

    }
}
