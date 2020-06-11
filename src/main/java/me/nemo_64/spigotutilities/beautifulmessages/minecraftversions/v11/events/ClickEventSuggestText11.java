package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEventSuggestText;

public class ClickEventSuggestText11 extends ClickEventSuggestText {

	public ClickEventSuggestText11(String text) {
		super(text);
	}

	public ClickEventSuggestText11() {
		super();
	}

	@Override
	public String toJSON() {
		// ,"insertion":"TEXT"
		StringBuilder builder = new StringBuilder(",\"insertion\":\"");

		builder.append(getValue().replace("\"", "\\\""));

		builder.append("\"");

		return builder.toString();
	}

}
