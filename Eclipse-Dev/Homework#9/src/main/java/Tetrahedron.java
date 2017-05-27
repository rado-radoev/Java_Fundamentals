public class Tetrahedron extends ThreeDimensionalShape {

	public Tetrahedron(double base, double height, double dimension) {
		super(base, height, dimension);
	}

	
	@Override
	public double getArea() {
		return 4 * ((getBase() * getHeigth())/2);
	}

	@Override
	public double getVolume() {
		return 1/3.0 * ((getBase() * getHeigth())/2) * getDimension();
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
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
