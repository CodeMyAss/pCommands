package prophecykits.plugins.minecraft.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import prophecykits.plugins.minecraft.Utilites.Utils;

public class StaffChat implements Listener {
	public static ArrayList<String> sc = new ArrayList<String>();
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player pl = e.getPlayer();
		if(sc.contains(pl.getName())) {
			e.setCancelled(true);
			Utils.messageStaff(pl, ChatColor.AQUA + "[STAFF CHAT] " + ChatColor.GRAY  + pl.getName() + ChatColor.WHITE + ": " + e.getMessage());
		}
	}

}
