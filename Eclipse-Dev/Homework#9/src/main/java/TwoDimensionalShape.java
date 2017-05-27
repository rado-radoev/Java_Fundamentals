
public abstract class TwoDimensionalShape extends Shape {
	
	public TwoDimensionalShape(double diameter) {
		super(diameter);
	}
	
	public TwoDimensionalShape(double base, double heigth) {
		super(base, heigth);
	}
	
	// Abstract method to be overridden by subclasses
	public abstract double getArea();
}
