package com.ex2112;
import com.StackComposition.StackComposition;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixConverter implements Infix{

	private StringBuffer infix;
	private StringBuffer postfix = new StringBuffer();
	private StackComposition<Character> stack = new StackComposition<Character>();
	private Stack<Character> testStack = new Stack<>();
	
	@Override
	public void convertToPostfix(StringBuffer infix) {		
		for (int i = 0; i < infix.length(); i++) {	// loop through each character
			char c = infix.charAt(i);		// get the current char in variable
			if ((int)c == 32)
				continue;
			else if (isDigit(c)) 				// if character is digit
				postfix.append(c);			// append it to postfix
			else if (c == '(')				// if char is left bracket
				stack.push(c);				// push it to the stack
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() == '(')
					postfix.append(stack.peek());
				stack.pop();
			}
			else if (isOperator(c)) {		// if char is operator
				while (!stack.isEmpty() && precendence(stack.peek(), c))
					postfix.append(stack.pop());
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		
	}
	@Override
	public boolean isOperator(Character operator) {
		switch ((int)operator) {
		case 37: // %
		case 42: // *
		case 43: // +
		case 45: // -
		case 47: // /
			return true;
		default:
			return false;
		}
	}

	
	@Override
	public boolean precendence(Character operator1, Character operator2) {
		// if operator1 < operato2 return true
		// else return false
		Character[] additive = {'+', '-'};
		Character[] multiplicative = {'*', '/', '%'};
	
		// check if operator1 is in the additive array 
		if (Arrays.asList(multiplicative).contains(operator1) && Arrays.asList(additive).contains(operator2))
			return true;	// infix operator1 has lower precendence than operator2
		else
			return false;   // both operators have the same precendence or 2 is higher than 1
	}
	
	public StringBuffer readInfix() {
		System.out.println("Enter expression below:");
		Scanner input = new Scanner(System.in);
		
		infix = new StringBuffer(input.nextLine());
		input.close();
		return infix;
	}
	
	private boolean isInRange(int num, int minRange, int maxRange) {
		if (num >= minRange && num <= maxRange)
			return true;
		else
			return false;
	}
	
	public void print() {
		System.out.print(postfix);
	}
	
	
	private boolean isDigit(Character character) {
		if (isInRange((int)character, 48, 57))
			return true;
		else 
			return false;
	}
}
