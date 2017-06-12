package com.ex1212;

public class Celcius extends Temperature {
	
	double temp;

	public Celcius(double temp) {
		super(temp);
	}

	public static double convertToFahrenheit(double temperature) {
		return ((temperature * 9) / 5) + 32;
	}
	
	public static double ToKelvin(double temperature) {
		return temperature + 273.15;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
		
}
