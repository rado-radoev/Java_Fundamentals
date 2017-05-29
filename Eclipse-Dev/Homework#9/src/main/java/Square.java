
public class Square extends TwoDimensionalShape {

	// Invoke super class single constructor -> TwoDiemnsionalShape -> Shape
	public Square(double side) {
		super(side); 
	}
	
	// Calculate the area
	@Override
	public double getArea() {
		return Math.pow(super.getDimension(), 2);
	}

	// Return object's name
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	// Display side
	@Override
	public String toString() {
		return String.format("%s: %.2f","side" ,getDimension());
	}
}
