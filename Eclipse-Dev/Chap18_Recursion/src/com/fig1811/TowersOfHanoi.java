package com.fig1811;

import javax.xml.ws.Endpoint;

public class TowersOfHanoi {
	
	public static void main(String[] args) {
		int startPeg = 1;
		int endPeg = 3;
		int tempPeg = 2;
		int totalDisks = 3;
		
		//solveTowers(totalDisks, "A", "B", "C");
		solveHanoi(3, startPeg, endPeg, tempPeg);
	}
	
	public static void solveTowers(int disks, String startPole, String temporaryPole, String endPole) {
		// If there is only one pole, print where it was and were it went
		if (disks == 1) {
			System.out.println(startPole + " --> " + endPole);
		}
		else {
			// if more than one disks exist, move the disk from the start position, to end position
			solveTowers(disks - 1, startPole, endPole, temporaryPole);
			
			// print where disk was and were it went
			System.out.println(startPole + " --> " + endPole);
			
			// // if more than one disks exist, move the disk from the start position, to end position
			solveTowers(disks - 1, temporaryPole, startPole, endPole);
		}
	}

	public static void solveTowers(int disks, int sourcePeg, int destinatioPeg, int tempPeg) {
		// base case -- only one disk to move
		if (disks == 1) {
			System.out.printf("%n%d --> %d", sourcePeg, destinatioPeg);
			return;
		}
		
		// reucrsive call -- move (disks - 1) disks from sourcePeg to tempPeg, using destinationPeg
		solveTowers(disks - 1, sourcePeg, tempPeg, destinatioPeg);
		
		// move last disk from sourcePeg to destinationPeg
		System.out.printf("%n%d --> %d", sourcePeg, destinatioPeg);
		
		// move (disks - 1) disks from tempPeg to destinationPeg
		solveTowers(disks - 1, tempPeg, destinatioPeg, sourcePeg);
	}
	
	
	

	public static void solveHanoi(int disks, int sourcePole, int destinationPole, int tempPole) {
		if (disks == 1) {
			System.out.printf("%n%d --> %d", sourcePole, destinationPole);
			return; 
		}

		solveHanoi(disks - 1, sourcePole, tempPole, destinationPole);
		
		System.out.printf("%n%d --> %d", sourcePole, destinationPole);
		solveHanoi(disks - 1, tempPole, destinationPole, sourcePole);
	}



}
