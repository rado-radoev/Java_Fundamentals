package com.ex1212;

public abstract class Temperature {
	
	double temp;
	
	public Temperature(double temp) {
		this.temp = temp;
	}
	
	public double getTemp()	{
		return temp;
	}
	
	public String toString() {
		return String.format("%.2f", temp);
	}
}
