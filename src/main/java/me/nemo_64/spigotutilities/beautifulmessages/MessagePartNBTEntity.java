package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public abstract class MessagePartNBTEntity extends MessagePartNBT {

	private String selector;

	public MessagePartNBTEntity(String path, String selector, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.selector = selector;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

}
