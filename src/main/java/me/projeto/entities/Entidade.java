package me.projeto.entities;

import me.projeto.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class Entidade implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if(!(s instanceof Player)) return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("entidade")){

            if(args.length == 0){
                p.sendMessage("Você spawnou uma entidade!");
                spawnarNPC(p);
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("remover")){

                    for(World world : Bukkit.getWorlds()){
                        for (Entity en : world.getEntities()){
                            if(en.getCustomName() != null && en.getCustomName().equalsIgnoreCase("§6Mercador")) en.remove();
                        }
                    }
                }
            }

        }
        return false;
    }

   /* private void Entity(Player p){
        IronGolem ig = (IronGolem) p.getWorld().spawnEntity(p.getLocation(), EntityType.IRON_GOLEM);
        ig.setCustomName("Faustinho");
        ig.setCustomNameVisible(true);
        ig.setGlowing(true);

        ig.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.7);
        ig.setInvulnerable(true);



    }
*/

   private void spawnarNPC(Player p){
       Villager vl = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
       vl.setCustomNameVisible(true);
       vl.setCustomName("§6Mercador");
       vl.setProfession(Villager.Profession.BLACKSMITH);
       vl.setCareer(Villager.Career.WEAPON_SMITH);
       vl.setInvulnerable(true);
       vl.setAI(false);
   }

}
