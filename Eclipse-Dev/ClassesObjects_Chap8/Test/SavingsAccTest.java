import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingsAccTest {
	
	// THIS CLASS IS NOT WORKING!!!

	public static void main(String[] args) {
		
		// Create two Savings Account objects
		SavingsAcct2 saver1 = new SavingsAcct2();
		SavingsAcct2 saver2 = new SavingsAcct2();
		
		// set savings acct objects Saving Balances
		saver1.setSavingsBalance(BigDecimal.valueOf(2000));
		saver2.setSavingsBalance(BigDecimal.valueOf(3000));
		
		// set annual interest rate
		SavingsAcct2.modifyInterestRate(BigDecimal.valueOf(4));
		
		// calculate balance for 12 months
		System.out.printf("%s%10s%n", "Saver", "Balance");
		System.out.printf("Current Annual Interest Rate is: %fn", SavingsAcct2.getAnnualInterestRate());
		for (int month = 1; month <= 12; month++) {
			System.out.printf("%s%10f%n", "Saver1", saver1.getSavingsBanalce());
		}
		
		System.out.printf("%s%10s%n", "Saver", "Balance");
		System.out.printf("Current Annual Interest Rate is: %f%n", SavingsAcct2.getAnnualInterestRate());
		for (int month = 1; month <= 12; month++) {
			System.out.printf("%s%10f%n", "Saver2", saver2.getSavingsBanalce());
		}

		// set annual interest rate
		SavingsAcct2.modifyInterestRate(BigDecimal.valueOf(5));
		
		System.out.printf("%n%n");
		System.out.printf("Current Annual Interest Rate is: %f%n", SavingsAcct2.getAnnualInterestRate());
		for(int i = 0; i < 1; i++) {
			System.out.printf("%s%10f%n", "Saver1", saver1.getSavingsBanalce());
			System.out.printf("%s%10f%n", "Saver2", saver2.getSavingsBanalce());
		}
	}

}
