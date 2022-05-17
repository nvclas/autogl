package de.theniclas.autogl.main;

import java.util.List;

import de.theniclas.autogl.listeners.MessageReceiveHandler;
import de.theniclas.autogl.utils.Config;
import de.theniclas.autogl.utils.Settings;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

public class Main extends LabyModAddon {

	private static Main addon;
	
	@Override
	protected void fillSettings(List<SettingsElement> settings) {
		Settings.fillSettigs(settings);
	}

	@Override
	public void loadConfig() {
		Config.enabled = getConfig().has("Enabled") ? getConfig().get("Enabled").getAsBoolean() : true;
		Config.message = getConfig().has("Message") ? getConfig().get("Message").getAsString() : "gl";
	}

	@Override
	public void onEnable() {
		addon = this;
		api.getEventManager().register(new MessageReceiveHandler());
	}

	public static Main getAddon() {
		return addon;
	}
	
}
