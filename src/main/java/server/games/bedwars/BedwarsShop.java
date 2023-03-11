package server.games.bedwars;

import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class BedwarsShop {

    //---------------------------------------------------------------------------IRON------------------------------------------------------------------------------------------------
    public static int stoneSwordCost = 10;
    public static int stonePickaxeCost = 10;
    public static int stoneAxeCost = 10;
    public static int ironChestplateCost = 25;
    public static int shieldCost = 5;
    public static int woolCost = 5;
    public static int shearCost = 3;
    public static int snowballCost = 10;
    public static int steakCost = 15;
    public static int flintandsteelCost = 12;
    public static int cobwebCost = 15;
    //---------------------------------------------------------------------------GOLD------------------------------------------------------------------------------------------------
    public static int ironSwordCost = 7;
    public static int waterbukkitCost = 3;
    public static int arrowCost = 2;
    public static int ironPickaxeCost = 7;
    public static int ironAxeCost = 7;
    public static int diamondChestplateCost = 25;
    public static int instantDamageCost = 17;
    public static int invisibleCost = 15;
    public static int bowCost = 10;
    public static int stoneCost = 5;
    public static int bricksCost = 5;
    public static int knockbackStickCost = 20;
    public static int fishingrotCost = 2;
    public static int lavabukkitCost = 7;
    //---------------------------------------------------------------------------DIAMOND------------------------------------------------------------------------------------------------
    public static int diamondSwordCost = 5;
    public static int diamondPickaxeCost = 5;
    public static int diamondAxeCost = 5;
    public static int netherideChestplateCost = 15;
    public static int endstoneCost = 7;
    public static int enderperlCost = 5;
    public static int goldappleCost = 10;
    public static int totemCost = 35;


    public BedwarsShop(Player player){
        int iron = getIron(player);
        int gold = getGold(player);
        int diamond = getDiamond(player);
        String team = "red";

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
        System.out.println(team);

        Inventory inv = Bukkit.createInventory(null,6*9,ChatColor.GOLD+"Bedwars-Shop");

        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
        ItemMeta stoneSwordMeta = stoneSword.getItemMeta();
        stoneSwordMeta.setDisplayName(ChatColor.GOLD+"Steinschwert Kaufen");
        ArrayList stoneSwordLore = new ArrayList();
        stoneSwordLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+stoneSwordCost+" Eisen");
        if(iron>=stoneSwordCost){
            stoneSwordLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            stoneSwordLore.add(ChatColor.RED+"Nicht genügent Eisen.");
        }
        stoneSwordMeta.setLore(stoneSwordLore);
        stoneSword.setItemMeta(stoneSwordMeta);

        ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
        ironSword.setAmount(2);
        ItemMeta ironSwordMeta = ironSword.getItemMeta();
        ironSwordMeta.setDisplayName(ChatColor.GOLD+"Eisenschwert Kaufen");
        ArrayList ironSwordLore = new ArrayList();
        ironSwordLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+ironSwordCost+" Gold");
        if(gold>=ironSwordCost){
            ironSwordLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            ironSwordLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        ironSwordMeta.setLore(ironSwordLore);
        ironSword.setItemMeta(ironSwordMeta);

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        diamondSword.setAmount(3);
        ItemMeta diamondSwordMeta = diamondSword.getItemMeta();
        diamondSwordMeta.setDisplayName(ChatColor.GOLD+"Diamantschwert Kaufen");
        ArrayList diamondSwordLore = new ArrayList();
        diamondSwordLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+diamondSwordCost+" Diamanten");
        if(diamond>=diamondSwordCost){
            diamondSwordLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            diamondSwordLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        diamondSwordMeta.setLore(diamondSwordLore);
        diamondSword.setItemMeta(diamondSwordMeta);

        ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta stonePickaxeMeta = stonePickaxe.getItemMeta();
        stonePickaxeMeta.setDisplayName(ChatColor.GOLD+"Steinspitzhacke Kaufen");
        ArrayList stonePickaxeLore = new ArrayList();
        stonePickaxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+stonePickaxeCost+" Eisen");
        if(iron>=stonePickaxeCost){
            stonePickaxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            stonePickaxeLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        stonePickaxeMeta.setLore(stonePickaxeLore);
        stonePickaxe.setItemMeta(stonePickaxeMeta);

        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
        ironPickaxe.setAmount(2);
        ItemMeta ironPickaxeMeta = ironPickaxe.getItemMeta();
        ironPickaxeMeta.setDisplayName(ChatColor.GOLD+"Eisenspitzhacke Kaufen");
        ArrayList ironPickaxeLore = new ArrayList();
        ironPickaxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+ironPickaxeCost+" Gold");
        if(gold>=ironPickaxeCost){
            ironPickaxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            ironPickaxeLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        ironPickaxeMeta.setLore(ironPickaxeLore);
        ironPickaxe.setItemMeta(ironPickaxeMeta);

        ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        diamondPickaxe.setAmount(3);
        ItemMeta diamondPickaxeMeta = diamondPickaxe.getItemMeta();
        diamondPickaxeMeta.setDisplayName(ChatColor.GOLD+"Diamantspitzhacke Kaufen");
        ArrayList diamondPickaxeLore = new ArrayList();
        diamondPickaxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+diamondPickaxeCost+" Diamanten");
        if(diamond>=diamondPickaxeCost){
            diamondPickaxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            diamondPickaxeLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        diamondPickaxeMeta.setLore(diamondPickaxeLore);
        diamondPickaxe.setItemMeta(diamondPickaxeMeta);

        ItemStack stoneAxe = new ItemStack(Material.STONE_AXE);
        ItemMeta stoneAxeMeta = stoneAxe.getItemMeta();
        stoneAxeMeta.setDisplayName(ChatColor.GOLD+"Steinaxt Kaufen");
        ArrayList stoneAxeLore = new ArrayList();
        stoneAxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+stoneAxeCost+" Eisen");
        if(iron>=stoneAxeCost){
            stoneAxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            stoneAxeLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        stoneAxeMeta.setLore(stoneAxeLore);
        stoneAxe.setItemMeta(stoneAxeMeta);

        ItemStack ironAxe = new ItemStack(Material.IRON_AXE);
        ironAxe.setAmount(2);
        ItemMeta ironAxeMeta = ironAxe.getItemMeta();
        ironAxeMeta.setDisplayName(ChatColor.GOLD+"Eisenaxt Kaufen");
        ArrayList ironAxeLore = new ArrayList();
        ironAxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+ironAxeCost+" Gold");
        if(gold>=ironAxeCost){
            ironAxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            ironAxeLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        ironAxeMeta.setLore(ironAxeLore);
        ironAxe.setItemMeta(ironAxeMeta);

        ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
        diamondAxe.setAmount(3);
        ItemMeta diamondAxeMeta = diamondAxe.getItemMeta();
        diamondAxeMeta.setDisplayName(ChatColor.GOLD+"Diamantaxt Kaufen");
        ArrayList diamondAxeLore = new ArrayList();
        diamondAxeLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+diamondAxeCost+" Diamanten");
        if(diamond>=diamondAxeCost){
            diamondAxeLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            diamondAxeLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        diamondAxeMeta.setLore(diamondAxeLore);
        diamondAxe.setItemMeta(diamondAxeMeta);

        ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta ironChestplateMeta = ironChestplate.getItemMeta();
        ironChestplateMeta.setDisplayName(ChatColor.GOLD+"Eisenrüstung Kaufen");
        ArrayList ironChestplateLore = new ArrayList();
        ironChestplateLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+ironChestplateCost+" Eisen");
        if(iron>=ironChestplateCost){
            ironChestplateLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            ironChestplateLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        ironChestplateMeta.setLore(ironChestplateLore);
        ironChestplate.setItemMeta(ironChestplateMeta);

        ItemStack diamondChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        diamondChestplate.setAmount(2);
        ItemMeta diamondChestplateMeta = diamondChestplate.getItemMeta();
        diamondChestplateMeta.setDisplayName(ChatColor.GOLD+"Diamantrüstung Kaufen");
        ArrayList diamondChestplateLore = new ArrayList();
        diamondChestplateLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+diamondChestplateCost+" Gold");
        if(gold>=diamondChestplateCost){
            diamondChestplateLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            diamondChestplateLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        diamondChestplateMeta.setLore(diamondChestplateLore);
        diamondChestplate.setItemMeta(diamondChestplateMeta);

        ItemStack netherideChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        netherideChestplate.setAmount(3);
        ItemMeta netherideChestplateMeta = netherideChestplate.getItemMeta();
        netherideChestplateMeta.setDisplayName(ChatColor.GOLD+"Netheriterüstung Kaufen");
        ArrayList netherideChestplateLore = new ArrayList();
        netherideChestplateLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+netherideChestplateCost+" Diamanten");
        if(diamond>=netherideChestplateCost){
            netherideChestplateLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            netherideChestplateLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        netherideChestplateMeta.setLore(netherideChestplateLore);
        netherideChestplate.setItemMeta(netherideChestplateMeta);

        Potion instantDamagePotion = new Potion(PotionType.INSTANT_DAMAGE,1);
        instantDamagePotion.setSplash(true);
        ItemStack instantDamage = instantDamagePotion.toItemStack(1);
        ItemMeta instantDamageMeta = instantDamage.getItemMeta();
        instantDamageMeta.setDisplayName(ChatColor.GOLD+"Sofortschaden Kaufen");
        ArrayList instantDamageLore = new ArrayList();
        instantDamageLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+instantDamageCost+" Gold");
        if(gold>=instantDamageCost){
            instantDamageLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            instantDamageLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        instantDamageMeta.setLore(instantDamageLore);
        instantDamage.setItemMeta(instantDamageMeta);

        Potion invisiblePotion = new Potion(PotionType.INVISIBILITY,1);
        invisiblePotion.setSplash(true);
        ItemStack invisible = invisiblePotion.toItemStack(1);
        ItemMeta invisibleMeta = invisible.getItemMeta();
        invisibleMeta.setDisplayName(ChatColor.GOLD+"Unsichtbarkeit Kaufen");
        ArrayList invisibleLore = new ArrayList();
        invisibleLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+invisibleCost+" Gold");
        if(gold>=invisibleCost){
            invisibleLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            invisibleLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        invisibleMeta.setLore(invisibleLore);
        invisible.setItemMeta(invisibleMeta);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GOLD+"Bogen Kaufen");
        ArrayList bowLore = new ArrayList();
        bowLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+bowCost+" Gold");
        if(gold>=bowCost){
            bowLore.add(ChatColor.GREEN+"Klick zum Kaufen");
        }else{
            bowLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        bowMeta.setLore(bowLore);
        bow.setItemMeta(bowMeta);

        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta shieldMeta = shield.getItemMeta();
        shieldMeta.setDisplayName(ChatColor.GOLD+"Schild kaufen");
        ArrayList shieldLore = new ArrayList();
        shieldLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+shieldCost+" Eisen");
        if(iron>=shieldCost){
            shieldLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            shieldLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        shieldMeta.setLore(shieldLore);
        shield.setItemMeta(shieldMeta);

        ItemStack wool = null;
        if(team.equalsIgnoreCase("red")){
            wool = new ItemStack(Material.RED_WOOL);
        }else if(team.equalsIgnoreCase("yellow")){
            wool = new ItemStack(Material.YELLOW_WOOL);
        }else if(team.equalsIgnoreCase("blue")){
            wool = new ItemStack(Material.BLUE_WOOL);
        }else if(team.equalsIgnoreCase("green")){
            wool = new ItemStack(Material.GREEN_WOOL);
        }else{
            wool = new ItemStack(Material.RED_WOOL);
        }
        wool.setAmount(16);
        ItemMeta woolMeta = wool.getItemMeta();
        woolMeta.setDisplayName(ChatColor.GOLD+"Wolle Kaufen");
        ArrayList woolLore = new ArrayList();
        woolLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+woolCost+" Eisen");
        if(iron>=woolCost){
            woolLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            woolLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        woolMeta.setLore(woolLore);
        wool.setItemMeta(woolMeta);

        ItemStack stone = new ItemStack(Material.STONE);
        stone.setAmount(16);
        ItemMeta stoneMeta = stone.getItemMeta();
        stoneMeta.setDisplayName(ChatColor.GOLD+"Stein Kaufen");
        ArrayList stoneLore = new ArrayList();
        stoneLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+stoneCost+" Gold");
        if(gold>=stoneCost){
            stoneLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            stoneLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        stoneMeta.setLore(stoneLore);
        stone.setItemMeta(stoneMeta);

        ItemStack bricks = new ItemStack(Material.BRICKS);
        bricks.setAmount(16);
        ItemMeta bricksMeta = bricks.getItemMeta();
        bricksMeta.setDisplayName(ChatColor.GOLD+"Ziegel Kaufen");
        ArrayList bricksLore = new ArrayList();
        bricksLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+bricksCost+" Gold");
        if(gold>=bricksCost){
            bricksLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            bricksLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        bricksMeta.setLore(bricksLore);
        bricks.setItemMeta(bricksMeta);

        ItemStack endstone = new ItemStack(Material.END_STONE);
        endstone.setAmount(16);
        ItemMeta endstoneMeta = endstone.getItemMeta();
        endstoneMeta.setDisplayName(ChatColor.GOLD+"Endstein Kaufen");
        ArrayList endstoneLore = new ArrayList();
        endstoneLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+endstoneCost+" Diamanten");
        if(diamond>=endstoneCost){
            endstoneLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            endstoneLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        endstoneMeta.setLore(endstoneLore);
        endstone.setItemMeta(endstoneMeta);

        ItemStack knockbackStick = new ItemStack(Material.STICK);
        ItemMeta knockbackStickMeta = knockbackStick.getItemMeta();
        knockbackStickMeta.setDisplayName(ChatColor.GOLD+"Rückstoß-Stick Kaufen");
        ArrayList knockbackStickLore = new ArrayList();
        knockbackStickLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+knockbackStickCost+" Gold");
        if(gold>=knockbackStickCost){
            knockbackStickLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            knockbackStickLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        knockbackStickMeta.setLore(knockbackStickLore);
        knockbackStickMeta.addEnchant(Enchantment.KNOCKBACK,2,true);
        knockbackStick.setItemMeta(knockbackStickMeta);

        ItemStack enderperl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enderperlMeta = enderperl.getItemMeta();
        enderperlMeta.setDisplayName(ChatColor.GOLD+"Enderperle Kaufen");
        ArrayList enderperlLore = new ArrayList();
        enderperlLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+enderperlCost+" Diamanten");
        if(diamond>=enderperlCost){
            enderperlLore.add(ChatColor.GREEN+"Klicken zum Kaufen");
        }else{
            enderperlLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        enderperlMeta.setLore(enderperlLore);
        enderperl.setItemMeta(enderperlMeta);

        ItemStack fishingrot = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrotMeta = fishingrot.getItemMeta();
        fishingrotMeta.setDisplayName(ChatColor.GOLD+"Angel Kaufen");
        ArrayList fishingrotLore = new ArrayList();
        fishingrotLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+fishingrotCost+" Gold");
        if(gold>=fishingrotCost){
            fishingrotLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            fishingrotLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        fishingrotMeta.setLore(fishingrotLore);
        fishingrot.setItemMeta(fishingrotMeta);

        ItemStack shear = new ItemStack(Material.SHEARS);
        ItemMeta shearMeta = shear.getItemMeta();
        shearMeta.setDisplayName(ChatColor.GOLD+"Schere Kaufen");
        ArrayList shearlore = new ArrayList();
        shearlore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+shearCost+" Eisen");
        if(iron>=shearCost){
            shearlore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            shearlore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        shearMeta.setLore(shearlore);
        shear.setItemMeta(shearMeta);

        ItemStack arrow = new ItemStack(Material.ARROW);
        arrow.setAmount(16);
        ItemMeta arrowMeta = arrow.getItemMeta();
        arrowMeta.setDisplayName(ChatColor.GOLD+"Pfeile Kaufen");
        ArrayList arrowLore = new ArrayList();
        arrowLore.add(ChatColor.BLUE+"Preise: "+ChatColor.GOLD+arrowCost+" Gold");
        if(gold>=arrowCost){
            arrowLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            arrowLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        arrowMeta.setLore(arrowLore);
        arrow.setItemMeta(arrowMeta);

        ItemStack snowball = new ItemStack(Material.SNOWBALL);
        snowball.setAmount(8);
        ItemMeta snowballMeta = snowball.getItemMeta();
        snowballMeta.setDisplayName(ChatColor.GOLD+"Schneeball Kaufen");
        ArrayList snowballLore = new ArrayList();
        snowballLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+snowballCost+" Eisen");
        if(iron>=snowballCost){
            snowballLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            snowballLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        snowballMeta.setLore(snowballLore);
        snowball.setItemMeta(snowballMeta);

        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
        steak.setAmount(16);
        ItemMeta steakMeta = steak.getItemMeta();
        steakMeta.setDisplayName(ChatColor.GOLD+"Steak Kaufen");
        ArrayList steakLore = new ArrayList();
        steakLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+steakCost+" Eisen");
        if(iron>=steakCost){
            steakLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            steakLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        steakMeta.setLore(steakLore);
        steak.setItemMeta(steakMeta);

        ItemStack goldapple = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta goldappleMeta = goldapple.getItemMeta();
        goldappleMeta.setDisplayName(ChatColor.GOLD+"Goldapfel Kaufen");
        ArrayList goldappleLore = new ArrayList();
        goldappleLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+goldappleCost+" Diamanten");
        if(diamond>=goldappleCost){
            goldappleLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            goldappleLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        goldappleMeta.setLore(goldappleLore);
        goldapple.setItemMeta(goldappleMeta);

        ItemStack lavabukit = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta lavabukkitMeta = lavabukit.getItemMeta();
        lavabukkitMeta.setDisplayName(ChatColor.GOLD+"Lava-Eimer Kaufen");
        ArrayList lavabukkitLore = new ArrayList();
        lavabukkitLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+lavabukkitCost+" Gold");
        if(gold>=lavabukkitCost){
            lavabukkitLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            lavabukkitLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        lavabukkitMeta.setLore(lavabukkitLore);
        lavabukit.setItemMeta(lavabukkitMeta);

        ItemStack flintandsteel = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta flintandsteelMeta = flintandsteel.getItemMeta();
        flintandsteelMeta.setDisplayName(ChatColor.GOLD+"Feuerzeug Kaufen");
        ArrayList flintandsteelLore = new ArrayList();
        flintandsteelLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+flintandsteelCost+" Eisen");
        if(iron>=flintandsteelCost){
            flintandsteelLore.add(ChatColor.GREEN+"Klicke zum Kaufen");
        }else{
            flintandsteelLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        flintandsteelMeta.setLore(flintandsteelLore);
        flintandsteel.setItemMeta(flintandsteelMeta);

        ItemStack waterbukkit = new ItemStack(Material.WATER_BUCKET);
        ItemMeta waterbukkitMeta = waterbukkit.getItemMeta();
        waterbukkitMeta.setDisplayName(ChatColor.GOLD+"Wasser-Eimer Kaufen");
        ArrayList waterbukkitLore = new ArrayList();
        waterbukkitLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+waterbukkitCost+" Gold");
        if(gold>=waterbukkitCost){
            waterbukkitLore.add(ChatColor.GREEN+"Klicken zum Kaufen");
        }else{
            waterbukkitLore.add(ChatColor.RED+"Nicht genügent Gold");
        }
        waterbukkitMeta.setLore(waterbukkitLore);
        waterbukkit.setItemMeta(waterbukkitMeta);

        ItemStack cobweb = new ItemStack(Material.COBWEB);
        cobweb.setAmount(5);
        ItemMeta cobwebMeta = cobweb.getItemMeta();
        cobwebMeta.setDisplayName(ChatColor.GOLD+"Spinnennetz Kaufen");
        ArrayList cobwebLore = new ArrayList();
        cobwebLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+cobwebCost+" Eisen");
        if(iron>=cobwebCost){
            cobwebLore.add(ChatColor.GREEN+"Klicken zum Kaufen");
        }else{
            cobwebLore.add(ChatColor.RED+"Nicht genügent Eisen");
        }
        cobwebMeta.setLore(cobwebLore);
        cobweb.setItemMeta(cobwebMeta);

        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta totemMeta = totem.getItemMeta();
        totemMeta.setDisplayName(ChatColor.GOLD+"Totem Kaufen");
        ArrayList totemLore = new ArrayList();
        totemLore.add(ChatColor.BLUE+"Preis: "+ChatColor.GOLD+totemCost+" Diamanten");
        if(diamond>=totemCost){
            totemLore.add(ChatColor.GREEN+"Klicken zum Kaufen");
        }else{
            totemLore.add(ChatColor.RED+"Nicht genügent Diamanten");
        }
        totemMeta.setLore(totemLore);
        totem.setItemMeta(totemMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED+"Schließen");
        close.setItemMeta(closeMeta);







        inv.setItem(0,stoneSword);
        inv.setItem(1,stonePickaxe);
        inv.setItem(2, stoneAxe);
        inv.setItem(9,ironSword);
        inv.setItem(10,ironPickaxe);
        inv.setItem(11,ironAxe);
        inv.setItem(18,diamondSword);
        inv.setItem(19,diamondPickaxe);
        inv.setItem(20,diamondAxe);
        inv.setItem(3,ironChestplate);
        inv.setItem(12,diamondChestplate);
        inv.setItem(21,netherideChestplate);
        inv.setItem(27,instantDamage);
        inv.setItem(28,invisible);
        inv.setItem(29,bow);
        inv.setItem(30,shield);
        inv.setItem(5,wool);
        inv.setItem(6,stone);
        inv.setItem(7,bricks);
        inv.setItem(8,endstone);
        inv.setItem(14,knockbackStick);
        inv.setItem(15,enderperl);
        inv.setItem(16,fishingrot);
        inv.setItem(17,shear);
        inv.setItem(23,arrow);
        inv.setItem(24,snowball);
        inv.setItem(25,steak);
        inv.setItem(26,goldapple);
        inv.setItem(32,lavabukit);
        inv.setItem(33,flintandsteel);
        inv.setItem(34,waterbukkit);
        inv.setItem(35,cobweb);
        inv.setItem(40,totem);
        inv.setItem(53,close);
        player.openInventory(inv);
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
