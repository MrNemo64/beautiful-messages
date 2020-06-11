package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import me.nemo_64.spigotutilities.beautifulmessages.Message;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEventText;

public class HoverEventText11 extends HoverEventText {

	public HoverEventText11(String text) {
		super(text);
	}

	public HoverEventText11() {
		super();
	}

	public HoverEventText11(Message message) {
		super(message);
	}

	@Override
	public String toJSON() {
		// ,"hoverEvent":{"action":"show_text","value":"VALUE"}
		StringBuilder builder = new StringBuilder(",\"hoverEvent\":{\"action\":\"show_text\",\"value\":");

		builder.append(getValue()/* .replace("\"", "\\\"") */);

		builder.append("}");

		return builder.toString();
	}

}
