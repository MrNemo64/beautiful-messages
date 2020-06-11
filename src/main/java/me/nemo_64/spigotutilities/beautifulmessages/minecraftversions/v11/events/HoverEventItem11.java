package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v11.events;

import org.bukkit.inventory.ItemStack;

import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEventItem;

public class HoverEventItem11 extends HoverEventItem {

	public HoverEventItem11(String item) {
		super(item);
	}

	public HoverEventItem11() {
		super();
	}

	public HoverEventItem11(ItemStack item) {
		super(item);
	}

	public HoverEventItem11(JSONItemStack item) {
		super(item);
	}

	@Override
	public String toJSON() {
		// ,"hoverEvent":{"action":"show_item","value":"ITEM"}

		StringBuilder builder = new StringBuilder(",\"hoverEvent\":{\"action\":\"show_item\",\"value\":\"");

		builder.append(getValue().replace("\"", "\\\""));

		builder.append("\"}");

		return builder.toString();
	}

}
