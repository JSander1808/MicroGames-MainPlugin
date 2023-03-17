package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Scoreboard;
import server.general.Coins;
import server.general.Level;
import server.lobby.general.Matchmaking;

import java.util.Calendar;

public class BedwarsManager {

    public static void updateBedwarsLobby(String server){
        if(getTeams(server)<=1){
            if(server.equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server1/server/");
                int playerCount = world.getPlayers().size();
                StringBuilder winnerMessage = new StringBuilder();
                for(int i = 0;i<Matchmaking.bedwarsServer1.size();i++){
                    BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)));
                    Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                    String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).getName();
                    Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                    Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).getPlayer(),15);
                    Level.addXp(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).getPlayer(),20);
                    winnerMessage.append(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i)).getName()).append("  ");
                }
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(!Matchmaking.bedwarsServer1.contains(player.getUniqueId())){
                        if(!Matchmaking.bedwarsServer1Spectator.contains(player.getUniqueId())){
                            Level.addXp(player, 5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+"Gewonnen hat",ChatColor.GOLD+""+winnerMessage);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
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
                Matchmaking.bedwarsServer1Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server2/server/");
                int playerCount = world.getPlayers().size();
                StringBuilder winnerMessage = new StringBuilder();
                for(int i = 0;i<Matchmaking.bedwarsServer2.size();i++){
                    BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)));
                    Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                    String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).getName();
                    Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                    Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).getPlayer(),15);
                    Level.addXp(Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).getPlayer(),20);
                    winnerMessage.append(Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i)).getName()).append("  ");
                }
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(!Matchmaking.bedwarsServer2.contains(player.getUniqueId())){
                        if(!Matchmaking.bedwarsServer2Spectator.contains(player.getUniqueId())){
                            Level.addXp(player, 5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+"Gewonnen hat",ChatColor.GOLD+""+winnerMessage);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
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
                Matchmaking.bedwarsServer2Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server3/server/");
                int playerCount = world.getPlayers().size();
                StringBuilder winnerMessage = new StringBuilder();
                for(int i = 0;i<Matchmaking.bedwarsServer3.size();i++){
                    BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)));
                    Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                    String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).getName();
                    Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                    Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).getPlayer(),15);
                    Level.addXp(Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).getPlayer(),20);
                    winnerMessage.append(Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i)).getName()).append("  ");
                }
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(!Matchmaking.bedwarsServer3.contains(player.getUniqueId())){
                        if(!Matchmaking.bedwarsServer3Spectator.contains(player.getUniqueId())){
                            Level.addXp(player, 5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+"Gewonnen hat",ChatColor.GOLD+""+winnerMessage);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
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
                Matchmaking.bedwarsServer3Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server4/server/");
                int playerCount = world.getPlayers().size();
                StringBuilder winnerMessage = new StringBuilder();
                for(int i = 0;i<Matchmaking.bedwarsServer4.size();i++){
                    BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)));
                    Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                    String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).getName();
                    Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                    Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).getPlayer(),15);
                    Level.addXp(Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).getPlayer(),20);
                    winnerMessage.append(Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i)).getName()).append("  ");
                }
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(!Matchmaking.bedwarsServer4.contains(player.getUniqueId())){
                        if(!Matchmaking.bedwarsServer4Spectator.contains(player.getUniqueId())){
                            Level.addXp(player, 5);
                        }
                    }
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.sendTitle(ChatColor.BLUE+"Gewonnen hat",ChatColor.GOLD+""+winnerMessage);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
                    player.setGameMode(GameMode.ADVENTURE);
                    if(player.isOp()){
                        player.setAllowFlight(true);
                    }
                    player.setFlying(false);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,30,0);
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
                Matchmaking.bedwarsServer4Running=false;
            }
        }
    }

    public static int getTeams(String server){
        int teams = 0;
        Scoreboard scoreboard = null;
        boolean found = false;
        for(Player player : Bukkit.getWorld(server).getPlayers()){
            if(!found){
                if(player.getScoreboard()!=null){
                    scoreboard = player.getScoreboard();
                    found = true;
                }
            }
        }
        if(server.equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer1.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i));
                        if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer1.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i));
                        if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer1.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i));
                        if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer1.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(i));
                        if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
        }
        if(server.equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer2.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i));
                        if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer2.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i));
                        if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer2.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i));
                        if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer2.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer2.get(i));
                        if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
        }
        if(server.equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer3.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i));
                        if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer3.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i));
                        if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer3.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i));
                        if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer3.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer3.get(i));
                        if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
        }
        if(server.equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer4.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i));
                        if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer4.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i));
                        if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer4.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i));
                        if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
            if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().size()>=1){
                boolean tempFound = false;
                for(int i = 0;i<Matchmaking.bedwarsServer4.size();i++){
                    if(!tempFound){
                        Player tempPlayer = Bukkit.getPlayer(Matchmaking.bedwarsServer4.get(i));
                        if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().contains(tempPlayer)){
                            tempFound=true;
                            teams++;
                        }
                    }
                }
            }
        }
        return teams;
    }
}
