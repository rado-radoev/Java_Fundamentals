
public class Square extends TwoDimensionalShape {

	public Square(double side) {
		super(side);
	}
	
	@Override
	public double getArea() {
		return Math.pow(super.getDimension(), 2);
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	@Override
	public String toString() {
		return String.format("%s: %.2f","side" ,getDimension());
	}
}
