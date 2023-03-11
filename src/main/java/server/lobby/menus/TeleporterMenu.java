package server.lobby.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeleporterMenu {

    public TeleporterMenu(Player player){
        ItemStack spawn = new ItemStack(Material.COMPASS);
        ItemMeta spawnMeta = spawn.getItemMeta();
        spawnMeta.setDisplayName(ChatColor.GOLD+"Spawn");
        ArrayList spawnLore = new ArrayList();
        spawnLore.add(ChatColor.GREEN+"Erreichbar");
        spawnMeta.setLore(spawnLore);
        spawn.setItemMeta(spawnMeta);

        ItemStack bedwars = new ItemStack(Material.RED_BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName(ChatColor.GOLD+"Bedwars");
        ArrayList bedwarsLore = new ArrayList();
        bedwarsLore.add(ChatColor.GREEN+"Erreichbar");
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack skywars = new ItemStack(Material.IRON_SWORD);
        ItemMeta skywarsMeta = skywars.getItemMeta();
        skywarsMeta.setDisplayName(ChatColor.GOLD+"Skywars");
        ArrayList skywarsLore = new ArrayList();
        skywarsLore.add(ChatColor.GREEN+"Erreichbar");
        skywarsMeta.setLore(skywarsLore);
        skywars.setItemMeta(skywarsMeta);

        ItemStack stickBattle = new ItemStack(Material.STICK);
        ItemMeta stickBattleMeta = stickBattle.getItemMeta();
        stickBattleMeta.setDisplayName(ChatColor.GOLD+"Stick-Battle");
        stickBattleMeta.addEnchant(Enchantment.KNOCKBACK,5,true);
        ArrayList stickBattleLore = new ArrayList();
        stickBattleLore.add(ChatColor.RED+"Nicht Erreichbar");
        stickBattleMeta.setLore(stickBattleLore);
        stickBattle.setItemMeta(stickBattleMeta);

        ItemStack tntRun = new ItemStack(Material.TNT);
        ItemMeta tntRunMeta = tntRun.getItemMeta();
        tntRunMeta.setDisplayName(ChatColor.GOLD+"TNT-Run");
        ArrayList tntRunLore = new ArrayList();
        tntRunLore.add(ChatColor.RED+"Nicht Erreichbar");
        tntRunMeta.setLore(tntRunLore);
        tntRun.setItemMeta(tntRunMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Schließen");
        close.setItemMeta(closeMeta);

        Inventory inv = Bukkit.createInventory(null,3*9,ChatColor.GOLD+"Teleporter");
        inv.setItem(11,spawn);
        inv.setItem(12,bedwars);
        inv.setItem(13,skywars);
        inv.setItem(14,stickBattle);
        inv.setItem(15, tntRun);
        inv.setItem(26,close);

        player.openInventory(inv);
    }
}
