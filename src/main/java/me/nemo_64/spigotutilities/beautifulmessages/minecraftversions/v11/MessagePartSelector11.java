package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePartSelector;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePartSelector11 extends MessagePartSelector {

	public MessagePartSelector11(String selector, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartSelector11() {
		super();
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"selector":"SELECTOR",...}
		StringBuilder builder = new StringBuilder("{\"selector\":\"");

		builder.append(getText().replace("\"", "\\\""));

		builder.append("\"");

		if (!ignoreColors)
			builder = appendColor(builder);

		if (!ignoreEvents)
			builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

	@Override
	public MessagePartSelector clone() {
		return new MessagePartSelector11(getText(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

}
