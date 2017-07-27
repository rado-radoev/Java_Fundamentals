package com.fig1811;

public class TowersOfHanoi {
	
	public static void main(String[] args) {
		int startPeg = 1;
		int endPeg = 3;
		int tempPeg = 2;
		int totalDisks = 3;
		
		solveTowers(totalDisks, startPeg, endPeg, tempPeg);
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
}
