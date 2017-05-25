package com.polymorphism1015;

// Fig. 10.15: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.
public class PayableInterfaceTest 
{
   public static void main(String[] args)
   {
      // create four-element Payable array
      Payable[] payableObjects = new Payable[2];
      
      // populate array with objects that implement Payable
      payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
      payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      
      
      
      Employee[] employees = new Employee[4];
      
      employees[0] = 
         new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      employees[1] = 
         new CommissionEmployee("Lisa", "Barnes", "888-88-8888", 1200.00, .8);
      employees[2] =
		  new BasePlusCommissionEmployee("John", "Logan", "555-66-7777", 100, .2, 500);
      employees[3] =
		  new HourlyEmployee("Mr.", "Smith", "000-00-00000", 500, 8);

      System.out.println(
         "Invoices processed polymorphically:"); 

      // generically process each element in array payableObjects
      for (Payable currentPayable : payableObjects)
      {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s %n%s: $%,.2f%n", 
            currentPayable.toString(), // could invoke implicitly
            "payment due", currentPayable.getPaymentAmount()); 
      } 
      
      
      System.out.println(
    		  "Employees processed polymorphically");
      
      for (Employee currentEmployee : employees) {
    	  if (currentEmployee instanceof BasePlusCommissionEmployee) {
    		  BasePlusCommissionEmployee employee = 
				  (BasePlusCommissionEmployee) currentEmployee;
    		  
    		  employee.setBaseSalary(1.10 * employee.getBaseSalary());
    		  
    		  System.out.printf(
				  "New base salary with 10%% increase is: $%,.2f%n", 
				  employee.getBaseSalary());
    	  }
    	  
    	  
    	  System.out.printf(
			  "%s%n earned $%,.2f%n%n", 
			  currentEmployee,
			  currentEmployee.getPaymentAmount());
      }
      
      
      for (int i = 0; i < employees.length; i++) {
    	  System.out.printf(
			  "Employee %d is a %s%n",
			  i,
		  	 employees[i].getClass().getName());
      }
      
      
      
      
      
      
      
      
      
      
   } // end main
} // end class PayableInterfaceTest

