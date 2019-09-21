package me.projeto.events;

import me.projeto.entities.WelcomeInventory;
import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;


public class PlayerEvents implements Listener {


    @EventHandler
    public void QuandoQuebrarBloco(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() == Material.GRASS) {

            p.sendMessage("§5Isso é um bloco de grama!");
            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 100, 2, true, true));
        }
        Bukkit.getConsoleSender().sendMessage(p + "Quebrou um bloco.");

        ItemStack item = p.getInventory().getItem(1);
        ItemStack diamond = p.getInventory().getItem(0);
        ItemStack elmo = new Item(Material.IRON_HELMET, 1, (short) 0)
                .setName("Um capacete mágico.")
                .setLore(Arrays.asList("Capacete locão."))
                .getItemStack();

                p.getInventory().setHelmet(elmo);

        if(diamond != null && diamond.getType() == Material.DIAMOND) p.sendMessage("Teste");

        if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("Um diamante bem legal!")){
            p.sendMessage("É uma espada sharp 400! Uou.");
        }
    }



    @EventHandler
    public void QuendoEntrarServidor(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("§5Bem-vindo ao servidor do BielBless! Servidor feito para testar Java.");
    }

    @EventHandler
    public void QuandoChamarComando(PlayerCommandPreprocessEvent e ) {
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("/youtube")) {
            p.openInventory(new WelcomeInventory().getInventory());
            e.setCancelled(true);
        }

    }
}
