package fr.ted.celeskyshop;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

import fr.ted.celeskyshop.shops.ShopBlocks;

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
			String shopBlocksUUID = main.getConfig().getString("sellers.blocks.UUID");
			String shopPermission = main.getConfig().getString("sellers.blocks.shopPermission");
			
			if (entity.getUniqueId().toString().equals(shopBlocksUUID)) {
				
				//Permission check
				if(player.hasPermission(shopPermission) != true) {
					player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'autorisation d'accèder à ce shop.");
					return;
				}
				
				
				ShopBlocks.shopItemBlocks(main, player);
				
			}
				
		}
		
	}
}
