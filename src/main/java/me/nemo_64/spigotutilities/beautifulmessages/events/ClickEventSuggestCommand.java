package me.nemo_64.spigotutilities.beautifulmessages.events;

/**
 * When clicked the player will get the suggestion the specified command.<br>
 * Take in mind that if the command is "/say hellow" the value must be "/say hello"<br>
 * If there is not a "/" at the beggining, the player will just get a message as suggestion
 */

public abstract class ClickEventSuggestCommand extends ClickEvent {

	public ClickEventSuggestCommand() {
		super();
	}
	
	public ClickEventSuggestCommand(String command) {
		super(command);
	}

}
