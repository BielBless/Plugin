package me.projeto.entities;

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class WelcomeInventory {

    private Inventory inventory;

    public WelcomeInventory() {
        inventory = Bukkit.createInventory(null, 9*3, "Bem vindo ao servidor!");
        insertItens();
    }

    private WelcomeInventory insertItens(){
        ItemStack i2 = new Item(Material.GOLD_INGOT, 1, (short) 0).setName("Aperte para receber um oi.").getItemStack();

        ItemStack i = new Item(Material.DIAMOND, 1, (short) 0).setName("Aperte para receber um Olá.").getItemStack();

        inventory.setItem(12, i);
        inventory.setItem(14, i2);

        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
