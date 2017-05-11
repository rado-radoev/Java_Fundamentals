import javax.naming.directory.InvalidAttributesException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ex 8.16

public class HugeInteger implements IHugeInteger {

	private final int elements = 40;
	private int[] hugeInteger = new int[elements];
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
		
		int counter = elements - 1;
		// Loop through each char of the string
		for (int i = hugeInteger.length() - 1; i >= 0; i--) {
			if (isDigit(hugeInteger.charAt(i))) {	// verify if current char is digit
				this.hugeInteger[counter] = hugeInteger.charAt(i) - 48;	// return current char as digit and assign to array
				numberOfDigits++;
				counter--;
			}
			else {
				throw new InvalidAttributesException("Expected digit 0 - 9");	// if current char is not digit, throw an exception
			}
		}
	}

	@Override
	public HugeInteger add(HugeInteger a) {
		int carry = 0;	// This will hold the carry number when adding digits larger than 10
		
		// Start from the last index
		for (int i = elements - 1; i >= 0;i--) {
			// Add the index of the current object to the index of the passed object + any carry gigits
			this.hugeInteger[i] += a.hugeInteger[i] + carry;	
			// if the sum of the two numbers is bigger than 10 do a module and add 1 to carry
			if (this.hugeInteger[i] >= 10) {
				this.hugeInteger[i] %= 10;
				carry++;
			}
			else {
				// if the sum of the two digits is less than 10 there is no carry
				carry = 0;
			}
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
		// Pattern to search for (any number of zeros starting the begging of the string)
		String pattern = "^0*";
		
		// Create pattern object
		Pattern r = Pattern.compile(pattern);
		
		for (int i = 0; i < this.hugeInteger.length; i++) {
			sb.append(hugeInteger[i]);
		}
		
		// Create matcher object
		Matcher m = r.matcher(sb.toString());
		
		// Assign SB object to string
		String s = sb.toString();
		
		// Remove all occurances of zero before the 1st significatnt digit
		s = m.replaceAll("");
		
		// print the modified string
		return s;
	}
	
	
}
