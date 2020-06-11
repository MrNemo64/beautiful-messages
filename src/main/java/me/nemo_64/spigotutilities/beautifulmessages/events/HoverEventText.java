package me.nemo_64.spigotutilities.beautifulmessages.events;

import me.nemo_64.spigotutilities.beautifulmessages.Message;

public abstract class HoverEventText extends HoverEvent {

	public HoverEventText(String text) {
		super(text);
	}

	public HoverEventText() {
		super();
	}

	public HoverEventText(Message message) {
		super(message.toJSON(true, true));
	}

}
