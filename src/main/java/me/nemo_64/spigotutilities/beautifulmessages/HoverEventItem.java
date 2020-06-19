package me.nemo_64.spigotutilities.beautifulmessages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import org.bukkit.inventory.ItemStack;

import me.nemo_64.spigotutilities.ReflectionUtils;

public class HoverEventItem extends HoverEvent {

	/**
	 * @param item
	 *            The item as JSON to be displayed
	 */
	public HoverEventItem(String item) {
		super(item);
	}

	/**
	 * @param item
	 *            The item to be displayed
	 */
	public HoverEventItem(ItemStack item) {
		this(new JSONItemStack(item));
	}

	/**
	 * @param item
	 *            The item to be displayed
	 */
	public HoverEventItem(JSONItemStack item) {
		this(item.toJSON());
	}

	@Override
	protected Supplier<String> getParserToUse() {
		return get8();
	}

	private Supplier<String> get8() {
		return () -> {
			// ,"hoverEvent":{"action":"show_item","value":"ITEM"}

			StringBuilder builder = new StringBuilder(",\"hoverEvent\":{\"action\":\"show_item\",\"value\":\"");

			builder.append(getValue().replace("\"", "\\\""));

			builder.append("\"}");

			return builder.toString();
		};
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
			try {
				Class<?> craftItemStack = ReflectionUtils.getCraftClass("inventory.CraftItemStack");
				Class<?> nmsItemStack = ReflectionUtils.getNMSClass("ItemStack");
				Class<?> nbtTagCompound = ReflectionUtils.getNMSClass("NBTTagCompound");

				Constructor<?> nbtTagCompoundConstructor = nbtTagCompound.getConstructor();

				Method asNMSCopy = craftItemStack.getMethod("asNMSCopy", ItemStack.class);
				Method toString = nbtTagCompound.getMethod("toString");
				Method save = nmsItemStack.getMethod("save", nbtTagCompound);

				Object nbtTagCompoundObject = nbtTagCompoundConstructor.newInstance();
				Object nmsItemStackObject = asNMSCopy.invoke(null, item);
				save.invoke(nmsItemStackObject, nbtTagCompoundObject);
				Object str = toString.invoke(nbtTagCompoundObject);

				if (str instanceof String)
					this.json = (String) str;
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException |
					InvocationTargetException | InstantiationException e) {
				e.printStackTrace();
			}
		}

	}

}
