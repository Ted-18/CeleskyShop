package fr.ted.celeskyshop;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.ted.celeskyshop.dependencies.LuckPermsInitialisation;
import fr.ted.celeskyshop.dependencies.VaultInitialisation;
import net.milkbowl.vault.economy.Economy;

public class SignPermission implements Listener {
	
	private static Main main;
	
	public SignPermission(Main main) {
		SignPermission.main = main;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		
		//Get event informations
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
	
		//Get Config informations
		String worldName = main.getConfig().getString("signs.settings.world");
		String signTitle = main.getConfig().getString("signs.settings.signTitle");
		String level1 = main.getConfig().getString("signs.ranks.level1");
		String level2 = main.getConfig().getString("signs.ranks.level2");
		String level3 = main.getConfig().getString("signs.ranks.level3");
		String level4 = main.getConfig().getString("signs.ranks.level4");
		String level5 = main.getConfig().getString("signs.ranks.level5");
		
		if(block == null) return;
		
		//Verify world name
		if(player.getLocation().getWorld().getName().equals(worldName) != true) return;
		
		//Verify if sign is OAK_WALL_SIGN
		if(block.getType().equals(Material.OAK_WALL_SIGN) != true) return;
		
		//Get informations from sign
		Sign sign = (Sign) block.getState();
		
		//Verify if Line 1 (0) is title 
		if(sign.getLine(0).contains(signTitle) != true) return;
		
		
		//Verify level on line 2 (1)
		if(sign.getLine(1).contains(level1)) {
			addRank(player, sign, level1);
		}
		else if(sign.getLine(1).contains(level2)) {
			if(!LuckPermsInitialisation.isPlayerInGroup(player, "shop:" + level1.toLowerCase())) {
				player.sendMessage("§8[§bCelesky Shop§8]§cVous ne possédez pas le rang précédent.");
				return;
			}
			addRank(player, sign, level2);
		}
		else if(sign.getLine(1).contains(level3)) {
			if(!LuckPermsInitialisation.isPlayerInGroup(player, "shop:" + level2.toLowerCase())) {
				player.sendMessage("§8[§bCelesky Shop§8]§cVous ne possédez pas le rang précédent.");
				return;
			}
			addRank(player, sign, level3);
		}
		else if(sign.getLine(1).contains(level4)) {
			if(!LuckPermsInitialisation.isPlayerInGroup(player, "shop:" + level3.toLowerCase())) {
				player.sendMessage("§8[§bCelesky Shop§8]§cVous ne possédez pas le rang précédent.");
				return;
			}
			addRank(player, sign, level4);
		}
		else if(sign.getLine(1).contains(level5)) {
			if(!LuckPermsInitialisation.isPlayerInGroup(player, "shop:" + level4.toLowerCase())) {
				player.sendMessage("§8[§bCelesky Shop§8]§cVous ne possédez pas le rang précédent.");
				return;
			}
			addRank(player, sign, level5);
		}
		else {
			player.sendMessage("§8[§bCelesky Shop§8] §cErreur, rang non reconnu!");
		}
	}
	
	
	public void addRank(Player player, Sign sign, String level) {
		
		//get Economy
		Economy economy = VaultInitialisation.getEconomy();
		double playerMoneyValue = economy.getBalance(player);
		
		//Get level in lower case
		String levelLower = "shop:" + level.toLowerCase();
		
		//Verify if user has permission
		if(LuckPermsInitialisation.isPlayerInGroup(player, levelLower)) {
			player.sendMessage("§8[§bCelesky Shop§8]§aVous possédez déjà ce rang.");
			return;
		}
		
		//Get line 3 (2) of sign
		String price = sign.getLine(2);
		
		//Remove ' and c from string
		Integer priceClean = Integer.valueOf(price.replace("'", "").replace("c", ""));
		
		//If player have enough money
		if(playerMoneyValue >= priceClean) {
			
			//Remove money of player
			economy.withdrawPlayer(player, priceClean);
			
			//Send message
			player.sendMessage("§8[§bCelesky Shop§8]§aFélicitation vous venez de passer au rang de " + level);
			
			//Add Permission
			LuckPermsInitialisation.addGroup(player, levelLower);
			
		}
		else {
			player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'argent.");
		}
	}
	
}
