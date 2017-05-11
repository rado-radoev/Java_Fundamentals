import javax.naming.directory.InvalidAttributesException;

// ex 8.16

public class HugeInteger implements IHugeInteger {

	private int[] hugeInteger = new int[40];
	private int numberOfDigits;
	
	public HugeInteger() {}
	
	public HugeInteger(int[] hugeInteger) {
		this.hugeInteger = hugeInteger;
	}

	// Check if string length is more than 40
	private boolean checkHugeIntegerStringLenght(String hugeInteger) {
		if (hugeInteger.length() > 40) {
			return false;	// Huge Integer max length is 40
		}
		return true;
	}
	
	// Check is current char is digit
	private boolean isDigit(char character) {
		if (character >= 48 && character <= 57 ) {
			return true; // Character is int
		}
		return false; 	// character is not int
	}
	
	private int[] smallestArray(HugeInteger a) {
		return this.hugeInteger.length <= a.hugeInteger.length ? this.hugeInteger : a.hugeInteger;
	}
	
	// Parse String to hugeInteger array 
	@Override
	public void parse(String hugeInteger) throws IndexOutOfBoundsException, InvalidAttributesException {
		// Check if parsed string has length of <= 40
		if (!checkHugeIntegerStringLenght(hugeInteger)) {	
			throw new IndexOutOfBoundsException(String.format("Huge Integer can contain up to 40 digits. Your contains %d", hugeInteger.length()));	// if String is longer than 40 chars throw an exception
		}
		
		// Loop through each char of the string
		for (int i = hugeInteger.length(); i >= 0; i--) {
			if (isDigit(hugeInteger.charAt(i))) {	// verify if current char is digit
				this.hugeInteger[i] = hugeInteger.charAt(i) - 48;	// return current char as digit and assign to array
				numberOfDigits++;
			}
			else {
				throw new InvalidAttributesException("Expected digit 0 - 9");	// if current char is not digit, throw an exception
			}
		}
	}

	@Override
	public HugeInteger add(HugeInteger a) {
		int carry = 0;	// This will hold the carry number when adding digits larger than 10
		int largestArray = this.numberOfDigits >= a.numberOfDigits ? this.numberOfDigits: a.numberOfDigits;	// longest array
		int smallestArray = this.numberOfDigits <= a.numberOfDigits? this.numberOfDigits: a.numberOfDigits;	// smallest array
		int difference = largestArray - smallestArray;	// difference between the two arrays
		
		HugeInteger temp = new HugeInteger();
		for (int i = smallestArray - 1; i >= 0;i--) {
			
		}
		
		return this;
	}

	@Override
	public HugeInteger subtract(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqualTo(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNotEqualTo(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThan(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThan(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThanOrEqualTo(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isZero(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HugeInteger multiply(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HugeInteger divide(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HugeInteger remainder(HugeInteger a, HugeInteger b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfDigits; i++) {
			sb.append(hugeInteger[i]);
		}
		return sb.toString();
	}
	
	
}
