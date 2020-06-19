package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import org.bukkit.ChatColor;

/**
 * Works in 1.15+<br>
 * This message part will be replaced with the data from the path specified in
 * the storage specified.<br>
 * A storage is created and a value is stored in the path, for example, using
 * the command
 * {@code /data modify storage %STORAGE_NAME% %PATH_TO_DATA% set value %VALUE%}
 */
public class MessagePartNBTStorage extends MessagePartNBT {

	private String storage;

	/**
	 * @param path
	 *            The nbt path
	 * @param storage
	 *            The storage to get the data from
	 * @param interpret
	 *            If true, the data will be interpreted
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
	public MessagePartNBTStorage(String path, String storage, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.storage = storage;
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get15();
	}

	private Supplier<String> get15() {
		return () -> {
			// {"nbt": <path>, "storage":"<resource id>",...}

			StringBuilder builder = new StringBuilder("{\"nbt\":\"");

			builder.append(getPath());

			builder.append("\", \"storage\":\"");

			builder.append(getStorage());

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
		return new MessagePartNBTStorage(getPath(), getStorage(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

}
