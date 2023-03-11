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
import server.games.bedwars.BedwarsHandler;
import server.games.bedwars.BedwarsWorldInitialer;
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
    public static int bedwarsServer1Countdown = 60;
    public static int bedwarsServer2Countdown = 60;
    public static int bedwarsServer3Countdown = 60;
    public static int bedwarsServer4Countdown = 60;







    public static int skywarsServer1MaxPlayer = 2;
    public static int skywarsServer2MaxPlayer = 2;
    public static int skywarsServer3MaxPlayer = 4;
    public static int skywarsServer4MaxPlayer = 8;
    public static int bedwarsServer1MaxPlayer = 2;
    public static int bedwarsServer2MaxPlayer = 4;
    public static int bedwarsServer3MaxPlayer = 4;
    public static int bedwarsServer4MaxPlayer = 8;






    public static ArrayList<UUID> skywarsServer1 = new ArrayList<UUID>();
    public static ArrayList<UUID> skywarsServer1Spectator = new ArrayList<UUID>();
    public static boolean skywarsServer1Running = false;
    public static ArrayList<UUID> skywarsServer2 = new ArrayList<UUID>();
    public static ArrayList<UUID> skywarsServer2Spectator = new ArrayList<UUID>();
    public static boolean skywarsServer2Running = false;
    public static ArrayList<UUID> skywarsServer3 = new ArrayList<UUID>();
    public static ArrayList<UUID> skywarsServer3Spectator = new ArrayList<UUID>();
    public static boolean skywarsServer3Running = false;
    public static ArrayList<UUID> skywarsServer4 = new ArrayList<UUID>();
    public static ArrayList<UUID> skywarsServer4Spectator = new ArrayList<UUID>();
    public static boolean skywarsServer4Running = false;


    public static ArrayList<UUID> bedwarsServer1 = new ArrayList<UUID>();
    public static ArrayList<UUID> bedwarsServer1Spectator = new ArrayList<UUID>();
    public static boolean bedwarsServer1Running = false;
    public static ArrayList<UUID> bedwarsServer2 = new ArrayList<UUID>();
    public static ArrayList<UUID> bedwarsServer2Spectator = new ArrayList<UUID>();
    public static boolean bedwarsServer2Running = false;
    public static ArrayList<UUID> bedwarsServer3 = new ArrayList<UUID>();
    public static ArrayList<UUID> bedwarsServer3Spectator = new ArrayList<UUID>();
    public static boolean bedwarsServer3Running = false;
    public static ArrayList<UUID> bedwarsServer4 = new ArrayList<UUID>();
    public static ArrayList<UUID> bedwarsServer4Spectator = new ArrayList<UUID>();
    public static boolean bedwarsServer4Running = false;






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
        }else if(bedwarsServer1.contains(player.getUniqueId())){
            bedwarsServer1.remove(player.getUniqueId());
            updateSigns();
        }else if(bedwarsServer2.contains(player.getUniqueId())){
            bedwarsServer2.remove(player.getUniqueId());
            updateSigns();
        }else if(bedwarsServer3.contains(player.getUniqueId())){
            bedwarsServer3.remove(player.getUniqueId());
            updateSigns();
        }else if(bedwarsServer4.contains(player.getUniqueId())){
            bedwarsServer4.remove(player.getUniqueId());
            updateSigns();
        }
    }

    public static void removePlayerFromSpectator(Player player){
        if(skywarsServer1Spectator.contains(player.getUniqueId())){
            skywarsServer1Spectator.remove(player.getUniqueId());
        }else if(skywarsServer2Spectator.contains(player.getUniqueId())){
            skywarsServer2Spectator.remove(player.getUniqueId());
        }else if(skywarsServer3Spectator.contains(player.getUniqueId())){
            skywarsServer3Spectator.remove(player.getUniqueId());
        }else if(skywarsServer4Spectator.contains(player.getUniqueId())){
            skywarsServer4Spectator.remove(player.getUniqueId());
        }else if(bedwarsServer1Spectator.contains(player.getUniqueId())){
            bedwarsServer1Spectator.remove(player.getUniqueId());
        }else if(bedwarsServer2Spectator.contains(player.getUniqueId())){
            bedwarsServer2Spectator.remove(player.getUniqueId());
        }else if(bedwarsServer3Spectator.contains(player.getUniqueId())){
            bedwarsServer3Spectator.remove(player.getUniqueId());
        }else if(bedwarsServer4Spectator.contains(player.getUniqueId())){
            bedwarsServer4Spectator.remove(player.getUniqueId());
        }
    }

    public static void addPlayerToMatchmaking(Player player, String server){
        if(server.equalsIgnoreCase("skywarsServer1")){
            if(!skywarsServer1.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(60,-41,-9);
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
                    player.teleport(Bukkit.getWorld("GameServer/Skywars/Server1/server/").getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.getInventory().clear();
                    removePlayerFromMatchmaking(player);
                    player.sendMessage(ChatColor.GRAY+"Du beobachtest nun das Spiel");
                    Matchmaking.skywarsServer1Spectator.add(player.getUniqueId());
                }
            }else{
                skywarsServer1.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer2")){
            if(!skywarsServer2.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(59,-41,-9);
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
                    player.teleport(Bukkit.getWorld("GameServer/Skywars/Server2/server/").getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.getInventory().clear();
                    removePlayerFromMatchmaking(player);
                    player.sendMessage(ChatColor.GRAY+"Du beobachtest nun das Spiel");
                    Matchmaking.skywarsServer2Spectator.add(player.getUniqueId());
                }
            }else{
                skywarsServer2.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer3")){
            if(!skywarsServer3.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(58,-41,-9);
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
                    player.teleport(Bukkit.getWorld("GameServer/Skywars/Server3/server/").getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.getInventory().clear();
                    removePlayerFromMatchmaking(player);
                    player.sendMessage(ChatColor.GRAY+"Du beobachtest nun das Spiel");
                    Matchmaking.skywarsServer3Spectator.add(player.getUniqueId());
                }
            }else{
                skywarsServer3.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("skywarsServer4")){
            if(!skywarsServer4.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block skywarsServerBlock = world.getBlockAt(57,-41,-9);
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
                    player.teleport(Bukkit.getWorld("GameServer/Skywars/Server4/server/").getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.getInventory().clear();
                    removePlayerFromMatchmaking(player);
                    player.sendMessage(ChatColor.GRAY+"Du beobachtest nun das Spiel");
                    Matchmaking.skywarsServer4Spectator.add(player.getUniqueId());
                }
            }else{
                skywarsServer4.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }

//------------------------------------------------------------------Bedwars--------------------------------------------------------------------------------------------

        }else if(server.equalsIgnoreCase("bedwarsServer1")){
            if(!bedwarsServer1.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block bedwarsServerBlock = world.getBlockAt(-6,-36,63);
                org.bukkit.block.Sign bedwarsServerSign = (Sign) bedwarsServerBlock.getState();
                if(bedwarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((bedwarsServer1.size()+1)<=bedwarsServer1MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        bedwarsServer1.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<bedwarsServer1.size();i++){
                            Bukkit.getPlayer(bedwarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer1.size()+" / "+bedwarsServer1MaxPlayer));
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
                bedwarsServer1.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("bedwarsServer2")){
            if(!bedwarsServer2.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block bedwarsServerBlock = world.getBlockAt(-6,-36,64);
                org.bukkit.block.Sign bedwarsServerSign = (Sign) bedwarsServerBlock.getState();
                if(bedwarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((bedwarsServer2.size()+1)<=bedwarsServer2MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        bedwarsServer2.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<bedwarsServer2.size();i++){
                            Bukkit.getPlayer(bedwarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer2.size()+" / "+bedwarsServer2MaxPlayer));
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
                bedwarsServer2.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("bedwarsServer3")){
            if(!bedwarsServer3.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block bedwarsServerBlock = world.getBlockAt(-6,-36,65);
                org.bukkit.block.Sign bedwarsServerSign = (Sign) bedwarsServerBlock.getState();
                if(bedwarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((bedwarsServer3.size()+1)<=bedwarsServer3MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        bedwarsServer3.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<bedwarsServer3.size();i++){
                            Bukkit.getPlayer(bedwarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer3.size()+" / "+bedwarsServer3MaxPlayer));
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
                bedwarsServer3.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }else if(server.equalsIgnoreCase("bedwarsServer4")){
            if(!bedwarsServer4.contains(player.getUniqueId())){
                World world = Bukkit.getWorld("world");
                Block bedwarsServerBlock = world.getBlockAt(-6,-36,66);
                org.bukkit.block.Sign bedwarsServerSign = (Sign) bedwarsServerBlock.getState();
                if(bedwarsServerSign.getLine(3).equalsIgnoreCase("")){
                    if((bedwarsServer4.size()+1)<=bedwarsServer4MaxPlayer){
                        removePlayerFromMatchmaking(player);
                        bedwarsServer4.add(player.getUniqueId());
                        updateSigns();
                        for(int i = 0;i<bedwarsServer4.size();i++){
                            Bukkit.getPlayer(bedwarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer4.size()+" / "+bedwarsServer4MaxPlayer));
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
                bedwarsServer4.remove(player.getUniqueId());
                updateSigns();
                player.sendMessage(ChatColor.RED+"Du wurdest aus der Spielersuche entfernt.");
            }
        }
    }

    public static void updateSigns(){
        World world = Bukkit.getWorld("world");

        Block skywarsServer1Block = world.getBlockAt(60,-41,-9);
        org.bukkit.block.Sign skywarsServer1Sign = (Sign) skywarsServer1Block.getState();
        skywarsServer1Sign.setLine(0, ChatColor.GOLD+"Skywars");
        skywarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1 | SOLO");
        skywarsServer1Sign.setLine(2,ChatColor.GREEN+""+skywarsServer1.size()+" / "+skywarsServer1MaxPlayer);
        if(skywarsServer1Running){
            skywarsServer1Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer1Sign.setLine(3,"");
        }
        skywarsServer1Sign.update();

        Block skywarsServer2Block = world.getBlockAt(59,-41,-9);
        org.bukkit.block.Sign skywarsServer2Sign = (Sign) skywarsServer2Block.getState();
        skywarsServer2Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2 | SOLO");
        skywarsServer2Sign.setLine(2,ChatColor.GREEN+""+skywarsServer2.size()+" / "+skywarsServer2MaxPlayer);
        if(skywarsServer2Running){
            skywarsServer2Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer2Sign.setLine(3,"");
        }
        skywarsServer2Sign.update();

        Block skywarsServer3Block = world.getBlockAt(58,-41,-9);
        org.bukkit.block.Sign skywarsServer3Sign = (Sign) skywarsServer3Block.getState();
        skywarsServer3Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer3Sign.setLine(1,ChatColor.GREEN+"Server 3 | SOLO");
        skywarsServer3Sign.setLine(2,ChatColor.GREEN+""+skywarsServer3.size()+" / "+skywarsServer3MaxPlayer);
        if(skywarsServer3Running){
            skywarsServer3Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer3Sign.setLine(3,"");
        }
        skywarsServer3Sign.update();

        Block skywarsServer4Block = world.getBlockAt(57,-41,-9);
        org.bukkit.block.Sign skywarsServer4Sign = (Sign) skywarsServer4Block.getState();
        skywarsServer4Sign.setLine(0,ChatColor.GOLD+"Skywars");
        skywarsServer4Sign.setLine(1,ChatColor.GREEN+"Server 4 | SOLO");
        skywarsServer4Sign.setLine(2,ChatColor.GREEN+""+skywarsServer4.size()+" / "+skywarsServer4MaxPlayer);
        if(skywarsServer4Running){
            skywarsServer4Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            skywarsServer4Sign.setLine(3,"");
        }
        skywarsServer4Sign.update();


//------------------------------------------------------------------Bedwars--------------------------------------------------------------------------------------------

        Block bedwarsServer1Block = world.getBlockAt(-6,-36,63);
        org.bukkit.block.Sign bedwarsServer1Sign = (Sign) bedwarsServer1Block.getState();
        bedwarsServer1Sign.setLine(0,ChatColor.GOLD+"Bedwars");
        bedwarsServer1Sign.setLine(1,ChatColor.GREEN+"Server 1 | SOLO");
        bedwarsServer1Sign.setLine(2,ChatColor.GREEN+""+bedwarsServer1.size()+" / "+bedwarsServer1MaxPlayer);
        if(bedwarsServer1Running){
            bedwarsServer1Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            bedwarsServer1Sign.setLine(3,"");
        }
        bedwarsServer1Sign.update();

        Block bedwarsServer2Block = world.getBlockAt(-6,-36,64);
        org.bukkit.block.Sign bedwarsServer2Sign = (Sign) bedwarsServer2Block.getState();
        bedwarsServer2Sign.setLine(0,ChatColor.GOLD+"Bedwars");
        bedwarsServer2Sign.setLine(1,ChatColor.GREEN+"Server 2 | SOLO");
        bedwarsServer2Sign.setLine(2,ChatColor.GREEN+""+bedwarsServer2.size()+" / "+bedwarsServer2MaxPlayer);
        if(bedwarsServer2Running){
            bedwarsServer2Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            bedwarsServer2Sign.setLine(3,"");
        }
        bedwarsServer2Sign.update();

        Block bedwarsServer3Block = world.getBlockAt(-6,-36,65);
        org.bukkit.block.Sign bedwarsServer3Sign = (Sign) bedwarsServer3Block.getState();
        bedwarsServer3Sign.setLine(0,ChatColor.GOLD+"Bedwars");
        bedwarsServer3Sign.setLine(1,ChatColor.GREEN+"Server 3 | DUO");
        bedwarsServer3Sign.setLine(2,ChatColor.GREEN+""+bedwarsServer3.size()+" / "+bedwarsServer3MaxPlayer);
        if(bedwarsServer3Running){
            bedwarsServer3Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            bedwarsServer3Sign.setLine(3,"");
        }
        bedwarsServer3Sign.update();

        Block bedwarsServer4Block = world.getBlockAt(-6,-36,66);
        org.bukkit.block.Sign bedwarsServer4Sign = (Sign) bedwarsServer4Block.getState();
        bedwarsServer4Sign.setLine(0,ChatColor.GOLD+"Bedwars");
        bedwarsServer4Sign.setLine(1,ChatColor.GREEN+"Server 4 | TEAM");
        bedwarsServer4Sign.setLine(2,ChatColor.GREEN+""+bedwarsServer4.size()+" / "+bedwarsServer4MaxPlayer);
        if(bedwarsServer4Running){
            bedwarsServer4Sign.setLine(3,ChatColor.RED+"Spiel läuft");
        }else{
            bedwarsServer4Sign.setLine(3,"");
        }
        bedwarsServer4Sign.update();
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

//------------------------------------------------------------------Bedwars--------------------------------------------------------------------------------------------

        if(bedwarsServer1.size()>=bedwarsServer1MaxPlayer){
            bedwarsServer1Countdown--;
        }else{
            bedwarsServer1Countdown=60;
        }
        if(bedwarsServer1.size()==0){
            File server = new File("GameServer/Bedwars/Server1/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Bedwars/Server1/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(), ()->{
                       World unload = Bukkit.getWorld("GameServer/Bedwars/Server1/server/");
                       unloadWorld(unload);
                       deleteWorld(new File("GameServer/Bedwars/Server1/server"));
                    });
                    bedwarsServer1Running=false;
                    bedwarsServer1Countdown=60;
                }
            }
        }
        if(bedwarsServer1.size()==bedwarsServer1MaxPlayer&&bedwarsServer1Countdown>10) bedwarsServer1Countdown=10;
        if(bedwarsServer1Countdown==5){
            Thread thread = new Thread(()->{new BedwarsHandler(bedwarsServer1, 1); });
            thread.start();
            bedwarsServer1Running=true;
        }


        if(bedwarsServer2.size()>=bedwarsServer2MaxPlayer/2){
            bedwarsServer2Countdown--;
        }else{
            bedwarsServer2Countdown=60;
        }
        if(bedwarsServer2.size()==0){
            File server = new File("GameServer/Bedwars/Server2/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Bedwars/Server2/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(), ()->{
                        World unload = Bukkit.getWorld("GameServer/Bedwars/Server2/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Bedwars/Server2/server"));
                    });
                    bedwarsServer2Running=false;
                    bedwarsServer2Countdown=60;
                }
            }
        }
        if(bedwarsServer2.size()==bedwarsServer2MaxPlayer&&bedwarsServer2Countdown>10) bedwarsServer2Countdown=10;
        if(bedwarsServer2Countdown==5){
            Thread thread = new Thread(()->{new BedwarsHandler(bedwarsServer2,2); });
            thread.start();
            bedwarsServer2Running=true;
        }


        if(bedwarsServer3.size()>=bedwarsServer3MaxPlayer&&(bedwarsServer3.size()%2)==0){
            bedwarsServer3Countdown--;
        }else{
            bedwarsServer3Countdown=60;
        }
        if(bedwarsServer3.size()==0){
            File server = new File("GameServer/Bedwars/Server3/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Bedwars/Server3/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(), ()->{
                        World unload = Bukkit.getWorld("GameServer/Bedwars/Server3/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Bedwars/Server3/server"));
                    });
                    bedwarsServer3Running=false;
                    bedwarsServer3Countdown=60;
                }
            }
        }
        if(bedwarsServer3.size()==bedwarsServer3MaxPlayer&&bedwarsServer3Countdown>10) bedwarsServer3Countdown=10;
        if(bedwarsServer3Countdown==5){
            Thread thread = new Thread(()->{new BedwarsHandler(bedwarsServer3,3); });
            thread.start();
            bedwarsServer3Running=true;
        }


        if(bedwarsServer4.size()>=bedwarsServer4MaxPlayer/2&&(bedwarsServer4.size()%2)==0){
            bedwarsServer4Countdown--;
        }else{
            bedwarsServer4Countdown=60;
        }
        if(bedwarsServer4.size()==0){
            File server = new File("GameServer/Bedwars/Server4/server");
            if(server.isDirectory()){
                if(Bukkit.getWorld("GameServer/Bedwars/Server4/server/").getPlayers().size()==0){
                    Bukkit.getScheduler().runTask(Main.getPlugin(), ()->{
                        World unload = Bukkit.getWorld("GameServer/Bedwars/Server4/server/");
                        unloadWorld(unload);
                        deleteWorld(new File("GameServer/Bedwars/Server4/server"));
                    });
                    bedwarsServer4Running=false;
                    bedwarsServer4Countdown=60;
                }
            }
        }
        if(bedwarsServer4.size()==bedwarsServer4MaxPlayer&&bedwarsServer4Countdown>10) bedwarsServer4Countdown=10;
        if(bedwarsServer4Countdown==5){
            Thread thread = new Thread(()->{new BedwarsHandler(bedwarsServer4, 4); });
            thread.start();
            bedwarsServer4Running=true;
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

//------------------------------------------------------------------Bedwars--------------------------------------------------------------------------------------------

        if(bedwarsServer1.size()>=1){
            for(int i = 0;i<bedwarsServer1.size();i++){
                Player player = Bukkit.getPlayer(bedwarsServer1.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(bedwarsServer1Countdown<60){
                        Bukkit.getPlayer(bedwarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer1.size()+" / "+bedwarsServer1MaxPlayer+"   "+bedwarsServer1Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(bedwarsServer1.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer1.size()+" / "+bedwarsServer1MaxPlayer));
                    }
                }
            }
        }
        if(bedwarsServer2.size()>=1){
            for(int i = 0;i<bedwarsServer2.size();i++){
                Player player = Bukkit.getPlayer(bedwarsServer2.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(bedwarsServer2Countdown<60){
                        Bukkit.getPlayer(bedwarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer2.size()+" / "+bedwarsServer2MaxPlayer+"   "+bedwarsServer2Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(bedwarsServer2.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer2.size()+" / "+bedwarsServer2MaxPlayer));
                    }
                }
            }
        }
        if(bedwarsServer3.size()>=1){
            for(int i = 0;i<bedwarsServer3.size();i++){
                Player player = Bukkit.getPlayer(bedwarsServer3.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(bedwarsServer3Countdown<60){
                        Bukkit.getPlayer(bedwarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer3.size()+" / "+bedwarsServer3MaxPlayer+"   "+bedwarsServer3Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(bedwarsServer3.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer3.size()+" / "+bedwarsServer3MaxPlayer));
                    }
                }
            }
        }
        if(bedwarsServer4.size()>=1){
            for(int i = 0;i<bedwarsServer4.size();i++){
                Player player = Bukkit.getPlayer(bedwarsServer4.get(i));
                if(player.getWorld().getName().equalsIgnoreCase("world")){
                    if(bedwarsServer4Countdown<60){
                        Bukkit.getPlayer(bedwarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer4.size()+" / "+bedwarsServer4MaxPlayer+"   "+bedwarsServer4Countdown+"s"));
                    }else{
                        Bukkit.getPlayer(bedwarsServer4.get(i)).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN+"Spielersuche...  "+bedwarsServer4.size()+" / "+bedwarsServer4MaxPlayer));
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
