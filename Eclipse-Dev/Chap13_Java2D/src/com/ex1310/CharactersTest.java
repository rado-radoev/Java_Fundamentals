package com.ex1310;

import javax.swing.JFrame;

public class CharactersTest {

	public static void main (String[] args) {
		JFrame frame = new JFrame("Random chars");
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Characters chars = new Characters();
		frame.add(chars);
		frame.setVisible(true);
		frame.setSize(420, 420);
	}
}
