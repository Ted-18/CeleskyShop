package fr.ted.celeskyshop;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItem implements Listener {

	
	public static ItemStack addItemShop(Material material, int amout, String name, String lore, double e, double d) {
			
			ItemStack item = new ItemStack(material, amout);
			
			ItemMeta itemMeta = item.getItemMeta();
			
			if(name != null) itemMeta.setDisplayName(name);
			if(lore != null) itemMeta.setLore(Arrays.asList(lore));
				
			if(e != 0 && d != 0) {
				itemMeta.setLore(Arrays.asList("§7Achat: §a" + e, "§7Vente: §c" + d));
			}
			else if(d != 0) {
				itemMeta.setLore(Arrays.asList("§7Vente: §c" + d));
			}
			else if(e != 0) {
				itemMeta.setLore(Arrays.asList("§7Achat: §a" + e));
			}
			
			item.setItemMeta(itemMeta);
			
			return item;
		}

}
