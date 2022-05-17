package de.theniclas.autogl.utils;

import java.util.List;

import de.theniclas.autogl.main.Main;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.StringElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

public class Settings {

	public static void fillSettigs(List<SettingsElement> settings) {
		
		BooleanElement enable = new BooleanElement("Enable addon", new ControlElement.IconData(Material.LEVER), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean toggle) {
				Config.enabled = toggle;
				Main.getAddon().getConfig().addProperty("Enabled", toggle);
			}
		}, Config.enabled);
		
		StringElement message = new StringElement("Message", new ControlElement.IconData(Material.PAPER), Config.message, new Consumer<String>() {
			@Override
			public void accept(String message) {
				Config.message = message;
				Main.getAddon().getConfig().addProperty("Message", message);
			}
		});
		
		settings.add(enable);
		settings.add(message);
		
	}
	
}
