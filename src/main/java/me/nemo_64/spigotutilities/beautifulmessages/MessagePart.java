package me.nemo_64.spigotutilities.beautifulmessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.ChatColor;

/**
 * Represents a message part with just text
 */
public abstract class MessagePart {

	private ClickEvent click;
	private HoverEvent hover;
	private String text;
	private ChatColor color;

	private boolean bold;
	private boolean italics;
	private boolean underlined;
	private boolean strikethrough;
	private boolean obfuscated;

	protected MessagePart(@Nonnull String text, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		super();
		this.text = text;
		this.color = color;
		this.bold = bold;
		this.italics = italics;
		this.underlined = underlined;
		this.strikethrough = strikethrough;
		this.obfuscated = obfuscated;
		this.click = click;
		this.hover = hover;
	}

	/**
	 * Creates an empty message part
	 */
	protected MessagePart() {
		this("empty", ChatColor.WHITE, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param text
	 *            The text to be displayed
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
	public static MessagePart create(@Nonnull String text, @Nullable ChatColor color, boolean bold, boolean italics,
			boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable ClickEvent click,
			@Nullable HoverEvent hover) {
		return new MessagePart8(text, color, bold, italics, underlined, strikethrough, obfuscated, click, hover);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create() {
		return new MessagePart8();
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param text
	 *            The text to be displayed
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String text) {
		return create(text, ChatColor.WHITE);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param text
	 *            The text to be displayed
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String text, @Nullable ChatColor color) {
		return new MessagePart8(text, color, false, false, false, false, false, null, null);
	}

	/**
	 * Creates a message part in the corresponding minecraft version
	 * 
	 * @param text
	 *            The text to be displayed
	 * @param color
	 *            The color of the text
	 * @return A message part in the corresponding minecraft version
	 */
	public static MessagePart create(@Nonnull String text, @Nullable ChatColor color, boolean bold) {
		return new MessagePart8(text, color, bold, false, false, false, false, null, null);
	}

	/**
	 * Gets a clone of this message part
	 */
	public abstract MessagePart clone();

	/**
	 * Turns turns this message part into a JSON string
	 * 
	 * @param ignoreColors
	 *            If true, colors won't be applied
	 * @param ignoreEvents
	 *            If true, events won't be applied
	 * @return This message part as a JSON
	 */

	public abstract String toJSON(boolean ignoreColors, boolean ignoreEvents);

	@Nullable
	public String toJSON() {
		return toJSON(false, false);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MessagePart)
			return equals((MessagePart) obj);
		return false;
	}

	/**
	 * Checks if a given message part is equal to this one
	 * 
	 * @param part
	 *            The message part to checl
	 * @return If both parts are equal
	 */
	public boolean equals(MessagePart part) {
		return getText().equals(part.getText()) && getColor() == part.getColor() && isBold() == part.isBold()
				&& isItalics() == part.isItalics() && isUnderlined() == part.isUnderlined()
				&& isStrikethrough() == part.isStrikethrough() && isObfuscated() == part.isObfuscated()
				&& getHover().equals(part.getHover()) && getClick().equals(part.getClick());
	}

	protected StringBuilder appendColor(StringBuilder builder) {
		if (bold)
			builder.append(", \"bold\":true");
		if (italics)
			builder.append(", \"italics\":true");
		if (underlined)
			builder.append(", \"underlined\":true");
		if (strikethrough)
			builder.append(", \"strikethrough\":true");
		if (obfuscated)
			builder.append(", \"obfuscated\":true");
		if (color != null)
			builder.append(",\"color\": \"" + color.name().toLowerCase() + "\"");
		return builder;
	}

	protected StringBuilder appendEvents(StringBuilder builder) {
		if (getClick() != null)
			builder.append(getClick().toJSON());
		if (getHover() != null)
			builder.append(getHover().toJSON());
		return builder;
	}

	@Override
	public String toString() {
		return toJSON();
	}

	public ClickEvent getClick() {
		return click;
	}

	public void setClick(ClickEvent click) {
		this.click = click;
	}

	public HoverEvent getHover() {
		return hover;
	}

	public void setHover(HoverEvent hover) {
		this.hover = hover;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ChatColor getColor() {
		return color;
	}

	public void setColor(ChatColor color) {
		this.color = color;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalics() {
		return italics;
	}

	public void setItalics(boolean italics) {
		this.italics = italics;
	}

	public boolean isUnderlined() {
		return underlined;
	}

	public void setUnderlined(boolean underlined) {
		this.underlined = underlined;
	}

	public boolean isStrikethrough() {
		return strikethrough;
	}

	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}

	public boolean isObfuscated() {
		return obfuscated;
	}

	public void setObfuscated(boolean obfuscated) {
		this.obfuscated = obfuscated;
	}

}
