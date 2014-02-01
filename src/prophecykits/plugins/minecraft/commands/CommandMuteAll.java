package prophecykits.plugins.minecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import prophecykits.plugins.minecraft.listeners.Muted;

public class CommandMuteAll implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(cmd.getName().equalsIgnoreCase("muteall")) {
			if(!sender.hasPermission("muteall.yes")) {
				sender.sendMessage(ChatColor.RED + "You do not have enough permissions!");
				return true;
			}
			if(Muted.mutedAll == true) {
				Muted.mutedAll = false;
				Bukkit.broadcastMessage(ChatColor.GREEN
						+ "Chat is no longer muted!");
			}
			else {
				Muted.mutedAll = true;
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Chat is now muted!");
			}
		}
		return false;
	}

}
