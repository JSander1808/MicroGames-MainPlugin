package server.games.skywars;

import org.bukkit.entity.Player;

import java.io.*;

public class SkywarsWinnManager {

    public static void addWin(Player player){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("gamestats/skywars/"+player.getName()+".conf"));
            int score = Integer.valueOf(reader.readLine());
            score++;
            PrintWriter writer = new PrintWriter("gamestats/skywars/"+player.getName()+".conf");
            writer.write(String.valueOf(score));
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
