
public class Cube extends ThreeDimensionalShape {

	public Cube(double dimension) {
		super(dimension);
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(getDimension(), 2);
	}

	@Override
	public double getVolume() {
		return Math.pow(getDimension(), 3);
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
