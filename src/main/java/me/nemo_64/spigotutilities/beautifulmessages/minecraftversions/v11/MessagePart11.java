package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePart11 extends MessagePart {

	public MessagePart11(@Nonnull String text, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super(text, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	/**
	 * Creates an empty message part
	 */
	public MessagePart11() {
		super("empty", ChatColor.WHITE, false, false, false, false, false, null, null);
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"text":"TEXT",...}
		StringBuilder builder = new StringBuilder("{\"text\":\"");

		builder.append(getText().replace("\"", "\\\""));

		builder.append("\"");

		if (!ignoreColors)
			builder = appendColor(builder);

		if (!ignoreEvents)
			builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

	public MessagePart clone() {
		return new MessagePart11(getText(), getColor(), isBold(), isItalics(), isUnderlined(), isStrikethrough(),
				isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toString() {
		return toJSON();
	}
}
