package fr.ted.celeskyshop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ted.celeskyshop.admin.AdminInformation;
import fr.ted.celeskyshop.dependencies.LuckPermsInitialisation;
import fr.ted.celeskyshop.dependencies.VaultInitialisation;
import fr.ted.celeskyshop.system.ConfigInitialisation;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;

public class Main extends JavaPlugin {

	
	
	@Override
	public void onEnable() {
		VaultInitialisation.vaultInit(this);
		LuckPermsInitialisation.luckPermsInit(this);
		
		ConfigInitialisation.configInit(this);
		
		getServer().getPluginManager().registerEvents(new ShopCore(this), this);
		getServer().getPluginManager().registerEvents(new ShopOpen(this), this);
		getServer().getPluginManager().registerEvents(new AdminInformation(this), this);
		getServer().getPluginManager().registerEvents(new SignPermission(this), this);
		
		Bukkit.getLogger().info("[CeleskyShop] Plugin loaded");
		
	}
	

	@Override
	public void onDisable() {
		Bukkit.getLogger().info("[CeleskyShop] Plugin unloaded");
	}
	
	
}
