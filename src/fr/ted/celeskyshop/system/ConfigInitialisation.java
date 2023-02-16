package fr.ted.celeskyshop.system;

import java.io.File;

import org.bukkit.Bukkit;

import fr.ted.celeskyshop.Main;

public class ConfigInitialisation {
	
	public static void configInit(Main main) {
//		main.saveDefaultConfig(); 
		
		if (!main.getDataFolder().exists()) {
			main.getDataFolder().mkdirs(); 
		} 
		
		File file = new File(main.getDataFolder(), "config.yml"); 
		
		if (!file.exists()) { 
			Bukkit.getLogger().info("[CeleskyShop] Configuration file created");
			main.saveDefaultConfig(); 
		}
		else {
			Bukkit.getLogger().info("[CeleskyShop] Configuration file already exist");
		}
	}
}
