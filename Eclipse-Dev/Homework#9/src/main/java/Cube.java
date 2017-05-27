
public class Cube extends ThreeDimensionalShape {

	public Cube(double Diameter) {
		super(Diameter);
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(getDiameter(), 2);
	}

	@Override
	public double getVolume() {
		return Math.pow(getDiameter(), 3);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
