package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.function.Supplier;

public class HoverEventEntity extends HoverEvent {

	protected HoverEventEntity(String value) {
		super(value);
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return getDefaultParser();
	}

}
