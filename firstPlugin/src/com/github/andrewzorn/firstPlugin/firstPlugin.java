package com.github.andrewzorn.firstPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class firstPlugin extends JavaPlugin {
	@Override
    public void onEnable(){
		getLogger().info("onEnable has been invoked!");
    }
 
    @Override
    public void onDisable() {
    	getLogger().info("onDisable has been invoked!");
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("getLessHungry")) {
			player.setFoodLevel(20);
			player.sendMessage("Does a body good.");
			return true;
		}
    	
    	else if (cmd.getName().equalsIgnoreCase("getFixedUp")) {
    		player.setHealth(20);
    		player.sendMessage("That's the stuff...");
    		return true;
    	}
		
    	else if (cmd.getName().equalsIgnoreCase("spareChange")) {
    		if( player.getInventory().contains(Material.DIAMOND,1) &&
    				player.getInventory().contains(Material.GOLD_INGOT,1) ) {
    			player.sendMessage("You're no bum!");
    			player.setHealth(1);
    		}
    		else {
    			player.getInventory().addItem(new ItemStack(Material.DIAMOND,1));
    			player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT,1));
    			player.sendMessage("Don't spend it all in once place.");
    		}
    		return true;
    	}
		
    	else if (cmd.getName().equalsIgnoreCase("getPaid")) {
    		if(player.hasPermission("tallStacks")) {
    			player.getInventory().addItem(new ItemStack(Material.DIAMOND,64));
    			player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT,64));
    			player.sendMessage("Chasin' paper!");
    		}
    		else
    			player.sendMessage("Healthcare may be a basic human right, tall stacks are not.");
    		return true;
    	}
		
    	return false;
    }
}