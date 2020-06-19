package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * This message part gets replaced with the entityes that match the
 * criteria.<br>
 * If you set as selector "@a", it will get replaced with the name of all the
 * players.<br>
 * The delector may change with the version.
 */
public class MessagePartSelector extends MessagePart {

	/**
	 * @param selector
	 *            The selector to be used
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
	public MessagePartSelector(@Nonnull String selector, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super(selector, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// {"selector":"SELECTOR",...}
			StringBuilder builder = new StringBuilder("{\"selector\":\"");

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
		return new MessagePartSelector(getText(), getColor(), isBold(), isItalics(), isUnderlined(), isStrikethrough(),
				isObfuscated(), getClick(), getHover());
	}

	public String getSelector() {
		return getText();
	}

	public void setSelector(String selector) {
		setText(selector);
	}

}
