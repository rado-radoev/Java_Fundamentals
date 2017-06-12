package com.ex1212;

public class Celcius extends Temperature {
	
	double temp;

	public Celcius(double temp) {
		super(temp);
	}

	public double convertToFahrenheit(double temperature) {
		return ((temperature * 9) / 5) + 32;
	}
	
	public double ToKelvin(double temperature) {
		return temperature + 273.15;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
		
}
