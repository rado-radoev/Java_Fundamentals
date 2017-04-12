
public class Factorial {

	public static void main(String[] args) {
		System.out.println(calcFactorial4(20));

	}
	
	public static void calcFactorial (int factorial) {
		long fact = 1;
		for (int i = factorial; i > 1;i--) {
			fact *= i;
			System.out.printf("%d\t",fact);
		}	
	}
	
	public static void calcFactorial2 (int factorial) {
		long result = 1;
		for (int i = 2; i <= factorial;i++){
			result *= i;
			System.out.println(result);
		}
	}
	
	public static void calcFactorial3 (int factorial) {
		long fact = 1;
		do {
			fact *= factorial;
			factorial--;
			System.out.println(fact);
		} while (factorial > 0);
	}
	
	public static long calcFactorial4 (int factorial) {
		if (factorial <= 1) 
			return 1;
		else
			return factorial * calcFactorial4(factorial - 1);
	}

}
