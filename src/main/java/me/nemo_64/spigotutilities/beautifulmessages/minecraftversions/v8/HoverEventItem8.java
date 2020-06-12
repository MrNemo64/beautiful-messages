package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v8;

import org.bukkit.inventory.ItemStack;

import me.nemo_64.spigotutilities.beautifulmessages.HoverEventItem;

public class HoverEventItem8 extends HoverEventItem {

	public HoverEventItem8(String item) {
		super(item);
	}

	public HoverEventItem8() {
		super();
	}

	public HoverEventItem8(ItemStack item) {
		super(item);
	}

	public HoverEventItem8(JSONItemStack item) {
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
