
public class Sphere extends ThreeDimensionalShape {
	
	private static final double PI = Math.PI;

	public Sphere(double Diameter) {
		super(Diameter);
	}

	@Override
	public double getArea() {
		return 4 * PI * Math.pow(getDiameter(), 2);
	}

	@Override
	public double getVolume() {
		return 4/3.0 * PI * Math.pow(getDiameter(), 3);
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}

}
