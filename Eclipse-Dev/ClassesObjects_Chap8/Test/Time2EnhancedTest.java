// Fig. 8.6: Time2Test.java
// Overloaded constructors used to initialize Time2 objects.

public class Time2EnhancedTest 
{
   public static void main(String[] args)
   {
      Time2Enhanced t1 = new Time2Enhanced(); // 00:00:00
      t1.tick();
      Time2Enhanced t2 = new Time2Enhanced(2, 58); // 02:00:00
      t2.incremenetMinute();
      Time2Enhanced t3 = new Time2Enhanced(12, 34); // 21:34:00
      t3.incrementHour();
      Time2Enhanced t4 = new Time2Enhanced(12, 58, 59); // 12:25:42
      t4.tick();
      Time2Enhanced t5 = new Time2Enhanced(t4); // 12:25:42

      System.out.println("Constructed with:");
      displayTime("t1: all default arguments", t1);
      displayTime("t2: hour specified; default minute and second", t2);
      displayTime("t3: hour and minute specified; default second", t3);
      displayTime("t4: hour, minute and second specified", t4);
      displayTime("t5: Time2 object t4 specified", t5);

      // attempt to initialize t6 with invalid values
      try
      {
         Time2Enhanced t6 = new Time2Enhanced(27, 74, 99); // invalid values
      } 
      catch (IllegalArgumentException e)
      {
         System.out.printf("%nException while initializing t6: %s%n",
            e.getMessage());
      } 
   } 

   // displays a Time2 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time2Enhanced t)
   {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
   } 
} // end class Time2Test

