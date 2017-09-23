package com.ex2216_Test;

public enum Colors {

	BLACK("Black"), 
	BLUE("Blue"), 
	CYAN("Cyan"), 
	DARKGRAY("Dark Grey"),
	GRAY("Gray"),
	GREEN("Green"),
	LIGHTGRAY("Light Gray"), 
	MAGENTA("Magenta"),
	ORANGE("Orange"),
	PINK("Pink"),
	RED("Red"),
	YELLOW("Yellow");
	
	private final String colorName;
	
	Colors(String colorName) {
		this.colorName = colorName;
	}
	
	public String getColorName() {
		return colorName;
	}
}
