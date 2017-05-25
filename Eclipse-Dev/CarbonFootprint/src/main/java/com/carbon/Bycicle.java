package com.carbon;

public class Bycicle implements CarbonFootprint{
	
	private double yearlyMilesRidden;
	
	public Bycicle(double yearlyMilesRidden) {
		setYearlyMilesRidden(yearlyMilesRidden);
	}
	
	public double getYearlyMilesRidden() {
		return yearlyMilesRidden;
	}
	
	public final void setYearlyMilesRidden(double yearlyMilesRidden) {
		this.yearlyMilesRidden = yearlyMilesRidden;
	}

	public double getCarbonFootprint() {
		return getYearlyMilesRidden() * .22;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s is $%,.2f %", 
				getClass().getName(),
				"carbon footprint",
				getCarbonFootprint());
	}

}
