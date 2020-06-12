package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

class MessagePartNBTEntity14 extends MessagePartNBTEntity {

	public MessagePartNBTEntity14(String path, String selector, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, selector, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	public MessagePart clone() {
		return new MessagePartNBTEntity14(getText(), getSelector(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"entity":"SELECTOR","nbt":"PATH","interpret":true,...}

		StringBuilder builder = new StringBuilder("{\"entity\":\"");

		builder.append(getSelector());

		builder.append("\",\"nbt\":\"");

		builder.append(getPath());

		builder.append("\"");

		builder = appendInterpret(builder);

		builder = appendColor(builder);

		builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

}
