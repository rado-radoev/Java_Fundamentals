import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String s = null;
		
		Scanner scan = new Scanner(System.in);
		s = scan.nextLine();
		
		if (!s.toUpperCase().equals("X")) {
			System.out.println("X");
		}
		else {
			System.out.println("O");
		}
	}

}
