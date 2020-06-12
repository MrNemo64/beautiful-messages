package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * Works in 1.14+<br>
 * Gets replaed with the information of an entity
 */
public abstract class MessagePartNBTEntity extends MessagePartNBT {

	private String selector;

	protected MessagePartNBTEntity(String path, String selector, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.selector = selector;
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param selector
	 *            The selector of the entitys
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
	public static MessagePartNBTEntity create(@Nonnull String nbtPath, @Nonnull String selector,
			@Nullable ChatColor color, boolean bold, boolean italics, boolean underlined, boolean strikethrough,
			boolean obfuscated, @Nullable ClickEvent click, @Nullable HoverEvent hover) {
		return new MessagePartNBTEntity14(nbtPath, selector, true, color, bold, italics, underlined, strikethrough,
				obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param selector
	 *            The selector of the entitys
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTEntity create(@Nonnull String nbtPath, @Nonnull String selector) {
		return create(nbtPath, selector, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version <br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param selector
	 *            The selector of the entitys
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTEntity create(@Nonnull String nbtPath, @Nonnull String selector,
			@Nullable ChatColor color) {
		return new MessagePartNBTEntity14(nbtPath, selector, true, color, false, false, false, false, false, null,
				null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param selector
	 *            The selector of the entitys
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTEntity create(@Nonnull String nbtPath, @Nonnull String selector,
			@Nullable ChatColor color, boolean bold) {
		return new MessagePartNBTEntity14(nbtPath, selector, true, color, bold, false, false, false, false, null, null);
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

}
