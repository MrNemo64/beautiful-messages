package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import org.bukkit.ChatColor;

/**
 * This message part is replaced with the translation in the lang file on the
 * player
 */
public class MessagePartTranslate extends MessagePart {

	/**
	 * @param path
	 *            The translate path. Check <a href=
	 *            "https://github.com/MrNemo64/beautiful-messages/blob/master/translate.json">this
	 *            link</a> to see all the message paths in 1.15
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
	public MessagePartTranslate(String path, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(path, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	@Override
	public MessagePart clone() {
		return new MessagePartTranslate(getPath(), getColor(), isBold(), isItalics(), isUnderlined(), isStrikethrough(),
				isObfuscated(), getClick(), getHover());
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// {"translate":"block.minecraft.stone"}

			StringBuilder builder = new StringBuilder("{\"translate\":\"");

			builder.append(getPath());

			builder.append("\"");

			builder = appendColor(builder);

			builder = appendEvents(builder);

			builder.append("}");

			return builder.toString();
		};
	}

	public String getPath() {
		return getText();
	}

	public void setPath(String path) {
		setText(path);
	}

}
