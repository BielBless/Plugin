package me.projeto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fome implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("fome")){
            if (p.getFoodLevel()<20){
                p.setFoodLevel(20);
                p.sendMessage("Barra de fome cheia!");
            }else{
                p.sendMessage("Você não está com fome.");
            }
        }

        return false;
    }
}
