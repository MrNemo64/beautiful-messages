package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEventRunCommand;

public class ClickEventRunCommand11 extends ClickEventRunCommand {

	public ClickEventRunCommand11() {
		super();
	}

	public ClickEventRunCommand11(String command) {
		super(command);
	}

	@Override
	public String toJSON() {
		//,"clickEvent":{"action":"run_command","value":"COMMAND"}
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"");
		
		builder.append(getValue().replace("\"", "\\\""));
		
		builder.append("\"}");
		
		return builder.toString();
	}

}
