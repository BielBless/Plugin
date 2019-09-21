package me.projeto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Efeito implements CommandExecutor {
    private HashMap<Player,Long> levitar = new HashMap<Player, Long>();
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("levitar")){

            if (levitar.containsKey(p) && !(System.currentTimeMillis()>= levitar.get(p))){
                p.sendMessage("Aguarde "+ converter(p) +" segundos para usar esse comando novamente.");
                return false;
            }else levitar.remove(p);

            levitar.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*10, 1, false, false));
            p.sendMessage("Um membro da STAFF lhe deu a liberdade de LEVITAR por 10 segundos!");
        }

        return false;
    }

    public Long converter(Player p){
        long tempo = System.currentTimeMillis() - levitar.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }

}
