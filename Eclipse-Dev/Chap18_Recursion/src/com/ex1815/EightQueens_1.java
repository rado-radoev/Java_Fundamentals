package com.ex1815;

/*
 * https://www.youtube.com/watch?v=kX5frmc6B7c
 * https://en.wikipedia.org/wiki/Backtracking
 * http://www.cs.ucf.edu/~dmarino/ucf/cop3503/lectures/EightQueens.java
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * https://en.wikipedia.org/wiki/Eight_queens_puzzle
 */

public class EightQueens_1 {
	
	final int N = 4;
	
	// print solution
	public void printSolution(int[][] board) {
		for (int i = 0, j = 0; i < N && j < N; i++, j++) {
			System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}
	
	// helper method to check if a queen can be placed on board[row][col]
	// This method is called when "col" queens are already placed in columns
	// from 0 to col - 1. We need to check only left side for attacking queens
	// TO DO: I can add a check if that row has already been marked with a queen - skip it
	public boolean isSafe(int board[][], int row, int col) {
		int i, j;
		
//		boolean[] rows = new boolean[N];
//		boolean[] cols = new boolean[N];
//		
//		if (rows[row] == true) {
//			return false; // row is already occupied
//		}
//		
//		if (cols[col] == true) {
//			return false; // column is already occupied
//		}
		
		// check this row on the left side
		for (i = 0; i < col; i++) {
			if(board[row][i] == 1){
				return false;
			}
		}
		
		// check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		
		// check lower diagonal on the left side
		for (i = row, j = col; i < N && j >=0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}
	
	
	// Recursive function that solves N Queen problem
	public boolean solveNQueenUtil(int board[][], int col) {
		// base case - if all queens are placed then return true
		if (col >= N)
			return true;
		
		// try placing the queens in all rows one by one
		for (int i = 0; i < N; i++) {
			// check if queen can be placed on board[i][col]
			if (isSafe(board, i, col)) {
				// place the queen in board[i][col]
				board[i][col] = 1;
				
				// place the rest of the queens recursively
				if (solveNQueenUtil(board, col + 1)) {
					return true;
				}
				
				// if placing queen in board[i][col]
				// doesnt' lead to a solution, remove queen from board[i][col]
				board[i][col] = 0;
			}
		}
		
		// if queen can not be placed in any row in this column then return false
		return false;
	}
	
	
	private boolean solveNQ() {
	    int[][] board = { 
    		{0, 0, 0, 0},
	        {0, 0, 0, 0},
	        {0, 0, 0, 0},
	        {0, 0, 0, 0}
	    };
	 
	    if ( solveNQueenUtil(board, 0) == false )
	    {
	      System.out.printf("Solution does not exist");
	      return false;
	    }
	 
	    printSolution(board);
	    return true;
	}
	

	public static void main(String[] args) {
		EightQueens_1 eq = new EightQueens_1();
		eq.solveNQ();
	}

}


/*
 * 1. Start at the leftmost column
 * 2. If all queens are placed
 * 		return true
 *  3. Try all rows in the current column
 *  	For every row:
 *  		If the queen can be safely placed in this row,column
 *  		as part of the solution, recursively check if placing
 *  		queen leads to a solution
 *   		
 *   		If placing queen in row,column leads to a solution return true
 *   
 *   		If placing a queen doesn't lead to a solution then mark this row,column
 *  		and back track to step and try next row
 *  
 *  4.	If all rows have been tried and no solution has been found. Return false and
 *  	trigger backtracking
 */