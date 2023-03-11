package server.games.bedwars;

import server.games.skywars.SkywarsServer;

import java.io.File;
import java.util.ArrayList;

public class BedwarsServer {

    private int maxplayer;
    private File worldFolder;

    public BedwarsServer(int maxplayer, File worldFolder){
        this.maxplayer=maxplayer;
        this.worldFolder=worldFolder;
    }

    public File getWorldFolder() {
        return worldFolder;
    }

    public void setWorldFolder(File wordFolder) {
        this.worldFolder = wordFolder;
    }
    public static ArrayList<BedwarsServer> getServerByMaxPlayer(ArrayList<BedwarsServer> servers, int maxPlayer){
        ArrayList<BedwarsServer> bedwarsServers = new ArrayList<BedwarsServer>();
        for(int i = 0;i< servers.size();i++){
            if(servers.get(i).getMaxplayer()>=maxPlayer){
                bedwarsServers.add(servers.get(i));
            }
        }
        return bedwarsServers;
    }

    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }
}
