package server.games.skywars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import server.lobby.general.Initial;
import server.lobby.general.Matchmaking;
import server.main.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class SkywarsHandler {

    public SkywarsHandler(ArrayList<UUID> players, int server) {
        int playerCount = players.size();
        ArrayList<SkywarsServer> servers = SkywarsServer.getServerByMaxPlayer(Initial.skywarsServers, playerCount);
        if (servers.size() >= 1) {
            int map = (int) Math.floor((Math.random() * (servers.size()) - 1) + 1);
            System.out.println("Map: "+map);
            new SkywarsWorldInitialer(players, server, servers.get(map));
        }else{
            System.out.println("No Server found for "+playerCount+" players");
        }
    }
}
