package com.ex2112;
import com.StackComposition.StackComposition;
import java.util.Scanner;


public class InfixToPostfixConverter implements Infix{

	private StringBuffer infix;
	private StringBuffer postfix;
	private StackComposition<Character> stack = new StackComposition<Character>();
	
	@Override
	public void convertToPostfix(StringBuffer infix) {
		for (int i = 0; i < infix.length(); i++) {	// loop through each character
			char c = infix.charAt(i);		// get the current char in variable
			if (isDigit(c)) 				// if character is digit
				postfix.append(c);			// append it to postfix
			else if (c == '(')				// if char is left bracket
				stack.push(c);				// push it to the stack
			else if (isOperator(c)) {		// if char is operator
				// not sure about this one! May be I need to check only the top most char in the stack not every one
				while (!stack.isEmpty()) {	// pop operators at the top of the stack while they have equal or higher precedence
					if (!isOperator(stack.peek()))	// then the current operator and append popped operators to postfix
						postfix.append(stack.pop());
				}
				stack.push(c);		// push current char onto stack
			}
			else if (c == ')') {				// if char is right bracket
				while (stack.peek() != '(') {   // while left paranthesis is not at the top of the stack
					if (isOperator(stack.peek())) {		// if the char is operator
						postfix.append(stack.pop());	// pop from the stack and append to postfix
					}
				}
			}
			stack.pop();	// pop and discard left paranthesis from the stack
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
		boolean op1 = false;
		boolean op2 = false;
		
		// check if operator1 is in the additive array 
		for (Character c : additive) {
			if (operator1 == c)
				op1 = true;
		}
		
		for (Character c : multiplicative) {
			if (operator2 == c) 
				op2 = true;
		}
		
		if (op1 && op2)
			return true;
		
		
		return false;
	}
	
	private void readInfix() {
		System.out.println("Enter expression below:");
		Scanner input = new Scanner(System.in);
		
		infix.append(input.nextLine());
		input.close();
	}
	
	private boolean isInRange(int num, int minRange, int maxRange) {
		if (num >= minRange && num <= maxRange)
			return true;
		else
			return false;
	}
	
	
	private boolean isDigit(Character character) {
		if (isInRange((int)character, 48, 57))
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {

	}
}
