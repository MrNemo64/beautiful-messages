package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import me.nemo_64.spigotutilities.JSONParseable;

public abstract class HoverEvent extends JSONParseable {

	private String value;

	public HoverEvent(String value) {
		this(null, value);
	}

	public HoverEvent(Supplier<String> parser, String value) {
		super(parser);
		this.value = value;
	}

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
