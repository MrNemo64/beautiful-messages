package me.nemo_64.spigotutilities.beautifulmessages.events;

import java.net.URL;

/**
 * When clicked a pop up message will tell the player if he wants to open the
 * specified webpage
 */
public abstract class ClickEventOpenURL extends ClickEvent {

	public ClickEventOpenURL() {
		super();
	}

	public ClickEventOpenURL(String url) {
		super(url);
	}
	
	public ClickEventOpenURL(URL url) {
		super(url.toString());
	}

}
