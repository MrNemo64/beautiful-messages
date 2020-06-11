package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePartTranslate;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePartTranslate11 extends MessagePartTranslate {

	public MessagePartTranslate11(String path, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartTranslate11() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartTranslate11(getText(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"translate":"block.minecraft.stone"}

		StringBuilder builder = new StringBuilder("{\"translate\":\"");
		
		builder.append(getPath());
		
		builder.append("\"");
		
		if(!ignoreColors)
			builder = appendColor(builder);
		
		if(!ignoreEvents)
			builder = appendEvents(builder);
		
		builder.append("}");
		
		return builder.toString();
	}

}
