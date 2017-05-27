
public abstract class ThreeDimensionalShape extends Shape {

	public ThreeDimensionalShape(double dimension) {
		super(dimension);
	}
	
	public ThreeDimensionalShape(double base, double height) {
		super(base, height);
	}
	
	public ThreeDimensionalShape(double base, double height, double dimension) {
		super(base, height, dimension);
	}
	
	// Abstract method to be overridden by subclasses
	public abstract double getArea();
	public abstract double getVolume();
}
