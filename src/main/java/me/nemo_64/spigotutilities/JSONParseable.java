package me.nemo_64.spigotutilities;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class JSONParseable {

	private Supplier<String> parser;

	public JSONParseable() {
		this(null);
	}
	
	public JSONParseable(@Nullable Supplier<String> parser) {
		this.parser = parser == null ? getParserToUse() : parser;
	}

	/**
	 * Gets the parser being used
	 * 
	 * @return The parser
	 */
	@Nonnull
	public Supplier<String> getParser() {
		return parser;
	}

	/**
	 * Sets the parser to be used
	 * 
	 * @param parser
	 *            The parser to be used
	 */
	public void setParser(@Nullable Supplier<String> parser) {
		this.parser = parser;
	}

	@Nonnull
	public Supplier<String> getDefaultParser() {
		return () -> null;
	}

	/**
	 * Converts this object to a JSON string
	 * 
	 * @return The object as JSON
	 */
	@Nonnull
	public String toJSON() {
		return parser.get();
	}

	/**
	 * Used to get the parser that has to be used in the server version that is
	 * being runned
	 * 
	 * @return The parser
	 */
	@Nonnull
	protected abstract Supplier<String> getParserToUse();

}
