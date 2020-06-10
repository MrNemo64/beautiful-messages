package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11to14;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePartKeybind;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePartKeybind11_14 extends MessagePartKeybind {

	public MessagePartKeybind11_14(Keybind key, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(key, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartKeybind11_14() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartKeybind11_14(getKey(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON() {
		// {"keybind":"KEY",...}
		StringBuilder builder = new StringBuilder("{\"keybind\":\"");
		
		builder.append(getKey().getPath());
		
		builder.append("\"");
		
		builder = appendColor(builder);
		
		builder = appendEvents(builder);
		
		builder.append("}");
		
		return builder.toString();
	}

}
