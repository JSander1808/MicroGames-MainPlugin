package server.games.skywars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import server.general.Coins;
import server.general.Level;
import server.lobby.general.Matchmaking;

import java.util.Calendar;

public class SkywarsManager {

    public static void updateSkywarsLobby(String server){
        if(server.equalsIgnoreCase("GameServer/Skywars/Server1/server/")){
            if(Matchmaking.skywarsServer1.size()==1){
                World world = Bukkit.getWorld("GameServer/Skywars/Server1/server/");
                int playerCount = world.getPlayers().size();
                SkywarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)));
                Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Skywars Siege: "+ChatColor.GREEN+"+1");
                String winner = Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)).getName();
                Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)).getPlayer(),15);
                Level.addXp(Bukkit.getPlayer(Matchmaking.skywarsServer1.get(0)).getPlayer(),20);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer1Spectator.contains(player.getUniqueId())){
                            Level.addXp(player,5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
                    player.setBedSpawnLocation(spawnLocation);
                    player.getInventory().clear();
                    for(PotionEffect effect : player.getActivePotionEffects()){
                        player.removePotionEffect(effect.getType());
                    }
                    player.setFireTicks(0);
                    Calendar calendar = Calendar.getInstance();
                    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                    int year = calendar.get(Calendar.YEAR);
                    player.setExp(0.002f*dayOfYear);
                    player.setLevel(year);

                    ItemStack teleporter = new ItemStack(Material.COMPASS);
                    ItemMeta teleporterMeta = teleporter.getItemMeta();
                    teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
                    teleporter.setItemMeta(teleporterMeta);

                    ItemStack kits = new ItemStack(Material.CHEST);
                    ItemMeta kitsMeta = kits.getItemMeta();
                    kitsMeta.setDisplayName(ChatColor.GOLD+"Kit Menu");
                    kits.setItemMeta(kitsMeta);

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    inv.setItem(4,kits);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
                Matchmaking.skywarsServer1Running=false;
            }
        }else if(server.equalsIgnoreCase("GameServer/Skywars/Server2/server/")){
            if(Matchmaking.skywarsServer2.size()==1){
                int playerCount = Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).getWorld().getPlayers().size();
                World world = Bukkit.getWorld("GameServer/Skywars/Server2/server/");
                String winner = Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).getName();
                SkywarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)));
                Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).sendMessage(ChatColor.BLUE+"Skywars Siege: "+ChatColor.GREEN+"+1");
                Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).getPlayer(),15);
                Level.addXp(Bukkit.getPlayer(Matchmaking.skywarsServer2.get(0)).getPlayer(),20);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer2Spectator.contains(player.getUniqueId())){
                            Level.addXp(player,5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
                    player.setBedSpawnLocation(spawnLocation);
                    player.getInventory().clear();
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    for(PotionEffect effect : player.getActivePotionEffects()){
                        player.removePotionEffect(effect.getType());
                    }
                    player.setFireTicks(0);
                    Calendar calendar = Calendar.getInstance();
                    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                    int year = calendar.get(Calendar.YEAR);
                    player.setExp(0.002f*dayOfYear);
                    player.setLevel(year);

                    ItemStack teleporter = new ItemStack(Material.COMPASS);
                    ItemMeta teleporterMeta = teleporter.getItemMeta();
                    teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
                    teleporter.setItemMeta(teleporterMeta);

                    ItemStack kits = new ItemStack(Material.CHEST);
                    ItemMeta kitsMeta = kits.getItemMeta();
                    kitsMeta.setDisplayName(ChatColor.GOLD+"Kit Menu");
                    kits.setItemMeta(kitsMeta);

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    inv.setItem(4,kits);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
            }
        }else if(server.equalsIgnoreCase("GameServer/Skywars/Server3/server/")){
            if(Matchmaking.skywarsServer3.size()==1){
                int playerCount = Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).getWorld().getPlayers().size();
                World world = Bukkit.getWorld("GameServer/Skywars/Server3/server/");
                String winner = Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).getName();
                SkywarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)));
                Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).sendMessage(ChatColor.BLUE+"Skywars Siege: "+ChatColor.GREEN+"+1");
                Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).getPlayer(),15);
                Level.addXp(Bukkit.getPlayer(Matchmaking.skywarsServer3.get(0)).getPlayer(),20);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer3Spectator.contains(player.getUniqueId())){
                            Level.addXp(player,5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
                    player.setBedSpawnLocation(spawnLocation);
                    player.getInventory().clear();
                    for(PotionEffect effect : player.getActivePotionEffects()){
                        player.removePotionEffect(effect.getType());
                    }
                    player.setFireTicks(0);
                    Calendar calendar = Calendar.getInstance();
                    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                    int year = calendar.get(Calendar.YEAR);
                    player.setExp(0.002f*dayOfYear);
                    player.setLevel(year);

                    ItemStack teleporter = new ItemStack(Material.COMPASS);
                    ItemMeta teleporterMeta = teleporter.getItemMeta();
                    teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
                    teleporter.setItemMeta(teleporterMeta);

                    ItemStack kits = new ItemStack(Material.CHEST);
                    ItemMeta kitsMeta = kits.getItemMeta();
                    kitsMeta.setDisplayName(ChatColor.GOLD+"Kit Menu");
                    kits.setItemMeta(kitsMeta);

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    inv.setItem(1,kits);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
            }
        }else if(server.equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
            if(Matchmaking.skywarsServer4.size()==1){
                int playerCount = Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).getWorld().getPlayers().size();
                World world = Bukkit.getWorld("GameServer/Skywars/Server4/server/");
                String winner = Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).getName();
                SkywarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)));
                Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).sendMessage(ChatColor.BLUE+"Skywars Siege: "+ChatColor.GREEN+"+1");
                Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).getPlayer(),15);
                Level.addXp(Bukkit.getPlayer(Matchmaking.skywarsServer4.get(0)).getPlayer(),20);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer4Spectator.contains(player.getUniqueId())){
                            Level.addXp(player,5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
                    player.setBedSpawnLocation(spawnLocation);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.getInventory().clear();
                    for(PotionEffect effect : player.getActivePotionEffects()){
                        player.removePotionEffect(effect.getType());
                    }
                    player.setFireTicks(0);
                    Calendar calendar = Calendar.getInstance();
                    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                    int year = calendar.get(Calendar.YEAR);
                    player.setExp(0.002f*dayOfYear);
                    player.setLevel(year);

                    ItemStack teleporter = new ItemStack(Material.COMPASS);
                    ItemMeta teleporterMeta = teleporter.getItemMeta();
                    teleporterMeta.setDisplayName(ChatColor.GOLD+"Teleporter");
                    teleporter.setItemMeta(teleporterMeta);

                    ItemStack kits = new ItemStack(Material.CHEST);
                    ItemMeta kitsMeta = kits.getItemMeta();
                    kitsMeta.setDisplayName(ChatColor.GOLD+"Kit Menu");
                    kits.setItemMeta(kitsMeta);

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    inv.setItem(4,kits);

                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
            }
        }
    }
}
