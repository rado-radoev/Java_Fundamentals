
public abstract class Shape {
	
	private double dimension;
	private double base;
	private double height;
	
	public Shape(double dimension) {
		setDimension(dimension);
	}
	
	
	public Shape(double base, double heigth) {
		this(base, heigth ,0);
	}
	
	public Shape(double base, double height, double dimension) {
		setBase(base);
		setHeigth(height);
		setDimension(dimension);
	}

	
	public double getDimension() {
		return dimension;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeigth() {
		return height;
	}
	
	public final void setDimension(double dimension) throws IllegalArgumentException {
		if (dimension < 0) {
			throw new IllegalArgumentException();
		}
		this.dimension = dimension;
	}
	
	public final void setBase(double base) throws IllegalArgumentException {
		if (base  < 0) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
	
	public final void setHeigth(double heigth) throws IllegalArgumentException {
		if (heigth < 0) {
			throw new IllegalArgumentException();
		}
		this.height = heigth;
	}
	
	//  Abstract method that will be overriden and return the name of the object
	public abstract String getName();
}
