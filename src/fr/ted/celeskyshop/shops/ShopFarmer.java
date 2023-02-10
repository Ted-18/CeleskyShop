package fr.ted.celeskyshop.shops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ted.celeskyshop.Main;
import fr.ted.celeskyshop.ShopItem;
import fr.ted.celeskyshop.dependencies.VaultInitialisation;
import net.milkbowl.vault.economy.Economy;

public class ShopFarmer {

    public static void shopItemFarmer(Main main, Player player) {
        
		//Get Shop name from config
		String shopName = main.getConfig().getString("sellers.Farmer.shopName");
		
		//Create chest shop panel
		Inventory shopItem = Bukkit.createInventory(null, 54, shopName);
		
		//Get economy informations
		Economy economy = VaultInitialisation.getEconomy();
		String playerMoney = String.valueOf(economy.getBalance(player));
		
		//Set Emerald item
		shopItem.setItem(49, ShopItem.addItemShop(Material.EMERALD, 1, "§aTon argent: §e" + playerMoney, null, 0, 0));
		
		
		//Permission level 1
		String shopLevel1 = main.getConfig().getString("sellers.Farmer.shopLevel1");
		if(player.hasPermission(shopLevel1) == true) {
			shopItem.setItem(0, ShopItem.addItemShop(Material.LIME_TERRACOTTA, 1, "§aNiveau 1", "§7Status: §aDébloqué", 0, 0));
			
			shopItem.setItem(1, ShopItem.addItemShop(Material.WHEAT_SEEDS, 1, null, null, 2, 1));
			shopItem.setItem(2, ShopItem.addItemShop(Material.CARROT, 1, null, null, 2, 1));
			shopItem.setItem(3, ShopItem.addItemShop(Material.POTATO, 1, null, null, 2, 1));
			shopItem.setItem(4, ShopItem.addItemShop(Material.RED_MUSHROOM, 1, null, null, 2, 1));
			shopItem.setItem(5, ShopItem.addItemShop(Material.BROWN_MUSHROOM, 1, null, null, 2, 1));
		}
		else {
			shopItem.setItem(0, ShopItem.addItemShop(Material.LIME_TERRACOTTA, 1, "§aNiveau 1", "§7Status: §cBloqué", 0, 0));
			
			shopItem.setItem(1, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(2, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(3, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(4, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(5, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(6, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(7, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(8, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
		}
		
		
		//Permission level 2
		String shopLevel2 = main.getConfig().getString("sellers.Farmer.shopLevel2");
		if(player.hasPermission(shopLevel2) == true) {
			shopItem.setItem(9, ShopItem.addItemShop(Material.YELLOW_TERRACOTTA, 1, "§eNiveau 2", "§7Status: §aDébloqué", 0, 0));
			
			shopItem.setItem(10, ShopItem.addItemShop(Material.WHEAT, 1, null, null, 2, 1));
			shopItem.setItem(11, ShopItem.addItemShop(Material.MELON_SLICE, 1, null, null, 2, 1));
			shopItem.setItem(12, ShopItem.addItemShop(Material.BAKED_POTATO, 1	, null, null, 2, 1));
			shopItem.setItem(13, ShopItem.addItemShop(Material.APPLE, 1, null, null, 2, 1));
			shopItem.setItem(14, ShopItem.addItemShop(Material.SUGAR_CANE, 1, null, null, 2, 1));
			shopItem.setItem(15, ShopItem.addItemShop(Material.CACTUS, 1, null, null, 2, 1));
			shopItem.setItem(16, ShopItem.addItemShop(Material.BEETROOT, 1, null, null, 2, 1));
			}
		else {
			shopItem.setItem(9, ShopItem.addItemShop(Material.YELLOW_TERRACOTTA, 1, "§eNiveau 2", "§7Status: §cBloqué", 0, 0));
			
			shopItem.setItem(10, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(11, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(12, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(13, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(14, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(15, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(16, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(17, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
		}
		
		
		//Permission level 3
		String shopLevel3 = main.getConfig().getString("sellers.Farmer.shopLevel3");
		if(player.hasPermission(shopLevel3) == true) {
			shopItem.setItem(18, ShopItem.addItemShop(Material.ORANGE_TERRACOTTA, 1, "§6Niveau 3", "§7Status: §aDébloqué", 0, 0));
			
			shopItem.setItem(19, ShopItem.addItemShop(Material.PUMPKIN_PIE, 1, null, null, 2, 1));
			shopItem.setItem(20, ShopItem.addItemShop(Material.COOKIE, 1, null, null, 2, 1));
			shopItem.setItem(21, ShopItem.addItemShop(Material.MUSHROOM_STEW, 1, null, null, 2, 1));
			shopItem.setItem(22, ShopItem.addItemShop(Material.BEETROOT_SOUP, 1, null, null, 2, 1));
		}
		else {
			shopItem.setItem(18, ShopItem.addItemShop(Material.ORANGE_TERRACOTTA, 1, "§6Niveau 3", "§7Status: §cBloqué", 0, 0));
			
			shopItem.setItem(19, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(20, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(21, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(22, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(23, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(24, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(25, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(26, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
		}
		
		//Permission level 4
		String shopLevel4 = main.getConfig().getString("sellers.Farmer.shopLevel4");
		if(player.hasPermission(shopLevel4) == true) {
			shopItem.setItem(27, ShopItem.addItemShop(Material.RED_TERRACOTTA, 1, "§cNiveau 4", "§7Status: §aDébloqué", 0, 0));
			
			shopItem.setItem(28, ShopItem.addItemShop(Material.CAKE, 1, null, null, 2, 1));
		}
		else {
			shopItem.setItem(27, ShopItem.addItemShop(Material.RED_TERRACOTTA, 1, "§cNiveau 4", "§7Status: §cBloqué", 0, 0));
			
			shopItem.setItem(28, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(29, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(30, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(31, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(32, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(33, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(34, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(35, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
		}
		
		//Permission level 5
		String shopLevel5 = main.getConfig().getString("sellers.Farmer.shopLevel5");
		if(player.hasPermission(shopLevel5) == true) {
			shopItem.setItem(36, ShopItem.addItemShop(Material.BROWN_TERRACOTTA, 1, "§4Niveau 5", "§7Status: §aDébloqué", 0, 0));
			
			shopItem.setItem(37, ShopItem.addItemShop(Material.KELP, 1, null, null, 2, 1));
			shopItem.setItem(38, ShopItem.addItemShop(Material.CHORUS_FRUIT, 1, null, null, 2, 1));
		}
		else {
			shopItem.setItem(36, ShopItem.addItemShop(Material.BROWN_TERRACOTTA, 1, "§4Niveau 5", "§7Status: §cBloqué", 0, 0));
			
			shopItem.setItem(37, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(38, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(39, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(40, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(41, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(42, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(43, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
			shopItem.setItem(44, ShopItem.addItemShop(Material.BARRIER, 1, "§cBloqué", null, 0, 0));
		}
		
		
		//Open chest shop panel to player
		player.openInventory(shopItem);
    	
    	
    }

}
