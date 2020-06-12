package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

/**
 * When clicked the player gets a suggestion of a text.<br>
 * Have in munt that for this to work the player must shitf+click.<br>
 * If you want to be able to just do it with the click use
 * {@link ClickEventSuggestCommand} and don't use "/" at the beggining of the
 * command
 */
public abstract class ClickEventSuggestText extends ClickEvent {

	protected ClickEventSuggestText() {
		super();
	}

	protected ClickEventSuggestText(String text) {
		super(text);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param textToSuggest
	 *            The text to suggest. In orther for the text to be suggested the
	 *            player has to shift+click
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventSuggestText create(@Nonnull String textToSuggest) {
		return new ClickEventSuggestText8(textToSuggest);
	}

}
