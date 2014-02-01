package prophecykits.plugins.minecraft;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import prophecykits.plugins.minecraft.commands.CommandClearChat;
import prophecykits.plugins.minecraft.commands.CommandMuteAll;
import prophecykits.plugins.minecraft.commands.CommandStaffChat;
import prophecykits.plugins.minecraft.listeners.Muted;
import prophecykits.plugins.minecraft.listeners.StaffChat;

public class pCommands extends JavaPlugin {
	public Logger log;
	public Plugin pl;
	
	public void onEnable() {
		pl = this;
		log = getLogger();
		log.warning("enabled");
		loadCommands();
		loadListeners();
	}
	
	
	public void loadCommands() {
		getCommand("clearchat").setExecutor(new CommandClearChat());
		getCommand("staffchat").setExecutor(new CommandStaffChat());
		getCommand("muteall").setExecutor(new CommandMuteAll());
	}
	
	
	public void loadListeners() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new StaffChat(), this);
		pm.registerEvents(new Muted(), this);
	}
	
	public void onDisable() {
		log.warning("disabled");
	}
	
	

}
