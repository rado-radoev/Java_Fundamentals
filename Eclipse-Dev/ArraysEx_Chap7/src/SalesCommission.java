// Ex 7.10 page 300
public class SalesCommission {
	
	private double salary = 200;
	private double grossPercent = 0.09;
	
	public SalesCommission () {
		
	}

	public static void main(String[] args) {
		
		int[] sales = {2000, 3250, 8970, 1000, 5690, 5200};
		SalesCommission sc = new SalesCommission();
		sc.calcSalaries(sales);
	}
	
	
	public void calcSalaries(int[] salaries) {
		
		int[] salariesRange = new int[11];
		
		for (int pay : salaries) {
			int sum = (int)salary + (int)(pay * grossPercent);
			++salariesRange[sum / 100];
		}
		
		for (int count = 1; count < salariesRange.length; count++) {
			if (count >= 10) {
				System.out.printf("%d: ", 1000);
			}
			else {
				System.out.printf("%d - %d ", count * 100, count * 100 + 99);
			}
			
			
			for (int stars = 0; stars < salariesRange[count]; stars++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
