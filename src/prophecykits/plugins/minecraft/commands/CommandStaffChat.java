package prophecykits.plugins.minecraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import prophecykits.plugins.minecraft.listeners.StaffChat;

public class CommandStaffChat implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You are not a player!");
			return true;
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("staffchat")) {
			if(!sender.hasPermission("clearchat.yes")) {
				sender.sendMessage(ChatColor.RED + "You do not have enough permissions!");
				return true;
			}
			if(StaffChat.sc.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "You have un-toggle staff chat!");
				StaffChat.sc.remove(p.getName());
			}
			else {
				p.sendMessage(ChatColor.RED + "You have toggle staff chat!");
				StaffChat.sc.add(p.getName());
			}
		}
		return false;
	}
}