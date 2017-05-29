
public class Circle extends TwoDimensionalShape {

	// Invoke super class single constructor -> TwoDiemnsionalShape -> Shape
	public Circle(double radius) {
		super(radius);
	}

	// Calculate the area
	@Override
	public double getArea() {
		return Math.PI * Math.pow(super.getDimension(), 2);
	}
	
	// Output the object's name
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	// Display radius
	@Override
	public String toString() {
		return String.format("%s: %.2f", "radius" , getDimension());
	}
	
}
