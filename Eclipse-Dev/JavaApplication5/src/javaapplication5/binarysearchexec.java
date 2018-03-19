/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.Arrays;

/**
 *
 * @author superlamer
 */
public class binarysearchexec {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        int[] arr = new int[Integer.MAX_VALUE /2 + 2];
        arr[1] = 1;
        Arrays.sort(arr);
        
        bs.setArr(arr);
        
        System.out.println(bs.binarySearch(arr, 1));
    }
    
    
}
