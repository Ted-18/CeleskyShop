package fr.ted.celeskyshop.dependencies;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.ted.celeskyshop.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;


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
	
	
	public static void addGroup(Player player, String permission) {
		User user = luckPermsPlugin.getPlayerAdapter(Player.class).getUser(player);
		
		// Add the permission
	    user.data().add(Node.builder("group." + permission).build());

	    // Now we need to save changes.
	    luckPermsPlugin.getUserManager().saveUser(user);
	}
	
	public static boolean isPlayerInGroup(Player player, String group) {
	    return player.hasPermission("group." + group);
	}
}
