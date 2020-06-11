package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import java.net.URL;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEventOpenURL;

public class ClickEventOpenURL11 extends ClickEventOpenURL {

	public ClickEventOpenURL11() {
		super();
	}

	public ClickEventOpenURL11(String url) {
		super(url);
	}

	public ClickEventOpenURL11(URL url) {
		super(url.toString());
	}

	@Override
	public String toJSON() {
		// ,"clickEvent":{"action":"open_url","value":"URL"}
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"");

		builder.append(getValue().replace("\"", "\\\""));

		builder.append("\"}");

		return builder.toString();
	}

}
