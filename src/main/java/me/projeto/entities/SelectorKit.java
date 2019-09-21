package me.projeto.entities;

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class SelectorKit {

    private Inventory inventory;

    public SelectorKit(){
       inventory = Bukkit.createInventory(null, 9*3, "Selecione um kit!");
        insertKits();
    }

    private SelectorKit insertKits(){
        ItemStack i1 = new Item(Material.WOOD_SWORD, 1, (short) 0).setName("§aKit madeira!").getItemStack();
        ItemStack i2 = new Item(Material.STONE_SWORD, 1, (short) 0).setName("§aKit pedra!").getItemStack();

        inventory.setItem(12, i1);
        inventory.setItem(14, i2);
        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
