package server.games.skywars;

import server.lobby.general.Initial;
import java.util.ArrayList;
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
