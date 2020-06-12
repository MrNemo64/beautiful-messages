package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

class MessagePartScore8 extends MessagePartScore {

	public MessagePartScore8(String player, String score, ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(player, score, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartScore8() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartScore8(getPlayer(), getScore(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"score":{"name":"PLAYER","objective":"SCOREBOARD"},...}
		StringBuilder builder = new StringBuilder("{\"score\":{\"name\":\"");

		builder.append(getPlayer());

		builder.append("\",\"objective\":\"");

		builder.append(getScore());

		builder.append("\"}");

		if (!ignoreColors)
			builder = appendColor(builder);

		if (!ignoreEvents)
			builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

}
