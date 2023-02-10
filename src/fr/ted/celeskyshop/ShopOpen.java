package fr.ted.celeskyshop;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

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

public class ShopOpen implements Listener {
	
	private static Main main;
	
	public ShopOpen(Main main) {
		ShopOpen.main = main;
	}

	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent event) {

		//Exclude useless entity
		if (event.getRightClicked().getType() != EntityType.PLAYER) return;
		
		if (event.getHand() == EquipmentSlot.OFF_HAND) return;
		
		//Event Informations
		Player player = event.getPlayer();
		Player entity = (Player) event.getRightClicked();
		
		
		//On click on entity
		if (entity.getType() == EntityType.PLAYER) {
			
			//Shop Blocks
			String shopBlocksUUID = main.getConfig().getString("sellers.Blocks.UUID");
			String shopBlocksPermission = main.getConfig().getString("sellers.Blocks.shopPermission");
			if (entity.getUniqueId().toString().equals(shopBlocksUUID)) {
				//Permission check
				if(player.hasPermission(shopBlocksPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopBlocks.shopItemBlocks(main, player);
			}
			
			//Shop Blacksmith
			String shopBlacksmithUUID = main.getConfig().getString("sellers.Blacksmith.UUID");
			String shopBlacksmithPermission = main.getConfig().getString("sellers.Blacksmith.shopPermission");
			if (entity.getUniqueId().toString().equals(shopBlacksmithUUID)) {
				//Permission check
				if(player.hasPermission(shopBlacksmithPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopBlacksmith.shopItemBlacksmith(main, player);
			}

			//Shop Carpenter
			String shopCarpenterUUID = main.getConfig().getString("sellers.Carpenter.UUID");
			String shopCarpenterPermission = main.getConfig().getString("sellers.Carpenter.shopPermission");
			if (entity.getUniqueId().toString().equals(shopCarpenterUUID)) {
				//Permission check
				if(player.hasPermission(shopCarpenterPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopCarpenter.shopItemCarpenter(main, player);
			}

			//Shop Farmer
			String shopFarmerUUID = main.getConfig().getString("sellers.Farmer.UUID");
			String shopFarmerPermission = main.getConfig().getString("sellers.Farmer.shopPermission");
			if (entity.getUniqueId().toString().equals(shopFarmerUUID)) {
				//Permission check
				if(player.hasPermission(shopFarmerPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopFarmer.shopItemFarmer(main, player);
			}

			//Shop Butcher
			String shopButcherUUID = main.getConfig().getString("sellers.Butcher.UUID");
			String shopButcherPermission = main.getConfig().getString("sellers.Butcher.shopPermission");
			if (entity.getUniqueId().toString().equals(shopButcherUUID)) {
				//Permission check
				if(player.hasPermission(shopButcherPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopButcher.shopItemButcher(main, player);
			}

			//Shop Miner
			String shopMinerUUID = main.getConfig().getString("sellers.Miner.UUID");
			String shopMinerPermission = main.getConfig().getString("sellers.Miner.shopPermission");
			if (entity.getUniqueId().toString().equals(shopMinerUUID)) {
				//Permission check
				if(player.hasPermission(shopMinerPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopMiner.shopItemMiner(main, player);
			}

			//Shop Magician
			String shopMagicianUUID = main.getConfig().getString("sellers.Magician.UUID");
			String shopMagicianPermission = main.getConfig().getString("sellers.Magician.shopPermission");
			if (entity.getUniqueId().toString().equals(shopMagicianUUID)) {
				//Permission check
				if(player.hasPermission(shopMagicianPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopMagician.shopItemMagician(main, player);
			}

			//Shop Engineer
			String shopEngineerUUID = main.getConfig().getString("sellers.Engineer.UUID");
			String shopEngineerPermission = main.getConfig().getString("sellers.Engineer.shopPermission");
			if (entity.getUniqueId().toString().equals(shopEngineerUUID)) {
				//Permission check
				if(player.hasPermission(shopEngineerPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopEngineer.shopItemEngineer(main, player);
			}

			//Shop Adventurer
			String shopAdventurerUUID = main.getConfig().getString("sellers.Adventurer.UUID");
			String shopAdventurerPermission = main.getConfig().getString("sellers.Adventurer.shopPermission");
			if (entity.getUniqueId().toString().equals(shopAdventurerUUID)) {
				//Permission check
				if(player.hasPermission(shopAdventurerPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopAdventurer.shopItemAdventurer(main, player);
			}

			//Shop Hero
			String shopHeroUUID = main.getConfig().getString("sellers.Hero.UUID");
			String shopHeroPermission = main.getConfig().getString("sellers.Hero.shopPermission");
			if (entity.getUniqueId().toString().equals(shopHeroUUID)) {
				//Permission check
				if(player.hasPermission(shopHeroPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopHero.shopItemHero(main, player);
			}

			//Shop Alchemist
			String shopAlchemistUUID = main.getConfig().getString("sellers.Alchemist.UUID");
			String shopAlchemistPermission = main.getConfig().getString("sellers.Alchemist.shopPermission");
			if (entity.getUniqueId().toString().equals(shopAlchemistUUID)) {
				//Permission check
				if(player.hasPermission(shopAlchemistPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopAlchemist.shopItemAlchemist(main, player);
			}
	
		}
	}
}
