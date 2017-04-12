import java.util.Scanner;
public class BarChart {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int minNum = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("Enter a number: ");
			int num = scan.nextInt();
			
			if (num < minNum) {
				minNum = num;
			}
		}
		System.out.println(minNum);
	}

}
