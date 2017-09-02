package com.ex2113;

import com.StackComposition.StackComposition;

public class PostfixEvaluator {

	private StringBuffer postfix;
	private StackComposition<Integer> stack;
	
	public PostfixEvaluator(StringBuffer postfix) {
		setPostfix(postfix);
		stack = new StackComposition<>();
	}
	
	public StringBuffer getPostfix() {
		return postfix;
	}
	
	public final void setPostfix(StringBuffer postfix) {
		this.postfix = postfix;
	}
	
	public void evaluatePostfixExpression () {
		String[] temp = postfix.toString().split(" ");
		
		for (int i = 0; i < temp.length; i++) {
			String num = temp[i];
			
			if (isNumber(num))
				stack.push(Integer.valueOf(num));
			else if (isOperator(num)) {
				Integer operand2 = stack.pop();
				Integer operand1 = stack.pop();
				Integer result = calculate(operand1, operand2, num);
				stack.push(result);
			}
		}	
	}
	
	public void print() {
		System.out.println(stack.pop());
	}
	
	private Integer calculate(Integer operand1, Integer operand2, String operator) {
		int result = 0;
		switch (operator) {
		case "-":
			result = operand1 - operand2;
			break;
		case "+":
			result = operand1 + operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			result = operand1 / operand2;
			break;
		case "%":
			result = operand1 % operand2;
			break;
		case "^":
			result = (int) Math.pow(operand1, operand2);
			break;
		default:
			break;
		}
		
		return result;
	}
	
	public boolean isOperator(String operator) {
		if (operator.matches("-|\\+|\\*|\\%|\\^|\\/"))
			return true;
		else 
			return false;
	}
	

	// check if current char is digit
	private boolean isNumber (String character) {
		if (character.matches("\\d+"))
			return true;
		else 
			return false;
	}
}
