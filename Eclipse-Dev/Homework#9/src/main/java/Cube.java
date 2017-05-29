
public class Cube extends ThreeDimensionalShape {

	// Invoke super class single constructor -> ThreeDiemnsionalShape -> Shape
	public Cube(double dimension) {
		super(dimension);
	}

	// Get area
	@Override
	public double getArea() {
		return 6 * Math.pow(getDimension(), 2);
	}

	// Get voulume
	@Override
	public double getVolume() {
		return Math.pow(getDimension(), 3);
	}

	// Get object's name
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
