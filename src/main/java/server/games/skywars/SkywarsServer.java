package server.games.skywars;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class SkywarsServer {

    private int maxplayer;
    private File wordFolder;

    public SkywarsServer(int maxplayer, File worldFolder){
        this.maxplayer=maxplayer;
        this.wordFolder=worldFolder;
    }

    public File getWorldFolder() {
        return wordFolder;
    }

    public void setWorldFolder(File wordFolder) {
        this.wordFolder = wordFolder;
    }
    public static ArrayList<SkywarsServer> getServerByMaxPlayer(ArrayList<SkywarsServer> servers, int maxPlayer){
        ArrayList<SkywarsServer> skywarsServers = new ArrayList<SkywarsServer>();
        for(int i = 0;i< servers.size();i++){
            if(servers.get(i).getMaxplayer()>=maxPlayer){
                skywarsServers.add(servers.get(i));
            }
        }
        return skywarsServers;
    }

    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }
}
