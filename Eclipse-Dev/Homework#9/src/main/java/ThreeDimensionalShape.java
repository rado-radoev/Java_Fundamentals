
public abstract class ThreeDimensionalShape extends Shape {

	public ThreeDimensionalShape(double Diameter) {
		super(Diameter);
	}
	
	public ThreeDimensionalShape(double base, double height) {
		super(base, height);
	}
	
	// Abstract method to be overridden by subclasses
	public abstract double getArea();
	public abstract double getVolume();

}
