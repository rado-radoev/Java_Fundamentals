// Ex 8.4
public class Rectangle {
	
	private float lenght = 1f;
	private float width = 1f;
	
	public float getLenght(){
		return lenght;
	}
	
	public void setLength(int length) {
		if (verifyLengthWidthLessThan20GreaterThan0(length))
			this.lenght = lenght;
	}
	
	public float getWidth()	{
		return width;
	}
	
	public void setWidth(float width) {
		if (verifyLengthWidthLessThan20GreaterThan0(width))
			this.width = width;
	}
	
	public float calculatePerimeter() {
		return 2 * (getLenght() + getWidth());

	}
	
	public float calculateArea() {
		return getLenght() * getWidth();
	}
	
	private boolean verifyLengthWidthLessThan20GreaterThan0(float side) {
		if (side < 1f || side > 20f) {
			return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.setLength(5);
		rectangle.setWidth(5);
		System.out.printf("Area is: %.2f%n", rectangle.calculateArea());
		System.out.printf("Perimeter is: %.2f%n", rectangle.calculatePerimeter());

	}

}
