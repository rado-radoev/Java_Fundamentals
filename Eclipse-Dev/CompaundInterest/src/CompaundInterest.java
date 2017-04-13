
public class CompaundInterest {

	public static void main(String[] args) {
		int amount = 0;
		int principle = 1000;
		int rate = 0;

		System.out.printf("%s%20s%n", "Year", "Amount on deposit");
		
		for (int year = 1; year <= 10; ++year) {
			amount = principle * (int)Math.pow(1.0 + rate, year);
			
			System.out.printf("%4d%,20d%n", year, amount);
		}
	}

}
