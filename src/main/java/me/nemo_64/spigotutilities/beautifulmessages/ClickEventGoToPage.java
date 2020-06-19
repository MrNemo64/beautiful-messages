package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

/**
 * Only works in books<br>
 * When clicked the player will go to the specified page
 */
public class ClickEventGoToPage extends ClickEvent {

	/**
	 * @param page
	 *            The page number to go when clicked.<br>
	 *            The book pages are numebed as 1 to n where n is the total amount
	 *            of pages
	 */
	public ClickEventGoToPage(int page) {
		super(String.valueOf(page));
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"clickEvent":{"action":"change_page","value":0}
			StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"change_page\",\"value\":");

			builder.append(getValue());

			builder.append("}");

			return builder.toString();
		};
	}

}
