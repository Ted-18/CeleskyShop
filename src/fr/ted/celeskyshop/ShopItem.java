package fr.ted.celeskyshop;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItem implements Listener {

	
	public static ItemStack addItemShop(Material material, int amout, String name, String lore, int prixAchat, int prixVente) {
			
			ItemStack item = new ItemStack(material, amout);
			
			ItemMeta itemMeta = item.getItemMeta();
			
			if(name != null) itemMeta.setDisplayName(name);
			if(lore != null) itemMeta.setLore(Arrays.asList(lore));
				
			if(prixAchat != 0 && prixVente != 0) {
				itemMeta.setLore(Arrays.asList("§7Achat: §a" + prixAchat, "§7Vente: §c" + prixVente));
			}
			else if(prixVente != 0) {
				itemMeta.setLore(Arrays.asList("§7Vente: §c" + prixVente));
			}
			else if(prixAchat != 0) {
				itemMeta.setLore(Arrays.asList("§7Achat: §a" + prixAchat));
			}
			
			item.setItemMeta(itemMeta);
			
			return item;
		}

}
