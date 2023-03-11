package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Scoreboard;
import server.games.skywars.SkywarsWinnManager;
import server.lobby.general.Coins;
import server.lobby.general.Matchmaking;

import java.util.Calendar;

public class BedwarsManager {

    public static void updateBedwarsLobby(String server){
        if(getTeams(server)<=1){
            if(server.equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server1/server/");
                int playerCount = world.getPlayers().size();
                BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)));
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getName();
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getPlayer(),15);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.bedwarsServer1Spectator.contains(player.getUniqueId())){
                            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"5 Coins "+ChatColor.BLUE+"für das mitspielen erhalten.");
                            Coins.addCoins(player,5);
                        }
                    }
                    System.out.println(player.getName());
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
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

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
                Matchmaking.skywarsServer1Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server2/server/");
                int playerCount = world.getPlayers().size();
                BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)));
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getName();
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getPlayer(),15);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer1Spectator.contains(player.getUniqueId())){
                            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"5 Coins "+ChatColor.BLUE+"für das mitspielen erhalten.");
                            Coins.addCoins(player,5);
                        }
                    }
                    System.out.println(player.getName());
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
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

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
                Matchmaking.skywarsServer1Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server3/server/");
                int playerCount = world.getPlayers().size();
                BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)));
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getName();
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getPlayer(),15);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer1Spectator.contains(player.getUniqueId())){
                            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"5 Coins "+ChatColor.BLUE+"für das mitspielen erhalten.");
                            Coins.addCoins(player,5);
                        }
                    }
                    System.out.println(player.getName());
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
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

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
                Matchmaking.skywarsServer1Running=false;
            }else if(server.equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                World world = Bukkit.getWorld("GameServer/Bedwars/Server4/server/");
                int playerCount = world.getPlayers().size();
                BedwarsWinnManager.addWin(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)));
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Bedwars Siege: "+ChatColor.GREEN+"+1");
                String winner = Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getName();
                Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"15 Coins "+ChatColor.BLUE+"für das Gewinnen der Runde bekommen.");
                Coins.addCoins(Bukkit.getPlayer(Matchmaking.bedwarsServer1.get(0)).getPlayer(),15);
                for(int i = 0;i<playerCount;i++){
                    Player player = world.getPlayers().get(0);
                    if(Bukkit.getPlayer(winner)!=player){
                        if(!Matchmaking.skywarsServer1Spectator.contains(player.getUniqueId())){
                            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"5 Coins "+ChatColor.BLUE+"für das mitspielen erhalten.");
                            Coins.addCoins(player,5);
                        }
                    }
                    System.out.println(player.getName());
                    Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                    player.teleport(spawnLocation);
                    player.getInventory().clear();
                    player.setMaxHealth(20);
                    player.sendTitle(ChatColor.BLUE+""+winner,ChatColor.GOLD+"Hat Gewonnen");
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

                    Inventory inv = player.getInventory();
                    inv.setItem(0,teleporter);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    Matchmaking.removePlayerFromSpectator(player);
                }
                Matchmaking.skywarsServer1Running=false;
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
        System.out.println(teams);
        return teams;
    }
}
