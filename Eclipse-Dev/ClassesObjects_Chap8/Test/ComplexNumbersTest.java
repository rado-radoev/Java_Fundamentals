
public class ComplexNumbersTest {

	public static void main(String[] args) {
		ComplexNumbers complex1 = new ComplexNumbers(4,33);
		ComplexNumbers complex2 = new ComplexNumbers(10,-2);
		
		System.out.print(ComplexNumbers.subtract(complex1, complex2));
	}

}
