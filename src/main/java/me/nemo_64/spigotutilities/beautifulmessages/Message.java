package me.nemo_64.spigotutilities.beautifulmessages;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import me.nemo_64.spigotutilities.ReflectionUtils;

public class Message {

	private List<MessagePart> parts;

	public Message() {
		this.parts = new ArrayList<MessagePart>();
	}

	public Message(List<MessagePart> parts) {
		this.parts = parts;
	}

	public Message(MessagePart... parts) {
		this(Arrays.asList(parts));
	}

	/**
	 * Sends this message to the player
	 * 
	 * @param player
	 *            The player that will recive the message
	 */
	public void sendTo(@Nonnull Player player) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + player.getName() + " " + toJSON());
	}

	/**
	 * Sends this message to the player Not all message parts may wotk with this
	 * 
	 * @param player
	 *            The player that will recive the message
	 */
	public void sendWithPacketsTo(Player player) {
		// For some reason, things like the score and the selector don't work sending it
		// like this
		try {
			// Get the "a" method in ChatSerializer and use it with this messages json
			Object iChatBaseComponentObject = ReflectionUtils.getNMSClass("IChatBaseComponent$ChatSerializer")
					.getMethod("a", String.class).invoke(null, toJSON());
			// Get the constructor of PacketPlayOutChat that takes as parameter a
			// IChatBaseComponent and instancie a new PacketPlayOutChat
			Object packetPlayOutChatpackage = ReflectionUtils.getNMSClass("PacketPlayOutChat")
					.getConstructor(ReflectionUtils.getNMSClass("IChatBaseComponent"))
					.newInstance(iChatBaseComponentObject);
			ReflectionUtils.sendPacket(player, packetPlayOutChatpackage);

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException |
				SecurityException | InstantiationException e) {
			// So many posible errors :(
			e.printStackTrace();
		}
	}

	/**
	 * Sets this message to a book page
	 * 
	 * @param meta
	 *            The book meta
	 * @param page
	 *            The page to set it
	 */
	public void setOnBook(BookMeta meta, int page) {
		meta.setPage(page, toJSON());
	}

	/**
	 * Sets this message to a book page
	 * 
	 * @param meta
	 *            The book meta
	 * @param page
	 *            The page to set it
	 */
	public void setOnBook(ItemMeta meta, int page) {
		if (!(meta instanceof BookMeta))
			throw new IllegalArgumentException("The ItemMeta is not an instanco of a BookMeta");
		setOnBook((BookMeta) meta, page);
	}

	/**
	 * Creates a new page and sets this text on it
	 * 
	 * @param meta
	 *            The book meta
	 */
	public void addToBook(ItemMeta meta) {
		if (!(meta instanceof BookMeta))
			throw new IllegalArgumentException("The ItemMeta is not an instanco of a BookMeta");
		BookMeta bMeta = (BookMeta) meta;
		// Since the first page is the page 1, the amount of pages is the index of the
		// last page + 1
		setOnBook(bMeta, bMeta.getPageCount() + 1);
	}

	/**
	 * Sets this message to a book page
	 * 
	 * @param book
	 *            The book item
	 * @param page
	 *            The page
	 */
	public void setOnBook(ItemStack book, int page) {
		if (!(book.getItemMeta() instanceof BookMeta))
			throw new IllegalArgumentException("The item is not a book");
		setOnBook((BookMeta) book.getItemMeta(), page);
	}

	/**
	 * Creates a new page and sets this text on it
	 * 
	 * @param book
	 *            The book item
	 */
	public void addToBook(ItemStack book) {
		if (!(book.getItemMeta() instanceof BookMeta))
			throw new IllegalArgumentException("The item is not a book");
		addToBook((BookMeta) book.getItemMeta());
	}

	/**
	 * Clones this message
	 * 
	 * @return A new message
	 */
	public Message clone() {
		return new Message(getParts());
	}

	/**
	 * Turns turns this message into a JSON string
	 * 
	 * @param ignoreColors
	 *            If true, colors won't be applied
	 * @param ignoreEvents
	 *            If true, events won't be applied
	 * @return This message as a JSON. If there are no message parts, returns null
	 */
	public String toJSON(boolean ignoreColors, boolean ignoreEvents) {
		if (getParts().isEmpty())
			return null;

		StringBuilder builder = new StringBuilder("[\"\",");

		for (int i = 0; i < getParts().size(); i++) {
			if (getParts().get(i) == null)
				continue;
			builder.append(getParts().get(i).toJSON());
			if (i != getParts().size() - 1)
				builder.append(",");
		}

		builder.append("]");

		return builder.toString();
	}

	/**
	 * Turns turns this message into a JSON string
	 * 
	 * @return This message as a JSON. If there are no message parts, returns null
	 */
	public String toJSON() {
		return toJSON(false, false);
	}

	/**
	 * Ads a message part to this message
	 * 
	 * @param part
	 *            The part to be added
	 */
	public void add(@Nonnull MessagePart part) {
		this.parts.add(part);
	}

	/**
	 * Sets in the given index the message part. If the index is higher than the
	 * size, the part will just be added
	 * 
	 * @param index
	 *            The index
	 * @param part
	 *            The message
	 */
	public void set(@Nonnegative int index, @Nonnull MessagePart part) {
		if (index >= parts.size()) {
			add(part);
		} else {
			this.parts.set(index, part);
		}
	}

	/**
	 * Removes the message part at the given index
	 * 
	 * @param index
	 *            The index
	 * @return The message part removed. Null if no part was removed
	 */
	@Nullable
	public MessagePart remove(@Nonnegative int index) {
		if (index >= parts.size())
			return null;
		return parts.remove(index);
	}

	/**
	 * Removes the last part of the message
	 * 
	 * @return The message part removed. Null if no part was removed
	 */
	@Nullable
	public MessagePart remove() {
		return remove(parts.size() - 1);
	}

	/**
	 * Removes the specified part of the message
	 * 
	 * @param part
	 *            The part to be removed
	 * @return The message part removed. Null if no part was removed
	 */
	@Nullable
	public MessagePart remove(MessagePart part) {
		if (!contains(part))
			return null;
		return remove(indexOf(part));
	}

	/**
	 * Checks if the specified part is in the message
	 * 
	 * @param part
	 *            The part
	 * @return True if the part is in them message
	 */
	public boolean contains(MessagePart part) {
		return indexOf(part) > 0;
	}

	/**
	 * Gets the index of the part specified
	 * 
	 * @param part
	 *            The part to get the index
	 * @return The index of the part. -1 if the message does not have the part
	 */
	public int indexOf(MessagePart part) {
		for (int i = 0; i < parts.size(); i++) {
			if (parts.get(i).equals(part)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean equals(@Nonnull Object obj) {
		if (obj instanceof Message)
			return equals((Message) obj);
		return false;
	}

	/**
	 * Checks if the message is equal to this one
	 * 
	 * @param message
	 *            The message
	 * @return True if the messages are equal
	 */
	public boolean equals(@Nonnull Message message) {
		return getParts().equals(message.getParts());
	}

	/**
	 * Turns turns this message into a JSON string
	 * 
	 * @return This message as a JSON. If there are no message parts, returns null
	 */
	@Override
	@Nullable
	public String toString() {
		return toJSON();
	}

	/**
	 * Gets all the parts of the message
	 * 
	 * @return A list with all the parts of the message
	 */
	@Nonnull
	public List<MessagePart> getParts() {
		return parts;
	}

}
