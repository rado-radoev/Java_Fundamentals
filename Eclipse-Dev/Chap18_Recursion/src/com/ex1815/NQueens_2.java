package com.ex1815;

import java.util.Set;
import java.util.HashSet;
import static java.lang.Math.min;

public class NQueens_2 {
	
	private static int N = 8; // default board size
	private static int[][] board = new int[N][N];
	private static Set<Integer> existingRows = new HashSet<Integer>();
	
	public static void main(String[] args) {
		System.out.printf("%4d %2d %2d %2d %2d %2d %2d %2d%n", 0,1,2,3,4,5,6,7);
//		board[2][3] = 1;
//		printBoard(board, 0);
		
		NQueenBackTrack(0,N);		
//		System.out.println("2, 3 " +  isQueenSafe(2,3));
//		System.out.println("3, 4 " + isQueenSafe(3,4));
//		System.out.println("0, 4 " + isQueenSafe(0,4));
	}
	
	// print the board using recursion
	private static String printBoard(int[][] board, int row) {
		if (row == N) 
			return "";
		
		System.out.printf("%d ", row);	// this print the number of the row
		for (int j = 0; j < N; j++) { // loop though cols 
			if (board[row][j] == 0) 
				System.out.print(" * ");  // if box is 0, no queen is placed on that position, print *
			else 
				System.out.print(" Q "); // if box is 1, a queen has been placed on that position, print Q
		}
		
		System.out.println();	// move to the next line
		return printBoard(board, row + 1); // invoke the function again to print the next line
	}
	
	
	
	// function to check if the cell is safe for a queen
	private static boolean isQueenSafe(int row, int col) {
		
		// if row has already been used no need to go further
		if (existingRows.contains(row))
			return false;
		
		// if another queen is on the same row or col return false
		// loop throuh all the rows and cols
		for (int i = 0; i < N; i++) {
			if (board[row][i] == 1 || board[i][col] == 1) {
				return false;
			}
		}
		
		// get diagonal. To calculate -> min(row, col) - 1
		int diag = min(row, col) - 1;

		// checking from top left to bottom right
		for (int i = row - diag, j = col - diag; i < N && j < N; i++, j++) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// checking from top right to bottom left
		for (int i = row - diag, j = col + diag; i < N && j > 0; i++, j--) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// if none of the checks have returned false. 
		// it is safe to place a queen
		// but first add the column and row to a hash map.
		// that way next time when a check is performed we don't have to 
		// iterate through all the rows and cols. We can check if the row has been 
		// used and if it is then skip it.
		existingRows.add(row);
		return true;
	}
	
	public static void NQueenBackTrack(int row, int n) {
		for (int i = 0; i < n ; i++) {
			if (isQueenSafe(row, i)) {
				board[row][i] = 1;
				if (row == n) {
					printBoard(board, 0);
				}
				else {
					board[row][i] = 0;
				}
				
				NQueenBackTrack(row + 1, n);
			}
		}
	}

}
