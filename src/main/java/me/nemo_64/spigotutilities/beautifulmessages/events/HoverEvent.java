package me.nemo_64.spigotutilities.beautifulmessages.events;

public abstract class HoverEvent {

	public abstract String toJSON();
	
	@Override
	public String toString() {
		return toJSON();
	}
	
}
