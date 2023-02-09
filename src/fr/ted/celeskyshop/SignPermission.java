package fr.ted.celeskyshop;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.ted.celeskyshop.dependencies.VaultInitialisation;
import net.milkbowl.vault.economy.Economy;

public class SignPermission implements Listener {
	
	private static Main main;
	
	public SignPermission(Main main) {
		SignPermission.main = main;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		
		String worldName = main.getConfig().getString("signs.settings.world");
		String signTitle = main.getConfig().getString("signs.settings.signTitle");
		String level1 = main.getConfig().getString("signs.ranks.level1");
		String level2 = main.getConfig().getString("signs.ranks.level2");
		String level3 = main.getConfig().getString("signs.ranks.level3");
		String level4 = main.getConfig().getString("signs.ranks.level4");
		String level5 = main.getConfig().getString("signs.ranks.level5");
		
		if(player.getLocation().getWorld().getName().equals(worldName) != true) return;
		
		if(block.getType().equals(Material.OAK_WALL_SIGN) != true) return;
		

		Sign sign = (Sign) block.getState();
		
		if(sign.getLine(0).contains(signTitle) != true) return;
		
		
		if(sign.getLine(1).contains(level1)) addRank(player, sign);
		else if(sign.getLine(1).contains(level2)) addRank(player, sign);
		else if(sign.getLine(1).contains(level3)) addRank(player, sign);
		else if(sign.getLine(1).contains(level4)) addRank(player, sign);
		else if(sign.getLine(1).contains(level5)) addRank(player, sign);
		else player.sendMessage("§8[§bCelesky Shop§8] §cErreur, rang non reconnu!");
	}
	
	
	public void addRank(Player player, Sign sign) {
		Economy economy = VaultInitialisation.getEconomy();
		double playerMoneyValue = economy.getBalance(player);
		
		String price = sign.getLine(2);
		
		Integer priceClean = Integer.valueOf(price.replace("'", "").replace("c", ""));

		if(playerMoneyValue >= priceClean) {
			
			//Remove money of player
			economy.withdrawPlayer(player, priceClean);
			
		}
		else {
			player.sendMessage("§8[§bCelesky Shop§8]§cVous n'avez pas l'argent.");
		}
	}
	
}
