package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8.ClickEventRunCommand8;

/**
 * When clicked the player will run the specified command.<br>
 * Take in mind that if the command is "/say hellow" the value must be "/say
 * hello"<br>
 * If there is not a "/" at the beggining, the player will just send a message
 */
public abstract class ClickEventRunCommand extends ClickEvent {

	protected ClickEventRunCommand() {
		super();
	}

	protected ClickEventRunCommand(String command) {
		super(command);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param command
	 *            The command to be runned. The command is exacly what this string
	 *            is.<br>
	 *            For example, if you use "say hi" the player will send in the chat
	 *            "say hi".<br>
	 *            If you use "/say hi" the player will run the command "say" with
	 *            the arguments "hi"
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventRunCommand create(@Nonnull String command) {
		return new ClickEventRunCommand8(command);
	}

}
