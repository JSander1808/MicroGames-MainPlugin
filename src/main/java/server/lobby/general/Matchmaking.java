package server.lobby.general;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import server.games.skywars.SkywarsHandler;
import server.main.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class Matchmaking {

    public static int MATCHMAKINGPROCESSID;
    private static World worldPublic;

    public static int skywarsServer1Countdown = 60;
    public static int skywarsServer2Countdown = 60;
    public static int skywarsServer3Countdown = 60;
    public static int skywarsServer4Countdown = 60;

    public static int skywarsServer1MaxPlayer = 2;
    public static int skywarsServer2MaxPlayer = 2;
    public static int skywarsServer3MaxPlayer = 4;
    public static int skywarsServer4MaxPlayer = 8;

    public static ArrayList<UUID> skywarsServer1 = new ArrayList<UUID>();
    public static boolean skywarsServer1Running = false;
    public static ArrayList<UUID> skywarsServer2 = new ArrayList<UUID>();
    public static boolean skywarsServer2Running = false;
    public static ArrayList<UUID> skywarsServer3 = new ArrayList<UUID>();
    public static boolean skywarsServer3Running = false;
    public static ArrayList<UUID> skywarsServer4 = new ArrayList<UUID>();
    public static boolean skywarsServer4Running = false;

    public static void removePlayerFromMatchmaking(Player player){
        if(skywarsServer1.contains(player.getUniqueId())){
            skywarsServer1.remove(player.getUniqueId());
            updateSigns();
        }else if(skywarsServer2.contains(player.getUniqueId())){
            skywarsServer2.remove(player.getUniqueId());
            updateSigns();
        }else if(skywarsServer3.contains(player.getUniqueId())){
            skywarsServer3.remove(player.getUniqueId());
            updateSigns();
        }else if(skywarsServer4.contains(player.getUniqueId())){
            skywarsServer4.remove(player.getUniqueId());
            updateSigns();
        }
    }

    public static void addPlayerToMatchmaking(Player player, String server){
        if(server.equalsIgnoreCase("skywarsServer1")){
            if(!skywarsServer1.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(-32,61,-30);
                org.bukkit.block.Sign skywarsServerSign = (Sign) skywarsServerBlock.getState();
                if(skywarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((skywarsServer1.size()+1)<=skywarsServer1MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        skywarsServer1.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<skywarsServer1.size();i++){
                            Bukkit.getPlayer(skywarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer1.size()+" / "+skywarsServer1MaxPlayer));
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                        player.sendMessage(ChatColor.GREEN+"Du wurdest der Spielersuche hinzugefügt...");
                    }else{
                        player.sendMessage(ChatColor.RED+"The Server is allready full.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"You can´t join a running game.");
                }
            }else{
                skywarsServer1.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer2")){
            if(!skywarsServer2.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(-28,61,-34);
                org.bukkit.block.Sign skywarsServerSign = (Sign) skywarsServerBlock.getState();
                if(skywarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((skywarsServer2.size()+1)<=skywarsServer2MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        skywarsServer2.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<skywarsServer2.size();i++){
                            Bukkit.getPlayer(skywarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer2.size()+" / "+skywarsServer2MaxPlayer));
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                        player.sendMessage(ChatColor.GREEN+"Du wurdest der Spielersuche hinzugefügt...");
                    }else{
                        player.sendMessage(ChatColor.RED+"The Server is allready full.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"You can´t join a running game.");
                }
            }else{
                skywarsServer2.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer3")){
            if(!skywarsServer3.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(-32,61,-38);
                org.bukkit.block.Sign skywarsServerSign = (Sign) skywarsServerBlock.getState();
                if(skywarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((skywarsServer3.size()+1)<=skywarsServer3MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        skywarsServer3.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<skywarsServer3.size();i++){
                            Bukkit.getPlayer(skywarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer3.size()+" / "+skywarsServer3MaxPlayer));
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                        player.sendMessage(ChatColor.GREEN+"Du wurdest der Spielersuche hinzugefügt...");
                    }else{
                        player.sendMessage(ChatColor.RED+"The Server is allready full.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"You can´t join a running game.");
                }
            }else{
                skywarsServer3.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer4")){
            if(!skywarsServer4.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(-36,61,-34);
                org.bukkit.block.Sign skywarsServerSign = (Sign) skywarsServerBlock.getState();
                if(skywarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((skywarsServer4.size()+1)<=skywarsServer4MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        skywarsServer4.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<skywarsServer4.size();i++){
                            Bukkit.getPlayer(skywarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer4.size()+" / "+skywarsServer4MaxPlayer));
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                        player.sendMessage(ChatColor.GREEN+"Du wurdest der Spielersuche hinzugefügt...");
                    }else{
                        player.sendMessage(ChatColor.RED+"The Server is allready full.");
                    }
                }else{
                    player.sendMessage(ChatColor.RED+"You can´t join a running game.");
                }
            }else{
                skywarsServer4.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }
    }

    public static void updateSigns(){
        World world = Bukkit.getWorld("world");

        Block skywarsServer1Block = world.getBlockAt(-32,61,-30);
        org.bukkit.block.Sign skywarsServer1Sign = (Sign) skywarsServer1Block.getState();
        skywarsServer1Sign.setLine(0, ChatColor.GOLD+"Skywars");
        skywarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1");
        skywarsServer1Sign.setLine(2,ChatColor.GREEN+""+skywarsServer1.size()+" / "+skywarsServer1MaxPlayer);
        if(skywarsServer1Running){
            skywarsServer1Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer1Sign.setLine(3,"");
        }
        skywarsServer1Sign.update();

        Block skywarsServer2Block = world.getBlockAt(-28,61,-34);
        org.bukkit.block.Sign skywarsServer2Sign = (Sign) skywarsServer2Block.getState();
        skywarsServer2Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2");
        skywarsServer2Sign.setLine(2,ChatColor.GREEN+""+skywarsServer2.size()+" / "+skywarsServer2MaxPlayer);
        if(skywarsServer2Running){
            skywarsServer2Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer2Sign.setLine(3,"");
        }
        skywarsServer2Sign.update();

        Block skywarsServer3Block = world.getBlockAt(-32,61,-38);
        org.bukkit.block.Sign skywarsServer3Sign = (Sign) skywarsServer3Block.getState();
        skywarsServer3Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer3Sign.setLine(1,ChatColor.GREEN+"Server 3");
        skywarsServer3Sign.setLine(2,ChatColor.GREEN+""+skywarsServer3.size()+" / "+skywarsServer3MaxPlayer);
        if(skywarsServer3Running){
            skywarsServer3Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer3Sign.setLine(3,"");
        }
        skywarsServer3Sign.update();

        Block skywarsServer4Block = world.getBlockAt(-36,61,-34);
        org.bukkit.block.Sign skywarsServer4Sign = (Sign) skywarsServer4Block.getState();
        skywarsServer4Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer4Sign.setLine(1,ChatColor.GREEN+"Server 4");
        skywarsServer4Sign.setLine(2,ChatColor.GREEN+""+skywarsServer4.size()+" / "+skywarsServer4MaxPlayer);
        if(skywarsServer4Running){
            skywarsServer4Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer4Sign.setLine(3,"");
        }
        skywarsServer4Sign.update();
    }

    public static void MatchmakingHandle(){
        if(skywarsServer1.size()>=skywarsServer1MaxPlayer){
            skywarsServer1Countdown--;
        }else{
            skywarsServer1Countdown=60;
        }
        if(skywarsServer1.size()==0){
            File server = new File("GameServer/Skywars/Server1/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Skywars/Server1/server/").getPlayers().size()==0){
                    skywarsServer1Running=false;
                    Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
                        World unload = Bukkit.getWorld("GameServer/Skywars/Server1/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Skywars/Server1/server"));
                    });
                    skywarsServer1Countdown=60;
                }
            }
        }
        if(skywarsServer1.size()==skywarsServer1MaxPlayer && skywarsServer1Countdown>10) skywarsServer1Countdown=10;
        if(skywarsServer1Countdown==5){
            Thread thread = new Thread(()->{new SkywarsHandler(skywarsServer1, 1); });
            thread.start();
            skywarsServer1Running=true;
        }


        if(skywarsServer2.size()>=skywarsServer2MaxPlayer){
            skywarsServer2Countdown--;
        }else{
            skywarsServer2Countdown=60;
        }
        if(skywarsServer2.size()==0){
            File server = new File("GameServer/Skywars/Server2/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Skywars/Server2/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
                        World unload = Bukkit.getWorld("GameServer/Skywars/Server2/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Skywars/Server2/server"));
                    });
                    skywarsServer2Running=false;
                    skywarsServer2Countdown=60;
                }
            }
        }
        if(skywarsServer2.size()==skywarsServer2MaxPlayer && skywarsServer2Countdown>10) skywarsServer2Countdown=10;
        if(skywarsServer2Countdown==5){
            Thread thread = new Thread(()->{new SkywarsHandler(skywarsServer2, 2); });
            thread.start();
            skywarsServer2Running=true;
        }


        if(skywarsServer3.size()>=skywarsServer3MaxPlayer/2){
            skywarsServer3Countdown--;
        }else{
            skywarsServer3Countdown=60;
        }
        if(skywarsServer3.size()==0){
            File server = new File("GameServer/Skywars/Server3/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Skywars/Server3/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
                        World unload = Bukkit.getWorld("GameServer/Skywars/Server3/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Skywars/Server3/server"));
                    });
                    skywarsServer3Running=false;
                    skywarsServer3Countdown=60;
                }
            }
        }
        if(skywarsServer3.size()==skywarsServer3MaxPlayer && skywarsServer3Countdown>10) skywarsServer3Countdown=10;
        if(skywarsServer3Countdown==5){
            Thread thread = new Thread(()->{new SkywarsHandler(skywarsServer3, 3); });
            thread.start();
            skywarsServer3Running=true;
        }


        if(skywarsServer4.size()>=skywarsServer4MaxPlayer/2){
            skywarsServer4Countdown--;
        }else{
            skywarsServer4Countdown=60;
        }
        if(skywarsServer4.size()==0){
            File server = new File("GameServer/Skywars/Server4/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Skywars/Server4/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
                        World unload = Bukkit.getWorld("GameServer/Skywars/Server4/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Skywars/Server4/server"));
                    });
                    skywarsServer4Running=false;
                    skywarsServer4Countdown=60;
                }
            }
        }
        if(skywarsServer4.size()==skywarsServer4MaxPlayer && skywarsServer4Countdown>10) skywarsServer4Countdown=10;
        if(skywarsServer4Countdown==5){
            Thread thread = new Thread(()->{new SkywarsHandler(skywarsServer4, 4); });
            thread.start();
            skywarsServer4Running=true;
        }










        if(skywarsServer1.size()>=1){
            for(int i = 0;i<skywarsServer1.size();i++){
                Player player = Bukkit.getPlayer(skywarsServer1.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(skywarsServer1Countdown<60){
                        Bukkit.getPlayer(skywarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer1.size()+" / "+skywarsServer1MaxPlayer+"   "+skywarsServer1Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(skywarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer1.size()+" / "+skywarsServer1MaxPlayer));
                    }
                }
            }
        }
        if(skywarsServer2.size()>=1){
            for(int i = 0;i<skywarsServer2.size();i++){
                Player player = Bukkit.getPlayer(skywarsServer2.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(skywarsServer2Countdown<60){
                        Bukkit.getPlayer(skywarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer2.size()+" / "+skywarsServer2MaxPlayer+"   "+skywarsServer2Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(skywarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer2.size()+" / "+skywarsServer2MaxPlayer));
                    }
                }
            }
        }
        if(skywarsServer3.size()>=1){
            for(int i = 0;i<skywarsServer3.size();i++){
                Player player = Bukkit.getPlayer(skywarsServer3.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(skywarsServer3Countdown<60){
                        Bukkit.getPlayer(skywarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer3.size()+" / "+skywarsServer3MaxPlayer+"   "+skywarsServer3Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(skywarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer3.size()+" / "+skywarsServer3MaxPlayer));
                    }
                }
            }
        }
        if(skywarsServer4.size()>=1){
            for(int i = 0;i<skywarsServer4.size();i++){
                Player player = Bukkit.getPlayer(skywarsServer4.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(skywarsServer4Countdown<60){
                        Bukkit.getPlayer(skywarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer4.size()+" / "+skywarsServer4MaxPlayer+"   "+skywarsServer4Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(skywarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+skywarsServer4.size()+" / "+skywarsServer4MaxPlayer));
                    }
                }
            }
        }

        Bukkit.getScheduler().runTask(Main.getPlugin(),()->{updateSigns();});

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void unloadWorld(World world) {
        worldPublic = Bukkit.getWorld("");
        if(!world.equals(null)) {
            Bukkit.getServer().unloadWorld(world, false);
        }
    }

    public static boolean deleteWorld(File path) {
        if(path.exists()) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return(path.delete());
    }

}
