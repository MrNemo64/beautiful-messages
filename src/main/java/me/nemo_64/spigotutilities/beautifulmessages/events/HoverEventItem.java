package me.nemo_64.spigotutilities.beautifulmessages.events;

import org.bukkit.inventory.ItemStack;

public abstract class HoverEventItem extends HoverEvent {

	public HoverEventItem(String item) {
		super(item);
	}

	public HoverEventItem() {
		super();
	}

	public HoverEventItem(ItemStack item) {
		this(new JSONItemStack(item));
	}

	public HoverEventItem(JSONItemStack item) {
		super(item.toJSON());
	}

	public static class JSONItemStack {

		private ItemStack item;
		private String json;
		
		public JSONItemStack(ItemStack item) {
			this.item = item;
			convert();
		}
		
		public String toJSON() {
			return json;
		}
		
		public ItemStack getItem() {
			return item;
		}
		
		private void convert() {
			
		}
		
	}

}
