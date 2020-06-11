package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public abstract class MessagePartNBT extends MessagePart {

	private boolean interpret;

	public MessagePartNBT(String path, boolean interpret, ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.interpret = interpret;
	}

	public boolean isInterpret() {
		return interpret;
	}

	public void setInterpret(boolean interpret) {
		this.interpret = interpret;
	}
	
	public String getPath() {
		return getText();
	}
	
	public void setPath(String path) {
		setText(path);
	}
	
	protected StringBuilder appendInterpret(StringBuilder builder) {
		if (isInterpret()) {
			builder.append(",\"interpret\":");
			builder.append(isInterpret());
		}
		return builder;
	}

}
