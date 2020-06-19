package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

/**
 * When clicked the player gets a suggestion of a text.<br>
 * Have in munt that for this to work the player must shitf+click.<br>
 * If you want to be able to just do it with the click use
 * {@link ClickEventSuggestCommand} and don't use "/" at the beggining of the
 * command
 */
public class ClickEventSuggestText extends ClickEvent {

	/**
	 * @param text
	 *            The text to be suggested when the player shift+click
	 */
	public ClickEventSuggestText(String text) {
		super(text);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"insertion":"TEXT"
			StringBuilder builder = new StringBuilder(",\"insertion\":\"");

			builder.append(getValue().replace("\"", "\\\""));

			builder.append("\"");

			return builder.toString();
		};
	}

}
