package com.passwordprompt;

import javax.swing.JFrame;

public class PasswordPromptTest {

	public static void main(String[] args) {
		PasswordPrompt passwordPromptFrame = new PasswordPrompt();
		passwordPromptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		passwordPromptFrame.setSize(500,500);
		passwordPromptFrame.setVisible(true);
	}
}
