package me.projeto.events;

import me.projeto.utils.Item;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class InventoryClick implements Listener {

    @EventHandler
    public void quandoClicar(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase("Bem vindo ao servidor!")) return;
        e.setCancelled(true);
        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();
        /*
        if (i.getType() == Material.DIAMOND){
            p.sendMessage("Olá. player.");
            p.closeInventory();
        }

        if(i.getType()==Material.GOLD_INGOT){
            p.sendMessage("Oi, player.");
            e.setCancelled(true);
            e.isShiftClick();
            p.closeInventory();
        }

        */

        if ((!i.hasItemMeta() && i.getItemMeta().hasDisplayName())) return;

        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("Aperte para receber um Olá.")) {
            ItemStack capa = new Item(Material.GOLD_HELMET, 1, (short) 0)
                    .setName("§aCapacete de ouro!")
                    .setLore(Arrays.asList("§7Capacete de ouro"))
                    .EncantoInq()
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                    .getItemStack();
            p.getInventory().setHelmet(capa);

            ItemStack espada = new Item(Material.STONE_SWORD, 1, (short) 0)
                    .setName("§aEspada de pedra!")
                    .EncantoInq()
                    .setEncanto(Enchantment.DAMAGE_ALL, 1)
                    .setLore(Arrays.asList("§7Espada de pedra!"))
                    .getItemStack();
                    p.getInventory().setItem(0, espada);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§5Você recebeu o kit ouro!"));
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
            p.closeInventory();
        }

        if (i.getItemMeta().getDisplayName().equalsIgnoreCase("Aperte para receber um oi.")) {
            ItemStack capacete2 = new Item(Material.IRON_HELMET, 1, (short) 0)
                    .setName("§aCapacete de ferro!")
                    .setLore(Arrays.asList("§7Capacete de ferro!"))
                    .setEncanto(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
                    .EncantoInq()
                    .getItemStack();
            p.getInventory().setHelmet(capacete2);
            ItemStack item = p.getInventory().getItem(0);
            ItemStack espada2 = new Item(Material.WOOD_SWORD, 1, (short) 0)
                    .setName("§aEspada de madeira!")
                    .setLore(Arrays.asList("§7Espada de madeira!"))
                    .setEncanto(Enchantment.DAMAGE_ALL, 1)
                    .EncantoInq()
                    .getItemStack();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§5Você recebeu o kit ferro!"));
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
           if(item == null) p.getInventory().addItem(espada2);
            p.closeInventory();


        }


    }
}
