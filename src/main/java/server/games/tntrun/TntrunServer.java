package server.games.tntrun;

import java.io.File;
import java.util.ArrayList;

public class TntrunServer {

    private int maxplayer;
    private File worldFolder;

    public TntrunServer(int maxplayer, File worldFolder){
        this.maxplayer=maxplayer;
        this.worldFolder=worldFolder;
    }

    public File getWorldFolder() {
        return worldFolder;
    }

    public void setWorldFolder(File wordFolder) {
        this.worldFolder = wordFolder;
    }
    public static ArrayList<TntrunServer> getServerByMaxPlayer(ArrayList<TntrunServer> servers, int maxPlayer){
        ArrayList<TntrunServer> tntrunServers = new ArrayList<TntrunServer>();
        for(int i = 0;i< servers.size();i++){
            if(servers.get(i).getMaxplayer()>=maxPlayer){
                tntrunServers.add(servers.get(i));
            }
        }
        return tntrunServers;
    }

    public int getMaxplayer() {
        return maxplayer;
    }

    public void setMaxplayer(int maxplayer) {
        this.maxplayer = maxplayer;
    }
}
