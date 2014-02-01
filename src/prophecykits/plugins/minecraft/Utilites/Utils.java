package prophecykits.plugins.minecraft.Utilites;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
	
	public static void messageStaff(Player p, String msg) {
		for(Player pls : Bukkit.getServer().getOnlinePlayers()) {
			if(pls.hasPermission("staffchat.see")) {
				pls.sendMessage(msg);
			}
		}
	}

}
