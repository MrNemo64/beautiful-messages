package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

/**
 * Only works with minecraft 1.15+<br>
 * When clicked the player will copy the specified text to copy
 */
public class ClickEventCopyToClipboard extends ClickEvent {

	/**
	 * @param textToCopy
	 *            The text to be copyed to the clipboard when clicked
	 */
	public ClickEventCopyToClipboard(String textToCopy) {
		super(textToCopy);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get15();
	}

	private Supplier<String> get15() {
		return () -> {
			// ,"clickEvent":{"action":"copy_to_clipboard","value":"VALUE"}

			StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"");

			builder.append(getValue());

			builder.append("\"}");

			return builder.toString();
		};
	}

}
