package me.projeto.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntradaServer implements Listener {

    @EventHandler
    public void EntrouServer(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aSeja bem-vindo ao servidor, " + p.getName()));
    }

    @EventHandler
    public void SaiuServer(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Bukkit.broadcastMessage("O jogador §4§l[§a§l+§4§l] §f" + e.getPlayer().getName() + " saiu do servidor servidor");
    }

}
