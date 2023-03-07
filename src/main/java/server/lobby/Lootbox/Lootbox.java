package server.lobby.Lootbox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Lootbox {

    private ArmorStand armorStand;
    private Location location;

    public Lootbox(Location location){
        this.location=location;
        armorStand = (ArmorStand) Bukkit.getWorld(location.getWorld().getUID()).spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setCustomNameVisible(true);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);
        armorStand.setCustomName(ChatColor.GOLD+"LootBoxen Öffnen");
    }

    public void openLootBox(Player player){

        player.sendMessage(ChatColor.RED+"Lootboxen sind noch nicht verfügbar.");
    }

    public void remove(){
        armorStand.remove();
    }
}
