package me.projeto;

import me.projeto.commands.*;
import me.projeto.entities.Entidade;
import me.projeto.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Projeto extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfiguration();
        registrarEventos();
        registrarComandos();
    }

    private void registrarEventos() {
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new EventsServer(), this);
        Bukkit.getPluginManager().registerEvents(new EntradaServer(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new NPCEvents(), this);
    }

    private void registrarComandos() {
        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("server").setExecutor(new DataServer());
        getCommand("levitar").setExecutor(new Efeito());
        getCommand("correr").setExecutor(new Correr());
        getCommand("limparinv").setExecutor(new limpar());
        getCommand("kit").setExecutor(new Capacete());
        getCommand("entidade").setExecutor(new Entidade());
    }


    @Override
    public void onDisable() {
    }

    private void loadConfiguration() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }
}
