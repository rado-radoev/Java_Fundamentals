import javax.naming.directory.InvalidAttributesException;

public class HugeIntegerTest {

	public static void main(String[] args) throws IndexOutOfBoundsException, InvalidAttributesException {
		HugeInteger hugeInteger = new HugeInteger();
		
		hugeInteger.parse("123");
		
		System.out.println(hugeInteger.add(hugeInteger));

	}

}
