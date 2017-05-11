import javax.naming.directory.InvalidAttributesException;

public class HugeIntegerTest {

	public static void main(String[] args) throws IndexOutOfBoundsException, InvalidAttributesException {
		HugeInteger hugeInteger = new HugeInteger();
		HugeInteger hugeInteger2 = new HugeInteger();
		
		hugeInteger.parse("123");
		hugeInteger2.parse("4567");
		
		System.out.println(hugeInteger.add(hugeInteger2));

	}

}
