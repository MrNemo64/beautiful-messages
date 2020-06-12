package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * Works in 1.15+<br>
 * This message part will be replaced with the data from the apth specified in
 * the storage specified.<br>
 * A storage is created and a value is stored in the path, for example, using
 * the command
 * {@code /data modify storage %STORAGE_NAME% %PATH_TO_DATA% set value %VALUE}
 */
public abstract class MessagePartNBTStorage extends MessagePartNBT {

	private String storage;

	protected MessagePartNBTStorage(String path, String storage, boolean interpret, ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, ClickEvent click,
			HoverEvent hover) {
		super(path, interpret, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.storage = storage;
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param storage
	 *            The storage to take the value from
	 * @param color
	 *            The color of the text
	 * @param bold
	 *            If the text is bold
	 * @param italics
	 *            If the text is in italics
	 * @param underlined
	 *            If the text is underlined
	 * @param strikethrough
	 *            If the text is in strikethrough
	 * @param obfuscated
	 *            If the text is obfuscated
	 * @param click
	 *            The click event
	 * @param hover
	 *            The hover event
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTStorage create(@Nonnull String nbtPath, @Nonnull String storage,
			@Nullable ChatColor color, boolean bold, boolean italics, boolean underlined, boolean strikethrough,
			boolean obfuscated, @Nullable ClickEvent click, @Nullable HoverEvent hover) {
		return new MessagePartNBTStorage15(nbtPath, storage, true, color, bold, italics, underlined, strikethrough,
				obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param storage
	 *            The storage to take the value from
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTStorage create(@Nonnull String nbtPath, @Nonnull String storage) {
		return create(nbtPath, storage, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version <br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param storage
	 *            The storage to take the value from
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTStorage create(@Nonnull String nbtPath, @Nonnull String storage,
			@Nullable ChatColor color) {
		return new MessagePartNBTStorage15(nbtPath, storage, true, color, false, false, false, false, false, null,
				null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version<br>
	 * interpret is set by default to true
	 * 
	 * @param nbtPath
	 *            The NBT path
	 * @param storage
	 *            The storage to take the value from
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartNBTStorage create(@Nonnull String nbtPath, @Nonnull String storage,
			@Nullable ChatColor color, boolean bold) {
		return new MessagePartNBTStorage15(nbtPath, storage, true, color, bold, false, false, false, false, null, null);
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

}
