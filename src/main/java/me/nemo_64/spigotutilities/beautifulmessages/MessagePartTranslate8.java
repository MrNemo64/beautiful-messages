package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

class MessagePartTranslate8 extends MessagePartTranslate {

	public MessagePartTranslate8(String path, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartTranslate8() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartTranslate8(getText(), getColor(), isBold(), isItalics(), isUnderlined(),
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
