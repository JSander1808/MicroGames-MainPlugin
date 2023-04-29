package server.games.tntrun;

import server.lobby.general.Initial;

import java.util.ArrayList;
import java.util.UUID;

public class TntrunHandler {

    public TntrunHandler(ArrayList<UUID> players, int server){
        int playerCount = players.size();
        if(server>=3){ playerCount = playerCount/2; }
        ArrayList<TntrunServer> servers = TntrunServer.getServerByMaxPlayer(Initial.tntrunServers, playerCount);
        if(servers.size()>=1){
            int map = (int) Math.floor((Math.random() * (servers.size())));
            System.out.println("Map: "+map);
            new TntrunWorldInitialer(players,server,servers.get(map));
        }else{
            System.out.println("No Server found for "+playerCount+" players");
        }
    }

}
