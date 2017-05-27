
public class Sphere extends ThreeDimensionalShape {
	
	public Sphere(double dimension) {
		super(dimension);
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(getDimension(), 2);
	}

	@Override
	public double getVolume() {
		return 4/3.0 * Math.PI * Math.pow(getDimension(), 3);
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
