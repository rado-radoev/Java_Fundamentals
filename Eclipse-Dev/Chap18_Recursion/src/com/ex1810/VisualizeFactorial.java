package com.ex1810;

public class VisualizeFactorial {

	    private static String str = "";
	    public static long factorial(long number,long level) {
	    	
	    if (number <= 1) { //test for base case
	        System.out.printf("%s%d! = %d*%d!= ", str, level, level, (level - 1 == -1) ? level : level - 1);
	        str += " ";
	        return 1;
	    }
	    else{ //recursion step
	        return number * factorial(number - 1,level);
	    }
	}

	public static void main(String[] args) {
	    //calculate factorials 0-21
        for (int counter = 0; counter <= 19; counter++){
            long x = factorial(counter,counter);
        System.out.printf("%d%n",x);
	    }
	}

}