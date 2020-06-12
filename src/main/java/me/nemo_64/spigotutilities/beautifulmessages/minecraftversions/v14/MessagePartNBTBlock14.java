package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v14;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import me.nemo_64.spigotutilities.beautifulmessages.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.HoverEvent;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePartNBTBlock;

public class MessagePartNBTBlock14 extends MessagePartNBTBlock {

	public MessagePartNBTBlock14(String nbtPath, Location block, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(nbtPath, block, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	public MessagePart clone() {
		return new MessagePartNBTBlock14(getText(), getBlock(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		// {"block":"X Y Z","nbt":"PATH","interpret":true,...}

		StringBuilder builder = new StringBuilder("{\"block\":\"");

		builder.append(getBlock().getBlockX());

		builder.append(" ");

		builder.append(getBlock().getBlockY());

		builder.append(" ");

		builder.append(getBlock().getBlockZ());

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
