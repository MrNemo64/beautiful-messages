package me.nemo_64.spigotutilities.beautifulmessages;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Message {

	private List<MessagePart> parts;

	public Message() {
		this.parts = new ArrayList<MessagePart>();
	}
	
	public Message(List<MessagePart> parts) {
		this.parts = parts;
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
		if (parts.isEmpty())
			return null;

		StringBuilder builder = new StringBuilder("[\"\",");

		for (int i = 0; i < parts.size(); i++) {
			if (parts.get(i) == null)
				continue;
			builder.append(parts.get(i).toString());
			if (i != parts.size() - 1)
				builder.append(",");
		}
		
		builder.append("]");

		return builder.toString();
	}

	public Message clone() {
		return new Message(new ArrayList<>(getParts()));
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
