import java.util.Scanner;

public class CalculateSales {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String out = null;
		int number = 0;
		int quantity = 0;
		double total;
		
		Items prod1 = new Items(number,quantity,2.98);
		Items prod2 = new Items(number,quantity,4.50);
		Items prod3 = new Items(number,quantity,9.98);
		Items prod4 = new Items(number,quantity,4.49);
		Items prod5 = new Items(number,quantity,6.87);
		
		while (out != "exit") {
			System.out.println("Enter number 1-5 or exit to quit");
			out = input.nextLine();
			if (out.equals("exit"))
				break;
			
			number = Integer.parseInt(out);
			
			System.out.println("Enter quantity");
			quantity = input.nextInt();
			input.nextLine();
			
			switch (number) {
			case 1:
				prod1.setQuantitySold(quantity);
				break;
			case 2:
				prod2.setQuantitySold(quantity);
				break;
			case 3:
				prod3.setQuantitySold(quantity);
				break;
			case 4:
				prod4.setQuantitySold(quantity);
				break;
			case 5:
				prod5.setQuantitySold(quantity);
				break;
			default:
				break;
			}
		}

		input.close();
		
		total = (prod1.getQuantitySold() * prod1.getProductPrice()) +
				(prod2.getQuantitySold() * prod2.getProductPrice()) +
				(prod3.getQuantitySold() * prod3.getProductPrice()) + 
				(prod4.getQuantitySold() * prod4.getProductPrice()) +
				(prod5.getQuantitySold() * prod5.getProductPrice());
		
		System.out.println("Total is: " + total);
	}

}
