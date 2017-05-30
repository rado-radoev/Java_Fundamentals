// 11.19

package com.exceptions_4;

public class ConstructorFailure {

	public static void main(String[] args) {
		
		try { 
			SomeClass someClass = new SomeClass();
			someClass.getClass().getName();
		} catch (Exception e) {
			StackTraceElement[] stackTrace = e.getStackTrace();
			
			for (StackTraceElement element : stackTrace) {
				System.err.printf("%s: %s%n%s: %s%n%s: %s%n%s: %s%n", 
						"Class", element.getClassName(),
						"Method", element.getMethodName(),
						"File", element.getFileName(),
						"Line", element.getLineNumber());
			}
		}

	}

}
