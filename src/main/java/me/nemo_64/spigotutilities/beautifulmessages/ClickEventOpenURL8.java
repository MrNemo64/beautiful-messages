package me.nemo_64.spigotutilities.beautifulmessages;

import java.net.URL;

class ClickEventOpenURL8 extends ClickEventOpenURL {

	public ClickEventOpenURL8() {
		super();
	}

	public ClickEventOpenURL8(String url) {
		super(url);
	}

	public ClickEventOpenURL8(URL url) {
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
