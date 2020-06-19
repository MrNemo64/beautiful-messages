package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

public class HoverEventText extends HoverEvent {

	/**
	 * @param JSONtext
	 *            The text as JSON to be displayed in the hover
	 */
	public HoverEventText(String JSONtext) {
		super(JSONtext);
	}

	/**
	 * @param message
	 *            The message to be shown in the hover
	 */
	public HoverEventText(Message message) {
		this(message.toJSON(true, true));
	}

	/**
	 * @param message
	 *            The message to be shown in the hover
	 */
	public HoverEventText(MessagePart message) {
		this(new Message(message));
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"hoverEvent":{"action":"show_text","value":"VALUE"}
			StringBuilder builder = new StringBuilder(",\"hoverEvent\":{\"action\":\"show_text\",\"value\":");

			builder.append(getValue()/* .replace("\"", "\\\"") */);

			builder.append("}");

			return builder.toString();
		};
	}

}
