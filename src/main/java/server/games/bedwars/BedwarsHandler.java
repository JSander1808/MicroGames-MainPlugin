package server.games.bedwars;

import server.lobby.general.Initial;

import java.util.ArrayList;
import java.util.UUID;

public class BedwarsHandler {
    public static int BedwarsServerMap[] = new int[4];

    public BedwarsHandler(ArrayList<UUID> players, int server){
        int playerCount = players.size();
        if(server>=3){ playerCount = playerCount/2; }
        ArrayList<BedwarsServer> servers = BedwarsServer.getServerByMaxPlayer(Initial.bedwarsServers, playerCount);
        if(servers.size()>=1){
            int map = (int) Math.floor((Math.random() * (servers.size())));
            if(servers.get(map).getWorldFolder().getName().equalsIgnoreCase("bedwars1")) BedwarsServerMap[server-1] = 1;
            if(servers.get(map).getWorldFolder().getName().equalsIgnoreCase("bedwars2")) BedwarsServerMap[server-1] = 2;
            if(servers.get(map).getWorldFolder().getName().equalsIgnoreCase("bedwars3")) BedwarsServerMap[server-1] = 3;
            System.out.println("Map: "+map);
            new BedwarsWorldInitialer(players,server,servers.get(map));
        }else{
            System.out.println("No Server found for "+playerCount+" players");
        }
    }
}
