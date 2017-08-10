package com.ex197;

//Exercise 16.7 Solution: BucketSort.java
//Sort an array's values into ascending order using bucket sort.
import java.util.Random;

public class BucketSort 
{
private int[] data; // array of values
private static Random generator = new Random();

// create array of given size and fill with random integers
public BucketSort( int size )
{
   data = new int[ size ]; // create space for array

   // fill array with random ints in range 10-99
   for ( int i = 0; i < size; i++ )
      data[ i ] = 10 + generator.nextInt( 90 );
} // end BucketSort constructor

// perform bucket sort algorithm on array
public void sort()
{
   // store maximum number of digits in numbers to sort
   int totalDigits = numberOfDigits(); 

   // bucket array where numbers will be placed
   int pail[][] = new int [ 10 ][ data.length ];

   // go through all digit places and sort each number
   // according to digit place value
   for ( int pass = 1; pass <= totalDigits; pass++ ) 
   {
      distributeElements( pail, pass ); // distribution pass
      collectElements( pail ); // gathering pass

      if ( pass != totalDigits )
         emptyBucket( pail ); // set size of buckets to 0
   } // end for
} // end method sort

// determine number of digits in the largest number
public int numberOfDigits()
{
   int largest = data[ 0 ]; // set largest to first element

   // loop over elements to find largest
   for ( int element : data )
      if ( element > largest )
         largest = element; // set largest to current element

   // calculate number of digits in largest value
   int digits = ( int ) ( Math.floor( Math.log10( largest ) ) + 1 );

   return digits;
}  // end method numberOfDigits

// distribute elements into buckets based on specified digit
public void distributeElements( int pail[][], int digit )
{
   int bucketNumber; // number of bucket to place element
   int elementNumber; // location in bucket to place element

   // determine the divisor used to get specific digit
   int divisor = ( int ) ( Math.pow( 10, digit ) );

   for ( int element : data )
   {
      // bucketNumber example for hundreds digit:
      // ( 1234 % 1000 ) / 100 --> 2
      bucketNumber = ( element % divisor ) / ( divisor / 10 );

      // retrieve value in pail[ bucketNumber ][ 0 ] to
      // determine which element of the row to store c[ i ]
      elementNumber = ++pail[ bucketNumber ][ 0 ];
      pail[ bucketNumber ][ elementNumber ] = element;
   } // end for
}  // end method distributeElements

// return elements to original array
public void collectElements( int pails[][] )
{
   int subscript = 0; // initialize location in data

   for ( int i = 0; i < 10; i++ ) // loop over buckets

      // loop over elements in each bucket
      for ( int j = 1; j <= pails[ i ][ 0 ]; j++ )
         data[ subscript++ ] = pails[ i ][ j ]; // add element to array
} // end method collectElements

// set size of all buckets to zero
public void emptyBucket( int pails[][] )
{
   for ( int i = 0; i < 10; i++ )
      pails[ i ][ 0 ] = 0; // set size of bucket to 0
} // end method emptyBucket

// method to output values in array
public String toString()
{
   StringBuffer temporary = new StringBuffer();

   // iterate through array
   for ( int element : data )
      temporary.append( element + " " );
  
   temporary.append( "\n" );  // add endline character
   return temporary.toString();
} // end method toString
} // end class BucketSort


/**************************************************************************
* (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
