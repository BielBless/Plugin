package me.projeto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("curar")){
            if(p.getHealth()<20){
                p.setHealth(20);
                p.setFireTicks(0);
                p.sendMessage("Você foi curado!");
            }else{
                p.sendMessage("Você está com a vida cheia!");
            }
        }


        return false;
    }
}