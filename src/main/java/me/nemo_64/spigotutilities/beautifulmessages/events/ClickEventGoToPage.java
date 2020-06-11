package me.nemo_64.spigotutilities.beautifulmessages.events;

/**
 * Only works in books<br>
 * When clicked the player will go to the specified page
 */
public abstract class ClickEventGoToPage extends ClickEvent {

	public ClickEventGoToPage() {
		super("0");
	}
	
	public ClickEventGoToPage(int page) {
		super(String.valueOf(page));
	}

}
