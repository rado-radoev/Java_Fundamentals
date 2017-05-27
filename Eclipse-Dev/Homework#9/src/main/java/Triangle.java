
public class Triangle extends TwoDimensionalShape {

	public Triangle(double base, double heigth) {
		super(base, heigth);
	}

	@Override
	public double getArea() {
		return (getBase() * getHeigth()) / 2;
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
}
