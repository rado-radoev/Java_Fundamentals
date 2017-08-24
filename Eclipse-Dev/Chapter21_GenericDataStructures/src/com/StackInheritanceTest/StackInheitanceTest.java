package com.StackInheritanceTest;
import com.figStackInheritance.StackInheritance;
import com.figLinkedList.EmptyListException;

public class StackInheitanceTest {

	public static void main(String[] args) {
		StackInheritance<Integer> stack = new StackInheritance<>();
		
		// use push method
		stack.push(-1);
		stack.print();
		stack.push(0);
		stack.print();
		stack.push(1);
		stack.print();
		stack.push(5);
		stack.print();
		
		// remove items from stack
		try {
			int removedItem;
			
			while (true) {
				removedItem = stack.pop();
				System.out.printf("%n%d popped%n", removedItem);
				stack.print();
			}
			
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}

}
