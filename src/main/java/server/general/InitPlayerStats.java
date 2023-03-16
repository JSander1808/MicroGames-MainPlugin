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

        File bedwarsRankFile = new File("gamestats/bedwars/"+player.getName()+".conf");
        if(!bedwarsRankFile.exists()){
            try {
                bedwarsRankFile.createNewFile();
                PrintWriter writer = new PrintWriter(bedwarsRankFile);
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
        if(!playerConfig.existdata("level")){
            playerConfig.set("level","1");
        }
        if(!playerConfig.existdata("xp")){
            playerConfig.set("xp","0");
        }
        if(!playerConfig.existdata("xpNextLevel")){
            playerConfig.set("xpNextLevel","50");
        }


        if(!playerConfig.existdata("kits.skywars.sprengmeister")){
            playerConfig.set("kits.skywars.sprengmeister","false");
        }
        if(!playerConfig.existdata("kits.skywars.maurer")){
            playerConfig.set("kits.skywars.maurer","false");
        }
        if(!playerConfig.existdata("kits.skywars.grillmeister")){
            playerConfig.set("kits.skywars.grillmeister","false");
        }
        if(!playerConfig.existdata("kits.skywars.zauberer")){
            playerConfig.set("kits.skywars.zauberer","false");
        }
        if(!playerConfig.existdata("kits.skywars.crafter")){
            playerConfig.set("kits.skywars.crafter","false");
        }
        if(!playerConfig.existdata("kits.skywars.tank")){
            playerConfig.set("kits.skywars.tank","false");
        }
        if(!playerConfig.existdata("kits.skywars.assasine")){
            playerConfig.set("kits.skywars.assasine","false");
        }
        if(!playerConfig.existdata("kits.skywars.pirat")){
            playerConfig.set("kits.skywars.pirat","false");
        }
        if(!playerConfig.existdata("kits.skywars.miner")){
            playerConfig.set("kits.skywars.miner","false");
        }
        if(!playerConfig.existdata("kits.skywars.bauer")){
            playerConfig.set("kits.skywars.bauer","false");
        }
        if(!playerConfig.existdata("kits.skywars.schneeman")){
            playerConfig.set("kits.skywars.schneeman","false");
        }
        if(!playerConfig.existdata("kits.skywars.angler")){
            playerConfig.set("kits.skywars.angler","false");
        }
        if(!playerConfig.existdata("kits.skywars.enderman")){
            playerConfig.set("kits.skywars.enderman","false");
        }
        if(!playerConfig.existdata("kits.skywars.zauberer")){
            playerConfig.set("kits.skywars.zauberer","false");
        }
        if(!playerConfig.existdata("kits.skywars.geizhals")){
            playerConfig.set("kits.skywars.geizhals","false");
        }
        if(!playerConfig.existdata("kits.skywars.bogenmeister")){
            playerConfig.set("kits.skywars.bogenmeister","false");
        }
        if(!playerConfig.existdata("kits.skywars.spinne")){
            playerConfig.set("kits.skywars.spinne","false");
        }
        if(!playerConfig.existdata("kits.skywars.ritter")){
            playerConfig.set("kits.skywars.ritter","false");
        }
        if(!playerConfig.existdata("kits.skywars.sensenman")){
            playerConfig.set("kits.skywars.sensenman","false");
        }
        if(!playerConfig.existdata("kits.skywars.starter")){
            playerConfig.set("kits.skywars.starter","true");
        }
        if(!playerConfig.existdata("kits.skywars.active")){
            playerConfig.set("kits.skywars.active","null");
        }
        if(!playerConfig.existdata("shop.lootbox.amount")){
            playerConfig.set("shop.lootbox.amount","0");
        }
    }
}
