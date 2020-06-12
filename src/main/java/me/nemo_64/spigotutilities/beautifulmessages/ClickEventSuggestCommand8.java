package me.nemo_64.spigotutilities.beautifulmessages;

class ClickEventSuggestCommand8 extends ClickEventSuggestCommand {

	public ClickEventSuggestCommand8() {
		super();
	}

	public ClickEventSuggestCommand8(String command) {
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
