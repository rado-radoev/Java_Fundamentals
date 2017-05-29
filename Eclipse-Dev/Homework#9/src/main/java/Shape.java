
public abstract class Shape {
	
	private double dimension;	// Used when only one side, radius, diameter etc is know. Used in Circle, Square, Cube, Sphere, Tetrahedron
	private double base;		// Used to set triangle or tetrahedron base
	private double height;		// Used to set trianble or tetrahedron height
	
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
	
	// Setter to set one know dimension of a figure. Negative dimensions are not allowed
	public final void setDimension(double dimension) throws IllegalArgumentException {
		if (dimension < 0) {
			throw new IllegalArgumentException();
		}
		this.dimension = dimension;
	}
	
	// Setter to set the base. Negative base is not allowed
	public final void setBase(double base) throws IllegalArgumentException {
		if (base  < 0) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
	
	// Setter to set the height. Negative height is not supported
	public final void setHeigth(double heigth) throws IllegalArgumentException {
		if (heigth < 0) {
			throw new IllegalArgumentException();
		}
		this.height = heigth;
	}
	
	//  Abstract method that will be overriden and return the name of the object
	public abstract String getName();
}
