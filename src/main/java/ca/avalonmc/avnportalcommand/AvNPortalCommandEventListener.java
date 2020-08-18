package ca.avalonmc.avnportalcommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import static ca.avalonmc.avnportalcommand.AvNPortalCommand.*;


public class AvNPortalCommandEventListener implements Listener {
	
	private String command = config.getString("Command");
	
	
	@EventHandler
	public void onPortalActivate (PlayerPortalEvent e) {
		
		if (e.getCause() != PlayerPortalEvent.TeleportCause.NETHER_PORTAL) {
			
			return;
			
		}
		
		e.setCancelled(true);
		
		if (command == null) {
			
			log.warning("Command not found in config.");
			return;
			
		}
		
		if (!e.getPlayer().performCommand(command)) {
			
			log.warning("Command '" + command + "'failed to run for " + e.getPlayer().getName());
			return;
			
		}
		
		if (config.getBoolean("EnableLogging")) {
			
			log.info("Command '" + command + "' ran successfully for " + e.getPlayer().getName());
			
		}
	
	}
	
}
