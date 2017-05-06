// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  

public class Time2Enhanced
{
   private int hour; // 0 - 23
   private int minute; // 0 - 59
   private int second; // 0 - 59

   // Time2 no-argument constructor: 
   // initializes each instance variable to zero
   public Time2Enhanced()
   {
      this(0, 0, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2Enhanced(int hour) 
   { 
      this(hour, 0, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2Enhanced(int hour, int minute) 
   { 
      this(hour, minute, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour, minute and second supplied
   public Time2Enhanced(int hour, int minute, int second) 
   { 
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   } 

   // Time2 constructor: another Time2 object supplied
   public Time2Enhanced(Time2Enhanced time)
   {
      // invoke constructor with three arguments
      this(time.getHour(), time.getMinute(), time.getSecond());
   } 

   // Set Methods
   // set a new time value using universal time; 
   // validate the data
   public void setTime(int hour, int minute, int second)
   {
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   } 

   // validate and set hour 
   public void setHour(int hour) 
   { 
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      this.hour = hour;
   } 

   // validate and set minute 
   public void setMinute(int minute) 
   { 
      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      this.minute = minute; 
   } 

   // validate and set second 
   public void setSecond(int second) 
   { 
      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

       this.second = second; 
   } 

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      return hour; 
   } 

   // get minute value
   public int getMinute() 
   { 
      return minute; 
   } 

   // get second value
   public int getSecond() 
   { 
      return second; 
   } 

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format("%d:%02d:%02d %s", 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   } 
   
   // add one second
   public void tick() {
	   if (getSecond() + 1 >= 60) {
		   setSecond(0);	// if second + 1 will be 60 next second is 0
		   if (getMinute() + 1 >= 60) {
			   setMinute(0);	// if minute + 1 will be 60 next minute is 0
			   if (getHour() + 1 >= 24) {
				   setHour(0);	// if next hour is midnight set to 0
			   }
			   else setHour(getHour() + 1); // if not midnight increment hour
		   }
		   else setMinute(getMinute() + 1);  // if next minute is not 60, inrement it
	   }
	   else setSecond(getSecond() + 1);	// if next second is not 60, icrement it
   }
   // add one minute
   public void incremenetMinute() {
	   if (getMinute() + 1 >= 60) {
		   setMinute(0);	// if minute + 1 will be 60, next minute is 0
		   if (getHour() + 1 >= 24) {
			   setHour(0); // if hour + 1 will be 24, next hour is 0
		   }
		   else {
			   setHour(getHour() + 1);	// if hour + 1 is not 24, increment hour
		   }
	   }
	   else {
		   setMinute(getMinute() + 1);	// if minute + 1 is not 60, increment minute
	   }
   }
   
   // add one hour
   public void incrementHour() {
	   setHour((getHour() + 1 >= 24) ? 0 : getHour() + 1);
   }
} // end class Time2
