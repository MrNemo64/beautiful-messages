package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

/**
 * When clicked the player will get the suggestion the specified command.<br>
 * Take in mind that if the command is "/say hellow" the value must be "/say
 * hello"<br>
 * If there is not a "/" at the beggining, the player will just get a message as
 * suggestion
 */

public class ClickEventSuggestCommand extends ClickEvent {

	/**
	 * @param command
	 *            The command to be suggested when clicked
	 */
	public ClickEventSuggestCommand(String command) {
		super(command);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"clickEvent":{"action":"suggest_command","value":"COMMAND"}
			StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"");

			builder.append(getValue().replace("\"", "\\\""));

			builder.append("\"}");

			return builder.toString();
		};
	}
}
