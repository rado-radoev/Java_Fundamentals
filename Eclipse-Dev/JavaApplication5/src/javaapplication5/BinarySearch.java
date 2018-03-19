/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author superlamer
 */
public class BinarySearch {
    
    private int[] arr;
    
    public int binarySearch(int[] a, int key) { 
          int low = 0; 
          int high = a.length - 1; 
  
          while (low <= high) { 
              int mid = low + ((high - low) / 2); 
              //int mid = (low + high) / 2; 
              int midVal = a[mid]; 
  
              if (midVal < key) 
                 low = mid + 1; 
             else if (midVal > key) 
                 high = mid - 1; 
             else 
                 return mid; // key found 
         } 
         return -(low + 1);  // key not found. 
     } 

    public void setArr(int[] arr) {
        this.arr = arr;
    }  
    
    public int[] getArr() {
        return arr;
    }
    
}
