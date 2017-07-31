package com.ex1815;

import java.util.Scanner;

public class NQueens_2 {
	
	private static int N = 8; // default board size
	private static int[][] board = new int[N][N];
	
	public static void main(String[] args) {
		System.out.printf("%4d %2d %2d %2d %2d %2d %2d %2d%n", 1,2,3,4,5,6,7,8);
		System.out.println(printBoard(board, 0));
	}
	
	// print the board using recursion
	private static String printBoard(int[][] board, int row) {
		if (row >= N) 
			return "";
		
		System.out.printf("%d ", row + 1);	// this print the number of the row
		for (int i = 0, j = 0; i < N && j < N; i++, j++) { // loop thourgh rows and cols 
			if (board[i][j] == 0) 
				System.out.print(" * ");  // if box is 0, no queen is placed on that position, print *
			else 
				System.out.print("Q"); // if box is 1, a queen has been placed on that position, print Q
		}
		
		System.out.println();	// move to the next line
		return printBoard(board, row + 1); // invoke the function again to print the next line
	}
	
	// function to check if the cell is safe for a queen
	private static boolean isQueenSafe(int[][] board, int row, int col) {
		
		// if another queen is on the same row return false
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false; // queen exists
			}
		}
		
		// if another queen is on the same col return false
		for (int j = 0; j < col; j++) {
			if (board[row][j] == 1) {
				return false; // queen exist
			}
		}
		
		// get diagonal
		int diag = Math.min(row, col) - 1;
		// if another queen is on diagonal retrun false. To calculate min(row, col) - 1
		
		
		
		// it is a bit tricky to get the return the opposite diagonal
		
		
		
		return false;
	}

}
