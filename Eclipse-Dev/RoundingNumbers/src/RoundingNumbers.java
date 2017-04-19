import java.util.Collections;

public class RoundingNumbers {

	public static void main(String[] args) {
		displaySquareOfAsterisk(4);
	}
	
	public static void displaySquareOfAsterisk(int square) {
		for (int i = 0; i < square; i++) {
			System.out.println(String.join("", Collections.nCopies(square, "*")));
		}
	}
	
	public static boolean isMultiple(int a, int b) {
		if (a % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static double hypothenuse(double side1, double side2) {
		double a = side1 * side1;
		double b = side2 * side2;
		double c = Math.sqrt(a + b);
		return c;
	}
	
	public static int integerPower(int base, int exponent) {
		int output = base; 
		for (int i = 1; i < exponent; i++) {
			output *= base;
		}
		
		return output;
	}
	
	public static void mathFloor() {
		double x1 = 15.20;
		double x2 = 14.32;
		double x3 = 0.5;
		
		double y1 = Math.floor(x1 * 1000 + 0.5) / 1000;
		double y2 = Math.floor(x2 + 0.5);
		double y3 = Math.floor(x3 + 0.5);
		
		System.out.printf("Before: %f After: %f", x1, y1);
		System.out.println("Before: " + x2 + " After: " + y2);
		System.out.println("Before: " + x3 + " After: " + y3);
	}

}
