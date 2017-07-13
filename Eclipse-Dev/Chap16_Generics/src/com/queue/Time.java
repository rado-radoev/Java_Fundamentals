package com.queue;

;

// This class is used to set time

public class Time implements Comparable<Time> {

	private Time time;
	private int hour;
	private int minute;
	private int second;
	
	public Time () {
		this(0,0,0);
	}
	
	public Time (int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public int getHour() {
		return hour;
	}
	
	public final void setHour(int hour) {
		// if provided hour is not in the correct range, set it to 0
		if (hour >= 0 && hour <= 23) {
			this.hour = hour;
		}
		else {
			this.hour = 0;
		}
	}
	
	public int getMinute() {
		return minute;
	}
	
	public final void setMinute(int minute) {
		// if provided minute is not in the correct range, set it to 0
		if (minute >= 0 && minute <= 59) {
			this.minute = minute;
		}
		else {
			this.minute = 0;
		}
	}
	
	
	public int getSecond() {
		return second;
	}
	
	public final void setSecond(int second) {
		// if provided minute is not in the correc range, set it to 0
		if (second >= 0 && second <= 59) {
			this.second = second;
		}
		else {
			this.second = 0;
		}
	}

	@Override
	public int compareTo(Time otherTiem) {
		return this.time.compareTo(otherTiem);
	}
	
	@Override
	public String toString() {
		// dispaly time separated by :
		return String.format("%02d%4$s%02d%4$s%02d", getHour(), getMinute(), getSecond(), ":");
		
	}
}
