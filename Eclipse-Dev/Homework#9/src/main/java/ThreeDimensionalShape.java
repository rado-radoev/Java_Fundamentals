
public abstract class ThreeDimensionalShape extends Shape {

	// Invoking single parameter super class - Sphere
	public ThreeDimensionalShape(double dimension) {
		super(dimension);
	}
	
	// Invoking double parameter super class - Sphere
	public ThreeDimensionalShape(double base, double height) {
		super(base, height);
	}
	
	// Invoking triple parameter super class - Sphere
	public ThreeDimensionalShape(double base, double height, double dimension) {
		super(base, height, dimension);
	}
	
	// Abstract method to be overridden by subclasses
	public abstract double getArea();
	public abstract double getVolume();
}
