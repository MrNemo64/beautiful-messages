package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8.ClickEventSuggestCommand8;

/**
 * When clicked the player will get the suggestion the specified command.<br>
 * Take in mind that if the command is "/say hellow" the value must be "/say
 * hello"<br>
 * If there is not a "/" at the beggining, the player will just get a message as
 * suggestion
 */

public abstract class ClickEventSuggestCommand extends ClickEvent {

	protected ClickEventSuggestCommand() {
		super();
	}

	protected ClickEventSuggestCommand(String command) {
		super(command);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param command
	 *            The command to be suggested. The command is exacly what this
	 *            string is.<br>
	 *            For example, if you use "say hi" the player get as suggestion "say
	 *            hi".<br>
	 *            If you use "/say hi" the player will get as suggestion "/say hi"
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventSuggestCommand create(@Nonnull String command) {
		return new ClickEventSuggestCommand8(command);
	}

}
