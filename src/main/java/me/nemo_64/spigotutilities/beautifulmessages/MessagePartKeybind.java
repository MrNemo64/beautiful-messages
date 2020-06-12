package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v12.MessagePartKeybind12;

/**
 * Works in 1.12+<br>
 * This message part has no text.<br>
 * It will just get replaced with the key that the player has configured for a
 * specific action.<br>
 * For example, {@link Keybind#FORWARD} will probably get replaced with "w"
 * since is the key by default.
 */
public abstract class MessagePartKeybind extends MessagePart {

	private Keybind key;

	protected MessagePartKeybind(Keybind key, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super(key.getPath(), color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.key = key;
	}

	protected MessagePartKeybind() {
		super();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param key
	 *            The key to be displayed
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
	public static MessagePartKeybind create(@Nonnull Keybind key, @Nullable ChatColor color, boolean bold,
			boolean italics, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		return new MessagePartKeybind12(key, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartKeybind create() {
		return new MessagePartKeybind12();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param key
	 *            The key to be displayed
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartKeybind create(@Nonnull Keybind key) {
		return create(key, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param key
	 *            The key to be displayed
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartKeybind create(@Nonnull Keybind key, @Nullable ChatColor color) {
		return new MessagePartKeybind12(key, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param key
	 *            The key to be displayed
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePartKeybind create(@Nonnull Keybind key, @Nullable ChatColor color, boolean bold) {
		return new MessagePartKeybind12(key, color, bold, false, false, false, false, null, null);
	}

	public Keybind getKey() {
		return key;
	}

	public void setKey(Keybind key) {
		this.key = key;
	}

	public static enum Keybind {
		/**
		 * Walk Forwards
		 */
		FORWARD("forward"),
		/**
		 * Walk Backwards
		 */
		BACK("back"),
		/**
		 * Strafe Left
		 */
		LEFT("left"),
		/**
		 * Strafe Right
		 */
		RIGHT("right"),
		/**
		 * Jump
		 */
		JUMP("jump"),
		/**
		 * Sneak
		 */
		SNEAK("sneak"),
		/**
		 * Sprint
		 */
		SPRINT("sprint"),
		/**
		 * Open/Close Inventory
		 */
		INVENTORY("inventory"),
		/**
		 * Attack/Destroy
		 */
		ATTACK("attack"),
		/**
		 * Use Item/Place Block
		 */
		USE("use"),
		/**
		 * Pick Block
		 */
		PICKITEM("pickItem"),
		/**
		 * Drop Selected Item
		 */
		DROP("drop"),
		/**
		 * Swap Item In Hands
		 */
		SWAPHANDS("swapHands"),
		/**
		 * Hotbar Slot 1
		 */
		HOTBAR_1("hotbar.1"),
		/**
		 * Hotbar Slot 2
		 */
		HOTBAR_2("hotbar.2"),
		/**
		 * Hotbar Slot 3
		 */
		HOTBAR_3("hotbar.3"),
		/**
		 * Hotbar Slot 4
		 */
		HOTBAR_4("hotbar.4"),
		/**
		 * Hotbar Slot 5
		 */
		HOTBAR_5("hotbar.5"),
		/**
		 * Hotbar Slot 6
		 */
		HOTBAR_6("hotbar.6"),
		/**
		 * Hotbar Slot 7
		 */
		HOTBAR_7("hotbar.7"),
		/**
		 * Hotbar Slot 8
		 */
		HOTBAR_8("hotbar.8"),
		/**
		 * Hotbar Slot 9
		 */
		HOTBAR_9("hotbar.9"),
		/**
		 * Save Toolbar
		 */
		SAVETOOLBARACTIVATOR("saveToolbarActivator"),
		/**
		 * Load Toolbar
		 */
		LOADTOOLBARACTIVATOR("loadToolbarActivator"),
		/**
		 * List Players
		 */
		PLAYERLIST("playerlist"),
		/**
		 * Open Chat
		 */
		CHAT("chat"),
		/**
		 * Open Command
		 */
		COMMAND("command"),
		/**
		 * Highlight Players (Spectators)
		 */
		SPECTATOROUTLINES("spectatorOutlines"),
		/**
		 * Take Screenshot
		 */
		SCREENSHOT("screenshot"),
		/**
		 * Toggle Cinematic Camera
		 */
		SMOOTHCAMERA("smoothCamera"),
		/**
		 * Toggle Fullscreen
		 */
		FULLSCREEN("fullscreen"),
		/**
		 * Toggle Perspective
		 */
		TOGGLEPERSPECTIVE("togglePerspective");

		private static final String prefix = "key.";
		private String path;

		private Keybind(String path) {
			this.path = path;
		}

		public String getValue() {
			return path;
		}

		public String getPath() {
			return getPrefix() + getValue();
		}

		@Override
		public String toString() {
			return getPath();
		}

		public static String getPrefix() {
			return prefix;
		}
	}

}
