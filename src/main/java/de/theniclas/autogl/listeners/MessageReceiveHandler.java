package de.theniclas.autogl.listeners;

import de.theniclas.autogl.utils.Config;
import de.theniclas.autogl.utils.ServerMessages;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class MessageReceiveHandler implements MessageReceiveEvent {

	@Override
	public boolean onReceive(String formatted, String unformatted) {
		System.out.println(formatted);
		if(!Config.enabled) return false;
		if(!ServerMessages.messages.stream().anyMatch(s -> formatted.contains(s))) return false;
		Minecraft.getMinecraft().thePlayer.sendChatMessage(Config.message);
		return false;
	}
}
