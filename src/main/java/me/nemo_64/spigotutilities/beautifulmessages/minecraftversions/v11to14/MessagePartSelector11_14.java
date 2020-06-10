package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11to14;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePartSelector;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePartSelector11_14 extends MessagePartSelector {

	public MessagePartSelector11_14(String selector, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartSelector11_14() {
		super();
	}

	@Override
	public String toJSON() {
		// {"selector":"SELECTOR",...}
		StringBuilder builder = new StringBuilder("{\"selector\":\"");
		
		builder.append(getText().replace("\"", "\\\""));
		
		builder.append("\"");
		
		builder = appendColor(builder);
		
		builder = appendEvents(builder);
		
		builder.append("}");
		
		return builder.toString();
	}

	@Override
	public MessagePartSelector clone() {
		return new MessagePartSelector11_14(getText(), getColor(), isBold(), isItalics(), isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

}
