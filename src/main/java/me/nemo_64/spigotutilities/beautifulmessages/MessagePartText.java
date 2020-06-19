package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import org.bukkit.ChatColor;

public class MessagePartText extends MessagePart {

	/**
	 * @param text
	 *            The text to be shown
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
	public MessagePartText(String text, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(text, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// {"text":"TEXT",...}
			StringBuilder builder = new StringBuilder("{\"text\":\"");

			builder.append(getText().replace("\"", "\\\""));

			builder.append("\"");

			builder = appendColor(builder);

			builder = appendEvents(builder);

			builder.append("}");

			return builder.toString();
		};
	}

	@Override
	public MessagePart clone() {
		return new MessagePartText(getText(), getColor(), isBold(), isItalics(), isUnderlined(), isStrikethrough(),
				isObfuscated(), getClick(), getHover());
	}

}
