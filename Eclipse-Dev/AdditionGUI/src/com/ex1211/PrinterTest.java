package com.ex1211;

import javax.swing.JFrame;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		printer.setSize(350, 150);
		printer.setVisible(true);
	}
}
