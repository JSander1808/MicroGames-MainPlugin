package server.lobby.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import server.general.Config;

import java.util.ArrayList;

public class SkywarsKitManagerMenu {

    public SkywarsKitManagerMenu(Player player){
        Inventory inv = Bukkit.createInventory(null,6*9, ChatColor.GOLD+"Skywars-Kit-Manager");


        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Schließen");
        close.setItemMeta(closeMeta);


        inv.setItem(53,close);
        player.openInventory(inv);

        setActiveKit(inv,player);
        loadSkywarsKits(inv,player);
    }

    public void setActiveKit(Inventory inv, Player player){

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
        }else if(playerConfig.get("kits.skywars.active").equalsIgnoreCase("starter")){
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

    public void loadSkywarsKits(Inventory inv, Player player){

        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");
        int kits = 0;

        if(playerConfig.get("kits.skywars.sprengmeister").equalsIgnoreCase("true")){
            ItemStack sprengmeister = new ItemStack(Material.TNT);
            ItemMeta sprengmeisterMeta = sprengmeister.getItemMeta();
            sprengmeisterMeta.setDisplayName(ChatColor.GOLD+"Sprengmeister");
            ArrayList sprengmeisterLore = new ArrayList();
            sprengmeisterLore.add(ChatColor.GRAY+"5x TNT");
            sprengmeisterLore.add(ChatColor.GRAY+"1x Feuerzeug");
            sprengmeisterMeta.setLore(sprengmeisterLore);
            sprengmeister.setItemMeta(sprengmeisterMeta);
            inv.setItem(kits,sprengmeister);
            kits++;
        }

        if(playerConfig.get("kits.skywars.maurer").equalsIgnoreCase("true")){
            ItemStack maurer = new ItemStack(Material.BRICKS);
            ItemMeta maurerMeta = maurer.getItemMeta();
            maurerMeta.setDisplayName(ChatColor.GOLD+"Maurer");
            ArrayList maurerLore = new ArrayList();
            maurerLore.add(ChatColor.GRAY+"64x Ziegelsteine");
            maurerLore.add(ChatColor.GRAY+"1x Goldhelm");
            maurerMeta.setLore(maurerLore);
            maurer.setItemMeta(maurerMeta);
            inv.setItem(kits,maurer);
            kits++;
        }

        if(playerConfig.get("kits.skywars.grillmeister").equalsIgnoreCase("true")){
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
            inv.setItem(kits, grillmeister);
            kits++;
        }

        if(playerConfig.get("kits.skywars.zauberer").equalsIgnoreCase("true")){
            ItemStack zauberer = new ItemStack(Material.ENCHANTING_TABLE);
            ItemMeta zaubererMeta = zauberer.getItemMeta();
            zaubererMeta.setDisplayName(ChatColor.GOLD+"Zauberer");
            ArrayList zaubererLore = new ArrayList();
            zaubererLore.add(ChatColor.GRAY+"1x Zaubertisch");
            zaubererLore.add(ChatColor.GRAY+"32x Xp-Flaschen");
            zaubererMeta.setLore(zaubererLore);
            zauberer.setItemMeta(zaubererMeta);
            inv.setItem(kits, zauberer);
            kits++;
        }

        if(playerConfig.get("kits.skywars.crafter").equalsIgnoreCase("true")){
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
            inv.setItem(kits,crafter);
            kits++;
        }

        if(playerConfig.get("kits.skywars.tank").equalsIgnoreCase("true")){
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
            inv.setItem(kits, tank);
            kits++;
        }

        if(playerConfig.get("kits.skywars.assasine").equalsIgnoreCase("true")){
            ItemStack assasine = new ItemStack(Material.FEATHER);
            ItemMeta assasineMeta = assasine.getItemMeta();
            assasineMeta.setDisplayName(ChatColor.GOLD+"Assasine");
            ArrayList assasineLore = new ArrayList();
            assasineLore.add(ChatColor.GRAY+"1x Diastiefel");
            assasineLore.add(ChatColor.GRAY+"1x Diaschwert");
            assasineMeta.setLore(assasineLore);
            assasine.setItemMeta(assasineMeta);
            inv.setItem(kits, assasine);
            kits++;
        }

        if(playerConfig.get("kits.skywars.pirat").equalsIgnoreCase("true")){
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
            inv.setItem(kits, pirat);
            kits++;
        }

        if(playerConfig.get("kits.skywars.miner").equalsIgnoreCase("true")){
            ItemStack miner = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta minerMeta = miner.getItemMeta();
            minerMeta.setDisplayName(ChatColor.GOLD+"Miner");
            ArrayList minerLore = new ArrayList();
            minerLore.add(ChatColor.GRAY+"1x Diamantspitzhacke");
            minerLore.add(ChatColor.GRAY+"1x Eisenhelm");
            minerMeta.setLore(minerLore);
            miner.setItemMeta(minerMeta);
            inv.setItem(kits,miner);
            kits++;
        }

        if(playerConfig.get("kits.skywars.bauer").equalsIgnoreCase("true")){
            ItemStack bauer = new ItemStack(Material.HAY_BLOCK);
            ItemMeta bauerMeta = bauer.getItemMeta();
            bauerMeta.setDisplayName(ChatColor.GOLD+"Bauer");
            ArrayList bauerLore = new ArrayList();
            bauerLore.add(ChatColor.GRAY+"64x Heuballen");
            bauerLore.add(ChatColor.GRAY+"16x Brote");
            bauerLore.add(ChatColor.GRAY+"1x Eisenhacke");
            bauerMeta.setLore(bauerLore);
            bauer.setItemMeta(bauerMeta);
            inv.setItem(kits,bauer);
            kits++;
        }

        if(playerConfig.get("kits.skywars.schneeman").equalsIgnoreCase("true")){
            ItemStack schneeman = new ItemStack(Material.SNOWBALL);
            ItemMeta schneemanMeta = schneeman.getItemMeta();
            schneemanMeta.setDisplayName(ChatColor.GOLD+"Schneeman");
            ArrayList schneemanLore = new ArrayList();
            schneemanLore.add(ChatColor.GRAY+"16x Schneebälle");
            schneemanMeta.setLore(schneemanLore);
            schneeman.setItemMeta(schneemanMeta);
            inv.setItem(kits,schneeman);
            kits++;
        }

        if(playerConfig.get("kits.skywars.angler").equalsIgnoreCase("true")){
            ItemStack angler = new ItemStack(Material.FISHING_ROD);
            ItemMeta anglerMeta = angler.getItemMeta();
            anglerMeta.setDisplayName(ChatColor.GOLD+"Angler");
            ArrayList anglerLore = new ArrayList();
            anglerLore.add(ChatColor.GRAY+"1x Angel");
            anglerLore.add(ChatColor.GRAY+"20x Gebratene Fische");
            anglerMeta.setLore(anglerLore);
            angler.setItemMeta(anglerMeta);
            inv.setItem(kits, angler);
            kits++;
        }

        if(playerConfig.get("kits.skywars.enderman").equalsIgnoreCase("true")){
            ItemStack enderman = new ItemStack(Material.ENDER_PEARL);
            ItemMeta endermanMeta = enderman.getItemMeta();
            endermanMeta.setDisplayName(ChatColor.GOLD+"Enderman");
            ArrayList endermanLore = new ArrayList();
            endermanLore.add(ChatColor.GRAY+"1x Enderperle");
            endermanMeta.setLore(endermanLore);
            enderman.setItemMeta(endermanMeta);
            inv.setItem(kits,enderman);
            kits++;
        }

        if(playerConfig.get("kits.skywars.geizhals").equalsIgnoreCase("true")){
            ItemStack geizhals = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta geizhalsMeta = geizhals.getItemMeta();
            geizhalsMeta.setDisplayName(ChatColor.GOLD+"Geizhals");
            ArrayList geizhalsLore = new ArrayList();
            geizhalsLore.add(ChatColor.GRAY+"1x Goldapfel");
            geizhalsMeta.setLore(geizhalsLore);
            geizhals.setItemMeta(geizhalsMeta);
            inv.setItem(kits,geizhals);
            kits++;
        }

        if(playerConfig.get("kits.skywars.bogenmeister").equalsIgnoreCase("true")){
            ItemStack bogenmeister = new ItemStack(Material.BOW);
            ItemMeta bogenmeisterMeta = bogenmeister.getItemMeta();
            bogenmeisterMeta.setDisplayName(ChatColor.GOLD+"Bogenmeister");
            ArrayList bogenmeisterLore = new ArrayList();
            bogenmeisterLore.add(ChatColor.GRAY+"1x Bogen");
            bogenmeisterLore.add(ChatColor.GRAY+"8x Pfeile");
            bogenmeisterMeta.setLore(bogenmeisterLore);
            bogenmeister.setItemMeta(bogenmeisterMeta);
            inv.setItem(kits,bogenmeister);
            kits++;
        }

        if(playerConfig.get("kits.skywars.spinne").equalsIgnoreCase("true")){
            ItemStack spinne = new ItemStack(Material.COBWEB);
            ItemMeta spinneMeta = spinne.getItemMeta();
            spinneMeta.setDisplayName(ChatColor.GOLD+"Spinne");
            ArrayList spinneLore = new ArrayList();
            spinneLore.add(ChatColor.GRAY+"5x Spinnennetz");
            spinneLore.add(ChatColor.GRAY+"1x Vergiftung");
            spinneMeta.setLore(spinneLore);
            spinne.setItemMeta(spinneMeta);
            inv.setItem(kits,spinne);
            kits++;
        }

        if(playerConfig.get("kits.skywars.ritter").equalsIgnoreCase("true")){
            ItemStack ritter = new ItemStack(Material.IRON_SWORD);
            ItemMeta ritterMeta = ritter.getItemMeta();
            ritterMeta.setDisplayName(ChatColor.GOLD+"Ritter");
            ArrayList ritterLore = new ArrayList();
            ritterLore.add(ChatColor.GRAY+"1x Eisenschwert");
            ritterLore.add(ChatColor.GRAY+"1x Eisenaxt");
            ritterMeta.setLore(ritterLore);
            ritter.setItemMeta(ritterMeta);
            inv.setItem(kits,ritter);
            kits++;
        }

        if(playerConfig.get("kits.skywars.sensenman").equalsIgnoreCase("true")){
            ItemStack sensenman = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta sensenmanMeta = sensenman.getItemMeta();
            sensenmanMeta.setDisplayName(ChatColor.GOLD+"Sensenman");
            ArrayList sensenmanLore = new ArrayList();
            sensenmanLore.add(ChatColor.GRAY+"1x Diamantharke");
            sensenmanLore.add(ChatColor.GRAY+"1x Schwarze Lederrüstung(Komplett)");
            sensenmanLore.add(ChatColor.GRAY+"1x Schnelligkeit");
            sensenmanMeta.setLore(sensenmanLore);
            sensenman.setItemMeta(sensenmanMeta);
            inv.setItem(kits,sensenman);
            kits++;
        }

        if(playerConfig.get("kits.skywars.starter").equalsIgnoreCase("true")){
            ItemStack ritter = new ItemStack(Material.WOODEN_SWORD);
            ItemMeta ritterMeta = ritter.getItemMeta();
            ritterMeta.setDisplayName(ChatColor.GOLD+"Anfänger");
            ArrayList ritterLore = new ArrayList();
            ritterLore.add(ChatColor.GRAY+"1x Holzschwert");
            ritterLore.add(ChatColor.GRAY+"1x Holzspitzhacke");
            ritterLore.add(ChatColor.GRAY+"1x Holzaxt");
            ritterMeta.setLore(ritterLore);
            ritter.setItemMeta(ritterMeta);
            inv.setItem(kits,ritter);
            kits++;
        }
    }
}
