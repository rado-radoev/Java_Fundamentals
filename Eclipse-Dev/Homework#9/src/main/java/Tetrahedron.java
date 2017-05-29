public class Tetrahedron extends ThreeDimensionalShape {

	// Invoke super class triple constructor -> ThreeDiemnsionalShape -> Shape
	public Tetrahedron(double base, double height, double dimension) {
		super(base, height, dimension);
	}

	// Get area
	@Override
	public double getArea() {
		return 4 * ((getBase() * getHeigth())/2);
	}

	// Get volume
	@Override
	public double getVolume() {
		return 1/3.0 * ((getBase() * getHeigth())/2) * getDimension();
	}

	// Get object's name
	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	// Display base width, base height, and height
	@Override
	public String toString() {
		return String.format("%s: %.2f, %s: %.2f, %s: %.2f",
				"base width",
				getBase(),
				"base height",
				getHeigth(),
				"height",
				getDimension());
	}
}
