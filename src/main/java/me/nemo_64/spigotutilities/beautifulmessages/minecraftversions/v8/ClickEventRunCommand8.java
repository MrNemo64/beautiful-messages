package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8;

import me.nemo_64.spigotutilities.beautifulmessages.ClickEventRunCommand;

public class ClickEventRunCommand8 extends ClickEventRunCommand {

	public ClickEventRunCommand8() {
		super();
	}

	public ClickEventRunCommand8(String command) {
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
