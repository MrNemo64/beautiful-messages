package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8.HoverEventText8;

public abstract class HoverEventText extends HoverEvent {

	protected HoverEventText(String text) {
		super(text);
	}

	protected HoverEventText() {
		super();
	}

	protected HoverEventText(Message message) {
		super(message.toJSON(true, true));
	}
	
	/**
	 * Creates an instance of this event
	 * 
	 * @param text
	 *            The text to be displayed in the hover
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static HoverEventText create(@Nonnull String text) {
		return new HoverEventText8(text);
	}
	
	/**
	 * Creates an instance of this event
	 * 
	 * @param message
	 *            The message to be displayed in the hover
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static HoverEventText create(Message message) {
		return new HoverEventText8(message);
	}
	
}
