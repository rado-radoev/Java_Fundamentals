package com.ex2216;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.channels.SelectableChannel;

import javax.swing.JFrame;

public class Demo {

	public static void main(String[] args) {
		DesktopFrame desktopFrame = new DesktopFrame();
		desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopFrame.setVisible(true);
		
		
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		desktopFrame.setBounds(inset, inset,
                screenSize.width  - inset*2,
                screenSize.height - inset*2);
	}

}
