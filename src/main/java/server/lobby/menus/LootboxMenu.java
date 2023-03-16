package server.lobby.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import server.general.Coins;
import server.general.Config;
import server.general.Level;
import server.main.Main;

import java.util.ArrayList;

public class LootboxMenu {

    public int TaskID;
    public int complettedRolls = 20;
    public int temp;

    public LootboxMenu(Player player){
        Inventory inv = Bukkit.createInventory(null, 3*9, ChatColor.GOLD+"Standart-Lootbox");
        ItemStack[] items = getLootboxItems(player);

        ItemStack nothing = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta nothingMeta = nothing.getItemMeta();
        nothingMeta.setDisplayName(" ");
        nothing.setItemMeta(nothingMeta);

        ItemStack selectedItem = new ItemStack(Material.HOPPER);
        ItemMeta selectedItemMeta = selectedItem.getItemMeta();
        selectedItemMeta.setDisplayName(" ");
        selectedItem.setItemMeta(selectedItemMeta);

        for(int i = 0;i<=26;i++){
            inv.setItem(i,nothing);
        }
        inv.setItem(4,selectedItem);
        player.openInventory(inv);

        inv.setItem(9,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(10,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(11,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(12,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(13,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(14,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(15,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(16,items[(int) Math.floor(Math.random()*(items.length))]);
        inv.setItem(17,items[(int) Math.floor(Math.random()*(items.length))]);

        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(),()->{
            if(complettedRolls>=0){
                if(complettedRolls>=6){
                    inv.setItem(9,inv.getItem(10));
                    inv.setItem(10,inv.getItem(11));
                    inv.setItem(11,inv.getItem(12));
                    inv.setItem(12,inv.getItem(13));
                    inv.setItem(13,inv.getItem(14));
                    inv.setItem(14,inv.getItem(15));
                    inv.setItem(15,inv.getItem(16));
                    inv.setItem(16,inv.getItem(17));
                    inv.setItem(17,items[(int) Math.floor(Math.random()*(items.length))]);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,20,2);
                    complettedRolls--;
                }else if(complettedRolls<=5&&complettedRolls>=3){
                    if(temp==3){
                        inv.setItem(9,inv.getItem(10));
                        inv.setItem(10,inv.getItem(11));
                        inv.setItem(11,inv.getItem(12));
                        inv.setItem(12,inv.getItem(13));
                        inv.setItem(13,inv.getItem(14));
                        inv.setItem(14,inv.getItem(15));
                        inv.setItem(15,inv.getItem(16));
                        inv.setItem(16,inv.getItem(17));
                        inv.setItem(17,items[(int) Math.floor(Math.random()*(items.length))]);
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,20,2);
                        temp=0;
                        complettedRolls--;
                    }
                    temp++;
                }else if(complettedRolls<=2){
                    if(temp==4){
                        inv.setItem(9,inv.getItem(10));
                        inv.setItem(10,inv.getItem(11));
                        inv.setItem(11,inv.getItem(12));
                        inv.setItem(12,inv.getItem(13));
                        inv.setItem(13,inv.getItem(14));
                        inv.setItem(14,inv.getItem(15));
                        inv.setItem(15,inv.getItem(16));
                        inv.setItem(16,inv.getItem(17));
                        inv.setItem(17,items[(int) Math.floor(Math.random()*(items.length))]);
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,20,2);
                        temp=0;
                        complettedRolls--;
                    }
                    temp++;
                }
            }else{
                Bukkit.getScheduler().cancelTask(TaskID);
                Bukkit.getScheduler().runTask(Main.getPlugin(),()->{
                    getPlayerReward(player, inv.getItem(13));
                    player.closeInventory();
                    player.playSound(player.getLocation(),Sound.ENTITY_PLAYER_LEVELUP,30,1);
                });
            }
        },0,3);
    }

    public void getPlayerReward(Player player, ItemStack item){
        System.out.println("get player reward");
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"50 Coins")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"50 Coins"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" 50 Coins"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            Coins.addCoins(player,50);
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"500 Coins")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"500 Coins"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" 500 Coins"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            Coins.addCoins(player,500);
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"1500 Coins")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"1500 Coins"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" 1500 Coins"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            Coins.addCoins(player,1500);
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN+"150 XP")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"150 XP"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" 150 XP"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            Level.addXp(player,150);
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Sprengmeister")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Sprengmeister"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Sprengmeister"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.sprengmeister","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Maurer")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Maurer"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Maurer"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.maurer","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Grillmeister")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Grillmeister"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Grillmeister"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.grillmeister","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Zauberer")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Zauberer"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Zauberer"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.zauberer","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Crafter")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Crafter"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Crafter"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.crafter","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Tank")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Tank"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Tank"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.tank","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Assasine")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Assasine"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Assasine"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.assasine","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Miner")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Miner"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Miner"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.miner","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Pirat")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Pirat"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Pirat"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.pirat","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Bauer")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Bauer"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Bauer"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.bauer","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Schneeman")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Schneeman"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Schneeman"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.schneeman","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Angler")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Angler"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Angler"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.angler","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Enderman")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Enderman"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Enderman"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.enderman","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Geizhals")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Geizhals"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Geizhals"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.geizhals","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Bogenmeister")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Bogenmeister"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Bogenmeister"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.bogenmeister","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Spinne")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Spinne"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Spinne"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.spinne","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Ritter")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Ritter"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - Ritter"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.ritter","true");
        }
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Skywars Kits - Sensenman")){
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE+"Du hast "+ChatColor.GOLD+"Skywars Kit - Sensenman"+ChatColor.BLUE+" erhalten");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN+"------------"+ChatColor.GOLD+"[Lootbox]"+ChatColor.GREEN+"------------");
            for(Player worldPlayer : Bukkit.getWorld("world").getPlayers()){
                if(worldPlayer!=player){
                    worldPlayer.sendMessage(ChatColor.GOLD+player.getName()+ChatColor.BLUE+" hat"+ChatColor.GREEN+" Skywars Kit - sensenman"+ChatColor.BLUE+" aus einer Lootbox erhalten.");
                }
            }
            playerConfig.set("kits.skywars.sensenman","true");
        }
    }

    public ItemStack[] getLootboxItems(Player player){
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();

        ItemStack smallCoins = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta smallCoinsMeta = smallCoins.getItemMeta();
        smallCoinsMeta.setDisplayName(ChatColor.GOLD+"50 Coins");
        smallCoins.setItemMeta(smallCoinsMeta);
        for(int i = 0;i<10;i++){
            items.add(smallCoins);
        }

        ItemStack mediumCoins = new ItemStack(Material.GOLD_INGOT);
        ItemMeta mediumCoinsMeta = mediumCoins.getItemMeta();
        mediumCoinsMeta.setDisplayName(ChatColor.GOLD+"500 Coins");
        mediumCoins.setItemMeta(mediumCoinsMeta);
        for(int i = 0;i<2;i++){
            items.add(mediumCoins);
        }

        ItemStack bigCoins = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta bigCoinsMeta = bigCoins.getItemMeta();
        bigCoinsMeta.setDisplayName(ChatColor.GOLD+"1500 Coins");
        bigCoins.setItemMeta(bigCoinsMeta);
        items.add(bigCoins);

        ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta xpMeta = xp.getItemMeta();
        xpMeta.setDisplayName(ChatColor.GREEN+"150 XP");
        xp.setItemMeta(xpMeta);
        for(int i = 0;i<7;i++){
            items.add(xp);
        }

        if(playerConfig.get("kits.skywars.sprengmeister").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.TNT);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Sprengmeister");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.maurer").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.BRICKS);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Maurer");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.grillmeister").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.COOKED_BEEF);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Grillmeister");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.zauberer").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.ENCHANTING_TABLE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Zauberer");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.crafter").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Crafter");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.tank").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Tank");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.assasine").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Assasine");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.pirat").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Pirat");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.miner").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Miner");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.bauer").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.HAY_BLOCK);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Bauer");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.schneeman").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.SNOWBALL);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Schneeman");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.angler").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.FISHING_ROD);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Angler");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.enderman").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.ENDER_PEARL);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Enderman");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.geizhals").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Geizhals");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.bogenmeister").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.BOW);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Bogenmeister");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.spinne").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.COBWEB);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Spinne");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.ritter").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.IRON_SWORD);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Ritter");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }
        if(playerConfig.get("kits.skywars.sensenman").equalsIgnoreCase("false")){
            ItemStack kits = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta kitsMeta = kits.getItemMeta();
            kitsMeta.setDisplayName(ChatColor.GOLD+"Skywars Kits - Sensenman");
            kits.setItemMeta(kitsMeta);
            items.add(kits);
        }

        ItemStack[] itemArray = new ItemStack[items.size()];
        for(int i = 0;i< items.size();i++){
            itemArray[i]=items.get(i);
        }
        return itemArray;
    }
}
