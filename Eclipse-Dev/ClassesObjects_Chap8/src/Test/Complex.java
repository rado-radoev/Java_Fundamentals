package Test;

//Exercise 8.11
import static java.lang.Math.sqrt;

public class Complex {
 
 // instance variables
 private float realPart;
 private float imaginaryPart;
 
 // no argument constructor with default values
 public Complex() {
     this(0,0);
 }
 
 // constructor 
 public Complex(float realPart, float imaginaryPart) {
     this.realPart = realPart;
     this.imaginaryPart = (float) sqrt(imaginaryPart * -1);
 }
 
 // print complex number
 public void printComplex() {
     System.out.printf("(%f, %f)\n", realPart, imaginaryPart);
 }
 
 public static void main(String[] args) {
     
     Complex number1 = new Complex(2, 9);
     Complex number2 = new Complex(44, 101);
     
     number1.printComplex();
     number2.printComplex();
     
 }
}