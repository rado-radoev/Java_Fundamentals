package com.carbon;

public class Building implements CarbonFootprint {
	
	private double yearlyElectrictyBill;
	private double yearlyGasBill;
	
	public Building(double yearlyElectircBill, double yearlyGasBill) {
		this.yearlyElectrictyBill = yearlyElectircBill;
		this.yearlyGasBill = yearlyGasBill;
	}
	
	

	public double getYearlyElectrictyBill() {
		return yearlyElectrictyBill;
	}



	public void setYearlyElectrictyBill(double yearlyElectrictyBill) {
		this.yearlyElectrictyBill = yearlyElectrictyBill;
	}



	public double getYearlyGasBill() {
		return yearlyGasBill;
	}



	public void setYearlyGasBill(double yearlyGasBill) {
		this.yearlyGasBill = yearlyGasBill;
	}



	public double getCarbonFootprint() {
		return getYearlyElectrictyBill() * 105 + getYearlyGasBill() * 105;
	}

	@Override
	public String toString() {
		return String.format("%s %s is $%,.2f %", 
				getClass().getName(),
				"carbon footprint",
				getCarbonFootprint());
	}
}
