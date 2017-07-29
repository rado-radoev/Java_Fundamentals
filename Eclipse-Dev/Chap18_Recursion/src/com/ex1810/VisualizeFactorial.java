package com.ex1810;

public class VisualizeFactorial {


	    private static String s1="";
	    public static long factorial(long number,long save) {


	    if (number <= 1) { //test for base case
	        System.out.printf("%s%d! = %d*%d!=  ",s1,save,save,save-1);
	        s1 = s1 +" ";
	        return 1;
	    }
	    else{ //recursion step
	        return number * factorial(number - 1,save);
	    }
	}

	//output factorial for values 0-21
	public static void main(String[] args) {
	    //calculate factorials 0-21
	            for (int counter = 0; counter <= 3; counter++){
	                long x = factorial(counter,counter);
	        System.out.printf("%d%n",x);
	    }
	}

}