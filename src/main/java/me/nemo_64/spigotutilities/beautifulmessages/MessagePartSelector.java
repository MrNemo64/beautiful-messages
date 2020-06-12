package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8.MessagePartSelector8;

/**
 * This message part gets replaced with the entityes that match the criteria.<br>
 * If you set as selector "@a", it will get replaced with the name of all the players.<br>
 * The delector may change with the version.
 */
public abstract class MessagePartSelector extends MessagePart {
	
	protected MessagePartSelector(@Nonnull String selector, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}
	
	protected MessagePartSelector() {
		super();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param selector
	 *            The selector to be used
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
	public static MessagePartSelector create(@Nonnull String selector, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		return new MessagePartSelector8(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartSelector create() {
		return new MessagePartSelector8();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param selector
	 *            The selector to be used
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartSelector create(@Nonnull String selector) {
		return create(selector, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param selector
	 *            The selector to be displayed
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartSelector create(@Nonnull String selector, @Nullable ChatColor color) {
		return new MessagePartSelector8(selector, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param selector
	 *            The selector to be used
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartSelector create(@Nonnull String selector, @Nullable ChatColor color, boolean bold) {
		return new MessagePartSelector8(selector, color, bold, false, false, false, false, null, null);
	}
	
}
