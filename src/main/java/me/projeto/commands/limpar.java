package me.projeto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class limpar implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("limparinv")){
            if(args.length == 0){
                p.sendMessage("Limpar inventario todo? Digite /limparinv full");
                p.sendMessage("Limpar primeiro item da sua mão? Digite /limparinv mao");
                    return true;
            }
            if (args.length == 1){
                if(args[0].equalsIgnoreCase("full")){
                    p.getInventory().clear();
                    p.sendMessage(("&dInventário limpo!").replace("&","§"));
                    return true;
                }
                    if (args[0].equalsIgnoreCase("mao")){
                        p.getInventory().clear(0);
                        p.sendMessage(("&dMão limpa!").replace("&","§"));
                        return true;
                }
            }
        }



        return false;
    }
}
