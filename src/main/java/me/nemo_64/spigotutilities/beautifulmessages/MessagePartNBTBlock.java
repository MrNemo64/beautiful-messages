package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Location;

/**
 * This only works on minecraft 1.14+<br>
 * This message part will be replaced with the specified nbt data of a specified
 * block
 */
public abstract class MessagePartNBTBlock extends MessagePartNBT {

	private Location block;

	protected MessagePartNBTBlock(String nbtPath, Location block, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(nbtPath, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.block = block;
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to false
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param location
	 *            The location of the block
	 * @param color
	 *            The color of the text
	 * @param bold
	 *            If the text is bold
	 * @param italics
	 *            If the text is in italics
	 * @param underlined
	 *            If the text is underlined
	 * @param strikethrough
	 *            If the text is in strikethrough
	 * @param obfuscated
	 *            If the text is obfuscated
	 * @param click
	 *            The click event
	 * @param hover
	 *            The hover event
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTBlock create(@Nonnull String nbtPath, @Nonnull Location location,
			@Nullable ChatColor color, boolean bold, boolean italics, boolean underlined, boolean strikethrough,
			boolean obfuscated, @Nullable ClickEvent click, @Nullable HoverEvent hover) {
		return new MessagePartNBTBlock14(nbtPath, location, false, color, bold, italics, underlined, strikethrough,
				obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to false
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param location
	 *            The location of the block
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTBlock create(@Nonnull String nbtPath, @Nonnull Location location) {
		return create(nbtPath, location, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version <br>
	 * interpret is set by default to false
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param location
	 *            The location of the block
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTBlock create(@Nonnull String nbtPath, @Nonnull Location location,
			@Nullable ChatColor color) {
		return new MessagePartNBTBlock14(nbtPath, location, false, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to false
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param location
	 *            The location of the block
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTBlock create(@Nonnull String nbtPath, @Nonnull Location location,
			@Nullable ChatColor color, boolean bold) {
		return new MessagePartNBTBlock14(nbtPath, location, false, color, bold, false, false, false, false, null, null);
	}

	public Location getBlock() {
		return block;
	}

	public void setBlock(Location block) {
		this.block = block;
	}

}
