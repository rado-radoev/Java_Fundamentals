import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import junit.framework.TestCase;


public class FindPrimes_test extends TestCase {
	
	public static String newline = System.getProperty("line.separator");
	
	public void testExhaustiveOutputVerification() {		
		// Capture the output
		final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(capturedOut));
		
		String[] arr = {};
		FindPrimes.main(arr);
		System.err.println(capturedOut);
		
		Scanner sc = new Scanner(capturedOut.toString());
		try {
			/* FIRST LINE
			 */
			assertEquals("The program's output is non-conformant: no output was recorded", true, sc.hasNext());
			
			nextLineContaining(sc, "Prime");    // Read to and discard the table heading
			
	        /**
	         * Loop 10000, checking every number along the way for primeness...
	         * If a given number is prime, ensure that it appears in the output of the code under test
	         */
	        for(int ii=0; ii < 10000; ii++) {
	            if(isPrime(ii)) {
	            	assertEquals("The prime numbers table data is incorrect and/or incorrectly formatted.", ii, sc.nextInt());
	                System.out.println(ii);
	            }
	        }
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	public void testIsNegativePrime() {
		try {
			assertEquals("Negative numbers are, by definition, not prime.", false, FindPrimes.isPrime(-7));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	// This should be overkill (the program's output is exhaustively verified in another test), but will confirm that the isPrime method was declared as specified and will help identify candidates for partial credit
	public void testIsZeroPrime() {
		try {
			assertEquals("0 is, by definition, not prime.", false, FindPrimes.isPrime(0));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	// This should be overkill (the program's output is exhaustively verified in another test), but will confirm that the isPrime method was declared as specified and will help identify candidates for partial credit
	public void testIsOnePrime() {
		try {
			assertEquals("1 is, by definition, not prime.", false, FindPrimes.isPrime(1));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	// This should be overkill (the program's output is exhaustively verified in another test), but will confirm that the isPrime method was declared as specified and will help identify candidates for partial credit
	public void testIsTwoPrime() {
		try {
			assertEquals("Two is prime.", true, FindPrimes.isPrime(2));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
	// This should be overkill (the program's output is exhaustively verified in another test), but will confirm that the isPrime method was declared as specified and will help identify candidates for partial credit
	public void testIsFourPrime() {
		try {
			assertEquals("Four is not prime.", false, FindPrimes.isPrime(4));
		} catch (Exception e) {
			assertThrowableTestFailure(e);
		}
	}
	
    public static boolean isPrime(int num) {
        // There are many ways to determine if a number is prime or not...
        // we'll take the "easy way out"
        if(num < 2) 
            return false;
        
        /**
         * I've commented out the less efficient approach...
         * for(int i=2; i <= num/2; i++) {
         * 
         * This exercise shows that you can solve the same problem with 
         * different algorithms... the key takeaway is that, just because one 
         * approach works doesn't mean it is the best.
         *
         * In this case, all of the numbers > the square root must be 
         * multiplied by a number < the square root to equal the target 
         * number... so why not just check the numbers <= the square root?
         */        
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num % i == 0)    // If num is evenly divisible by i 
                return false;   // then it isn't prime
        }
        
        // If it isn't not-prime then I suppose it is prime...
        return true;
    }
	
	/**
	 * @param sc the Scanner to read from
	 * @param str the string to identify within the candidate lines (Scanner's buffer). It is converted to lower case in support of a case-insensitive search.
	 * @return the next line from the scanner containing the specified parameter or null if none are present
	 */
	private String nextLineContaining(Scanner sc, String str) {
		str = str.toLowerCase();
		String currentLine;
		do {
			currentLine = sc.nextLine().toLowerCase();
		} while(!currentLine.contains(str) && sc.hasNextLine());
		if (!currentLine.contains(str)) {
			currentLine = null;
		}
		return currentLine;
	}
	
	/* method name retrieval code courtesy of: http://dev.kanngard.net/Permalinks/ID_20030114224837.html
	 */
	private void assertThrowableTestFailure(Throwable thrown) {
		StackTraceElement stackTraceElements[] =
            (new Throwable()).getStackTrace();
		fail(thrown.getClass().getName() + " encountered! Unable to successfully execute test: " + stackTraceElements[1].toString());
	}
}

