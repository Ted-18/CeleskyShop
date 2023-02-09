package fr.ted.celeskyshop.dependencies;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.ted.celeskyshop.Main;
import net.milkbowl.vault.economy.Economy;

public class VaultInitialisation {
	
	private static Economy econ = null;
	
	
	public static void vaultInit(Main main) {
		if (!setupEconomy(main)) {
			Bukkit.getLogger().severe("[CeleskyShop] Disabled due to no Vault dependency found!");
            main.getServer().getPluginManager().disablePlugin(main);
            return;
        }
	}
	
	
	private static boolean setupEconomy(Main main) {
        if (main.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = main.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	
	public static Economy getEconomy() {
        return econ;
    }
}
