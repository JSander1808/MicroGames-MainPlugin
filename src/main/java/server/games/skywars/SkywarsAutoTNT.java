package server.games.skywars;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SkywarsAutoTNT implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if(event.getPlayer() instanceof Player){
            Player player = event.getPlayer();
            if(player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Skywars/Server4/server/")){
                if(event.getBlock().getType()==Material.TNT){
                    Location location = event.getBlock().getLocation();
                    location.getBlock().setType(Material.AIR);
                    location.getWorld().spawnEntity(location, EntityType.PRIMED_TNT);
                }
            }
        }
    }
}
