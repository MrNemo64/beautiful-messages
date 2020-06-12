package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

class MessagePartSelector8 extends MessagePartSelector {

	public MessagePartSelector8(String selector, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartSelector8() {
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
		return new MessagePartSelector8(getText(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

}
