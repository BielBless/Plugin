package me.projeto.events;

import me.projeto.utils.Item;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ClickKit implements Listener {

    @EventHandler
    public void selecionarKit(InventoryClickEvent e){
        if(!e.getInventory().getName().equalsIgnoreCase("Selecione um kit!")) return;
        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if(!i.hasItemMeta() && i.getItemMeta().hasDisplayName()) return;

        if(i.getItemMeta().getDisplayName().equalsIgnoreCase("§aKit madeira!")){
            ItemStack item = p.getInventory().getItem(0);
            ItemStack i1 = new Item(Material.WOOD_SWORD, 1, (short) 0)
                    .setName("§aEspada de madeira!")
                    .EncantoInq()
                    .setEncanto(Enchantment.DAMAGE_ALL, 1)
                    .getItemStack();
            p.getInventory().setItem(0, i1);

            ItemStack i2 = new Item(Material.IRON_HELMET, 1, (short) 0)
                    .setName("§aCapacete de ferro!")
                    .EncantoInq()
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                    .getItemStack();
            p.getInventory().setHelmet(i2);
        }
        if(i.getItemMeta().getDisplayName().equalsIgnoreCase("§aKit pedra!")){
            ItemStack item = p.getInventory().getItem(0);
            ItemStack i3 = new Item(Material.STONE_SWORD, 1, (short) 0 )
                    .setName("§aEspada de pedra!")
                    .EncantoInq()
                    .setEncanto(Enchantment.DAMAGE_ALL, 1)
                    .getItemStack();
             p.getInventory().setItem(0, i3);

            ItemStack i4 = new Item(Material.GOLD_HELMET, 1, (short) 0)
                    .setName("§aCapacete de ouro!")
                    .EncantoInq()
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                    .getItemStack();
           p.getInventory().setHelmet(i4);

        }
    }

}
