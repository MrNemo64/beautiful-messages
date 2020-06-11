package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEventGoToPage;

public class ClickEventGoToPage11 extends ClickEventGoToPage {

	public ClickEventGoToPage11() {
		super(0);
	}

	public ClickEventGoToPage11(int page) {
		super(page);
	}

	@Override
	public String toJSON() {
		// ,"clickEvent":{"action":"change_page","value":0}
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"change_page\",\"value\":");

		builder.append(getValue());

		builder.append("}");

		return builder.toString();
	}

}
