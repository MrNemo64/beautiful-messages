package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v12;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.HoverEvent;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePartKeybind;

public class MessagePartKeybind12 extends MessagePartKeybind {

	public MessagePartKeybind12(Keybind key, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(key, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartKeybind12() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartKeybind12(getKey(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"keybind":"KEY",...}
		StringBuilder builder = new StringBuilder("{\"keybind\":\"");

		builder.append(getKey().getPath());

		builder.append("\"");

		if (!ignoreColors)
			builder = appendColor(builder);

		if (!ignoreEvents)
			builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

}
