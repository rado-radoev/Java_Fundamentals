
public class Circle extends TwoDimensionalShape {

	private final double PI = Math.PI;
	
	public Circle(double diameter) {
		super(diameter);
	}

	@Override
	public double getArea() {
		return PI * (super.getDiameter() * super.getDiameter());
	}
	
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
}
