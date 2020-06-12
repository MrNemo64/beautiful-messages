package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnegative;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8.ClickEventGoToPage8;

/**
 * Only works in books<br>
 * When clicked the player will go to the specified page
 */
public abstract class ClickEventGoToPage extends ClickEvent {

	protected ClickEventGoToPage() {
		super("0");
	}

	protected ClickEventGoToPage(int page) {
		super(String.valueOf(page));
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param page
	 *            The page. If the book does not have that page the event is ignored
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static ClickEventGoToPage create(@Nonnegative int page) {
		return new ClickEventGoToPage8(page);
	}

}
