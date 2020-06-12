package me.nemo_64.spigotutilities.beautifulmessages;

class HoverEventText8 extends HoverEventText {

	public HoverEventText8(String text) {
		super(text);
	}

	public HoverEventText8() {
		super();
	}

	public HoverEventText8(Message message) {
		super(message);
	}

	@Override
	public String toJSON() {
		// ,"hoverEvent":{"action":"show_text","value":"VALUE"}
		StringBuilder builder = new StringBuilder(",\"hoverEvent\":{\"action\":\"show_text\",\"value\":");

		builder.append(getValue()/* .replace("\"", "\\\"") */);

		builder.append("}");

		return builder.toString();
	}

}
