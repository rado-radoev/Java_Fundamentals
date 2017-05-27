
public class Triangle extends TwoDimensionalShape {

	public Triangle(double base, double heigth) {
		super(base, heigth);
	}

	@Override
	public double getArea() {
		return (super.getBase() * super.getHeigth()) / 2;
	}

	@Override
	public String getName() {
		return String.format("%s", getClass().getName());
	}
	
	@Override
	public String toString() {
		return String.format("%s: %.2f, %s: %.2f",
				"base",
				getBase(),
				"heigth",
				getHeigth());
	}
}
