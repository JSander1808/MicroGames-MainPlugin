package server.games.skywars;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import server.lobby.general.Matchmaking;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SkywarsEntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity());
            if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server1/server/")){
                if((player.getHealth()-event.getDamage())<=0){
                    for(int i = 0;i<player.getWorld().getPlayers().size();i++){
                        Player worldPlayer = player.getWorld().getPlayers().get(i);
                        worldPlayer.sendMessage(ChatColor.GRAY+""+player.getName()+" ist ausgeschieden.");
                    }
                    event.setCancelled(true);
                    Inventory inv =  player.getInventory();
                    for(int i = 0; i <= 36; i++){
                        try {
                            player.getWorld().dropItem(player.getLocation(), inv.getItem(i)).setPickupDelay(40);
                        }
                        catch(Exception a){
                        }
                        try {
                            switch (i) {
                                case 0:
                                    break;
                                case 1:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getChestplate()).setPickupDelay(40);
                                    break;
                                case 2:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getLeggings()).setPickupDelay(40);
                                    break;
                                case 3:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getHelmet()).setPickupDelay(40);
                                    break;
                            }
                        }
                        catch(Exception d) {
                        }
                    }
                    player.getInventory().clear();
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setHealth(20);
                    player.setGameMode(GameMode.SPECTATOR);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
                }
            }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server2/server/")){
                if((player.getHealth()-event.getDamage())<=0){
                    for(int i = 0;i<player.getWorld().getPlayers().size();i++){
                        Player worldPlayer = player.getWorld().getPlayers().get(i);
                        worldPlayer.sendMessage(ChatColor.GRAY+""+player.getName()+" ist ausgeschieden.");
                    }

                    event.setCancelled(true);
                    Inventory inv =  player.getInventory();
                    for(int i = 0; i <= 36; i++){
                        try {
                            player.getWorld().dropItem(player.getLocation(), inv.getItem(i)).setPickupDelay(40);
                        }
                        catch(Exception a){
                        }
                        try {
                            switch (i) {
                                case 0:
                                    break;
                                case 1:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getChestplate()).setPickupDelay(40);
                                    break;
                                case 2:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getLeggings()).setPickupDelay(40);
                                    break;
                                case 3:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getHelmet()).setPickupDelay(40);
                                    break;
                            }
                        }
                        catch(Exception d) {
                        }
                    }
                    player.getInventory().clear();
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setHealth(20);
                    player.setGameMode(GameMode.SPECTATOR);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
                }
            }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server3/server/")){
                if((player.getHealth()-event.getDamage())<=0){
                    for(int i = 0;i<player.getWorld().getPlayers().size();i++){
                        Player worldPlayer = player.getWorld().getPlayers().get(i);
                        worldPlayer.sendMessage(ChatColor.GRAY+""+player.getName()+" ist ausgeschieden.");
                    }
                    event.setCancelled(true);
                    Inventory inv =  player.getInventory();
                    for(int i = 0; i <= 36; i++){
                        try {
                            player.getWorld().dropItem(player.getLocation(), inv.getItem(i)).setPickupDelay(40);
                        }
                        catch(Exception a){
                        }
                        try {
                            switch (i) {
                                case 0:
                                    break;
                                case 1:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getChestplate()).setPickupDelay(40);
                                    break;
                                case 2:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getLeggings()).setPickupDelay(40);
                                    break;
                                case 3:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getHelmet()).setPickupDelay(40);
                                    break;
                            }
                        }
                        catch(Exception d) {
                        }
                    }
                    player.getInventory().clear();
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setHealth(20);
                    player.setGameMode(GameMode.SPECTATOR);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
                }
            }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
                if((player.getHealth()-event.getDamage())<=0){
                    for(int i = 0;i<player.getWorld().getPlayers().size();i++){
                        Player worldPlayer = player.getWorld().getPlayers().get(i);
                        worldPlayer.sendMessage(ChatColor.GRAY+""+player.getName()+" ist ausgeschieden.");
                    }
                    event.setCancelled(true);
                    Inventory inv =  player.getInventory();
                    for(int i = 0; i <= 36; i++){
                        try {
                            player.getWorld().dropItem(player.getLocation(), inv.getItem(i)).setPickupDelay(40);
                        }
                        catch(Exception a){
                        }
                        try {
                            switch (i) {
                                case 0:
                                    break;
                                case 1:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getChestplate()).setPickupDelay(40);
                                    break;
                                case 2:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getLeggings()).setPickupDelay(40);
                                    break;
                                case 3:
                                    player.getWorld().dropItem(player.getLocation(), ((PlayerInventory) inv).getHelmet()).setPickupDelay(40);
                                    break;
                            }
                        }
                        catch(Exception d) {
                        }
                    }
                    player.getInventory().clear();
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setHealth(20);
                    player.setGameMode(GameMode.SPECTATOR);
                    Matchmaking.removePlayerFromMatchmaking(player);
                    SkywarsManager.updateSkywarsLobby(player.getWorld().getName());
                }
            }
        }
    }
}
