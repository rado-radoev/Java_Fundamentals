package com.ex2115;

public class Customer {
	
	private int arrivalTime;
	private int minutes_served;
	private int minutes_waiting;
	private int minute_discarded;
	
	public Customer () {
		this(0, 0, 0, 0);
	}
	
	public Customer (int arrivalTime, int minutes_served) {
		this(arrivalTime,minutes_served,0,0);
	}
	
	public Customer(int arrivalTime, int minutes_served, int minutes_waiting, int minute_discarded) {
		super();
		setArrivalTime(arrivalTime);
		setMinutes_served(minutes_served);
		setMinutes_waiting(minutes_waiting);
		setMinute_discarded(minute_discarded);
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public final void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getMinutes_served() {
		return minutes_served;
	}

	public final void setMinutes_served(int minutes_served) {
		this.minutes_served = minutes_served;
	}

	public int getMinutes_waiting() {
		return minutes_waiting;
	}

	public final void setMinutes_waiting(int minutes_waiting) {
		this.minutes_waiting = minutes_waiting;
	}

	public int getMinute_discarded() {
		return minute_discarded;
	}

	public final void setMinute_discarded(int minute_discarded) {
		this.minute_discarded = minute_discarded;
	}
	
	public void displayCustomer() {
		System.out.printf("Arrival time: %d %nMinutes served: %d%nMinutes waiting: %d%nMinute exited the queue: %d", getArrivalTime(),
				getMinutes_served(),
				getMinutes_waiting(),
				getMinute_discarded());
	}

}
