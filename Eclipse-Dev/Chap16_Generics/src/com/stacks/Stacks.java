package com.stacks;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stacks {

	public static void main(String[] args) {

		Stack<Number> stack = new Stack<>(); // creates a stack
		
		// push elements to stack
		stack.push(12L);
		stack.push(5.55F);
		stack.push(18.9D);
		
		//printStack(stack);
		//printStackEmpty(stack);
		System.out.printf("%s", stack.contains(12L));
		
		
	}
	
	private static void printStackEmpty (Stack<Number> stack) {
		try {
			Number removedObject = null;
			
			while (true) {
				removedObject = stack.pop();
				System.out.printf("%s %s%n", "Popped element is", removedObject);
			}
		} catch (EmptyStackException ese) {
			System.out.printf("Stack is empty");
		
		}
	}
	
	// print stack using iterator
	private static void printStack (Stack<Number> stack) {
		Iterator<Number> stackIterator = stack.iterator();
		
		while (stackIterator.hasNext()) {
			System.out.printf("%s%n", stackIterator.next());
		}
	}
}
