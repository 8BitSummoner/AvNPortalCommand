package ca.avalonmc.avnportalcommand;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNPortalCommand extends JavaPlugin {
	
	static FileConfiguration config;
	static Logger log;
	
	
	@Override
	public void onEnable () {
		
		// Create config file (if needed)
		saveDefaultConfig();
		
		// Get config
		config = this.getConfig();
		
		// Register event handler
		getServer().getPluginManager().registerEvents(new AvNPortalCommandEventListener(), this);
		
		// Instantiate logger
		log = getLogger();
		
		log.info("=================================");
		log.info("AvNPortalCommand: Plugin Enabled! ");
		log.info("=================================");
		
	}
	
	
	@Override
	public void onDisable () {
		
		log.info("==================================");
		log.info("AvNPortalCommand: Plugin Disabled!");
		log.info("==================================");
		
	}
	
}
