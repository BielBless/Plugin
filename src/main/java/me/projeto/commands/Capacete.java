package me.projeto.commands;

import me.projeto.utils.Item;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class Capacete implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("kit")){
            ItemStack capacete = new Item(Material.IRON_HELMET,1,(short) 0)
                    .setName("§7Capacete de ferro!")
                    .setLore(Arrays.asList("§aCapacete de ferro!"))
                    .EsconderEncantos()
                    .EncantoInq()
                    .getItemStack();
                    p.getInventory().setHelmet(capacete);
            ItemStack item = p.getInventory().getItem(0);
            ItemStack espada = new Item(Material.STONE_SWORD,1, (short) 0)
                    .setName("§cEspada de pedra!")
                    .setLore(Arrays.asList("§aEspada de pedra!"))
                    .EncantoInq()
                    .setEncanto(Enchantment.DAMAGE_ALL, 1)
                    .EsconderEncantos()
                    .getItemStack();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Você recebeu o kit capacete."));
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 10);
           if (item == null) p.getInventory().addItem(espada);
            return true;
        }

        return false;
    }
}
