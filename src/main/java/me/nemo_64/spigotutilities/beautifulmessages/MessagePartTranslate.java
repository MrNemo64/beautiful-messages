package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public abstract class MessagePartTranslate extends MessagePart {

	public MessagePartTranslate(String path, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		// TODO Auto-generated constructor stub
	}

	public MessagePartTranslate() {
		super();
	}
	
	public String getPath() {
		return getText();
	}
	
	public void setPath(String path) {
		setText(path);
	}

}
