package com.ex2112;

// very good video: https://www.youtube.com/watch?v=vq-nUF0G4fI
import com.StackComposition.StackComposition;

import java.util.Arrays;
import java.util.Scanner;

public class InfixToPostfixConverter implements Infix{

	private StringBuffer infix;
	private StringBuffer postfix = new StringBuffer();
	private StackComposition<Character> stack = new StackComposition<Character>();
	
	@Override
	public void convertToPostfix(StringBuffer infix) {		
		for (int i = 0; i < infix.length(); i++) {	// loop through each character
			char c = infix.charAt(i);				// get the current char in variable
			if ((int)c == 32)
				continue;						// if current char is space continue
			else if (isDigit(c)) 				// if character is digit
				postfix.append(c);				// append it to postfix
			else if (c == '(')					// if char is left bracket
				stack.push(c);					// push it to the stack
			else if (c == ')') {				// if char is right bracket
				while (!stack.isEmpty() && stack.peek() != '(')		// check each element in the stack until a left bracket is reached or the end of the stack
					postfix.append(stack.pop());					// append each operator in the way to postfix
				
				stack.pop();										// pop the left paranthesis
			}
			else if (isOperator(c)) {			// if char is operator
				while (!stack.isEmpty() && isOperator(stack.peek()) && precendence(stack.peek(), c)) // check if stack is not empty, next char is stack is operator and check precedence
					postfix.append(stack.pop());		// if the stack operator has higher precedence then the current char append to postfix until no more chars
														// or the stack operator has lower precendence then the current char
				stack.push(c);							// push current operator to stack
			}
		}
		
		while(!stack.isEmpty()) {						// when the end of the infix is reached pop any operators that are still in the stack
			postfix.append(stack.pop());
		}
		
	}
	@Override
	// Check if character is operator
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
	// Check precendence of two operators
	public boolean precendence(Character stackOp, Character infixOp) {

		Character[] additive = {'+', '-'};
		//Character[] multiplicative = {'*', '/', '%'};
	
		int stack = Arrays.asList(additive).contains(stackOp) ? 2 : 4;
		int infix = Arrays.asList(additive).contains(infixOp) ? 2 : 4;
		
		if (stack >= infix)
			return true;
		else
			return false;
		
	}
	
	// Method to read the infix expression entered
	public StringBuffer readInfix() {
		System.out.println("Enter expression below:");
		Scanner input = new Scanner(System.in);
		
		infix = new StringBuffer(input.nextLine());
		input.close();
		return infix;
	}
	
	// helper method to check if a char is in range
	private boolean isInRange(int num, int minRange, int maxRange) {
		if (num >= minRange && num <= maxRange)
			return true;
		else
			return false;
	}
	
	public void print() {
		System.out.print(postfix);
	}
	
	// check if current char is digit
	private boolean isDigit(Character character) {
		if (isInRange((int)character, 48, 57))
			return true;
		else 
			return false;
	}
}
