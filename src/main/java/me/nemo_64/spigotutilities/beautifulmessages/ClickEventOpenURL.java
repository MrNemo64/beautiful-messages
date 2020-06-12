package me.nemo_64.spigotutilities.beautifulmessages;

import java.net.URL;

import javax.annotation.Nonnull;

/**
 * When clicked a pop up message will tell the player if he wants to open the
 * specified webpage
 */
public abstract class ClickEventOpenURL extends ClickEvent {

	protected ClickEventOpenURL() {
		super();
	}

	protected ClickEventOpenURL(String url) {
		super(url);
	}

	protected ClickEventOpenURL(URL url) {
		super(url.toString());
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param url
	 *            The url to be oppend
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventOpenURL create(@Nonnull String url) {
		return new ClickEventOpenURL8(url);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param url
	 *            The url to be oppend
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventOpenURL create(@Nonnull URL url) {
		return new ClickEventOpenURL8(url);
	}

}
