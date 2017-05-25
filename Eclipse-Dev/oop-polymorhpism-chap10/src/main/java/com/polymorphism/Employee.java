package com.polymorphism;
// Fig. 10.4: Employee.java
// Employee abstract superclass.

import java.util.Calendar;

public abstract class Employee
{
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthdate;

   // constructor
   public Employee(String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
      String socialSecurityNumber)
   {  
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber; 
      this.birthdate =  new Date(birthMonth, birthDay, birthYear);
   } 
   
   public Date getBirthDay() {
	   return birthdate;
   }

   // return first name
   public String getFirstName()
   {
      return firstName;
   } 

   // return last name
   public String getLastName()
   {
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } 

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nsocial security number: %s%n%s: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), "BirtDate", getBirthDay());
   } 
   
   public int bDayBonus() {
	  int bDayBonus = 0;
	  if (this.getBirthDay().getMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1) {
		 return bDayBonus = 100;
	  }
	  else {
		  return bDayBonus;
	  }
   }

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee

