package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

class MessagePartNBTStorage15 extends MessagePartNBTStorage {

	public MessagePartNBTStorage15(String path, String storage, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, storage, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	public MessagePart clone() {
		return new MessagePartNBTStorage15(getPath(), getStorage(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"nbt": <path>, "storage":"<resource id>",...}

		StringBuilder builder = new StringBuilder("{\"nbt\":\"");

		builder.append(getPath());

		builder.append("\", \"storage\":\"");

		builder.append(getStorage());

		builder.append("\"");

		if (!ignoreColors)
			builder = appendColor(builder);

		if (!ignoreEvents)
			builder = appendEvents(builder);

		builder.append("}");

		return builder.toString();
	}

}
