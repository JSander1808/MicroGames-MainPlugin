package server.games.bedwars;

import org.bukkit.*;
import org.bukkit.block.data.type.Bed;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import server.lobby.general.Matchmaking;
import server.main.Main;

public class BedwarsListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
            if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
                if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Bedwars-Shop")){
                    if(event.getRawSlot()<54) {
                        event.setCancelled(true);
                        switch (event.getCurrentItem().getType()) {
                            default:
                                new BedwarsShop(player);
                                break;
                            case STONE_SWORD:
                                if (removeIron(BedwarsShop.stoneSwordCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.STONE_SWORD));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case IRON_SWORD:
                                if (removeGold(BedwarsShop.ironSwordCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.IRON_SWORD));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case DIAMOND_SWORD:
                                if (removeDiamond(BedwarsShop.diamondSwordCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.DIAMOND_SWORD));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case STONE_PICKAXE:
                                if (removeIron(BedwarsShop.stonePickaxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.STONE_PICKAXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case IRON_PICKAXE:
                                if (removeGold(BedwarsShop.ironPickaxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.IRON_PICKAXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case DIAMOND_PICKAXE:
                                if (removeDiamond(BedwarsShop.diamondPickaxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.DIAMOND_PICKAXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case STONE_AXE:
                                if (removeIron(BedwarsShop.stoneAxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.STONE_AXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case IRON_AXE:
                                if (removeGold(BedwarsShop.ironAxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.IRON_AXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case DIAMOND_AXE:
                                if (removeDiamond(BedwarsShop.diamondAxeCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.DIAMOND_AXE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case IRON_CHESTPLATE:
                                if (removeIron(BedwarsShop.ironChestplateCost, player)) {
                                    player.getInventory().setItem(36, new ItemStack(Material.IRON_BOOTS));
                                    player.getInventory().setItem(37, new ItemStack(Material.IRON_LEGGINGS));
                                    player.getInventory().setItem(38, new ItemStack(Material.IRON_CHESTPLATE));
                                    player.getInventory().setItem(39, new ItemStack(Material.IRON_HELMET));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case DIAMOND_CHESTPLATE:
                                if (removeGold(BedwarsShop.diamondChestplateCost, player)) {
                                    player.getInventory().setItem(36, new ItemStack(Material.DIAMOND_BOOTS));
                                    player.getInventory().setItem(37, new ItemStack(Material.DIAMOND_LEGGINGS));
                                    player.getInventory().setItem(38, new ItemStack(Material.DIAMOND_CHESTPLATE));
                                    player.getInventory().setItem(39, new ItemStack(Material.DIAMOND_HELMET));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case NETHERITE_CHESTPLATE:
                                if (removeDiamond(BedwarsShop.netherideChestplateCost, player)) {
                                    player.getInventory().setItem(36, new ItemStack(Material.NETHERITE_BOOTS));
                                    player.getInventory().setItem(37, new ItemStack(Material.NETHERITE_LEGGINGS));
                                    player.getInventory().setItem(38, new ItemStack(Material.NETHERITE_CHESTPLATE));
                                    player.getInventory().setItem(39, new ItemStack(Material.NETHERITE_HELMET));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case SPLASH_POTION:
                                Potion potion = Potion.fromItemStack(event.getCurrentItem());
                                if (potion.getType() == PotionType.INSTANT_DAMAGE) {
                                    if (removeGold(BedwarsShop.instantDamageCost, player)) {
                                        Potion instantDamage = new Potion(PotionType.INSTANT_DAMAGE);
                                        givePlayerItem(player, instantDamage.toItemStack(1));
                                    } else {
                                        player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                    }
                                } else if (potion.getType() == PotionType.INVISIBILITY) {
                                    if (removeGold(BedwarsShop.invisibleCost, player)) {
                                        Potion instantDamage = new Potion(PotionType.INVISIBILITY);
                                        givePlayerItem(player, instantDamage.toItemStack(1));
                                    } else {
                                        player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                    }
                                }
                                new BedwarsShop(player);
                                break;
                            case BOW:
                                if (removeGold(BedwarsShop.bowCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.BOW));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case SHIELD:
                                if (removeIron(BedwarsShop.shieldCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.SHIELD));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case RED_WOOL:
                                if (removeIron(BedwarsShop.woolCost, player)) {
                                    ItemStack wool = new ItemStack(Material.RED_WOOL);
                                    wool.setAmount(16);
                                    givePlayerItem(player, wool);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case YELLOW_WOOL:
                                if (removeIron(BedwarsShop.woolCost, player)) {
                                    ItemStack wool = new ItemStack(Material.YELLOW_WOOL);
                                    wool.setAmount(16);
                                    givePlayerItem(player, wool);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case GREEN_WOOL:
                                if (removeIron(BedwarsShop.woolCost, player)) {
                                    ItemStack wool = new ItemStack(Material.GREEN_WOOL);
                                    wool.setAmount(16);
                                    givePlayerItem(player, wool);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case BLUE_WOOL:
                                if (removeIron(BedwarsShop.woolCost, player)) {
                                    ItemStack wool = new ItemStack(Material.BLUE_WOOL);
                                    wool.setAmount(16);
                                    givePlayerItem(player, wool);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case STONE:
                                if (removeGold(BedwarsShop.stoneCost, player)) {
                                    ItemStack stone = new ItemStack(Material.STONE);
                                    stone.setAmount(16);
                                    givePlayerItem(player, stone);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case BRICKS:
                                if (removeGold(BedwarsShop.bricksCost, player)) {
                                    ItemStack bricks = new ItemStack(Material.BRICKS);
                                    bricks.setAmount(16);
                                    givePlayerItem(player, bricks);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case END_STONE:
                                if (removeDiamond(BedwarsShop.endstoneCost, player)) {
                                    ItemStack endstone = new ItemStack(Material.END_STONE);
                                    endstone.setAmount(16);
                                    givePlayerItem(player, endstone);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case STICK:
                                if (removeGold(BedwarsShop.knockbackStickCost, player)) {
                                    ItemStack stick = new ItemStack(Material.STICK);
                                    ItemMeta stickMeta = stick.getItemMeta();
                                    stickMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
                                    stick.setItemMeta(stickMeta);
                                    givePlayerItem(player, stick);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case ENDER_PEARL:
                                if (removeDiamond(BedwarsShop.enderperlCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.ENDER_PEARL));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case FISHING_ROD:
                                if (removeGold(BedwarsShop.fishingrotCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.FISHING_ROD));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case SHEARS:
                                if (removeIron(BedwarsShop.shearCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.SHEARS));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case ARROW:
                                if (removeGold(BedwarsShop.arrowCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.ARROW));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case SNOWBALL:
                                if (removeIron(BedwarsShop.snowballCost, player)) {
                                    ItemStack snowball = new ItemStack(Material.SNOWBALL);
                                    snowball.setAmount(8);
                                    givePlayerItem(player, snowball);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case COOKED_BEEF:
                                if (removeIron(BedwarsShop.steakCost, player)) {
                                    ItemStack steak = new ItemStack(Material.COOKED_BEEF);
                                    steak.setAmount(16);
                                    givePlayerItem(player, steak);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case GOLDEN_APPLE:
                                if (removeDiamond(BedwarsShop.goldappleCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.GOLDEN_APPLE));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case LAVA_BUCKET:
                                if (removeGold(BedwarsShop.lavabukkitCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.LAVA_BUCKET));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case FLINT_AND_STEEL:
                                if (removeIron(BedwarsShop.flintandsteelCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.FLINT_AND_STEEL));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case WATER_BUCKET:
                                if (removeGold(BedwarsShop.waterbukkitCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.WATER_BUCKET));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case COBWEB:
                                if (removeIron(BedwarsShop.cobwebCost, player)) {
                                    ItemStack cobweb = new ItemStack(Material.COBWEB);
                                    cobweb.setAmount(5);
                                    givePlayerItem(player, cobweb);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case TOTEM_OF_UNDYING:
                                if (removeDiamond(BedwarsShop.totemCost, player)) {
                                    givePlayerItem(player, new ItemStack(Material.TOTEM_OF_UNDYING));
                                } else {
                                    player.sendMessage(ChatColor.RED + "Das kannst du dir nicht kaufen");
                                }
                                new BedwarsShop(player);
                                break;
                            case BARRIER:
                                player.closeInventory();
                                break;
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 15, 2);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            if(event.getRightClicked() instanceof Villager){
                new BedwarsShop(player);
            }
        }
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            if(event.getClickedBlock()!=null){
                if(event.getClickedBlock().getType()==Material.SPRUCE_TRAPDOOR||event.getClickedBlock().getType()==Material.BIRCH_TRAPDOOR){
                    event.setCancelled(true);
                }
                if(event.getClickedBlock().getType()==Material.RED_BED&&event.getAction()==Action.RIGHT_CLICK_BLOCK){
                    event.setCancelled(true);
                }
                if(event.getClickedBlock().getType()==Material.GREEN_BED&&event.getAction()==Action.RIGHT_CLICK_BLOCK){
                    event.setCancelled(true);
                }
                if(event.getClickedBlock().getType()==Material.YELLOW_BED&&event.getAction()==Action.RIGHT_CLICK_BLOCK){
                    event.setCancelled(true);
                }
                if(event.getClickedBlock().getType()==Material.BLUE_BED&&event.getAction()==Action.RIGHT_CLICK_BLOCK){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")||player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            if(!(event.getBlock().getType()==Material.RED_BED||event.getBlock().getType()==Material.CACTUS||event.getBlock().getType()==Material.DEAD_BUSH||event.getBlock().getType()==Material.YELLOW_BED||event.getBlock().getType()==Material.BLUE_BED||event.getBlock().getType()==Material.GREEN_BED||event.getBlock().getType()==Material.RED_WOOL||event.getBlock().getType()==Material.BLUE_WOOL||event.getBlock().getType()==Material.GREEN_WOOL||event.getBlock().getType()==Material.YELLOW_WOOL||event.getBlock().getType()==Material.STONE||event.getBlock().getType()==Material.BRICKS||event.getBlock().getType()==Material.END_STONE)){
                event.setCancelled(true);
            }
            if(event.getBlock().getType()==Material.RED_BED){
                if(!getTeamColor(player).equalsIgnoreCase("red")){
                    bedDestroyed(player, event.getBlock());
                }else{
                    event.setCancelled(true);
                }
            }
            if(event.getBlock().getType()==Material.YELLOW_BED){
                if(!getTeamColor(player).equalsIgnoreCase("yellow")){
                    bedDestroyed(player, event.getBlock());
                }else{
                    event.setCancelled(true);
                }
            }
            if(event.getBlock().getType()==Material.BLUE_BED){
                if(!getTeamColor(player).equalsIgnoreCase("blue")){
                    bedDestroyed(player, event.getBlock());
                }else{
                    event.setCancelled(true);
                }
            }
            if(event.getBlock().getType()==Material.GREEN_BED){
                if(!getTeamColor(player).equalsIgnoreCase("green")){
                    bedDestroyed(player, event.getBlock());
                }else{
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onSpawnItem(ItemSpawnEvent event){
        if(event.getEntity().getItemStack().getType()==Material.RED_BED||event.getEntity().getItemStack().getType()==Material.GREEN_BED||event.getEntity().getItemStack().getType()==Material.YELLOW_BED||event.getEntity().getItemStack().getType()==Material.BLUE_BED){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Villager){
            event.setCancelled(true);
        }
        if(event.getEntity() instanceof Player){
            Player player = ((Player) event.getEntity()).getPlayer();
            if(player.getHealth()-event.getDamage()<=0){
                event.setCancelled(true);
                if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
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
                    int serverMap = BedwarsHandler.BedwarsServerMap[0];
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    if(existBed(player,serverMap)){
                        new BedwarsRespawnPlayer(player,serverMap);
                    }else{
                        Matchmaking.removePlayerFromMatchmaking(player);
                        for(Player worldPlayer : player.getWorld().getPlayers()){
                            worldPlayer.sendMessage(ChatColor.GRAY+player.getName()+" ist ausgeschieden.");
                        }
                        if(!existOtherPlayerAliveInTeam(player)){
                            BedwarsManager.updateBedwarsLobby(player.getWorld().getName());
                        }
                    }
                }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
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
                    int serverMap = BedwarsHandler.BedwarsServerMap[1];
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    if(existBed(player,serverMap)){
                        new BedwarsRespawnPlayer(player,serverMap);
                    }else{
                        Matchmaking.removePlayerFromMatchmaking(player);
                        for(Player worldPlayer : player.getWorld().getPlayers()){
                            worldPlayer.sendMessage(ChatColor.GRAY+player.getName()+" ist ausgeschieden.");
                        }
                        if(!existOtherPlayerAliveInTeam(player)){
                            BedwarsManager.updateBedwarsLobby(player.getWorld().getName());
                        }
                    }
                }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
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
                    int serverMap = BedwarsHandler.BedwarsServerMap[2];
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    if(existBed(player,serverMap)){
                        new BedwarsRespawnPlayer(player,serverMap);
                    }else{
                        Matchmaking.removePlayerFromMatchmaking(player);
                        for(Player worldPlayer : player.getWorld().getPlayers()){
                            worldPlayer.sendMessage(ChatColor.GRAY+player.getName()+" ist ausgeschieden.");
                        }
                        if(!existOtherPlayerAliveInTeam(player)){
                            BedwarsManager.updateBedwarsLobby(player.getWorld().getName());
                        }
                    }
                }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
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
                    int serverMap = BedwarsHandler.BedwarsServerMap[3];
                    player.teleport(player.getWorld().getSpawnLocation());
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    if(existBed(player,serverMap)){
                        new BedwarsRespawnPlayer(player,serverMap);
                    }else{
                        Matchmaking.removePlayerFromMatchmaking(player);
                        for(Player worldPlayer : player.getWorld().getPlayers()){
                            worldPlayer.sendMessage(ChatColor.GRAY+player.getName()+" ist ausgeschieden.");
                        }
                        if(!existOtherPlayerAliveInTeam(player)){
                            BedwarsManager.updateBedwarsLobby(player.getWorld().getName());
                        }
                    }
                }
            }
        }
    }

    public boolean existBed(Player player, int serverMap){
        if(serverMap==1){
            String team = getTeamColor(player);
            if(team!=null){
                if(team.equalsIgnoreCase("red")){
                    if(player.getWorld().getBlockAt(88,3,88).getType()==Material.RED_BED) return true;
                    return false;
                }else if(team.equalsIgnoreCase("blue")){
                    if(player.getWorld().getBlockAt(9,3,167).getType()==Material.BLUE_BED) return true;
                    return false;
                }else if(team.equalsIgnoreCase("yellow")){
                    if(player.getWorld().getBlockAt(-70,3,88).getType()==Material.YELLOW_BED) return true;
                    return false;
                }else if(team.equalsIgnoreCase("green")){
                    if(player.getWorld().getBlockAt(9,3,9).getType()==Material.GREEN_BED) return true;
                    return false;
                }
            }
        }
        if(serverMap==2){
            String team = getTeamColor(player);
            if(team!=null){
                if(team.equalsIgnoreCase("red")){
                    if(player.getWorld().getBlockAt(8,0,-91).getType()==Material.RED_BED) return true;
                    return false;
                }else if(team.equalsIgnoreCase("blue")){
                    if(player.getWorld().getBlockAt(8,0,7).getType()==Material.YELLOW_BED) return true;
                    return false;
                }
            }
        }
        return false;
    }

    public void bedDestroyed(Player player, org.bukkit.block.Block block){
        for(Player worldPlayer : player.getWorld().getPlayers()){
            if(block.getType()==Material.RED_BED){
                worldPlayer.sendTitle(ChatColor.RED+"Bett zerstört!",ChatColor.BLUE+"Team Rot kann nun nicht mehr respawnen");
            }
            if(block.getType()==Material.GREEN_BED){
                worldPlayer.sendTitle(ChatColor.RED+"Bett zerstört!",ChatColor.BLUE+"Team Grün kann nun nicht mehr respawnen");
            }
            if(block.getType()==Material.YELLOW_BED){
                worldPlayer.sendTitle(ChatColor.RED+"Bett zerstört!",ChatColor.BLUE+"Team Gelb kann nun nicht mehr respawnen");
            }
            if(block.getType()==Material.BLUE_BED){
                worldPlayer.sendTitle(ChatColor.RED+"Bett zerstört!",ChatColor.BLUE+"Team Blau kann nun nicht mehr respawnen");
            }
        }
    }

    public String getTeamColor(Player player){
        String team = null;
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            Scoreboard scoreboard = player.getScoreboard();
            if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().contains(player)){
                team = "red";
            }else if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().contains(player)){
                team = "yellow";
            }else if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().contains(player)){
                team = "blue";
            }else if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().contains(player)){
                team = "green";
            }
        }
        return team;
    }

    public Team getBedwarsTeam(Player player){
        Scoreboard scoreboard = player.getScoreboard();
        Team team = null;
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            if(scoreboard.getTeam("bedwarsServer1TeamRed").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer1TeamRed");
            }else if(scoreboard.getTeam("bedwarsServer1TeamYellow").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer1TeamYellow");
            }else if(scoreboard.getTeam("bedwarsServer1TeamBlue").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer1TeamBlue");
            }else if(scoreboard.getTeam("bedwarsServer1TeamGreen").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer1TeamGreen");
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            if(scoreboard.getTeam("bedwarsServer2TeamRed").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer2TeamRed");
            }else if(scoreboard.getTeam("bedwarsServer2TeamYellow").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer2TeamYellow");
            }else if(scoreboard.getTeam("bedwarsServer2TeamBlue").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer2TeamBlue");
            }else if(scoreboard.getTeam("bedwarsServer2TeamGreen").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer2TeamGreen");
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            if(scoreboard.getTeam("bedwarsServer3TeamRed").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer3TeamRed");
            }else if(scoreboard.getTeam("bedwarsServer3TeamYellow").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer3TeamYellow");
            }else if(scoreboard.getTeam("bedwarsServer3TeamBlue").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer3TeamBlue");
            }else if(scoreboard.getTeam("bedwarsServer3TeamGreen").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer3TeamGreen");
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            if(scoreboard.getTeam("bedwarsServer4TeamRed").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer4TeamRed");
            }else if(scoreboard.getTeam("bedwarsServer4TeamYellow").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer4TeamYellow");
            }else if(scoreboard.getTeam("bedwarsServer4TeamBlue").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer4TeamBlue");
            }else if(scoreboard.getTeam("bedwarsServer4TeamGreen").getPlayers().contains(player)){
                team = scoreboard.getTeam("bedwarsServer4TeamGreen");
            }
        }
        return team;
    }

    public boolean existOtherPlayerAliveInTeam(Player player){
        Team team = getBedwarsTeam(player);
        int AlivePlayers = 0;
        if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server1/server/")){
            for(int i = 0;i<team.getPlayers().size();i++){
                if(team.getPlayers().contains(Matchmaking.bedwarsServer1.get(i))){
                    AlivePlayers++;
                }
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server2/server/")){
            for(int i = 0;i<team.getPlayers().size();i++){
                if(team.getPlayers().contains(Matchmaking.bedwarsServer2.get(i))){
                    AlivePlayers++;
                }
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server3/server/")){
            for(int i = 0;i<team.getPlayers().size();i++){
                if(team.getPlayers().contains(Matchmaking.bedwarsServer3.get(i))){
                    AlivePlayers++;
                }
            }
        }else if(player.getWorld().getName().equalsIgnoreCase("GameServer/Bedwars/Server4/server/")){
            for(int i = 0;i<team.getPlayers().size();i++){
                if(team.getPlayers().contains(Matchmaking.bedwarsServer4.get(i))){
                    AlivePlayers++;
                }
            }
        }
        if(AlivePlayers-1>=1){
            return true;
        }else{
            return false;
        }
    }

    public void givePlayerItem(Player player, ItemStack item){
        player.getInventory().addItem(item);
    }

    public boolean removeIron(int amount, Player player){
        if(amount<=getIron(player)){
            int buy = amount;
            for(int i = 0;i<36;i++){
                if(player.getInventory().getItem(i)!=null){
                    if(player.getInventory().getItem(i).getType()==Material.IRON_INGOT){
                        if(buy>=1){
                            if(player.getInventory().getItem(i).getAmount()>=buy){
                                player.getInventory().getItem(i).setAmount(player.getInventory().getItem(i).getAmount()-buy);
                            }else{
                                buy -= player.getInventory().getItem(i).getAmount();
                                player.getInventory().setItem(i,null);
                            }
                        }
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean removeGold(int amount, Player player){
        if(amount<=getGold(player)){
            int buy = amount;
            for(int i = 0;i<36;i++){
                if(player.getInventory().getItem(i)!=null){
                    if(player.getInventory().getItem(i).getType()==Material.GOLD_INGOT){
                        if(buy>=1){
                            if(player.getInventory().getItem(i).getAmount()>=buy){
                                player.getInventory().getItem(i).setAmount(player.getInventory().getItem(i).getAmount()-buy);
                            }else{
                                buy -= player.getInventory().getItem(i).getAmount();
                                player.getInventory().setItem(i,null);
                            }
                        }
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean removeDiamond(int amount, Player player){
        if(amount<=getDiamond(player)){
            int buy = amount;
            for(int i = 0;i<36;i++){
                if(player.getInventory().getItem(i)!=null){
                    if(player.getInventory().getItem(i).getType()==Material.DIAMOND){
                        if(buy>=1){
                            if(player.getInventory().getItem(i).getAmount()>=buy){
                                player.getInventory().getItem(i).setAmount(player.getInventory().getItem(i).getAmount()-buy);
                            }else{
                                buy -= player.getInventory().getItem(i).getAmount();
                                player.getInventory().setItem(i,null);
                            }
                        }
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public int getIron(Player player){
        int iron = 0;
        Inventory inv = player.getInventory();
        for(int i = 0;i<36;i++){
            if(inv.getItem(i)!=null){
                if(inv.getItem(i).getType()==Material.IRON_INGOT){
                    iron += inv.getItem(i).getAmount();
                }
            }
        }
        return iron;
    }
    public int getGold(Player player){
        int gold = 0;
        Inventory inv = player.getInventory();
        for(int i = 0;i<36;i++){
            if(inv.getItem(i)!=null){
                if(inv.getItem(i).getType()==Material.GOLD_INGOT){
                    gold += inv.getItem(i).getAmount();
                }
            }
        }
        return gold;
    }
    public int getDiamond(Player player){
        int diamond = 0;
        Inventory inv = player.getInventory();
        for(int i = 0;i<36;i++){
            if(inv.getItem(i)!=null){
                if(inv.getItem(i).getType()==Material.DIAMOND){
                    diamond += inv.getItem(i).getAmount();
                }
            }
        }
        return diamond;
    }
}
