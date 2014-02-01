package prophecykits.plugins.minecraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Muted implements Listener {
	
	public static boolean mutedAll = false;
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player pl = e.getPlayer();
		if(mutedAll == true && (!pl.hasPermission("muteall.bypass"))) {
			e.setCancelled(true);
			pl.sendMessage(ChatColor.RED + "You cannot talk during a muted chat.");
		}
				
	}
}