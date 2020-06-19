package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import org.bukkit.ChatColor;

/**
 * Works in 1.14+<br>
 * Gets replaed with the information of an entity
 */
public class MessagePartNBTEntity extends MessagePartNBT {

	private String selector;

	/**
	 * @param path
	 *            The nbt to be followed
	 * @param selector
	 *            The entity selector to be used
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
	public MessagePartNBTEntity(String path, String selector, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.selector = selector;
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get14();
	}

	private Supplier<String> get14() {
		return () -> {
			// {"entity":"SELECTOR","nbt":"PATH","interpret":true,...}

			StringBuilder builder = new StringBuilder("{\"entity\":\"");

			builder.append(getSelector());

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
		return new MessagePartNBTEntity(getPath(), getSelector(), isInterpret(), getColor(), isBold(), isItalics(),
				isUnderlined(), isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

}
