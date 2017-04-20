import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.Scanner;

public class RoundingNumbers {

	public static void main(String[] args) {
		
	}
	
	public static double distanceBetweenPoint(double x1, double x2, double y1, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)  * (y1 - y2));
		//return Point2D.distance(x1, y1, x2, y2);
	}

	
	public static void GCD(int a, int b) {
		int temp = 0;
		if (a > 0 && b > 0) {
			temp = a % b;
			GCD(b, temp);
		}
		else if (b <= 0) {
			System.out.println("GCD is :" + a);
			return;
		}
		else if (a <= 0 ) {
			System.out.println("GCD is: " + b);
			return;
		}
	}
	
	public static void reverseDigits(int number) {
		int temp = 0;
		while (number > 0) {
			temp = number % 10;
			number /= 10;	
			System.out.print(temp);
		}
	}
	
	public static void perfectNumber(long number) {
		long sum = 0;
		for (long i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				sum += i; 
			}
		}	
			
			if (sum == number) {
				System.out.println(number + " is a perfect number!");
			}
			else {
				System.out.println(number + " is not a perfect number!");
			}
		
	}
	
	public static float findMinimum(float a, float b, float c) {
		float min = Math.min(a, b);
		min = Math.min(min, c);
		return min;
	}
	
	public static double celciusToFahrenheit(double celcius) {
		return 9.0 / 5.0 * celcius + 32;
	}
	
	public static double fahrenheitToCelcius(double fahrenheit) {
		return 5.0 / 9.0 * (fahrenheit - 32);
	}
	
	public static void circleArea() {
		System.out.println("Enter circle radius:");
		Scanner scan = new Scanner(System.in);
		double radius = scan.nextDouble();
		scan.close();
		
		double area = Math.PI * Math.pow(radius, 2);
		System.out.printf("Area is: %.2f", area);
	}
	
	public static void displaySquareOfChar(int square) {
		System.out.println("Enter character to print:");
		Scanner scan = new Scanner(System.in);
		char fill = scan.next().charAt(0);
		scan.close();
		
		int counter = 0;
		while (counter < square) {
			System.out.println(String.join("", Collections.nCopies(square, Character.toString(fill))));
			counter++;
		}
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
