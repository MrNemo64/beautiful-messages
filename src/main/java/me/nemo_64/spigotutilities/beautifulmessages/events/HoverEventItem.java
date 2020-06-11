package me.nemo_64.spigotutilities.beautifulmessages.events;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.inventory.ItemStack;

import me.nemo_64.spigotutilities.ReflectionUtils;

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
