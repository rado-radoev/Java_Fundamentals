package com.ex1815;

import java.util.Scanner;

public class NQueens_2 {
	
	private static int N = 8; // default board size
	private static int[][] board = new int[N][N];
	
	public static void main(String[] args) {
		System.out.printf("%4d %2d %2d %2d %2d %2d %2d %2d%n", 0,1,2,3,4,5,6,7);
		board[2][3] = 1;
		System.out.println(printBoard(board, 0));
		
		
		System.out.print(isQueenSafe(2,3));
		System.out.print(isQueenSafe(3,4));
		
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
		
		// if another queen is on the same row or col return false
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 1) {
					return false; // queen exists
				}	
			}

		}
		
		// get diagonal. To calculate min(row, col) - 1
		int diag = Math.min(row, col) - 1;

		// checking from top left to bottom right
		for (int i = row, j = diag; i < row && j < col; i++, j++) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// checking from top left to bottom left
		for (int i = row, j = col; i < row && j > 0; i++, j--) {
			if (board[i][j] == 1) {
				return false; // queen exists
			}
		}
		
		// if none of the checks have returned false. 
		// it is safe to place a queen
		return true;
	}
	
	

}
