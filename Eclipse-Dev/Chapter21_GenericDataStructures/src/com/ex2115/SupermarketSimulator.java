package com.ex2115;

import java.security.SecureRandom;

public class SupermarketSimulator {
	
	private static SecureRandom rand = new SecureRandom();
	private static Line<Customer> line = new Line<Customer>();
	private static final int SIMULATIONTIME = 720;
	private static final int AVGWAIT = 4;
	
	public SupermarketSimulator() {
	}
		
	public static void simulateLine() {
			
		// set arrival time for the first customer
		int minute = 0;

		int nextCustArrivalTime = minute + (rand.nextInt(AVGWAIT) + 1); // get the time the next (first) customer arrives
		int timeUntilServiceCompleted = 0;	// control variable to monitor how many minutes have passed serving a client
		
		for (; minute < SIMULATIONTIME; minute++) {	// loop 720 minutes (12 hours)

			if (minute == nextCustArrivalTime)	{	// wait until current it is time for the next customer arrival
				System.out.printf("%s%n", "New customer arrives");	// announce the new customer arrival
				
				Customer newCustomer = new Customer(nextCustArrivalTime, rand.nextInt(AVGWAIT) + 1);	// create new customer obj with arrival time and random service time	
				line.enqueue(newCustomer);	// add customer to the queue
				nextCustArrivalTime = minute + (rand.nextInt(AVGWAIT) + 1); // calculate arrival time for next customer
			}
			
			if (!line.isEmpty() && line.peek().getMinutes_served() == timeUntilServiceCompleted) { // if there are customers in the queue and the customer service time is == to the service time 
				System.out.printf("%s%n", "Service completed");	// announce the service is completed
				Customer currentCust = line.peek();		// get the current customer in var for easy access
				currentCust.setMinute_discarded(minute); // get the time when the customer exited the queue
				currentCust.setMinutes_inQueue(minute - currentCust.getArrivalTime());	// get the time spend in the queue -> entered the queue + waiting + service
				currentCust.setMinutes_waiting(minute - currentCust.getArrivalTime() - currentCust.getMinutes_served()); // get the time customer spend waiting before the service started
				
				if (line.getHighestWaitTime() < currentCust.getMinutes_waiting()) // get the highest number of minutes a customer has spend in the queue
					line.setHighestWaitTime(currentCust.getMinutes_waiting());
				
				currentCust.displayCustomer(); // display the customer properties before discarding from the queue
				line.dequeue();	// remove customer from queue
				timeUntilServiceCompleted = 0;	// reset service time when customer is removed from the queue
			}

			if (!line.isEmpty())	// increment service time only if there are customers in the queue
				timeUntilServiceCompleted++;
			
			if (line.getMaxCustomersInLine() < line.getSize())	// capture the maximum queue size
				line.setMaxCustomersInLine(line.getSize());
			
			System.out.printf("Queue size: %d%n", line.getSize()); // display max numbers in the queue at any time
		}
			
		System.out.printf("Maximum number of customers in queue: %d%n", line.getMaxCustomersInLine());
		System.out.printf("Maximum time customer spend in the queue: %d%n", line.getHighestWaitTime());
		System.out.printf("People still in queue: %d%n", line.getSize());
	}
}
