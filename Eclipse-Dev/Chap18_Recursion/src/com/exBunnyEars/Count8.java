package com.exBunnyEars;

// http://codingbat.com/prob/p192383

/*
	Given a non-negative int n, 
	compute recursively (no loops) the count of the occurrences of 8 as a digit, 
	except that an 8 with another 8 immediately to its left counts double, 
	so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
	while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
 */
public class Count8 {

	public static void main(String[] args) {
		int eight = 881888;
		int count = 0;
		int prev = 0;
		while (eight > 0) {
			int temp = eight % 10;			
			if (temp == 8) {
				if (prev == 8)
					count+=2;
				else 
					count++;
			}
			eight /= 10;
			prev = temp;
		}

		System.out.println(count);
	}
	
	public static int count8(int n)
	{
		if(n == 0)
			return 0;
		if(n % 10 == 8)
		{
			if(n / 10 % 10 == 8)
				return 2+count8(n/10);
			return 1+count8(n/10);
		}
		return count8(n/10);
	}

}
