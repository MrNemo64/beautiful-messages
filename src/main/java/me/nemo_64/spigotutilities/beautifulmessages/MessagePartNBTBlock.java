package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

/**
 * This only works on minecraft 1.14+<br>
 * This message part will be replaced with the specified nbt data of a specified
 * block
 */
public abstract class MessagePartNBTBlock extends MessagePartNBT {

	private Location block;

	public MessagePartNBTBlock(String nbtPath, Location block, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(nbtPath, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.block = block;
	}

	public Location getBlock() {
		return block;
	}

	public void setBlock(Location block) {
		this.block = block;
	}

}
