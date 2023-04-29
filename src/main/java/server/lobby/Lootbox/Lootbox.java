package server.lobby.Lootbox;

import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import server.general.Config;
import server.main.Main;

import java.util.ArrayList;

public class Lootbox {

    private ArmorStand armorStand1;
    private ArmorStand armorStand2;
    private Location location;
    public int TaskID;
    public int temp;
    public int rolls = 20;

    public Lootbox(Location location){
        this.location=location;
        armorStand1 = (ArmorStand) Bukkit.getWorld(location.getWorld().getUID()).spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand1.setCustomNameVisible(true);
        armorStand1.setVisible(false);
        armorStand1.setGravity(false);
        armorStand1.setCanPickupItems(false);
        armorStand1.setCustomName(ChatColor.GOLD+"LootBoxen Öffnen");

        Config serverConfig = new Config("serverstats/shop/lootbox.conf");
        if(!serverConfig.get("sale").equalsIgnoreCase("0")){
            Location saleLocation = new Location(location.getWorld(), location.getX(),location.getY()-0.25,location.getZ());
            armorStand2 = (ArmorStand) Bukkit.getWorld(location.getWorld().getUID()).spawnEntity(saleLocation, EntityType.ARMOR_STAND);
            armorStand2.setCustomNameVisible(true);
            armorStand2.setVisible(false);
            armorStand2.setGravity(false);
            armorStand2.setCanPickupItems(false);
            armorStand2.setCustomName(ChatColor.GOLD+serverConfig.get("sale")+"% "+ChatColor.GREEN+"Rabatt");
        }
    }

    public void openLootBox(Player player){
        Inventory inv = Bukkit.createInventory(null,3*9,ChatColor.GOLD+"Lootboxen");
        Config playerConfig = new Config("playerstats/"+player.getName()+".conf");

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Schließen");
        close.setItemMeta(closeMeta);

        ItemStack openLootbox = null;

        if(Integer.valueOf(playerConfig.get("shop.lootbox.amount"))>=1){
            openLootbox = new ItemStack(Material.CHEST);
            openLootbox.setAmount(Integer.valueOf(playerConfig.get("shop.lootbox.amount")));
            ItemMeta openLootboxMeta = openLootbox.getItemMeta();
            openLootboxMeta.setDisplayName(ChatColor.GOLD+"Lootbox Öffnen");
            ArrayList openLootboxLore = new ArrayList();
            openLootboxLore.add(ChatColor.BLUE+"Lootboxen verfügbar: "+ChatColor.GOLD+playerConfig.get("shop.lootbox.amount"));
            openLootboxMeta.setLore(openLootboxLore);
            openLootbox.setItemMeta(openLootboxMeta);
        }else{
            openLootbox = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta openLootboxMeta = openLootbox.getItemMeta();
            openLootboxMeta.setDisplayName(ChatColor.RED+"Du hast gerade kein Lootbox");
            openLootbox.setItemMeta(openLootboxMeta);
        }
        ItemStack buyLootbox = new ItemStack(Material.CHEST);

        Config serverConfig = new Config("serverstats/shop/lootbox.conf");
        if(serverConfig.get("sale").equalsIgnoreCase("0")){
            ItemMeta buyLootboxMeta = buyLootbox.getItemMeta();
            buyLootboxMeta.setDisplayName(ChatColor.GOLD+"Lootbox Kaufen");
            ArrayList buyLootboxLore = new ArrayList();
            buyLootboxLore.add(ChatColor.BLUE+"Lootbox kaufen für: "+ChatColor.GREEN+serverConfig.get("lootboxCost")+" Coins");
            buyLootboxMeta.setLore(buyLootboxLore);
            buyLootbox.setItemMeta(buyLootboxMeta);
        }else{
            ItemMeta buyLootboxMeta = buyLootbox.getItemMeta();
            buyLootboxMeta.setDisplayName(ChatColor.GOLD+"Lootbox Kaufen");
            ArrayList buyLootboxLore = new ArrayList();
            int lootboxCost = Integer.valueOf(serverConfig.get("lootboxCost"));
            int sale = Integer.valueOf(serverConfig.get("sale"));
            int saledCost = lootboxCost-((lootboxCost*sale)/100);
            buyLootboxLore.add(ChatColor.BLUE+"Lootbox kaufen für: "+ChatColor.RED+ChatColor.STRIKETHROUGH+serverConfig.get("lootboxCost")+ChatColor.RESET+ChatColor.GRAY+" -> "+ChatColor.GREEN+saledCost+ChatColor.GOLD+" Coins");
            buyLootboxLore.add(ChatColor.GREEN+"Rabatt: "+ChatColor.GOLD+sale+"%");
            buyLootboxMeta.setLore(buyLootboxLore);
            buyLootbox.setItemMeta(buyLootboxMeta);
        }

        inv.setItem(11,openLootbox);
        inv.setItem(15, buyLootbox);
        inv.setItem(26,close);

        player.openInventory(inv);
    }

    public void remove(){
        armorStand1.remove();
        armorStand2.remove();
    }
}
