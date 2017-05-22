// ex. 8.11
public class ComplexNumbers {
	
	private float realPart;
	private float imaginaryPart;
	// i = Math.sqrt(-1);
	
	public ComplexNumbers () {
		this(0,0);
	}
	
	public ComplexNumbers (float realPart, float imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public static ComplexNumbers add(ComplexNumbers one, ComplexNumbers two) {
		float real = one.getRealPart() + two.getRealPart();
		float imaginary = one.getImaginaryPart() + two.getImaginaryPart();
		
		return new ComplexNumbers(real, imaginary);
	}
	
	public static ComplexNumbers subtract(ComplexNumbers one, ComplexNumbers two) {
		float real = one.getRealPart() - two.getRealPart();
		float imaginary = one.getImaginaryPart() - two.getImaginaryPart();

		return new ComplexNumbers(real, imaginary);
	}

	public float getRealPart() {
		return realPart;
	}

	public void setRealPart(float realPart) {
		this.realPart = realPart;
	}

	public float getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(float imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	public String toString() {
		return String.format("(%.0f + %.2fi)", getRealPart(), getImaginaryPart());
	}

}
