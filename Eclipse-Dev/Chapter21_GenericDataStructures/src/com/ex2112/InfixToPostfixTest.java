package com.ex2112;

public class InfixToPostfixTest {

	public static void main(String[] args) {
		InfixToPostfixConverter infix = new InfixToPostfixConverter();
			
		infix.convertToPostfix(infix.readInfix());
		infix.print();

	}

}
