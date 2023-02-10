package fr.ted.celeskyshop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.ted.celeskyshop.dependencies.VaultInitialisation;
import fr.ted.celeskyshop.shops.ShopAdventurer;
import fr.ted.celeskyshop.shops.ShopAlchemist;
import fr.ted.celeskyshop.shops.ShopBlacksmith;
import fr.ted.celeskyshop.shops.ShopBlocks;
import fr.ted.celeskyshop.shops.ShopButcher;
import fr.ted.celeskyshop.shops.ShopCarpenter;
import fr.ted.celeskyshop.shops.ShopEngineer;
import fr.ted.celeskyshop.shops.ShopFarmer;
import fr.ted.celeskyshop.shops.ShopHero;
import fr.ted.celeskyshop.shops.ShopMagician;
import fr.ted.celeskyshop.shops.ShopMiner;
import net.milkbowl.vault.economy.Economy;

public class ShopCore implements Listener {
	
	private static Main main;
	
	public ShopCore(Main main) {
		ShopCore.main = main;
	}
	
	
	public boolean shopVerification(String title) {
		
		//List of shops
		String[] shopList = new String[11];
		shopList[0] = main.getConfig().getString("sellers.Blocks.shopName");
		shopList[1] = main.getConfig().getString("sellers.Blacksmith.shopName");
		shopList[2] = main.getConfig().getString("sellers.Carpenter.shopName");
		shopList[3] = main.getConfig().getString("sellers.Farmer.shopName");
		shopList[4] = main.getConfig().getString("sellers.Butcher.shopName");
		shopList[5] = main.getConfig().getString("sellers.Miner.shopName");
		shopList[6] = main.getConfig().getString("sellers.Magician.shopName");
		shopList[7] = main.getConfig().getString("sellers.Engineer.shopName");
		shopList[8] = main.getConfig().getString("sellers.Adventurer.shopName");
		shopList[9] = main.getConfig().getString("sellers.Hero.shopName");
		shopList[10] = main.getConfig().getString("sellers.Alchemist.shopName");

		
		//Verification
		for (String shopName : shopList) {
			if (shopName.equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
				
		//Importants variables
		InventoryView inventory = event.getView();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		//Money of player
		Economy economy = VaultInitialisation.getEconomy();
		String playerMoney = String.valueOf(economy.getBalance(player));
		double playerMoneyValue = economy.getBalance(player);
		
		
		if(current == null) return;
		
		
		//If chest is a shop
		if(shopVerification(inventory.getTitle())) {
			
			String originalShopTitle = inventory.getTitle();
			
			
			event.setCancelled(true);
			
			//Verification
			if(event.getClickedInventory().getType() != InventoryType.CHEST) return;
			if(current.getItemMeta().getDisplayName().contains("§aNiveau 1")) return;
			if(current.getItemMeta().getDisplayName().contains("§eNiveau 2")) return;
			if(current.getItemMeta().getDisplayName().contains("§6Niveau 3")) return;
			if(current.getItemMeta().getDisplayName().contains("§cNiveau 4")) return;
			if(current.getItemMeta().getDisplayName().contains("§4Niveau 5")) return;
			if(current.getItemMeta().getDisplayName().contains("§cBloqué")) return;
			if(current.getItemMeta().getDisplayName().contains("§aTon argent: §e")) return;
			
			player.closeInventory();
			
			//Create Sell chest panel
			Inventory shopSelectedItem = Bukkit.createInventory(null, 54, "§aItem " + current.getType().toString());
			
			//Money Emerald
			shopSelectedItem.setItem(49, ShopItem.addItemShop(Material.EMERALD, 1, "§aTon argent: §e" + playerMoney, "§7Shop: " + originalShopTitle, 0, 0));
			
			//Item to sell
			shopSelectedItem.setItem(13, ShopItem.addItemShop(current.getType(), 1, null, null, 0, 0));
			
			
			//Define the price of differents quantity
			String itemBuyPriceArray = current.getItemMeta().getLore().get(0);
			String itemSellPriceArray = current.getItemMeta().getLore().get(1);
			
			String itemBuyPriceNum = itemBuyPriceArray.replace("§7Achat: §a", "");
			String itemSellPriceNum = itemSellPriceArray.replace("§7Vente: §c", "");
			
			int itemBuyPrice = Integer.parseInt(itemBuyPriceNum);
			int itemSellPrice = Integer.parseInt(itemSellPriceNum);
			
			int itemBuyPrice1 = itemBuyPrice*1;
			int itemBuyPrice4 = itemBuyPrice*4;
			int itemBuyPrice16 = itemBuyPrice*16;
			int itemBuyPrice32 = itemBuyPrice*32;
			int itemBuyPrice64 = itemBuyPrice*64;
			
			int itemSellPrice1 = itemSellPrice*1;
			int itemSellPrice4 = itemSellPrice*4;
			int itemSellPrice16 = itemSellPrice*16;
			int itemSellPrice32 = itemSellPrice*32;
			int itemSellPrice64 = itemSellPrice*64;
			
			shopSelectedItem.setItem(29, ShopItem.addItemShop(Material.GREEN_TERRACOTTA, 1, "§aAchat §7§lx1", null, itemBuyPrice1, 0));
			shopSelectedItem.setItem(30, ShopItem.addItemShop(Material.GREEN_TERRACOTTA, 4, "§aAchat §7§lx4", null, itemBuyPrice4, 0));
			shopSelectedItem.setItem(31, ShopItem.addItemShop(Material.GREEN_TERRACOTTA, 16, "§aAchat §7§lx16", null, itemBuyPrice16, 0));
			shopSelectedItem.setItem(32, ShopItem.addItemShop(Material.GREEN_TERRACOTTA, 32, "§aAchat §7§lx32", null, itemBuyPrice32, 0));
			shopSelectedItem.setItem(33, ShopItem.addItemShop(Material.GREEN_TERRACOTTA, 64, "§aAchat §7§lx64", null, itemBuyPrice64, 0));
			
			shopSelectedItem.setItem(38, ShopItem.addItemShop(Material.RED_TERRACOTTA, 1, "§cVente §7§lx1", null, 0, itemSellPrice1));
			shopSelectedItem.setItem(39, ShopItem.addItemShop(Material.RED_TERRACOTTA, 4, "§cVente §7§lx4", null, 0, itemSellPrice4));
			shopSelectedItem.setItem(40, ShopItem.addItemShop(Material.RED_TERRACOTTA, 16, "§cVente §7§lx16", null, 0, itemSellPrice16));
			shopSelectedItem.setItem(41, ShopItem.addItemShop(Material.RED_TERRACOTTA, 32, "§cVente §7§lx32", null, 0, itemSellPrice32));
			shopSelectedItem.setItem(42, ShopItem.addItemShop(Material.RED_TERRACOTTA, 64, "§cVente §7§lx64", null, 0, itemSellPrice64));
			
			//Return Arrow
			shopSelectedItem.setItem(53, ShopItem.addItemShop(Material.ARROW, 1, "§7Retour", null, 0, 0));
			
			//Open chest shop to player
			player.openInventory(shopSelectedItem);
			
		}
		else if (inventory.getTitle().equals("§aItem " + inventory.getItem(13).getType().toString())) {
			
			event.setCancelled(true);
			
			//Get Emeral money informations
			ItemStack playerMoneyEmerald = inventory.getItem(49);
			ItemMeta playerMoneyEmeraldMeta = playerMoneyEmerald.getItemMeta();
			String originalShopTitle = playerMoneyEmeraldMeta.getLore().get(0);
			
			
			//If Buy Terracotta is clicked
			if(current.getType() == Material.GREEN_TERRACOTTA) {
				
				//Define the price from lore
				String itemBuyPriceArray = current.getItemMeta().getLore().get(0);
				String itemBuyPriceNum = itemBuyPriceArray.replace("§7Achat: §a", "");
				int itemBuyPrice = Integer.parseInt(itemBuyPriceNum);
				
				//If player have enough money
				if(playerMoneyValue >= itemBuyPrice) {
					
					//If player have enough terracotta
					if(player.getInventory().firstEmpty() == -1) {
						player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas assez d'espace dans l'inventaire.");
						return;
					}
					
					//Get item to Buy
					ItemStack itemBuy = inventory.getItem(13).clone();
					
					//Set amout to Buy
					itemBuy.setAmount(current.getAmount());
					
					//Add item to player's inventory
					player.getInventory().addItem(itemBuy);
					
					//Remove money of player
					economy.withdrawPlayer(player, itemBuyPrice);
					
					//Redefine name of the Emerald Money
					String playerMoneyNewValue = String.valueOf(economy.getBalance(player));
					playerMoneyEmeraldMeta.setDisplayName("§aTon argent: §e" + playerMoneyNewValue);
					playerMoneyEmerald.setItemMeta(playerMoneyEmeraldMeta);
					
					//Send message to the player
					player.sendMessage("§8[§bCelesky Shop§8]§aVous avez acheté " + itemBuy.getType().toString());
				
				}
				else {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'argent.");
				}				
			}
			//If Sell Terracotta is clicked
			else if(current.getType() == Material.RED_TERRACOTTA) {
				
				//If player inventory contain the amout of selected item
				if(player.getInventory().containsAtLeast(inventory.getItem(13), current.getAmount())) {
					
					//Define the price from lore
					String itemSellPriceArray = current.getItemMeta().getLore().get(0);
					String itemSellPriceNum = itemSellPriceArray.replace("§7Vente: §c", "");
					int itemSellPrice = Integer.parseInt(itemSellPriceNum);
					
					//Get item to Sell
					ItemStack itemSell = inventory.getItem(13).clone();
					
					//Set amout to Sell
					itemSell.setAmount(current.getAmount());
					
					//Remove the item from the player inventory
					player.getInventory().removeItem(itemSell);
					
					//Add money to the player's account
					economy.depositPlayer(player, itemSellPrice);
					
					//Redefine name of the Emerald Money
					String playerMoneyNewValue = String.valueOf(economy.getBalance(player));
					playerMoneyEmeraldMeta.setDisplayName("§aTon argent: §e" + playerMoneyNewValue);
					playerMoneyEmerald.setItemMeta(playerMoneyEmeraldMeta);
					
					//Send message to the player
					player.sendMessage("§8[§bCelesky Shop§8]§cVous avez vendu " + itemSell.getType().toString());
				}
				else {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous ne pouvez pas vendre un item que vous ne possédez pas.");
				}
				
			}
			
			
			//Return arrow
			if (current.getItemMeta().getDisplayName().equals("§7Retour")) {
				player.closeInventory();
				
				openShop(main, player, originalShopTitle);
				
			}
			
		}
		
	}
	
	public void openShop(Main main, Player player, String shopName) {
		
		String OriginalShopName = shopName.replace("§7Shop: ", "");
		
		//List of shops
		String[] shopList = new String[11];
		shopList[0] = main.getConfig().getString("sellers.Blocks.shopName");
		shopList[1] = main.getConfig().getString("sellers.Blacksmith.shopName");
		shopList[2] = main.getConfig().getString("sellers.Carpenter.shopName");
		shopList[3] = main.getConfig().getString("sellers.Farmer.shopName");
		shopList[4] = main.getConfig().getString("sellers.Butcher.shopName");
		shopList[5] = main.getConfig().getString("sellers.Miner.shopName");
		shopList[6] = main.getConfig().getString("sellers.Magician.shopName");
		shopList[7] = main.getConfig().getString("sellers.Engineer.shopName");
		shopList[8] = main.getConfig().getString("sellers.Adventurer.shopName");
		shopList[9] = main.getConfig().getString("sellers.Hero.shopName");
		shopList[10] = main.getConfig().getString("sellers.Alchemist.shopName");
		
		if(OriginalShopName.equals(shopList[0])) {
			ShopBlocks.shopItemBlocks(main, player);
		}
		else if(OriginalShopName.equals(shopList[1])) {
			ShopBlacksmith.shopItemBlacksmith(main, player);
		}
		else if(OriginalShopName.equals(shopList[2])) {
			ShopCarpenter.shopItemCarpenter(main, player);
		}
		else if(OriginalShopName.equals(shopList[3])) {
			ShopFarmer.shopItemFarmer(main, player);
		}
		else if(OriginalShopName.equals(shopList[4])) {
			ShopButcher.shopItemButcher(main, player);
		}
		else if(OriginalShopName.equals(shopList[5])) {
			ShopMiner.shopItemMiner(main, player);
		}
		else if(OriginalShopName.equals(shopList[6])) {
			ShopMagician.shopItemMagician(main, player);
		}
		else if(OriginalShopName.equals(shopList[7])) {
			ShopEngineer.shopItemEngineer(main, player);
		}
		else if(OriginalShopName.equals(shopList[8])) {
			ShopAdventurer.shopItemAdventurer(main, player);
		}
		else if(OriginalShopName.equals(shopList[9])) {
			ShopHero.shopItemHero(main, player);
		}
		else if(shopName.equals(shopList[10])) {
			ShopAlchemist.shopItemAlchemist(main, player);
		}
		else {
			player.sendMessage("§8[§bCelesky Shop§8] §7Veuillez informer un développeur que le shop §c" + shopName + " §7n'as pas été ajouté à §cShopCore.openShop§7.");
		}
		
	}
	
	
}
