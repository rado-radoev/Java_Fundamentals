/*
 * IntegerSetTestManual.java
 */

/**
 *
 * @author Godfrey
 */

import java.util.Scanner;

public class IntegerSetTestManual {
    
    public static void main(String args[]) {
        
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
                
        Scanner scan = new Scanner(System.in);
        int input;
        
        do {            
            // Just for formatting purposes...
            System.out.println();            
            System.out.println("setA: " + setA);
            System.out.println("setB: " + setB);
            System.out.println("1) insertElement into setA");
            System.out.println("2) deleteElement from setA");
            System.out.println("3) insertElement into setB");
            System.out.println("4) deleteElement from setB");
            System.out.println("5) intersection of setA and setB");
            System.out.println("6) union of setA and setB");
            System.out.println("7) equality of setA and setB");
            System.out.println("Select from the menu above (or 0 to exit): ");
            input = scan.nextInt();
            
            switch(input) {
                case 1: 
                    System.out.print("Enter an element to insert into setA: ");
                    setA.insertElement(scan.nextInt());
                    break;
                case 2:
                    System.out.print("Enter an element to delete from setA: ");
                    setA.deleteElement(scan.nextInt());                  
                    break;
                case 3:    
                    System.out.print("Enter an element to insert into setB: ");
                    setB.insertElement(scan.nextInt());                 
                    break;
                case 4:
                    System.out.print("Enter an element to delete from setB: ");
                    setB.deleteElement(scan.nextInt());                  
                    break;
                case 5:    
                    System.out.println("The intersection of setA and setB is: " + IntegerSet.intersection(setA, setB));
                    break;
                case 6:
                    System.out.println("The union of setA and setB is: " + IntegerSet.union(setA, setB));
                    break;
                case 7:
                	System.out.println("setA and setB are " + (setA.isEqualTo(setB) ? "" : "un") + "equal");
                	break;
                default:
                	if (input != 0) {
                		System.out.println("\n*** Error, invalid input! ***\n");
                	}
            }          
        }while(input != 0);
    }
    
}
