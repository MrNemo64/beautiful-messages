package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import org.bukkit.ChatColor;
import org.bukkit.Location;

/**
 * This only works on minecraft 1.14+<br>
 * This message part will be replaced with the specified nbt data of a specified
 * block
 */
public class MessagePartNBTBlock extends MessagePartNBT {

	private Location block;

	/**
	 * @param nbtPath
	 *            The nbt path to follow
	 * @param block
	 *            The block to get the nbt from
	 * @param interpret
	 *            If true, the message will be interpreted
	 * @param color
	 *            The color of the message
	 * @param bold
	 *            If true, the message will be <b>bold</b>
	 * @param italics
	 *            If true, the message will be in <i>italics</i>
	 * @param underlined
	 *            If true, the message will be <u>underlined</u>
	 * @param strikethrough
	 *            If true, the message will be in <del>strikethrough</del>
	 * @param obfuscated
	 *            If true, the message will be obfuscated
	 * @param click
	 *            The click event to be runned when the message is clicked
	 * @param hover
	 *            The hover event to be shown
	 */
	public MessagePartNBTBlock(String nbtPath, Location block, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(nbtPath, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.block = block;
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get14();
	}

	private Supplier<String> get14() {
		return () -> {
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
		};
	}

	@Override
	public MessagePart clone() {
		return new MessagePartNBTBlock(getPath(), getBlock(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	public Location getBlock() {
		return block;
	}

	public void setBlock(Location block) {
		this.block = block;
	}

}
