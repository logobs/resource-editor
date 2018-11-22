package com.logo.util;

public enum ResourceType {
	LOCALIZABLE(1), NONLOCALIZABLE(2);

	private final Integer typ;

	private ResourceType(Integer typ) {
		this.typ = typ;
	}

	@Override
	public String toString() {
		if (typ == 1) {
			return "Localizable";
		}
		if (typ == 2) {
			return "Non-Localizable";
		}
		return "";
	}
}
