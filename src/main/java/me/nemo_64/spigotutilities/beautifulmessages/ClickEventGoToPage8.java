package me.nemo_64.spigotutilities.beautifulmessages;

class ClickEventGoToPage8 extends ClickEventGoToPage {

	public ClickEventGoToPage8() {
		super(0);
	}

	public ClickEventGoToPage8(int page) {
		super(page);
	}

	@Override
	public String toJSON() {
		// ,"clickEvent":{"action":"change_page","value":0}
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"change_page\",\"value\":");

		builder.append(getValue());

		builder.append("}");

		return builder.toString();
	}

}
