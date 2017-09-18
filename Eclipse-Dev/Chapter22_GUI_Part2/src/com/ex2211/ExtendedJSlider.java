package com.ex2211;

import javax.swing.JSlider;

public class ExtendedJSlider extends JSlider {
	
	private String name;

	public ExtendedJSlider() {
		super();

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
