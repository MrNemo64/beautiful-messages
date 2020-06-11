package me.nemo_64.spigotutilities.beautifulmessages.events;

import javax.annotation.Nonnull;

public abstract class ClickEvent {

	private String value;

	public ClickEvent(@Nonnull String value) {
		this.value = value;
	}

	public ClickEvent() {
		this("value");
	}

	public abstract String toJSON();

	@Override
	public String toString() {
		return toJSON();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
