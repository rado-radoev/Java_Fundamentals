package com.ex2110;
import java.util.Stack;

public class StackReverse {

	public static void main(String[] args) {
		String s = "S kakvo po diavolite se zahvanah?";

		Stack<String> stack = new Stack<String>();
		for (String string : s.split(" ")) {
			stack.push(string);
		}
		
		displayReverse(stack);
	}
	
	public static void displayReverse(Stack<String> str) {
		while (!str.isEmpty()) {
			System.out.print(str.pop() + " ");
		}
		
	}

}
