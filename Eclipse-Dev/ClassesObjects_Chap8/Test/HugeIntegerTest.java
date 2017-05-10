import javax.naming.directory.InvalidAttributesException;

public class HugeIntegerTest {

	public static void main(String[] args) throws IndexOutOfBoundsException, InvalidAttributesException {
		HugeInteger hugeInteger = new HugeInteger();
		
		hugeInteger.parse("12345678910111213141516171819202122");
		System.out.println(hugeInteger);

	}

}
