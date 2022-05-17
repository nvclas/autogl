package de.theniclas.autogl.listeners;

import de.theniclas.autogl.utils.Config;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class MessageReceiveHandler implements MessageReceiveEvent {

	@Override
	public boolean onReceive(String formatted, String unformatted) {
		System.out.println(formatted);
		if(!Config.enabled) return false;
		if(!formatted.contains("§r§7Die Runde beginnt in §r§e5§r§7 Sekunden§r")) return false;
		Minecraft.getMinecraft().thePlayer.sendChatMessage(Config.message);
		return false;
	}
}
