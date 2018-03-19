/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author superlamer
 */
public class BinarySearchTest{
 public final int ERROR = 0;
 
 
 @Test
 public void testBinarySearchBugOK(){
    BinarySearch bs = new BinarySearch();
          
    int[] vec = new int[Integer.MAX_VALUE / 2 + 2];
    vec[vec.length - 1] = 1;
    
  assertEquals(1073741824, bs.binarySearch(vec, 1), ERROR);
 }
}
