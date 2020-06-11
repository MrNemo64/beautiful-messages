package me.nemo_64.spigotutilities.beautifulmessages.events;

/**
 * Only works with minecraft 1.15+<br>
 * When clicked the player will copy the specified text to copy
 */
public abstract class ClickEventCopyToClipboard extends ClickEvent {

	public ClickEventCopyToClipboard() {
		super();
	}

	public ClickEventCopyToClipboard(String textToCopy) {
		super(textToCopy);
	}
}
