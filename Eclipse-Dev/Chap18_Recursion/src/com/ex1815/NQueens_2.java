package com.ex1815;

import static java.lang.Math.min;

public class NQueens_2 {
	
	private static int N = 8; // default board size
	private static int[][] board = new int[N][N];
	
	public static void main(String[] args) {
		System.out.printf("%4d %2d %2d %2d %2d %2d %2d %2d%n", 1,2,3,4,5,6,7,8);
		if (NQueenBackTrack(0,N)) {
			printBoard(board, 0);
		}

	}
	
	// print the board using recursion
	private static String printBoard(int[][] board, int row) {
		if (row == N) 
			return "";
		
		System.out.printf("%d ", row + 1);	// this print the number of the row
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
		
		// if another queen is on the same row or col return false
		// loop throuh all the rows and cols
		for (int i = 0; i < N; i++) {
			if (board[row][i] == 1 || board[i][col] == 1) {
				return false;
			}
		}
		
		
		// get diagonal. To calculate -> min(row, col) - 1
		int diag = min(row, col);

		// checking from top left to bottom right
		for (int i = row - diag, j = col - diag; i < N && j < N; i++, j++) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// checking from top right to bottom left
		for (int i = row - diag, j = col + diag; i < N && (j >= 0 && j < N); i++, j--) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// if none of the checks have returned false. 
		// it is safe to place a queen
		return true;
	}
	
	
	public static boolean NQueenBackTrack(int row, int n) {
		if (row == n) {
			return true;
		}
		
		for (int i = 0; i < n;i++) {
			if (isQueenSafe(row, i)) {
				board[row][i] = 1; // it is safe to place a queen
				
				if (NQueenBackTrack(row + 1, n)) {
					return true;
				}
				else {
					board[row][i] = 0;
				}
			}
		}
		
		return false;
	}
}
