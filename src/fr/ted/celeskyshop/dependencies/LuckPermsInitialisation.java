package fr.ted.celeskyshop.dependencies;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.ted.celeskyshop.Main;
import net.luckperms.api.LuckPerms;


public class LuckPermsInitialisation {
	
	private static LuckPerms luckPermsPlugin = null;
	
	
	public static void luckPermsInit(Main main) {
		if (!setupLuckPerms(main)) {
			Bukkit.getLogger().severe("[CeleskyShop] Disabled due to no Vault dependency found!");
            main.getServer().getPluginManager().disablePlugin(main);
            return;
        }
	}
	
	
	private static boolean setupLuckPerms(Main main) {
        if (main.getServer().getPluginManager().getPlugin("LuckPerms") == null) {
            return false;
        }
        
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider == null) {
		    return false;
		    
		}
		
		luckPermsPlugin = provider.getProvider();
        return luckPermsPlugin != null;
    }
	
	
	public static LuckPerms getLuckPerms() {
        return luckPermsPlugin;
    }
}
