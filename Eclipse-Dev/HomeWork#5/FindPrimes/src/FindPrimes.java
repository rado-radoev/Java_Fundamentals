/*
 * FindPrimes.java
 */

/**
 *
 * @author Radoslav Radoev
 */
public class FindPrimes {
       
    public static void main(String[] args) {
        System.out.println("Prime numbers < 10k:");
        for (int i = 0; i < 10000;i++) {
        	if (isPrime(i)) {
        		System.out.println(i); // print only prime numbers
        	}
        }
    }
    
    public static boolean isPrime(int num) {
    	if (num < 2) {
			return false; // 1, 0 and negative numbers are not prime
    	}
    	
    	int numSqrt = (int)Math.sqrt((double)num);	// find the square root of the number
    	for (int i = 2; i <= numSqrt; i++) {
    		if (num % i == 0) {
    			return false;	// num is not prime
    		}
    	}
    	
    	return true;	// the number is prime
    }    
}
