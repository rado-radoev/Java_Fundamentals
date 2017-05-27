
public class Square extends TwoDimensionalShape {

	public Square(double diameter) {
		super(diameter);
	}
	
	@Override
	public double getArea() {
		return super.getDiameter() * super.getDiameter();
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
}
