package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8;

import me.nemo_64.spigotutilities.beautifulmessages.ClickEventSuggestText;

public class ClickEventSuggestText8 extends ClickEventSuggestText {

	public ClickEventSuggestText8(String text) {
		super(text);
	}

	public ClickEventSuggestText8() {
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
