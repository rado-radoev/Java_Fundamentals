
public abstract class Shape {
	
	private double diameter;
	private double base;
	private double heigth;
	
	public Shape(double Diameter) {
		setDiameter(Diameter);
	}
	
	
	public Shape(double base, double heigth) {
		setBase(base);
		setHeigth(heigth);;
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeigth() {
		return heigth;
	}
	
	public final void setDiameter(double diameter) throws IllegalArgumentException {
		if (diameter <= .0) {
			throw new IllegalArgumentException();
		}
		this.diameter = diameter;
	}
	
	public final void setBase(double base) throws IllegalArgumentException {
		if (base <= .0) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
	
	public final void setHeigth(double heigth) throws IllegalArgumentException {
		if (heigth <= .0) {
			throw new IllegalArgumentException();
		}
		this.heigth = heigth;
	}
	
	// method that will be overriden and return the name of the object
	public abstract String getName();
}
