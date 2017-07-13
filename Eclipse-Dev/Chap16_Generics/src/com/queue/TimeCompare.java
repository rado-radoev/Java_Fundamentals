package com.queue;

import java.util.Comparator;

public class TimeCompare implements Comparator<Time> {

	@Override
	public int compare(Time time1, Time time2) {
		// if result is negative, first time is bigger than second
		// if result is positive, second time is bigger than first
		// if result i 0, then both times are equal (highly unlikely)

		// if hours are equal we need to compare minutes
		int compareHours = time1.getHour() - time2.getHour();
			if (compareHours != 0)
				return compareHours;
			
		// if minutes are equal we need to compare minutes
		int compareMinutes = time1.getMinute() - time2.getMinute();
			if (compareMinutes != 0)
				return compareMinutes;
						
		// if minutes are equal we need to compare seconds
		// if the seconds are equal too. return the seconds(0), meaning that the hours are equal
		int compareSeconds = time1.getSecond() - time2.getSecond();
		return compareSeconds;
	}
}
