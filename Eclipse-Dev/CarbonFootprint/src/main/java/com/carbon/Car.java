package com.carbon;

public class Car implements CarbonFootprint {
	
	private double yearlyMilage;
	private double yearlyGasUsed;
	
	public Car(double yearlyMilage, double yearlyGasUsed) {
		this.yearlyGasUsed = yearlyGasUsed;
		this.yearlyMilage = yearlyMilage;
	}
	
	public double getYearlyMilage()	 {
		return yearlyMilage;
	}
	
	public double getYearlyGasUsed() {
		return yearlyGasUsed;
	}
	
	public void setYearlyMilage(double yearlyMilage) {
		this.yearlyMilage = yearlyMilage;
	}
	
	public void setYearlyGasUsed(double yearlyGasUsed) {
		this.yearlyGasUsed = yearlyGasUsed;
	}

	public double getCarbonFootprint() {
		return getYearlyMilage() * 113 + getYearlyGasUsed() * .79;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s is $%,.2f %", 
				getClass().getName(),
				"carbon footprint",
				getCarbonFootprint());
	}

}
