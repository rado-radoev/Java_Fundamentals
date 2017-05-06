import java.math.BigDecimal;
import java.math.MathContext;

// ex 8.6
public class SavingsAcct {
	
	private static double annualInterestRate;
	private double savingsBalance;
	
	private double calculateMonthlyInterest() {
		return (savingsBalance * annualInterestRate) / 12;
	}
	
	public double getSavingsBanalce() {
		return savingsBalance += calculateMonthlyInterest();
	}
	
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public static void modifyInterestRate(double newInterstRate) {
		SavingsAcct.annualInterestRate = newInterstRate;
	}
	
	public static double getAnnualInterestRate() {
		return SavingsAcct.annualInterestRate;
	}
}

class SavingsAcct2{
	
	
	private static BigDecimal annualInterestRate = BigDecimal.valueOf(0);
	private BigDecimal savingsBalance = BigDecimal.valueOf(0);
	
	public BigDecimal calculateMonthlyInterest() {
		return (savingsBalance.multiply(annualInterestRate)).divide(BigDecimal.valueOf(12));
	}
	
	public BigDecimal getSavingsBanalce() {
		return savingsBalance.add(calculateMonthlyInterest(), MathContext.DECIMAL32);
	}
	
	public void setSavingsBalance(BigDecimal savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public static void modifyInterestRate(BigDecimal newInterstRate) {
		SavingsAcct2.annualInterestRate = newInterstRate;
	}
	
	public static BigDecimal getAnnualInterestRate() {
		return SavingsAcct2.annualInterestRate;
	}
}
