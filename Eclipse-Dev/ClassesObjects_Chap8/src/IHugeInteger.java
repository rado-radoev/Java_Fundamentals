import javax.naming.directory.InvalidAttributesException;

public interface IHugeInteger {
	public String toString();
	public void parse(String hugeInteger) throws IndexOutOfBoundsException, InvalidAttributesException;
	public HugeInteger add(HugeInteger a);
	public HugeInteger subtract(HugeInteger a);
	public boolean isEqualTo(HugeInteger a, HugeInteger b);
	public boolean isNotEqualTo(HugeInteger a, HugeInteger b);
	public boolean isGreaterThan(HugeInteger a, HugeInteger b);
	public boolean isLessThan(HugeInteger a, HugeInteger b);
	public boolean isGreaterThanOrEqualTo(HugeInteger a, HugeInteger b);
	public boolean isLessThanOrEqualTo(HugeInteger a, HugeInteger b);
	public boolean isZero(HugeInteger a, HugeInteger b);
	public HugeInteger multiply(HugeInteger a, HugeInteger b);
	public HugeInteger divide(HugeInteger a, HugeInteger b);
	public HugeInteger remainder(HugeInteger a, HugeInteger b);
}
