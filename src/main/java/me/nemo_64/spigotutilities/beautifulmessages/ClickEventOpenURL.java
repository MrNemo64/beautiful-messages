package me.nemo_64.spigotutilities.beautifulmessages;

import java.net.URL;
import java.util.function.Supplier;

/**
 * When clicked a pop up message will tell the player if he wants to open the
 * specified webpage
 */
public class ClickEventOpenURL extends ClickEvent {

	/**
	 * @param url
	 *            The url to be opend if the player clicks
	 */
	public ClickEventOpenURL(String url) {
		super(url);
	}

	/**
	 * @param url
	 *            The url to be opend if the player clicks
	 */
	public ClickEventOpenURL(URL url) {
		this(url.toString());
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"clickEvent":{"action":"open_url","value":"URL"}
			StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"");

			builder.append(getValue().replace("\"", "\\\""));

			builder.append("\"}");

			return builder.toString();
		};
	}

}
