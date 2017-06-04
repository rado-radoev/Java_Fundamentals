package com.button;
import javax.swing.JFrame;


public class ButtonTest {

	public static void main(String[] args) {
		Button radioButton = new Button();
		radioButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		radioButton.setSize(300,100);
		radioButton.setVisible(true);
	}
}
