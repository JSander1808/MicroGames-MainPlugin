package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import server.main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class BedwarsWorldInitialer {

    public int TaskID;
    public int MatchCooldown = 5;
    
    public static BedwarsRunntimeManager[] brm = new BedwarsRunntimeManager[4];


    public BedwarsWorldInitialer(ArrayList<UUID> players, int server, BedwarsServer serverMap){
        copyWorld(serverMap.getWorldFolder(),new File("GameServer/Bedwars/Server"+server+"/server/"));
        Bukkit.getScheduler().runTask(Main.getPlugin(), () -> {
            World world = new WorldCreator("GameServer/Bedwars/Server"+server+"/server/").createWorld();
            world.setAutoSave(false);
            if(serverMap.getWorldFolder().getName().equalsIgnoreCase("bedwars1")){
                initBedwars1(players,world,server);
            }else if(serverMap.getWorldFolder().getName().equalsIgnoreCase("bedwars2")){
                initBedwars2(players,world,server);
            }else if(serverMap.getWorldFolder().getName().equalsIgnoreCase("bedwars3")){
                initBedwars3(players, world, server);
            }
        });
    }

    public void initBedwars1(ArrayList<UUID> players, World world, int server){
        int playerCount = players.size();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        org.bukkit.scoreboard.Team[] teams = new org.bukkit.scoreboard.Team[4];
        //Team RED
        teams[0] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamRed");
        teams[0].setAllowFriendlyFire(false);
        teams[0].setPrefix(ChatColor.RED+"[Rot] ");
        teams[0].setColor(ChatColor.RED);
        teams[0].setCanSeeFriendlyInvisibles(false);

        //Team Yellow
        teams[1] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamYellow");
        teams[1].setAllowFriendlyFire(false);
        teams[1].setPrefix(ChatColor.YELLOW+"[Gelb] ");
        teams[1].setColor(ChatColor.YELLOW);
        teams[1].setCanSeeFriendlyInvisibles(false);

        //Team Blue
        teams[2] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamBlue");
        teams[2].setAllowFriendlyFire(false);
        teams[2].setPrefix(ChatColor.BLUE+"[Blau] ");
        teams[2].setColor(ChatColor.BLUE);
        teams[2].setCanSeeFriendlyInvisibles(false);

        //Team Green
        teams[3] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamGreen");
        teams[3].setAllowFriendlyFire(false);
        teams[3].setPrefix(ChatColor.GREEN+"[Grün] ");
        teams[3].setColor(ChatColor.GREEN);
        teams[3].setCanSeeFriendlyInvisibles(false);

        if(server<=2){
            for(int i = 0;i<playerCount;i++){
                teams[i].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }else{
            for(int i = 0;i<playerCount/2;i++){
                teams[0].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
            for(int i = players.size()/2;i<playerCount;i++){
                teams[1].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }

        if(teams[0].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[0].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 97.5,3,88.5,90,0));
                }
            }
        }
        if(teams[1].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[1].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, -78.5,3,88.5,-90,0));
                }
            }
        }
        if(teams[2].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[2].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 9.5,3,176.5,180,0));
                }
            }
        }
        if(teams[3].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[3].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 9.5,3,0.5,0,0));
                }
            }
        }
        for(Player player : world.getPlayers()){
            player.setGameMode(GameMode.SURVIVAL);
            if(server<=2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            }else if(server==2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  DUO",ChatColor.RED+"Teamen ist verboten.");
            }else{
                player.sendTitle(ChatColor.GREEN+"Bedwars  TEAM",ChatColor.RED+"Teamen ist verboten.");
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
            player.getInventory().clear();
            player.setHealth(20);
            player.setFoodLevel(20);
        }

        brm[server] = new BedwarsRunntimeManager(world);
        brm[server].addIronSpawn(new Location(world, 9.5,3,182.5));
        brm[server].addIronSpawn(new Location(world, -84.5,3,88.5));
        brm[server].addIronSpawn(new Location(world, 9.5,3,-5.5));
        brm[server].addIronSpawn(new Location(world,  103.5,3,88.5));
        brm[server].addGoldSpawn(new Location(world,56.5,4,88.5));
        brm[server].addGoldSpawn(new Location(world,9.5,4,41.5));
        brm[server].addGoldSpawn(new Location(world,-37.5,4,88.5));
        brm[server].addGoldSpawn(new Location(world,9.5,4,135.5));
        brm[server].addDiamondSpawn(new Location(world,9.5,9,88.5));

        Villager shop1 = (Villager) world.spawnEntity(new Location(world,9.5,3,-9.5), EntityType.VILLAGER);
        shop1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop2 = (Villager) world.spawnEntity(new Location(world,107.5,3,88.5), EntityType.VILLAGER);
        shop2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop3 = (Villager) world.spawnEntity(new Location(world,9.5,3,186.5), EntityType.VILLAGER);
        shop3.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop4 = (Villager) world.spawnEntity(new Location(world,-88.5,3,88.5), EntityType.VILLAGER);
        shop4.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));


        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GOLD+"Match started in: "+ChatColor.GREEN+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).playSound(world.getPlayers().get(i).getLocation(),Sound.ENTITY_EXPERIENCE_ORB_PICKUP,30,10);
                    ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
                    world.getPlayers().get(i).getInventory().setItem(0,woodenSword);
                    world.getPlayers().get(i).setExp(0);
                    world.getPlayers().get(i).setLevel(0);
                    if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("red")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.RED);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.RED);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.RED);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.RED);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("yellow")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.YELLOW);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.YELLOW);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.YELLOW);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.YELLOW);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("blue")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.BLUE);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.BLUE);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.BLUE);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.BLUE);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("green")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.GREEN);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.GREEN);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.GREEN);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.GREEN);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }
                    new BedwarsScorebaordManager(world.getName(),scoreboard);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
    }



    public void initBedwars2(ArrayList<UUID> players, World world, int server){
        int playerCount = players.size();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        org.bukkit.scoreboard.Team[] teams = new org.bukkit.scoreboard.Team[4];
        //Team RED
        teams[0] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamRed");
        teams[0].setAllowFriendlyFire(false);
        teams[0].setPrefix(ChatColor.RED+"[Rot] ");
        teams[0].setColor(ChatColor.RED);
        teams[0].setCanSeeFriendlyInvisibles(false);

        //Team Yellow
        teams[1] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamYellow");
        teams[1].setAllowFriendlyFire(false);
        teams[1].setPrefix(ChatColor.YELLOW+"[Gelb] ");
        teams[1].setColor(ChatColor.YELLOW);
        teams[1].setCanSeeFriendlyInvisibles(false);

        //Team Blue
        teams[2] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamBlue");
        teams[2].setAllowFriendlyFire(false);
        teams[2].setPrefix(ChatColor.BLUE+"[Blau] ");
        teams[2].setColor(ChatColor.BLUE);
        teams[2].setCanSeeFriendlyInvisibles(false);

        //Team Green
        teams[3] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamGreen");
        teams[3].setAllowFriendlyFire(false);
        teams[3].setPrefix(ChatColor.GREEN+"[Grün] ");
        teams[3].setColor(ChatColor.GREEN);
        teams[3].setCanSeeFriendlyInvisibles(false);

        if(server<=2){
            for(int i = 0;i<playerCount;i++){
                teams[i].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }else{
            for(int i = 0;i<playerCount/2;i++){
                teams[0].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
            for(int i = players.size()/2;i<playerCount;i++){
                teams[1].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }

        if(teams[0].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[0].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 8.5,0,-94.5,0,0));
                }
            }
        }
        if(teams[1].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[1].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 8.5,0,11.5,180,0));
                }
            }
        }
        for(Player player : world.getPlayers()){
            player.setGameMode(GameMode.SURVIVAL);
            if(server<=2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            }else if(server==2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  DUO",ChatColor.RED+"Teamen ist verboten.");
            }else{
                player.sendTitle(ChatColor.GREEN+"Bedwars  TEAM",ChatColor.RED+"Teamen ist verboten.");
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
            player.getInventory().clear();
            player.setHealth(20);
            player.setFoodLevel(20);
        }

        brm[server] = new BedwarsRunntimeManager(world);
        brm[server].addIronSpawn(new Location(world, 8.5,1,-1.5));
        brm[server].addIronSpawn(new Location(world, 8.5,1,-81.5));
        brm[server].addGoldSpawn(new Location(world, 8.5,1,-58.5));
        brm[server].addGoldSpawn(new Location(world,  8.5,1,-25.5));
        brm[server].addDiamondSpawn(new Location(world,8.5,1,-41.5));

        Villager shop1 = (Villager) world.spawnEntity(new Location(world,8.5,0,15.5), EntityType.VILLAGER);
        shop1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop2 = (Villager) world.spawnEntity(new Location(world,8.5,0,-98.5), EntityType.VILLAGER);
        shop2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));


        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GOLD+"Match started in: "+ChatColor.GREEN+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).playSound(world.getPlayers().get(i).getLocation(),Sound.ENTITY_EXPERIENCE_ORB_PICKUP,30,10);
                    ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
                    world.getPlayers().get(i).getInventory().setItem(0,woodenSword);
                    world.getPlayers().get(i).setExp(0);
                    world.getPlayers().get(i).setLevel(0);
                    if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("red")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.RED);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.RED);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.RED);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.RED);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("yellow")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.YELLOW);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.YELLOW);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.YELLOW);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.YELLOW);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("blue")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.BLUE);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.BLUE);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.BLUE);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.BLUE);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("green")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.GREEN);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.GREEN);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.GREEN);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.GREEN);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }
                    new BedwarsScorebaordManager(world.getName(),scoreboard);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
    }

    public void initBedwars3(ArrayList<UUID> players, World world, int server){
        int playerCount = players.size();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        org.bukkit.scoreboard.Team[] teams = new org.bukkit.scoreboard.Team[4];
        //Team RED
        teams[0] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamRed");
        teams[0].setAllowFriendlyFire(false);
        teams[0].setPrefix(ChatColor.RED+"[Rot] ");
        teams[0].setColor(ChatColor.RED);
        teams[0].setCanSeeFriendlyInvisibles(false);

        //Team Yellow
        teams[1] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamYellow");
        teams[1].setAllowFriendlyFire(false);
        teams[1].setPrefix(ChatColor.YELLOW+"[Gelb] ");
        teams[1].setColor(ChatColor.YELLOW);
        teams[1].setCanSeeFriendlyInvisibles(false);

        //Team Blue
        teams[2] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamBlue");
        teams[2].setAllowFriendlyFire(false);
        teams[2].setPrefix(ChatColor.BLUE+"[Blau] ");
        teams[2].setColor(ChatColor.BLUE);
        teams[2].setCanSeeFriendlyInvisibles(false);

        //Team Green
        teams[3] = scoreboard.registerNewTeam("bedwarsServer"+server+"TeamGreen");
        teams[3].setAllowFriendlyFire(false);
        teams[3].setPrefix(ChatColor.GREEN+"[Grün] ");
        teams[3].setColor(ChatColor.GREEN);
        teams[3].setCanSeeFriendlyInvisibles(false);

        if(server<=2){
            for(int i = 0;i<playerCount;i++){
                teams[i].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }else{
            for(int i = 0;i<playerCount/2;i++){
                teams[0].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
            for(int i = players.size()/2;i<playerCount;i++){
                teams[1].addPlayer(Bukkit.getPlayer(players.get(i)));
                Bukkit.getPlayer(players.get(i)).setScoreboard(scoreboard);
            }
        }

        if(teams[0].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[0].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, -6.5,-1,-6.5,0,0));
                }
            }
        }
        if(teams[1].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[1].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, -6.5,-1,-180.5,-180,0));
                }
            }
        }
        if(teams[2].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[2].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, 80.5,-1,-93.5,-90,0));
                }
            }
        }
        if(teams[3].getPlayers().size()!=0){
            for(int i = 0;i<players.size();i++){
                if(teams[3].getPlayers().contains(Bukkit.getPlayer(players.get(i)))){
                    Bukkit.getPlayer(players.get(i)).teleport(new Location(world, -93.5,-1,-93.5,90,0));
                }
            }
        }
        for(Player player : world.getPlayers()){
            player.setGameMode(GameMode.SURVIVAL);
            if(server<=2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            }else if(server==2){
                player.sendTitle(ChatColor.GREEN+"Bedwars  DUO",ChatColor.RED+"Teamen ist verboten.");
            }else{
                player.sendTitle(ChatColor.GREEN+"Bedwars  TEAM",ChatColor.RED+"Teamen ist verboten.");
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
            player.getInventory().clear();
            player.setHealth(20);
            player.setFoodLevel(20);
        }

        brm[server] = new BedwarsRunntimeManager(world);
        brm[server].addIronSpawn(new Location(world, -99.5,0,-97.5));
        brm[server].addIronSpawn(new Location(world, -10.5,0,-0.5));
        brm[server].addIronSpawn(new Location(world, 86.5,0,-89.5));
        brm[server].addIronSpawn(new Location(world,  -2.5,0,-186.5));
        brm[server].addGoldSpawn(new Location(world,-115.5,5,-88.5));
        brm[server].addGoldSpawn(new Location(world,-1.5,5,15.5));
        brm[server].addGoldSpawn(new Location(world,102.5,5,-98.5));
        brm[server].addGoldSpawn(new Location(world,-11.5,5,-202.5));
        brm[server].addDiamondSpawn(new Location(world,-6.5,26,-93.5));

        Villager shop1 = (Villager) world.spawnEntity(new Location(world,1.5,0,18.5), EntityType.VILLAGER);
        shop1.setCustomName(ChatColor.DARK_GREEN+"Soos");
        shop1.setCustomNameVisible(true);
        shop1.setProfession(Villager.Profession.NITWIT);
        shop1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop2 = (Villager) world.spawnEntity(new Location(world,105.5,0,-101.5), EntityType.VILLAGER);
        shop2.setCustomName(ChatColor.DARK_GREEN+"Soos");
        shop2.setCustomNameVisible(true);
        shop2.setProfession(Villager.Profession.NITWIT);
        shop2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop3 = (Villager) world.spawnEntity(new Location(world,-14.5,0,-205.5), EntityType.VILLAGER);
        shop3.setCustomName(ChatColor.DARK_GREEN+"Soos");
        shop3.setCustomNameVisible(true);
        shop3.setProfession(Villager.Profession.NITWIT);
        shop3.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));
        Villager shop4 = (Villager) world.spawnEntity(new Location(world,-118.5,0,-85.5), EntityType.VILLAGER);
        shop4.setCustomName(ChatColor.DARK_GREEN+"Soos");
        shop4.setCustomNameVisible(true);
        shop4.setProfession(Villager.Profession.NITWIT);
        shop4.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255));


        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GOLD+"Match started in: "+ChatColor.GREEN+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).playSound(world.getPlayers().get(i).getLocation(),Sound.ENTITY_EXPERIENCE_ORB_PICKUP,30,10);
                    ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
                    world.getPlayers().get(i).getInventory().setItem(0,woodenSword);
                    world.getPlayers().get(i).setExp(0);
                    world.getPlayers().get(i).setLevel(0);
                    if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("red")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.RED);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.RED);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.RED);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.RED);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("yellow")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.YELLOW);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.YELLOW);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.YELLOW);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.YELLOW);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("blue")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.BLUE);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.BLUE);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.BLUE);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.BLUE);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }else if(getTeamColor(world.getPlayers().get(i)).equalsIgnoreCase("green")){
                        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
                        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
                        helmetMeta.setColor(Color.GREEN);
                        helmet.setItemMeta(helmetMeta);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.GREEN);
                        chestplate.setItemMeta(chestplateMeta);
                        ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta legginsMeta = (LeatherArmorMeta) leggins.getItemMeta();
                        legginsMeta.setColor(Color.GREEN);
                        leggins.setItemMeta(legginsMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        bootsMeta.setColor(Color.GREEN);
                        boots.setItemMeta(bootsMeta);
                        world.getPlayers().get(i).getInventory().setItem(36,boots);
                        world.getPlayers().get(i).getInventory().setItem(37,leggins);
                        world.getPlayers().get(i).getInventory().setItem(38,chestplate);
                        world.getPlayers().get(i).getInventory().setItem(39,helmet);
                    }
                    new BedwarsScorebaordManager(world.getName(),scoreboard);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
    }
















    public String getTeamColor(Player player){
        String team = null;
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }
        return team;
    }

    public void copyWorld(File source, File target){
        try {
            ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
            if(!ignore.contains(source.getName())) {
                if(source.isDirectory()) {
                    if(!target.exists())
                        target.mkdirs();
                    String files[] = source.list();
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyWorld(srcFile, destFile);
                    }
                } else {
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0)
                        out.write(buffer, 0, length);
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {

        }
    }
}
