package fr.ted.celeskyshop.admin;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import fr.ted.celeskyshop.Main;

public class AdminInformation implements Listener {

	private static Main main;
	
	public AdminInformation(Main main) {
		AdminInformation.main = main;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent event) {

		//Exclude useless entity
		if (event.getRightClicked().getType() != EntityType.PLAYER) return;
		
		if (event.getHand() == EquipmentSlot.OFF_HAND) return;
		
		//Event Informations
		Player player = event.getPlayer();
		Player entity = (Player) event.getRightClicked();
		
		//Permission check
		String adminPermission = main.getConfig().getString("admin.checkUUID");
		if(player.hasPermission(adminPermission) != true) return;
		
		//Event
		if (entity.getType() == EntityType.PLAYER) {
			
			ItemStack itemInHand = player.getInventory().getItemInMainHand();
			
			if (itemInHand.getType() == Material.NETHER_STAR) {
				player.sendMessage("§aUUID: " + entity.getUniqueId().toString());
			}
				
		}
		
	}
	
}
