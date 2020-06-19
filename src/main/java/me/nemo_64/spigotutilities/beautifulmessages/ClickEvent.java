package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import me.nemo_64.spigotutilities.JSONParseable;

public abstract class ClickEvent extends JSONParseable {

	private String value;

	protected ClickEvent(@Nullable Supplier<String> parser, @Nonnull String value) {
		super(parser);
		this.value = value;
	}

	protected ClickEvent(@Nonnull String value) {
		this(null, value);
	}

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
