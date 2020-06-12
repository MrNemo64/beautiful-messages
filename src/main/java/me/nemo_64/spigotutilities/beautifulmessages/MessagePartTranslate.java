package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * This message part is replaced with the translation in the lang file on the
 * player
 */
public abstract class MessagePartTranslate extends MessagePart {

	protected MessagePartTranslate(String path, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	protected MessagePartTranslate() {
		super();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param path
	 *            The path to be used. <br>
	 *            To see all the path in the english lang file in 1.15 check this
	 *            link: <a href=
	 *            "https://github.com/MrNemo64/beautiful-messages/blob/master/translate.json">translate.json</a>
	 * @param color
	 *            The color of the path
	 * @param bold
	 *            If the path is bold
	 * @param italics
	 *            If the path is in italics
	 * @param underlined
	 *            If the path is underlined
	 * @param strikethrough
	 *            If the path is in strikethrough
	 * @param obfuscated
	 *            If the path is obfuscated
	 * @param click
	 *            The click event
	 * @param hover
	 *            The hover event
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String path, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		return new MessagePart8(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create() {
		return new MessagePart8();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param path
	 *            The path to be used. <br>
	 *            To see all the path in the english lang file in 1.15 check this
	 *            link: <a href=
	 *            "https://github.com/MrNemo64/beautiful-messages/blob/master/translate.json">translate.json</a>
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String path) {
		return create(path, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param path
	 *            The path to be used. <br>
	 *            To see all the path in the english lang file in 1.15 check this
	 *            link: <a href=
	 *            "https://github.com/MrNemo64/beautiful-messages/blob/master/translate.json">translate.json</a>
	 * @param color
	 *            The color of the path
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String path, @Nullable ChatColor color) {
		return new MessagePart8(path, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param path
	 *            The path to be used. <br>
	 *            To see all the path in the english lang file in 1.15 check this
	 *            link:
	 *            {@link https://github.com/MrNemo64/beautiful-messages/blob/master/translate.json
	 *            translate.json}
	 * @param color
	 *            The color of the path
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String path, @Nullable ChatColor color, boolean bold) {
		return new MessagePart8(path, color, bold, false, false, false, false, null, null);
	}

	public String getPath() {
		return getText();
	}

	public void setPath(String path) {
		setText(path);
	}

}
