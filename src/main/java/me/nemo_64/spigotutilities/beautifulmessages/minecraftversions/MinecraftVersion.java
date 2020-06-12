package me.nemo_64.spigotutilities.beautifulmessages.minecraftversions;

import org.bukkit.Bukkit;

public enum MinecraftVersion {

	v1_8("v1_8", 8),
	v1_9("v1_9", 9),
	v1_10("v1_10", 10),
	v1_11("v1_11", 11),
	v1_12("v1_12", 12),
	v1_13("v1_13", 13),
	v1_14("v1_14", 14),
	v1_15("v1_15", 15),
	v1_16("v1_16", 16);

	private static MinecraftVersion runningVersion;

	private String match;

	private int number;

	static {
		String v = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		for (MinecraftVersion ver : MinecraftVersion.values()) {
			if (ver.match.contains(v)) {
				runningVersion = ver;
				break;
			}
		}
	}

	private MinecraftVersion(String match, int number) {
		this.match = match;
		this.number = number;
	}

	public boolean isNewerThan(MinecraftVersion other) {
		return number > other.number;
	}

	public boolean isOltherThan(MinecraftVersion other) {
		return number < other.number;
	}
	
	public static MinecraftVersion getRunningVersion() {
		return runningVersion;
	}

}
