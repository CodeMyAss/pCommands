package prophecykits.plugins.minecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandClearChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(cmd.getName().equalsIgnoreCase("clearchat")) {
			if(!sender.hasPermission("clearchat.yes")) {
				sender.sendMessage(ChatColor.RED + "You do not have enough permissions!");
				return true;
			}
			for (int i = 0; i < 200; i++) {
				Bukkit.broadcastMessage(" ");
			}
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.ITALIC + "Chat has been cleared by " + sender.getName());
			return false;					
		}
		return false;
	}

}
