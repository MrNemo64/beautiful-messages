package me.nemo_64.spigotutilities.beautifulmessages.events;

/**
 * When clicked the player will run the specified command.<br>
 * Take in mind that if the command is "/say hellow" the value must be "/say hello"<br>
 * If there is not a "/" at the beggining, the player will just send a message
 */
public abstract class ClickEventRunCommand extends ClickEvent {

	public ClickEventRunCommand() {
		super();
	}

	public ClickEventRunCommand(String command) {
		super(command);
	}

}
