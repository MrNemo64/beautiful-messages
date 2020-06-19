package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * This message part has no text, only the name of a scoreboard and a
 * player.<br>
 * This message part will be replaced with the score of the player on the
 * defined scoreboard.<br>
 * If the scoreboard does not exist / the player has no score, this message part
 * will be replaced with nothing
 */
public class MessagePartScore extends MessagePart {

	private String player;
	private String score;

	/**
	 * @param player
	 *            The player to take the score
	 * @param score
	 *            The scoreboard to take the score
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
	public MessagePartScore(@Nonnull String player, @Nonnull String score, @Nullable ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super("", color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.player = player;
		this.score = score;
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// {"score":{"name":"PLAYER","objective":"SCOREBOARD"},...}
			StringBuilder builder = new StringBuilder("{\"score\":{\"name\":\"");

			builder.append(getPlayer());

			builder.append("\",\"objective\":\"");

			builder.append(getScore());

			builder.append("\"}");

			builder = appendColor(builder);

			builder = appendEvents(builder);

			builder.append("}");

			return builder.toString();
		};
	}

	@Override
	public MessagePart clone() {
		return new MessagePartScore(getPlayer(), getScore(), getColor(), isBold(), isItalics(), isUnderlined(),
				isStrikethrough(), isObfuscated(), getClick(), getHover());
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public void setText(String text) {
		throw new IllegalAccessError("The MessagePathScore does not have a text");
	}

	@Override
	public String getText() {
		throw new IllegalAccessError("The MessagePathScore does not have a text");
	}

}
