//Here goes commented code:


public class RationalNumbers {

    private int numerator; // You can declare private variables here all right
    private int denominator;


    // This constructor creates a new object of the class Rational. Objects are instances of that class, all right? 
    public RationalNumbers()
        {
            numerator = 0;
            denominator = 1;                
            //private int numerator = 0; 
            //private int denominator = 1; // I get it, you need them even when not giving arguments, but it is better to do stuff in constructors. You better try to make declarations in the constructor and not in the begining of a class, if possible.

        } 

    // Here is the constructor overriden, so you can create an instance that contains 4 arguments. (n,d,num,denom) Good.
    public RationalNumbers(int n, int d, int num, int denom)
    {
        // You repeat yourself in the constructor.
        // public void setDenominator(int n, int d, int num, int denom) does the same thing right?
        // I don't remember now, but I think that on instantiation you can't use methods, if you don't add the word static.
        // public static void setDenominator(int n, int d, int num, int denom) will make you able to call it in the constructor!
        if (d < 0)
        {
            num = -n;
            denom = d;
        }

        else if (d == 0)
        {
            num = n;
            denom = 1;
        }

        else 
        {
            num = n;
            denom = 0;
        }
    }

	public int getNumerator()
	{
	    return numerator;
	}
	
	
	public int getDenominator()
	{
	    return denominator;
	}
	
	public void setNumerator(int n)
	{
	    numerator = n;
	}
	
	public void setDenominator(int n, int d, int num, int denom) // FIX IT. ADD STATIC
	{
	    denominator = d;
	    if (d < 0)
	    {
	        num = -n;
	        denom = d;
	    }
	
	    else if (d == 0)
	    {
	        num = n;
	        denom = 1;
	    }
	
	    else
	    {
	        num = n;
	        denom = 0;
	    }
	}
	
	public String toString()
	{
	    return numerator + "/" + denominator; 
	}
	
	public boolean equals (RationalNumbers other)
	{
	    if(numerator * other.denominator == denominator * other.numerator)
	        return true;
	    else 
	        return false;
	}
	
	public boolean notequals(RationalNumbers other)
	{
	    if (numerator * other.denominator != denominator * other.numerator)
	        return true;
	    else 
	        return false;
	}
	
	//subtract method
	public RationalNumbers subtract(RationalNumbers other)
	{
	    RationalNumbers temp = null;
	    temp.numerator = numerator * other.denominator - denominator * other.numerator;
	    temp.denominator = denominator * other.denominator;
	    return temp;
	} // THIS RETURNS temp THAT IS AN OBJECT OF THE TYPE Rational!!! Remember that.
	
	
	//add method
	public RationalNumbers add(RationalNumbers other)
	{
	    RationalNumbers temp = null;
	    temp.numerator = numerator * other.denominator + denominator * other.numerator;
	    temp.denominator = denominator * other.denominator;
	    return temp;
	}// THIS RETURNS temp THAT IS AN OBJECT OF THE TYPE Rational!!! Remember that.
	
	public boolean lessThan(RationalNumbers other)
	{
	    return(numerator * other.denominator < denominator * other.numerator);
	}// What type is this method return? Here is the gap you must fill. If you learn how to handel what methods return, you will be fine. Try stuff out.
	
	public boolean greterThan(RationalNumbers other)
	{
	    return(numerator * other.denominator > denominator * other.numerator);
	}
	
	public boolean lessThanEqualTo(RationalNumbers other)
	{
	    return(numerator * other.denominator <= denominator * other.numerator);
	}
	
	public boolean greaterThanEqual(RationalNumbers other)
	{
	    return(numerator * other.denominator >= denominator * other.numerator);
	}


public static void main(String[] args) {
	RationalNumbers rn = new RationalNumbers();
	System.out.println(rn);
}

}
