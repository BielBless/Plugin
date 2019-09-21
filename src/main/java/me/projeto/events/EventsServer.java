package me.projeto.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class EventsServer implements Listener {


    @EventHandler
    public void Refresh(ServerListPingEvent e){
        if(!Bukkit.hasWhitelist()) e.setMotd("§5Venha jogar!");
        else e.setMotd("§7Servidor em manunteção!");
    }
}
