
public abstract class TwoDimensionalShape extends Shape {
	
	// Invoking single parameter super class - Sphere
	public TwoDimensionalShape(double diameter) {
		super(diameter);
	}
	
	// Invoking double parameter super class - Sphere
	public TwoDimensionalShape(double base, double heigth) {
		super(base, heigth);
	}
	
	// Abstract methods to be overridden by subclasses
	public abstract double getArea();
}
