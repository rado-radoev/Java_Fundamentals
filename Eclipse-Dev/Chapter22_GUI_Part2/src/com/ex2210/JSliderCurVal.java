package com.ex2210;

import java.awt.Graphics;
import javax.swing.JPanel;

public class JSliderCurVal extends JPanel {
	
	private String JSliderCurrentVal;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(JSliderCurrentVal, 0, 0);
	}
	
	public String getJSliderCurrentVal() {
		return JSliderCurrentVal;
	}
	
	public void setJSliderCurrentVal(String value) {
		this.JSliderCurrentVal = value;
	}
}
