package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;

public abstract class ClickEvent {

	private String value;

	protected ClickEvent(@Nonnull String value) {
		this.value = value;
	}

	protected ClickEvent() {
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
