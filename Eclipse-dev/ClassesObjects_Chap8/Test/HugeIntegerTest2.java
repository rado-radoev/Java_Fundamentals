// This class deals only with integers >= 0

public class HugeIntegerTest2 {
    final static int SIZE = 10; // number of digits of huge integer
    private int digits[];       // digits of huge integer
    boolean error;              // if overflow or underflow occurred, then true
                                // else false
    // utility variables
    final static int one[] = {0,0,0,0,0,0,0,0,0,1};
    final static HugeIntegerTest2 One = new HugeIntegerTest2(one),
                             Zero = new HugeIntegerTest2();

    // Constructor that constructs a Huge 0, as it were.
    public HugeIntegerTest2() { digits = new int[SIZE]; }

    // Constructor that takes an array of SIZE digits
    public HugeIntegerTest2(int d[]) {
        digits = new int[SIZE];

        for (int i = 0; i < SIZE; i++)
            digits[i] = d[SIZE - i - 1];
        error = false;
    }

    // Constructor that takes a HugeInteger as its argument
    public HugeIntegerTest2(HugeIntegerTest2 I) {
        digits = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            digits[i] = I.digits[i];
        }
        error = false;
    }

    // Not implemented: public inputHugeInteger() {}

    // Return a String representation of a HugeInteger
    public String outputHugeInteger() {
        char d[] = new char[SIZE];

        if (error)
            return "Error";
        for (int i = 0; i < SIZE; i++)
            d[SIZE - i - 1] = (char) (digits[i] + '0');
        return new String(d);
    }

    // Add I to this
    public HugeIntegerTest2 addHugeIntegers(HugeIntegerTest2 I) {
        int carry = 0;

        if (error || I.error) {
            error = true;
            return this;
        }
        for (int i = 0 ; i < SIZE; i++) {
            digits[i] += I.digits[i] + carry;
            if (digits[i] < 10)
                carry = 0;
            else {
                digits[i] -= 10;
                carry = 1;
            }
            /* Here is a shorter version.
                But, it may result in more machine instructions

            int t = digits[i] + I.digits[i] + carry;
            carry = t > 9 ? 1: 0;
            digits[i] = t % 10;

            */
        }
        if (carry > 0)
            error = true;
        return this;
    }

    // Subtract I from this
    public HugeIntegerTest2 subtractHugeIntegers(HugeIntegerTest2 I) {
        int borrow = 0;

        if (error || I.error || this.isLessThan(I)) {
            error = true;
            return this;
        }
        for (int i = 0 ; i < SIZE; i++) {
            digits[i] -= I.digits[i] + borrow;
            if (digits[i] >= 0)
                borrow = 0;
            else {
                digits[i] += 10;
                borrow = 1;
            }
        }
        return this;
    }

    // Multiply this by I
    public HugeIntegerTest2 multiplyHugeIntegers(HugeIntegerTest2 I) {
        if (error || I.error) {
            error = true;
            return this;
        }
        HugeIntegerTest2 count = new HugeIntegerTest2(),
                    T     = new HugeIntegerTest2();
        for ( ; count.isLessThan(I); count.addHugeIntegers(One) ) {
            T.addHugeIntegers(this);
            if (T.error)
                return T;
        }
        return T;
    }

    // Divide this by I
    public HugeIntegerTest2 divideHugeIntegers(HugeIntegerTest2 I) {
        HugeIntegerTest2 quotient = new HugeIntegerTest2(), T = new HugeIntegerTest2(this);

        if (error || I.error || I.isZero()) {
            quotient.error = true;
            return quotient;
        }
        for (; I.isLessThanOrEqualTo(T); quotient.addHugeIntegers(One) ) {
            T.subtractHugeIntegers(I);
        }
        return quotient;
    }

    // Take remainder of this when divided by I
    public HugeIntegerTest2 modulusHugeIntegers(HugeIntegerTest2 I) {
        if (error || I.error || I.isZero()) {
            error = true;
            return this;
        }
        HugeIntegerTest2 T = new HugeIntegerTest2(this);
        for (; I.isLessThanOrEqualTo(T); T.subtractHugeIntegers(I) )
            ;
        return T;
    }

    // true when this == I
    public boolean isEqualTo(HugeIntegerTest2 I) {
        if (error || I.error)
            return false;
        for (int i = 0; i < SIZE; i++)
            if (digits[i] != I.digits[i])
                return false;
        return true;
    }

    // true when this != I
    public boolean isNotEqualTo(HugeIntegerTest2 I) {
        return !error && !I.error && !this.isEqualTo(I);
    }

    // true when this > I
    public boolean isGreaterThan(HugeIntegerTest2 I) {
        return !error && !I.error && !this.isEqualTo(I) && !this.isLessThan(I);
    }

    // true when this < I
    public boolean isLessThan(HugeIntegerTest2 I) {
        for (int i = SIZE - 1; i >= 0; i--) {
            if (digits[i] < I.digits[i])
                return true;
            if (digits[i] > I.digits[i])
                return false;
        }
        return false;
    }


    // true when this >= I
    public boolean isGreaterThanOrEqualTo(HugeIntegerTest2 I) {
        return !error && !I.error && !this.isLessThan(I);
    }

    // true when this <= I
    public boolean isLessThanOrEqualTo(HugeIntegerTest2 I) {
        return !error && !I.error && !this.isGreaterThan(I);
    }

    // true when this == 0
    public boolean isZero() {
        return !error && this.isEqualTo(Zero);
    }
}