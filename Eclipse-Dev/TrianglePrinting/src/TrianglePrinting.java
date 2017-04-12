
public class TrianglePrinting {

	public static void main(String[] args) {
		for (int i = 0; i <= 10;i++) {
			for (int j = 0; j < i + 1;j++) {
				System.out.printf("%s","*");
			}
			System.out.println();
		}
	

		
		for (int i = 10; i >= 0;i--) {
			for (int j = 0; j <= i - 1;j++) {
				System.out.printf("%s","*");
			}
			System.out.println();
		}

	
		for (int i = 0; i <= 10; i++) {
			if (i != 0) {
				System.out.printf("%" + i + "s", " ");
			}
		for (int j = 10; j >= i; j--) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
		
		
		for (int i = 0; i <= 10; i++) {
			if (10 - i > 0)
				System.out.printf("%" + (10-i) + "s", " ");
			for (int j = 0; j <= i; j++) {
					System.out.printf("%s", "*");
			}
			System.out.println();
 		}
	}
	
}
