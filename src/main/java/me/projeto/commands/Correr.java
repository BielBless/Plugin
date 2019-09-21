package me.projeto.commands;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Correr implements CommandExecutor {
    private HashMap<Player,Long> correr = new HashMap<Player, Long>();
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;
        if(c.getName().equalsIgnoreCase("correr")){
            if (correr.containsKey(p) && !(System.currentTimeMillis() >= correr.get(p))){
                p.sendMessage("Aguarde "+ convertido(p) + " segundos para usar esse comando novamente.");
                return false;
            }else correr.remove(p);

            correr.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*10,1,true,true, Color.BLACK));
            p.sendMessage("Um membro da STAFF lhe deu velocidade!");
        }
        return false;
    }
    public Long convertido(Player p){
        long tempo = System.currentTimeMillis() - correr.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}
