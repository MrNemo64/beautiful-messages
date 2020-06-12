package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.inventory.ItemStack;

class HoverEventItem8 extends HoverEventItem {

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
