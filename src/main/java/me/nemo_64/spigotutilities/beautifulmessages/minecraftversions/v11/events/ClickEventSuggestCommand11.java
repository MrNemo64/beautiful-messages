package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEventSuggestCommand;

public class ClickEventSuggestCommand11 extends ClickEventSuggestCommand {

	public ClickEventSuggestCommand11() {
		super();
	}

	public ClickEventSuggestCommand11(String command) {
		super(command);
	}

	@Override
	public String toJSON() {
		// ,"clickEvent":{"action":"suggest_command","value":"COMMAND"}
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"");

		builder.append(getValue().replace("\"", "\\\""));
		
		builder.append("\"}");
		
		return builder.toString();
	}

}
