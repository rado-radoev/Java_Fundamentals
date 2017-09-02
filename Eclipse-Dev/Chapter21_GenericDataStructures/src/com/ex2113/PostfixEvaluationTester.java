package com.ex2113;
import java.util.Scanner;

public class PostfixEvaluationTester {

	public static void main(String[] args) {
		System.out.println("Enter expression:");
		Scanner input = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		sb.append(input.nextLine());
		
		PostfixEvaluator postfix = new PostfixEvaluator(sb);
		postfix.evaluatePostfixExpression();
		postfix.print();
	}

}
