
public class Sphere extends ThreeDimensionalShape {
	
	// Invoke super class single constructor -> ThreeDiemnsionalShape -> Shape
	public Sphere(double dimension) {
		super(dimension);
	}

	// Get area
	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(getDimension(), 2);
	}

	// Get volume
	@Override
	public double getVolume() {
		return 4/3.0 * Math.PI * Math.pow(getDimension(), 3);
	}

	// Get object's name
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
