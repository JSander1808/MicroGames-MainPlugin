package server.games.skywars;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import server.main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class SkywarsWorldInitialer {

    public int MatchCooldown = 5;
    public int TaskID;


    public SkywarsWorldInitialer(ArrayList<UUID> players, int server, SkywarsServer serverMap){
        copyWorld(serverMap.getWorldFolder(),new File("GameServer/Skywars/Server"+server+"/server/"));
        Bukkit.getScheduler().runTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                World world = new WorldCreator("GameServer/Skywars/Server"+server+"/server/").createWorld();
                world.setAutoSave(false);
                if(serverMap.getWorldFolder().getName().equalsIgnoreCase("skywars1")){
                    initSkywars1(players, world);
                }else if(serverMap.getWorldFolder().getName().equalsIgnoreCase("skywars2")){
                    initSkywars2(players,world);
                }else if(serverMap.getWorldFolder().getName().equalsIgnoreCase("skywars3")){
                    initSkywars3(players,world);
                }
            }
        });
    }



    public void initSkywars1(ArrayList<UUID> players, World world){
        int playerCount = players.size();
        System.out.println(playerCount);
        if(playerCount>=1){
            Bukkit.getPlayer(players.get(0)).teleport(new Location(world,57.5,118,56.5,180,0));
        }
        if(playerCount>=2){
            Bukkit.getPlayer(players.get(1)).teleport(new Location(world,57.5,118,-54.5,0,0));
        }
        if(playerCount>=3){
            Bukkit.getPlayer(players.get(2)).teleport(new Location(world,1.5,118,0.5,-90,0));
        }
        if(playerCount>=4){
            Bukkit.getPlayer(players.get(3)).teleport(new Location(world,113.5,118,0.5,90,0));
        }
        if(playerCount>=5){
            Bukkit.getPlayer(players.get(4)).teleport(new Location(world,95.5,119,38.5,134,0));
        }
        if(playerCount>=6){
            Bukkit.getPlayer(players.get(5)).teleport(new Location(world,21.5,119,36.5,-134,0));
        }
        if(playerCount>=7){
            Bukkit.getPlayer(players.get(6)).teleport(new Location(world,19.5,119,-37.5,-43,0));
        }
        if(playerCount>=8){
            Bukkit.getPlayer(players.get(7)).teleport(new Location(world,94.5,119,-36.5,44,0));
        }
        fillChest(new Location(world, 58,118,-57));
        fillChest(new Location(world,54,111,-54));
        fillChest(new Location(world, 95,119,-39));
        fillChest(new Location(world, 91,112,-36));
        fillChest(new Location(world,  115,118,1));
        fillChest(new Location(world,  112,111,-3));
        fillChest(new Location(world,  97,119,39));
        fillChest(new Location(world,  94,112,35));
        fillChest(new Location(world,  56,118,58));
        fillChest(new Location(world,  60,111,55));
        fillChest(new Location(world, 20,119,38));
        fillChest(new Location(world, 24,112,35));
        fillChest(new Location(world,  -1,118,-1));
        fillChest(new Location(world,  2,111,3));
        fillChest(new Location(world,  17,119,-39));
        fillChest(new Location(world,  20,112,-35));
        fillChest(new Location(world,62,117,1));
        fillChest(new Location(world,57,117,6));
        fillChest(new Location(world, 52,117,1));
        fillChest(new Location(world, 57,117,-4));
        fillChest(new Location(world, 57,116,0));
        fillChest(new Location(world, 58,116,1));
        fillChest(new Location(world, 57,116,2));
        fillChest(new Location(world, 56,116,1));
        if(Math.random()<=0.5){
            world.setTime(5000);
        }else{
            world.setTime(15000);
        }

        for(int i = 0;i<players.size();i++){
            Player player = Bukkit.getPlayer(players.get(i));
            player.getInventory().clear();
            player.setGameMode(GameMode.SURVIVAL);

            ItemStack stone = new ItemStack(Material.STONE);
            stone.setAmount(64);
            player.getInventory().clear();
            player.getInventory().setItem(8, stone);

            player.setLevel(0);
            player.setExp(0);
            player.sendTitle(ChatColor.GREEN+"Skywars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
        }
        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"Match started in: "+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).setHealth(20);
                    world.getPlayers().get(i).setFoodLevel(20);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
    }

    public void initSkywars2(ArrayList<UUID> players, World world){
        int playerCount = players.size();
        System.out.println(playerCount);
        if(playerCount>=1){
            Bukkit.getPlayer(players.get(0)).teleport(new Location(world,21.5,-30,22.5,0,0));
        }
        if(playerCount>=2){
            Bukkit.getPlayer(players.get(1)).teleport(new Location(world,21.5,-30,128.5,180,0));
        }
        if(playerCount>=3){
            Bukkit.getPlayer(players.get(2)).teleport(new Location(world,74.5,-30,75.5,90,0));
        }
        if(playerCount>=4){
            Bukkit.getPlayer(players.get(3)).teleport(new Location(world,-31.5,-30,75.5,-90,0));
        }
        fillChest(new Location(world, 22,-29,18));
        fillChest(new Location(world,21,-32,17));
        fillChest(new Location(world, 22,-30,38));
        fillChest(new Location(world, 21,-30,73));
        fillChest(new Location(world,  22,-30,76));
        fillChest(new Location(world,  21,-30,77));
        fillChest(new Location(world,  20,-30,75));
        fillChest(new Location(world,  58,-30,76));
        fillChest(new Location(world,  78,-29,76));
        fillChest(new Location(world,  79,-32,75));
        fillChest(new Location(world, 20,-30,112));
        fillChest(new Location(world, 20,-29,132));
        fillChest(new Location(world,  21, -32, 133));
        fillChest(new Location(world,  -16,-30,74));
        fillChest(new Location(world,  -36,-29,74));
        fillChest(new Location(world,  -37,-32,75));
        if(Math.random()<=0.5){
            world.setTime(5000);
        }else{
            world.setTime(15000);
        }

        for(int i = 0;i<players.size();i++){
            Player player = Bukkit.getPlayer(players.get(i));
            player.getInventory().clear();
            player.setGameMode(GameMode.SURVIVAL);

            ItemStack stone = new ItemStack(Material.STONE);
            stone.setAmount(64);
            player.getInventory().clear();
            player.getInventory().setItem(8, stone);

            player.setLevel(0);
            player.setExp(0);
            player.sendTitle(ChatColor.GREEN+"Skywars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
        }
        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"Match started in: "+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).setHealth(20);
                    world.getPlayers().get(i).setFoodLevel(20);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);


    }

    public void initSkywars3(ArrayList<UUID> players, World world){
        int playerCount = players.size();
        System.out.println(playerCount);
        if(playerCount>=1){
            Bukkit.getPlayer(players.get(0)).teleport(new Location(world,8.5,-31,-101.5,0,0));
        }
        if(playerCount>=2){
            Bukkit.getPlayer(players.get(1)).teleport(new Location(world,8.5,-32,6.5,-180,0));
        }
        if(playerCount>=3){
            Bukkit.getPlayer(players.get(2)).teleport(new Location(world,-45.5,-32,-47.5,-90,0));
        }
        if(playerCount>=4){
            Bukkit.getPlayer(players.get(3)).teleport(new Location(world,62.5,-32,-47.5,90,0));
        }
        fillChest(new Location(world, 68,-32,-48));
        fillChest(new Location(world,66,-35,-50));
        fillChest(new Location(world, 43,-33,-48));
        fillChest(new Location(world, 8,-33,-13));
        fillChest(new Location(world,  8,-32,12));
        fillChest(new Location(world,  10,-35,10));
        fillChest(new Location(world,  -27,-33,-48));
        fillChest(new Location(world,  -52,-32,-48));
        fillChest(new Location(world,  -50,-35,-46));
        fillChest(new Location(world,  8,-33,-83));
        fillChest(new Location(world, 8,-32,-108));
        fillChest(new Location(world, 6,-35,-106));
        fillChest(new Location(world,  8,-33,-50));
        fillChest(new Location(world,  10,-33,-48));
        fillChest(new Location(world,  8,-33,-46));
        fillChest(new Location(world,  7,-33,-49));
        if(Math.random()<=0.5){
            world.setTime(5000);
        }else{
            world.setTime(15000);
        }

        for(int i = 0;i<players.size();i++){
            Player player = Bukkit.getPlayer(players.get(i));
            player.getInventory().clear();
            player.setGameMode(GameMode.SURVIVAL);

            ItemStack stone = new ItemStack(Material.STONE);
            stone.setAmount(64);
            player.getInventory().clear();
            player.getInventory().setItem(8, stone);

            player.setLevel(0);
            player.setExp(0);
            player.sendTitle(ChatColor.GREEN+"Skywars  SOLO",ChatColor.RED+"Teamen ist verboten.");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,((MatchCooldown*20)+80),255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,((MatchCooldown*20)+80),255));
        }
        MatchCooldown+=4;
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), () -> {
            if(MatchCooldown!=0){
                MatchCooldown--;
                if(MatchCooldown<=5){
                    for(int i = 0;i<world.getPlayers().size();i++){
                        world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"Match started in: "+MatchCooldown);
                    }
                }
            }else{
                for(int i = 0;i<world.getPlayers().size();i++){
                    world.getPlayers().get(i).sendMessage(ChatColor.GREEN+"GO");
                    world.getPlayers().get(i).setHealth(20);
                    world.getPlayers().get(i).setFoodLevel(20);
                }
                Bukkit.getScheduler().cancelTask(TaskID);
            }
        },0,20);
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

    public void fillChest(Location location){
        Block block = location.getWorld().getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        Chest chest = (Chest) block.getState();
        Inventory inv = chest.getInventory();
        for(int i = 0;i<5;i++){
            int random = (int) Math.floor((Math.random()*(26-1))+1);
            ItemStack item = randomItem();
            inv.setItem(random, item);
        }
        for(int i = 0;i<1;i++){
            int random = (int) Math.floor((Math.random()*(26-1))+1);
            ItemStack item = randomRareItem();
            inv.setItem(random, item);
        }
    }

    public ItemStack randomItem(){
        ArrayList<ItemStack> itemPool = new ArrayList<ItemStack>();
        itemPool.add(new ItemStack(Material.IRON_SWORD));
        itemPool.add(new ItemStack(Material.IRON_PICKAXE));
        itemPool.add(new ItemStack(Material.IRON_AXE));
        ItemStack torch = new ItemStack(Material.TORCH);
        torch.setAmount(16);
        itemPool.add(torch);
        ItemStack steaks = new ItemStack(Material.BEEF);
        steaks.setAmount(8);
        itemPool.add(steaks);
        ItemStack brickBlocks = new ItemStack(Material.BRICK);
        brickBlocks.setAmount(64);
        itemPool.add(brickBlocks);
        itemPool.add(new ItemStack(Material.FLINT_AND_STEEL));
        ItemStack coal = new ItemStack(Material.COAL);
        coal.setAmount(8);
        itemPool.add(coal);
        ItemStack cookedChicken = new ItemStack(Material.COOKED_CHICKEN);
        cookedChicken.setAmount(16);
        itemPool.add(cookedChicken);
        ItemStack cookedPorkchop = new ItemStack(Material.COOKED_PORKCHOP);
        cookedPorkchop.setAmount(16);
        itemPool.add(cookedPorkchop);
        ItemStack cookedFish = new ItemStack(Material.COOKED_SALMON);
        cookedFish.setAmount(8);
        itemPool.add(cookedFish);
        ItemStack sticks = new ItemStack(Material.STICK);
        sticks.setAmount(16);
        itemPool.add(sticks);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        iron.setAmount(8);
        itemPool.add(iron);
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        diamond.setAmount(8);
        itemPool.add(diamond);
        ItemStack tnt = new ItemStack(Material.TNT);
        tnt.setAmount(2);
        itemPool.add(tnt);
        ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI);
        lapis.setAmount(4);
        itemPool.add(lapis);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        gold.setAmount(4);
        itemPool.add(gold);
        ItemStack apple = new ItemStack(Material.APPLE);
        apple.setAmount(6);
        itemPool.add(apple);
        ItemStack arrow = new ItemStack(Material.ARROW);
        arrow.setAmount(8);
        itemPool.add(arrow);
        ItemStack stone = new ItemStack(Material.STONE);
        stone.setAmount(32);
        itemPool.add(stone);
        ItemStack cobweps = new ItemStack(Material.COBWEB);
        cobweps.setAmount(3);
        itemPool.add(cobweps);


        int random = (int) Math.floor((Math.random()*(itemPool.size()-1))+1);
        return itemPool.get(random);
    }

    public ItemStack randomRareItem(){
        ArrayList<ItemStack> itemPool = new ArrayList<ItemStack>();
        itemPool.add(new ItemStack(Material.IRON_BOOTS));
        itemPool.add(new ItemStack(Material.IRON_HELMET));
        itemPool.add(new ItemStack(Material.IRON_LEGGINGS));
        itemPool.add(new ItemStack(Material.IRON_BOOTS));
        itemPool.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
        itemPool.add(new ItemStack(Material.DIAMOND_HELMET));
        itemPool.add(new ItemStack(Material.DIAMOND_LEGGINGS));
        itemPool.add(new ItemStack(Material.DIAMOND_BOOTS));
        itemPool.add(new ItemStack(Material.ENCHANTING_TABLE));
        itemPool.add(new ItemStack(Material.BOW));
        itemPool.add(new ItemStack(Material.FISHING_ROD));
        itemPool.add(new ItemStack(Material.WATER_BUCKET));
        itemPool.add(new ItemStack(Material.LAVA_BUCKET));
        ItemStack enderperl = new ItemStack(Material.ENDER_PEARL);
        enderperl.setAmount(1);
        itemPool.add(enderperl);
        ItemStack xpBottle = new ItemStack(Material.EXPERIENCE_BOTTLE);
        xpBottle.setAmount(32);
        itemPool.add(xpBottle);
        itemPool.add(new ItemStack(Material.GOLDEN_APPLE));
        int random = (int) Math.floor((Math.random()*(itemPool.size()-1))+1);
        return itemPool.get(random);
    }
}
