package me.mchiappinam.pdghdesbugar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {
    public static List<String> delayPDGH = new ArrayList<String>();

	  public void onEnable() {
		getServer().getPluginCommand("desbugar").setExecutor(this);
		getServer().getConsoleSender().sendMessage("§3[PDGHDesbugar] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHDesbugar] §2Acesse: http://pdgh.com.br/");
	  }

	  public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHDesbugar] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHDesbugar] §2Acesse: http://pdgh.com.br/");
	  }
		

	    @Override
	    public boolean onCommand(final CommandSender cs, Command cmd, String label, String[] args) {
	            if(cmd.getName().equalsIgnoreCase("desbugar")) {
	                if(delayPDGH.contains(cs.getName().toLowerCase())) {
	                	cs.sendMessage("§4[/d] §cAguarde um momento para desbugar novamente.");
	                	return true;
	                }
	                Player p=(Player)cs;
	                if(p.getWorld().getBlockAt(p.getLocation()).getType()==Material.WEB) {
	                	cs.sendMessage("§4[/d] §cVocê está preso em uma teia.");
	                	return true;
	                }
	                delayPDGH.add(cs.getName().toLowerCase());
	                //((Player)cs).getWorld().refreshChunk(((Player)cs).getLocation().getChunk().getX(), ((Player)cs).getLocation().getChunk().getZ());
	            	((Player)cs).teleport(((Player)cs).getLocation());
	                cs.sendMessage("§2[/d] §aDesbugado!");
	        		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	        			public void run() {
	        		        if(delayPDGH.contains(cs.getName().toLowerCase()))
	        		            delayPDGH.remove(cs.getName().toLowerCase());
	        			}
	        		}, 50L);
	                return true;
	            }
	            return false;
	    }
	  
}