
public class Triangle extends TwoDimensionalShape {

	// Invoke super class single constructor -> TwoDiemnsionalShape -> Shape
	public Triangle(double base, double heigth) {
		super(base, heigth);
	}

	// Calculate the area
	@Override
	public double getArea() {
		return (super.getBase() * super.getHeigth()) / 2;
	}

	// Return object's name
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	// Display base and height
	@Override
	public String toString() {
		return String.format("%s: %.2f, %s: %.2f",
				"base",
				getBase(),
				"heigth",
				getHeigth());
	}
}
