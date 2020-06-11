package me.nemo_64.spigotutilities.beautifulmessages.events;

/**
 * When clicked the player gets a suggestion of a text.<br>
 * Have in munt that for this to work the player must shitf+click.<br>
 * If you want to be able to just do it with the click use
 * {@link ClickEventSuggestCommand} and don't use "/" at the beggining of the
 * command
 */
public abstract class ClickEventSuggestText extends ClickEvent {

	public ClickEventSuggestText() {
		super();
	}

	public ClickEventSuggestText(String text) {
		super(text);
	}

}
