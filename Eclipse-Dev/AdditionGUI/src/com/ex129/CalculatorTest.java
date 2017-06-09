package com.ex129;

import javax.swing.JFrame;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setSize(250, 250);
		calculator.setVisible(true);
	}

}
