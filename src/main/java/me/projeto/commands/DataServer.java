package me.projeto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class DataServer implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("server")){
            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage(("&dDigite /server um para data servidor.").replace("&", "§"));
                p.sendMessage(("&dDigite /server dois para saber a data que eu comprei o curso.").replace("&", "§"));
                p.sendMessage("");
                return true;
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("um")){
                    p.sendMessage("");
                    p.sendMessage(("&dServidor criado em 11/09/2019.").replace("&","§"));
                    p.sendMessage("");
                    return true;
                }
                   if(args[0].equalsIgnoreCase("dois")) {
                       p.sendMessage("");
                       p.sendMessage(("&dCurso comprado em 11/09/2019 também.").replace("&", "§"));
                       p.sendMessage("");
                       return true;
                   }
            }
        }

        return false;
    }
}
