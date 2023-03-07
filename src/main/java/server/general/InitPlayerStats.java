package server.general;

import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InitPlayerStats {

    public InitPlayerStats(Player player){
        File skywarsRankFile = new File("gamestats/skywars/"+player.getName()+".conf");
        if(!skywarsRankFile.exists()){
            try {
                skywarsRankFile.createNewFile();
                PrintWriter writer = new PrintWriter(skywarsRankFile);
                writer.write("0");
                writer.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        playerConfig.init();
        if(!playerConfig.existdata("coins")){
            playerConfig.set("coins","0");
        }
    }
}
