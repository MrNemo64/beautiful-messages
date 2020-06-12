package me.nemo_64.spigotutilities.beautifulmessages;

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
public abstract class MessagePartScore extends MessagePart {

	private String player;
	private String score;

	protected MessagePartScore(@Nonnull String player, @Nonnull String score, @Nullable ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super("", color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.player = player;
		this.score = score;
	}

	protected MessagePartScore() {
		super();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param playerName
	 *            The playerName to be used
	 * @param scoreboard
	 *            The scoreboard to be used
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
	public static MessagePartScore create(@Nonnull String playerName, @Nonnull String scoreboard,
			@Nullable ChatColor color, boolean bold, boolean italics, boolean underlined, boolean strikethrough,
			boolean obfuscated, @Nullable ClickEvent click, @Nullable HoverEvent hover) {
		return new MessagePartScore8(playerName, scoreboard, color, bold, italics, underlined, strikethrough,
				obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartScore create() {
		return new MessagePartScore8();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param playerName
	 *            The playerName to be used
	 * @param scoreboard
	 *            The scoreboard to be used
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartScore create(@Nonnull String playerName, @Nonnull String scoreboard) {
		return create(playerName, scoreboard, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param playerName
	 *            The playerName to be used
	 * @param scoreboard
	 *            The scoreboard to be used
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartScore create(@Nonnull String playerName, @Nonnull String scoreboard,
			@Nullable ChatColor color) {
		return new MessagePartScore8(playerName, scoreboard, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param playerName
	 *            The playerName to be used
	 * @param scoreboard
	 *            The scoreboard to be used
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartScore create(@Nonnull String playerName, @Nonnull String scoreboard,
			@Nullable ChatColor color, boolean bold) {
		return new MessagePartScore8(playerName, scoreboard, color, bold, false, false, false, false, null, null);
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
