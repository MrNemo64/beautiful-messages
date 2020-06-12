package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v15.ClickEventCopyToClipboard15;

/**
 * Only works with minecraft 1.15+<br>
 * When clicked the player will copy the specified text to copy
 */
public abstract class ClickEventCopyToClipboard extends ClickEvent {

	protected ClickEventCopyToClipboard() {
		super();
	}

	protected ClickEventCopyToClipboard(String textToCopy) {
		super(textToCopy);
	}

	/**
	 * Creates an instance of this event.<br>
	 * Only works in 1.15+
	 * 
	 * @param textToCopy
	 *            The thext to be copyed.
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventCopyToClipboard create(@Nonnull String textToCopy) {
		return new ClickEventCopyToClipboard15(textToCopy);
	}

}
