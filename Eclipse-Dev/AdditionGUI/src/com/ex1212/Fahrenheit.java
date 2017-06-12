package com.ex1212;

public class Fahrenheit extends Temperature{
	
	double temp;

	public Fahrenheit(double temp) {
		super(temp);
	}
	
	public static double converttoCelcius(double temperature) {
		return ((temperature - 32) * 5) / 9;
	}
	
	public static double convertToKelvin(double temperature) {
		return ((temperature + 459.67) * 5 ) / 9;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
