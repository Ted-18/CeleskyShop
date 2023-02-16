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
import fr.ted.celeskyshop.shops.ShopSummoner;

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
			Boolean shopBlockEnable =  main.getConfig().getBoolean("sellers.Blocks.enable");
			if (entity.getUniqueId().toString().equals(shopBlocksUUID)) {
				
				if(!shopBlockEnable) return;
				
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
			Boolean shopBlacksmithEnable =  main.getConfig().getBoolean("sellers.Blacksmith.enable");
			if (entity.getUniqueId().toString().equals(shopBlacksmithUUID)) {
				
				if(!shopBlacksmithEnable) return;
				
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
			Boolean shopCarpenterEnable =  main.getConfig().getBoolean("sellers.Carpenter.enable");
			if (entity.getUniqueId().toString().equals(shopCarpenterUUID)) {

				if(!shopCarpenterEnable) return;
				
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
			Boolean shopFarmerEnable =  main.getConfig().getBoolean("sellers.Farmer.enable");
			if (entity.getUniqueId().toString().equals(shopFarmerUUID)) {

				if(!shopFarmerEnable) return;
				
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
			Boolean shopButcherEnable =  main.getConfig().getBoolean("sellers.Butcher.enable");
			if (entity.getUniqueId().toString().equals(shopButcherUUID)) {

				if(!shopButcherEnable) return;
				
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
			Boolean shopMinerEnable =  main.getConfig().getBoolean("sellers.Miner.enable");
			if (entity.getUniqueId().toString().equals(shopMinerUUID)) {

				if(!shopMinerEnable) return;
				
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
			Boolean shopMagicianEnable =  main.getConfig().getBoolean("sellers.Magician.enable");
			if (entity.getUniqueId().toString().equals(shopMagicianUUID)) {

				if(!shopMagicianEnable) return;
				
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
			Boolean shopEngineerEnable =  main.getConfig().getBoolean("sellers.Engineer.enable");
			if (entity.getUniqueId().toString().equals(shopEngineerUUID)) {

				if(!shopEngineerEnable) return;
				
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
			Boolean shopAdventurerEnable =  main.getConfig().getBoolean("sellers.Adventurer.enable");
			if (entity.getUniqueId().toString().equals(shopAdventurerUUID)) {

				if(!shopAdventurerEnable) return;
				
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
			Boolean shopHeroEnable =  main.getConfig().getBoolean("sellers.Hero.enable");
			if (entity.getUniqueId().toString().equals(shopHeroUUID)) {

				if(!shopHeroEnable) return;
				
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
			Boolean shopAlchemistEnable =  main.getConfig().getBoolean("sellers.Alchemist.enable");
			if (entity.getUniqueId().toString().equals(shopAlchemistUUID)) {

				if(!shopAlchemistEnable) return;
				
				//Permission check
				if(player.hasPermission(shopAlchemistPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopAlchemist.shopItemAlchemist(main, player);
			}
			
			//Shop Summoner
			String shopSummonerUUID = main.getConfig().getString("sellers.Summoner.UUID");
			String shopSummonerPermission = main.getConfig().getString("sellers.Summoner.shopPermission");
			Boolean shopSummonerEnable =  main.getConfig().getBoolean("sellers.Summoner.enable");
			if (entity.getUniqueId().toString().equals(shopSummonerUUID)) {

				if(!shopSummonerEnable) return;
				
				//Permission check
				if(player.hasPermission(shopSummonerPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				ShopSummoner.shopItemSummoner(main, player);
			}
	
		}
	}
}
