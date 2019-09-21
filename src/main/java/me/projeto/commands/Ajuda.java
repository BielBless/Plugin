package me.projeto.commands;
import me.projeto.entities.WelcomeInventory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import me.projeto.utils.Item;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Ajuda implements CommandExecutor  {

   private HashMap<Player,Long> ajuda = new HashMap<Player,Long>();


    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("ajuda")){


            if (ajuda.containsKey(p) && !(System.currentTimeMillis()>= ajuda.get(p))){
                p.sendMessage("Aguarde " + converter(p) + " segundos para realizar esse comando novamente.");
                return false;
            }else ajuda.remove(p);




            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

                if(args.length == 0){
                    p.sendMessage("");
                    p.sendMessage("Faltou argumentos. Digite /ajuda 1 para o servidor.");
                    p.sendMessage("Faltou argumentos. Digite /ajuda 2 para o youtube.");
                    p.sendMessage("");
                    return true;
                }

            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("1")){
                    p.sendMessage("§aO servidor está na versão 1.12.2");

                    ItemStack espadaPedra = new Item(Material.STONE_SWORD, 1, (short) 0)
                            .setName("Um diamante bem legal!")
                            .setLore(Arrays.asList("Um diamante.","Apenas um diamante."))
                            .setEncanto(Enchantment.DAMAGE_ALL, 400)
                            .EncantoInq()
                            .getItemStack();
                    p.getInventory().addItem(espadaPedra);
                    return true;

                }
                    if(args[0].equalsIgnoreCase("2")){
                        p.sendMessage("");
                        p.sendMessage("§cYoutube está indisponivel.");
                        p.sendMessage("");
                        return true;

                    }


            }


        }
        return false;
    }
    private Long converter (Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}
