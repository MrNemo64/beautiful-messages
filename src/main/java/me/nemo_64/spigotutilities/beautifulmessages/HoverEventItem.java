package me.nemo_64.spigotutilities.beautifulmessages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import me.nemo_64.spigotutilities.ReflectionUtils;

public abstract class HoverEventItem extends HoverEvent {

	protected HoverEventItem(String item) {
		super(item);
	}

	protected HoverEventItem() {
		super();
	}

	protected HoverEventItem(ItemStack item) {
		this(new JSONItemStack(item));
	}

	protected HoverEventItem(JSONItemStack item) {
		this(item.toJSON());
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param item
	 *            The item to be displayed in the hover
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static HoverEventItem create(String item) {
		return new HoverEventItem8(item);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param item
	 *            The item to be displayed in the hover
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static HoverEventItem create(@Nonnull ItemStack item) {
		return new HoverEventItem8(item);
	}

	/**
	 * Creates an instance of this event
	 * 
	 * @param item
	 *            The item to be displayed in the hover
	 * @return An instance of this event in the corresponding minecraft version
	 */
	public static HoverEventItem create(@Nonnull JSONItemStack item) {
		return new HoverEventItem8(item);
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
