package server.lobby.general;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.type.WallSign;

public class Initial {

    public Initial(){
        World world = Bukkit.getWorld("world");
        Block skywarsServer1 = world.getBlockAt(-32,61,-30);
        org.bukkit.block.Sign skywarsServer1Sign = (Sign) skywarsServer1.getState();
        skywarsServer1Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1");
        skywarsServer1Sign.setLine(2,ChatColor.GREEN+"0 / 4");
        skywarsServer1Sign.update();

        Block skywarsServer2 = world.getBlockAt(-28,61,-34);
        org.bukkit.block.Sign skywarsServer2Sign = (Sign) skywarsServer2.getState();
        skywarsServer2Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2");
        skywarsServer2Sign.setLine(2,ChatColor.GREEN+"0 / 8");
        skywarsServer2Sign.update();

        Thread matchmakingThread = new Thread(() -> Matchmaking.MatchmakingHandle());
        matchmakingThread.start();
    }
}
