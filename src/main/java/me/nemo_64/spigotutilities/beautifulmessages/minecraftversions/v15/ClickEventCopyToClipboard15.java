package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions.v15;

import me.nemo_64.spigotutilities.beautifulmessages.ClickEventCopyToClipboard;

public class ClickEventCopyToClipboard15 extends ClickEventCopyToClipboard {

	public ClickEventCopyToClipboard15() {
		super();
	}

	public ClickEventCopyToClipboard15(String textToCopy) {
		super(textToCopy);
	}

	@Override
	public String toJSON() {
		// ,"clickEvent":{"action":"copy_to_clipboard","value":"VALUE"}
		
		StringBuilder builder = new StringBuilder(",\"clickEvent\":{\"action\":\"copy_to_clipboard\",\"value\":\"");
		
		builder.append(getValue());
		
		builder.append("\"}");
		
		return builder.toString();
	}

}
