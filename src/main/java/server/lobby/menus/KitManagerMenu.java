package server.lobby.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KitManagerMenu {

    public KitManagerMenu(Player player){
        Inventory inv = Bukkit.createInventory(null,3*9, ChatColor.GOLD+"Kit-Manager");

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Schließen");
        close.setItemMeta(closeMeta);

        ItemStack skywars = new ItemStack(Material.IRON_SWORD);
        ItemMeta skywarsMeta = skywars.getItemMeta();
        skywarsMeta.setDisplayName(ChatColor.GOLD+"Skywars-Kits");
        skywars.setItemMeta(skywarsMeta);

        ItemStack bedwars = new ItemStack(Material.RED_BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName(ChatColor.GOLD+"Bedwars-Kits");
        ArrayList bedwarsLore = new ArrayList();
        bedwarsLore.add(ChatColor.RED+"Nicht verfügbar");
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack lootbox = new ItemStack(Material.CHEST);
        ItemMeta lootboxMeta = lootbox.getItemMeta();
        lootboxMeta.setDisplayName(ChatColor.GOLD+"Lootboxen öffnen");
        ArrayList lootboxLore = new ArrayList();
        lootbox.setItemMeta(lootboxMeta);

        inv.setItem(12,skywars);
        inv.setItem(14,bedwars);
        inv.setItem(18,lootbox);
        inv.setItem(26,close);
        player.openInventory(inv);
    }
}
