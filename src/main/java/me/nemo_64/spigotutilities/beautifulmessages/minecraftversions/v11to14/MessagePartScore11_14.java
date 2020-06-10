package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11to14;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.MessagePart;
import me.nemo_64.spigotutilities.beautifulmessages.MessagePartScore;
import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

public class MessagePartScore11_14 extends MessagePartScore {

	public MessagePartScore11_14(String player, String score, ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(player, score, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	public MessagePartScore11_14() {
		super();
	}

	@Override
	public MessagePart clone() {
		return new MessagePartScore11_14(getPlayer(), getScore(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	@Override
	public String toJSON() {
		// {"score":{"name":"PLAYER","objective":"SCOREBOARD"},...}
		StringBuilder builder = new StringBuilder(",{\"score\":{\"name\":\"");
		
		builder.append(getPlayer());
		
		builder.append("\",\"objective\":\"");
		
		builder.append(getScore());
		
		builder.append("\"}");
		
		builder = appendColor(builder);
		
		builder = appendEvents(builder);
		
		builder.append("}");
		
		return builder.toString();
	}

}
