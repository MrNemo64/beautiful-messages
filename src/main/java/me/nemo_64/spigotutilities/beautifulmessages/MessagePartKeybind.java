package me.nemo_64.spigotutilities.beautifulmessages;

import org.bukkit.ChatColor;

import me.nemo_64.spigotutilities.beautifulmessages.events.ClickEvent;
import me.nemo_64.spigotutilities.beautifulmessages.events.HoverEvent;

/**
 * This message part has no text.<br>
 * It will just get replaced with the key that the player has configured for a
 * specific action.<br>
 * For example, {@link Keybind#FORWARD} will probably get replaced with "w"
 * since is the key by default.
 */
public abstract class MessagePartKeybind extends MessagePart {

	private Keybind key;

	public MessagePartKeybind(Keybind key, ChatColor color, boolean bold, boolean italics, boolean underlined,
			boolean strikethrough, boolean obfuscated, ClickEvent click, HoverEvent hover) {
		super("", color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
		this.key = key;
	}

	public MessagePartKeybind() {
		super();
	}

	public Keybind getKey() {
		return key;
	}

	public void setKey(Keybind key) {
		this.key = key;
	}

	@Override
	public void setText(String text) {
		throw new IllegalAccessError("The MessagePartKeybind does not have a text");
	}

	@Override
	public String getText() {
		throw new IllegalAccessError("The MessagePartKeybind does not have a text");
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
