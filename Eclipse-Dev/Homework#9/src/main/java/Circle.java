
public class Circle extends TwoDimensionalShape {

	private final double PI = Math.PI;
	
	public Circle(double radius) {
		super(radius);
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(super.getDimension(), 2);
	}
	
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	@Override
	public String toString() {
		return String.format("%s: %.2f", "radius" , getDimension());
	}
	
}
