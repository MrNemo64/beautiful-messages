package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

/**
 * This message part gets replaced with the entityes that match the criteria.<br>
 * If you set as selector "@a", it will get replaced with the name of all the players.<br>
 * The delector may change with the version.
 */
public abstract class MessagePartSelector extends MessagePart {
	
	public MessagePartSelector(@Nonnull String selector, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}
	
	public MessagePartSelector() {
		super();
	}
	
}
