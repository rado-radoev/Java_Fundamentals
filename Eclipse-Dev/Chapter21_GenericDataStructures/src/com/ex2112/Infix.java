package com.ex2112;

public interface Infix {
	
	public void convertToPostfix(StringBuffer infix); // convert infix expression to postfix
	public boolean isOperator(Character operator); // determine whether a character is an operator
	public boolean precendence(Character operator1, Character operator2); // determine if precedence operator1 is < or == or > than operator2.
														  // Return true if operator1 has lower precendence than operator2, else return false;
	
	

}
