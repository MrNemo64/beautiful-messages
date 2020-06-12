package me.nemo_64.spigotutilities.beautifulmessages;

public abstract class HoverEvent {

	private String value;

	public HoverEvent(String value) {
		this.value = value;
	}

	public HoverEvent() {
		this("value");
	}

	public abstract String toJSON();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return toJSON();
	}

}
