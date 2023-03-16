package server.lobby.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import server.general.Coins;
import server.general.Config;
import server.lobby.Lootbox.Lootbox;
import server.lobby.general.Initial;
import server.lobby.menus.KitManagerMenu;
import server.lobby.menus.LootboxMenu;
import server.lobby.menus.SkywarsKitManagerMenu;
import server.lobby.menus.TeleporterMenu;
import server.main.Main;

import java.util.ArrayList;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(player.getWorld().getName().equalsIgnoreCase("world")){
                if(event.getInventory().getHolder()==player.getInventory().getHolder()){
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case COMPASS:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            new TeleporterMenu(player);
                            break;
                        case CHEST:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            new KitManagerMenu(player);
                            break;
                    }
                    if(!player.isOp()){
                        event.setCancelled(true);
                    }
                }
                if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Teleporter")){
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case BARRIER:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            player.closeInventory();
                            break;
                        case COMPASS:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            Location spawnLocation = new Location(Bukkit.getWorld("world"),8.5,-58,8.5,180,0);
                            player.teleport(spawnLocation);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GRAY+"Du wurdest zum Spawn teleportiert");
                            break;
                        case RED_BED:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            Location bedwarsLocation = new Location(Bukkit.getWorld("world"),-9.5,-38,65.5,-90,0);
                            player.teleport(bedwarsLocation);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GRAY+"Du wurdest zu Bedwars teleportiert");
                            break;
                        case IRON_SWORD:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            Location skywarsLocation = new Location(Bukkit.getWorld("world"),59.5,-43,-13.5,0,0);
                            player.teleport(skywarsLocation);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GRAY+"Du wurdest zu Skywars teleportiert");
                            break;
                        case TNT:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            Location tntRunLocation = new Location(Bukkit.getWorld("world"),-34.5,-56,36.5,-90,0);
                            player.teleport(tntRunLocation);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GRAY+"Du wurdest zu TNT-Run teleportiert");
                            break;
                        case STICK:
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                            Location stickfightLocation = new Location(Bukkit.getWorld("world"),-46.5,-55,-22.5,90,0);
                            player.teleport(stickfightLocation);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GRAY+"Du wurdest zu Stick-Battle teleportiert");
                            break;
                    }
                    event.setCancelled(true);
                }
                if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Kit-Manager")){
                    switch(event.getCurrentItem().getType()){
                        default:
                            break;
                        case BARRIER:
                            player.closeInventory();
                            break;
                        case IRON_SWORD:
                            new SkywarsKitManagerMenu(player);
                            break;
                        case CHEST:
                            Initial.lootbox1.openLootBox(player);
                            break;
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                    event.setCancelled(true);
                }
                if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Skywars-Kit-Manager")){
                    Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
                    if(event.getRawSlot()==49){
                        event.getInventory().setItem(49,null);
                        playerConfig.set("kits.skywars.active","null");
                    }else{
                        switch(event.getCurrentItem().getType()){
                            default:
                                break;
                            case BARRIER:
                                player.closeInventory();
                                break;
                            case TNT:
                                playerConfig.set("kits.skywars.active","sprengmeister");
                                break;
                            case BRICKS:
                                playerConfig.set("kits.skywars.active","maurer");
                                break;
                            case COOKED_BEEF:
                                playerConfig.set("kits.skywars.active","grillmeister");
                                break;
                            case ENCHANTING_TABLE:
                                playerConfig.set("kits.skywars.active","zauberer");
                                break;
                            case CRAFTING_TABLE:
                                playerConfig.set("kits.skywars.active","crafter");
                                break;
                            case IRON_CHESTPLATE:
                                playerConfig.set("kits.skywars.active","tank");
                                break;
                            case FEATHER:
                                playerConfig.set("kits.skywars.active","assasine");
                                break;
                            case LEATHER_HELMET:
                                playerConfig.set("kits.skywars.active","pirat");
                                break;
                            case DIAMOND_PICKAXE:
                                playerConfig.set("kits.skywars.active","miner");
                                break;
                            case HAY_BLOCK:
                                playerConfig.set("kits.skywars.active","bauer");
                                break;
                            case SNOWBALL:
                                playerConfig.set("kits.skywars.active","schneeman");
                                break;
                            case FISHING_ROD:
                                playerConfig.set("kits.skywars.active","angler");
                                break;
                            case ENDER_PEARL:
                                playerConfig.set("kits.skywars.active","enderman");
                                break;
                            case GOLDEN_APPLE:
                                playerConfig.set("kits.skywars.active","geizhals");
                                break;
                            case BOW:
                                playerConfig.set("kits.skywars.active","bogenmeister");
                                break;
                            case COBWEB:
                                playerConfig.set("kits.skywars.active","spinne");
                                break;
                            case IRON_SWORD:
                                playerConfig.set("kits.skywars.active","ritter");
                                break;
                            case DIAMOND_HOE:
                                playerConfig.set("kits.skywars.active","sensenman");
                                break;
                            case WOODEN_SWORD:
                                playerConfig.set("kits.skywars.active","starter");
                                break;
                        }
                        Thread thread = new Thread(()->{setActiveSkywarsKitInMenu(event.getInventory(),player); });
                        thread.start();
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                    event.setCancelled(true);
                }
                if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Lootboxen")){
                    if(event.getCurrentItem()!=null){
                        switch(event.getCurrentItem().getType()){
                            default:
                                break;
                            case BARRIER:
                                player.closeInventory();
                                break;
                            case CHEST:
                                if(event.getRawSlot()==11){
                                    Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
                                    if(Integer.valueOf(playerConfig.get("shop.lootbox.amount"))>=1){
                                        playerConfig.set("shop.lootbox.amount",String.valueOf(Integer.valueOf(playerConfig.get("shop.lootbox.amount"))-1));
                                        Bukkit.getScheduler().runTask(Main.getPlugin(),()->{new LootboxMenu(player); });
                                    }
                                }else if(event.getRawSlot()==15){
                                    Config serverConfig = new Config("serverstats/shop/lootbox.conf");
                                    int lootboxCost = Integer.valueOf(serverConfig.get("lootboxCost"));
                                    int sale = Integer.valueOf(serverConfig.get("sale"));
                                    int saledCost = lootboxCost-((lootboxCost*sale)/100);
                                    if(sale==0){
                                        if(Coins.hasCoins(player, lootboxCost)){
                                            Coins.setCoins(player,Coins.getCoins(player)-lootboxCost);
                                            Bukkit.getScheduler().runTask(Main.getPlugin(),()->{new LootboxMenu(player); });
                                        }else{
                                            player.sendMessage(ChatColor.RED+"Dafür hast du nicht genügent Coins");
                                        }
                                    }else{
                                        if(Coins.hasCoins(player, saledCost)){
                                            Coins.setCoins(player,Coins.getCoins(player)-saledCost);
                                            Bukkit.getScheduler().runTask(Main.getPlugin(),()->{new LootboxMenu(player); });
                                        }else{
                                            player.sendMessage(ChatColor.RED+"Dafür hast du nicht genügent Coins");
                                        }
                                    }
                                }
                                break;
                        }
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,40,2);
                    event.setCancelled(true);
                }
            }
        }
    }

    public void setActiveSkywarsKitInMenu(Inventory inv, Player player){

        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        int slot = 49;

        if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("sprengmeister")){
            ItemStack sprengmeister = new ItemStack(Material.TNT);
            ItemMeta sprengmeisterMeta = sprengmeister.getItemMeta();
            sprengmeisterMeta.setDisplayName(ChatColor.GOLD+"Sprengmeister");
            ArrayList sprengmeisterLore = new ArrayList();
            sprengmeisterLore.add(ChatColor.GRAY+"5x TNT");
            sprengmeisterLore.add(ChatColor.GRAY+"1x Feuerzeug");
            sprengmeisterMeta.setLore(sprengmeisterLore);
            sprengmeister.setItemMeta(sprengmeisterMeta);
            inv.setItem(slot,sprengmeister);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("maurer")){
            ItemStack maurer = new ItemStack(Material.BRICKS);
            ItemMeta maurerMeta = maurer.getItemMeta();
            maurerMeta.setDisplayName(ChatColor.GOLD+"Maurer");
            ArrayList maurerLore = new ArrayList();
            maurerLore.add(ChatColor.GRAY+"64x Ziegelsteine");
            maurerLore.add(ChatColor.GRAY+"1x Goldhelm");
            maurerMeta.setLore(maurerLore);
            maurer.setItemMeta(maurerMeta);
            inv.setItem(slot,maurer);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("grillmeister")){
            ItemStack grillmeister = new ItemStack(Material.COOKED_BEEF);
            ItemMeta grillmeisterMeta = grillmeister.getItemMeta();
            grillmeisterMeta.setDisplayName(ChatColor.GOLD+"Grillmeister");
            ArrayList grillmeisterLore = new ArrayList();
            grillmeisterLore.add(ChatColor.GRAY+"32x Steak");
            grillmeisterLore.add(ChatColor.GRAY+"32x Gebratenes Hänchen");
            grillmeisterLore.add(ChatColor.GRAY+"1x Feuerzeug");
            grillmeisterLore.add(ChatColor.GRAY+"12x Öfen");
            grillmeisterMeta.setLore(grillmeisterLore);
            grillmeister.setItemMeta(grillmeisterMeta);
            inv.setItem(slot, grillmeister);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("zauberer")){
            ItemStack zauberer = new ItemStack(Material.ENCHANTING_TABLE);
            ItemMeta zaubererMeta = zauberer.getItemMeta();
            zaubererMeta.setDisplayName(ChatColor.GOLD+"Zauberer");
            ArrayList zaubererLore = new ArrayList();
            zaubererLore.add(ChatColor.GRAY+"1x Zaubertisch");
            zaubererLore.add(ChatColor.GRAY+"32x Xp-Flaschen");
            zaubererMeta.setLore(zaubererLore);
            zauberer.setItemMeta(zaubererMeta);
            inv.setItem(slot, zauberer);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("crafter")){
            ItemStack crafter = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta crafterMeta = crafter.getItemMeta();
            crafterMeta.setDisplayName(ChatColor.GOLD+"Crafter");
            ArrayList crafterLore = new ArrayList();
            crafterLore.add(ChatColor.GRAY+"64x Craftingtables");
            crafterLore.add(ChatColor.GRAY+"32 Ambosse");
            crafterLore.add(ChatColor.GRAY+"64 Sticks");
            crafterLore.add(ChatColor.GRAY+"5x Diamanaten");
            crafterLore.add(ChatColor.GRAY+"5x Kohle");
            crafterLore.add(ChatColor.GRAY+"5x Eisen");
            crafterMeta.setLore(crafterLore);
            crafter.setItemMeta(crafterMeta);
            inv.setItem(slot,crafter);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("tank")){
            ItemStack tank = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta tankMeta = tank.getItemMeta();
            tankMeta.setDisplayName(ChatColor.GOLD+"Tank");
            ArrayList tankLore = new ArrayList();
            tankLore.add(ChatColor.GRAY+"1x Eisenhelm");
            tankLore.add(ChatColor.GRAY+"1x Eisenbrustplatte");
            tankLore.add(ChatColor.GRAY+"1x Eisenhose");
            tankLore.add(ChatColor.GRAY+"1x Eisenstiefel");
            tankMeta.setLore(tankLore);
            tank.setItemMeta(tankMeta);
            inv.setItem(slot, tank);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("assasine")){
            ItemStack assasine = new ItemStack(Material.FEATHER);
            ItemMeta assasineMeta = assasine.getItemMeta();
            assasineMeta.setDisplayName(ChatColor.GOLD+"Assasine");
            ArrayList assasineLore = new ArrayList();
            assasineLore.add(ChatColor.GRAY+"1x Diastiefel");
            assasineLore.add(ChatColor.GRAY+"1x Diaschwert");
            assasineMeta.setLore(assasineLore);
            assasine.setItemMeta(assasineMeta);
            inv.setItem(slot, assasine);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("pirat")){
            ItemStack pirat = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta piratMeta = pirat.getItemMeta();
            piratMeta.setDisplayName(ChatColor.GOLD+"Pirat");
            ArrayList piratLore = new ArrayList();
            piratLore.add(ChatColor.GRAY+"1x Goldschwert");
            piratLore.add(ChatColor.GRAY+"3x Dispenser");
            piratLore.add(ChatColor.GRAY+"16x Feuerkugeln");
            piratLore.add(ChatColor.GRAY+"3x Helbel");
            piratMeta.setLore(piratLore);
            pirat.setItemMeta(piratMeta);
            inv.setItem(slot, pirat);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("miner")){
            ItemStack miner = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta minerMeta = miner.getItemMeta();
            minerMeta.setDisplayName(ChatColor.GOLD+"Miner");
            ArrayList minerLore = new ArrayList();
            minerLore.add(ChatColor.GRAY+"1x Diamantspitzhacke");
            minerLore.add(ChatColor.GRAY+"1x Eisenhelm");
            minerMeta.setLore(minerLore);
            miner.setItemMeta(minerMeta);
            inv.setItem(slot,miner);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("bauer")){
            ItemStack bauer = new ItemStack(Material.HAY_BLOCK);
            ItemMeta bauerMeta = bauer.getItemMeta();
            bauerMeta.setDisplayName(ChatColor.GOLD+"Bauer");
            ArrayList bauerLore = new ArrayList();
            bauerLore.add(ChatColor.GRAY+"64x Heuballen");
            bauerLore.add(ChatColor.GRAY+"16x Brote");
            bauerLore.add(ChatColor.GRAY+"1x Eisenhacke");
            bauerMeta.setLore(bauerLore);
            bauer.setItemMeta(bauerMeta);
            inv.setItem(slot,bauer);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("schneeman")){
            ItemStack schneeman = new ItemStack(Material.SNOWBALL);
            ItemMeta schneemanMeta = schneeman.getItemMeta();
            schneemanMeta.setDisplayName(ChatColor.GOLD+"Schneeman");
            ArrayList schneemanLore = new ArrayList();
            schneemanLore.add(ChatColor.GRAY+"16x Schneebälle");
            schneemanMeta.setLore(schneemanLore);
            schneeman.setItemMeta(schneemanMeta);
            inv.setItem(slot,schneeman);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("angler")){
            ItemStack angler = new ItemStack(Material.FISHING_ROD);
            ItemMeta anglerMeta = angler.getItemMeta();
            anglerMeta.setDisplayName(ChatColor.GOLD+"Angler");
            ArrayList anglerLore = new ArrayList();
            anglerLore.add(ChatColor.GRAY+"1x Angel");
            anglerLore.add(ChatColor.GRAY+"20x Gebratene Fische");
            anglerMeta.setLore(anglerLore);
            angler.setItemMeta(anglerMeta);
            inv.setItem(slot, angler);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("enderman")){
            ItemStack enderman = new ItemStack(Material.ENDER_PEARL);
            ItemMeta endermanMeta = enderman.getItemMeta();
            endermanMeta.setDisplayName(ChatColor.GOLD+"Enderman");
            ArrayList endermanLore = new ArrayList();
            endermanLore.add(ChatColor.GRAY+"1x Enderperle");
            endermanMeta.setLore(endermanLore);
            enderman.setItemMeta(endermanMeta);
            inv.setItem(slot,enderman);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("geizhals")){
            ItemStack geizhals = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta geizhalsMeta = geizhals.getItemMeta();
            geizhalsMeta.setDisplayName(ChatColor.GOLD+"Geizhals");
            ArrayList geizhalsLore = new ArrayList();
            geizhalsLore.add(ChatColor.GRAY+"1x Goldapfel");
            geizhalsMeta.setLore(geizhalsLore);
            geizhals.setItemMeta(geizhalsMeta);
            inv.setItem(slot,geizhals);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("bogenmeister")){
            ItemStack bogenmeister = new ItemStack(Material.BOW);
            ItemMeta bogenmeisterMeta = bogenmeister.getItemMeta();
            bogenmeisterMeta.setDisplayName(ChatColor.GOLD+"Bogenmeister");
            ArrayList bogenmeisterLore = new ArrayList();
            bogenmeisterLore.add(ChatColor.GRAY+"1x Bogen");
            bogenmeisterLore.add(ChatColor.GRAY+"8x Pfeile");
            bogenmeisterMeta.setLore(bogenmeisterLore);
            bogenmeister.setItemMeta(bogenmeisterMeta);
            inv.setItem(slot,bogenmeister);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("spinne")){
            ItemStack spinne = new ItemStack(Material.COBWEB);
            ItemMeta spinneMeta = spinne.getItemMeta();
            spinneMeta.setDisplayName(ChatColor.GOLD+"Spinne");
            ArrayList spinneLore = new ArrayList();
            spinneLore.add(ChatColor.GRAY+"5x Spinnennetz");
            spinneLore.add(ChatColor.GRAY+"1x Vergiftung");
            spinneMeta.setLore(spinneLore);
            spinne.setItemMeta(spinneMeta);
            inv.setItem(slot,spinne);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("ritter")){
            ItemStack ritter = new ItemStack(Material.IRON_SWORD);
            ItemMeta ritterMeta = ritter.getItemMeta();
            ritterMeta.setDisplayName(ChatColor.GOLD+"Ritter");
            ArrayList ritterLore = new ArrayList();
            ritterLore.add(ChatColor.GRAY+"1x Eisenschwert");
            ritterLore.add(ChatColor.GRAY+"1x Eisenaxt");
            ritterMeta.setLore(ritterLore);
            ritter.setItemMeta(ritterMeta);
            inv.setItem(slot,ritter);
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("sensenman")){
            ItemStack sensenman = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta sensenmanMeta = sensenman.getItemMeta();
            sensenmanMeta.setDisplayName(ChatColor.GOLD+"Sensenman");
            ArrayList sensenmanLore = new ArrayList();
            sensenmanLore.add(ChatColor.GRAY+"1x Diamantharke");
            sensenmanLore.add(ChatColor.GRAY+"1x Schwarze Lederrüstung(Komplett)");
            sensenmanLore.add(ChatColor.GRAY+"1x Schnelligkeit");
            sensenmanMeta.setLore(sensenmanLore);
            sensenman.setItemMeta(sensenmanMeta);
            inv.setItem(slot,sensenman);
        }        if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("starter")){
            ItemStack ritter = new ItemStack(Material.WOODEN_SWORD);
            ItemMeta ritterMeta = ritter.getItemMeta();
            ritterMeta.setDisplayName(ChatColor.GOLD+"Anfänger");
            ArrayList ritterLore = new ArrayList();
            ritterLore.add(ChatColor.GRAY+"1x Holzschwert");
            ritterLore.add(ChatColor.GRAY+"1x Holzspitzhacke");
            ritterLore.add(ChatColor.GRAY+"1x Holzaxt");
            ritterMeta.setLore(ritterLore);
            ritter.setItemMeta(ritterMeta);
            inv.setItem(slot,ritter);
        }
    }
}
