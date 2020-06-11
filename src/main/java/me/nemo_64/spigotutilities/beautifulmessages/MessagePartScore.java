package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

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

	public MessagePartScore(@Nonnull String player, @Nonnull String score, @Nullable ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super("", color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.player = player;
		this.score = score;
	}

	public MessagePartScore() {
		super();
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
