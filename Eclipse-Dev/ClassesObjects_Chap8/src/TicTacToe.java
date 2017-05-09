// ex 8.17
import java.util.Scanner;

public class TicTacToe {

	private Scanner input = new Scanner(System.in);
	private TicTacToeEnum[][] board = new TicTacToeEnum[4][4];
	private int[] userSelection = new int[2];
	
	
	public TicTacToe() {
		initializeBoard();
	}
	
	// check if winning
//	private boolean checkWin() {
//		
//	}
	
	// place figure in array
	public void makeMove(int[] userChoice, TicTacToeEnum player) {
		board[userChoice[0]][userChoice[1]] = player;
	}
	 
	
	// Check if space is available to play
	public boolean isEmpty(int[] userSelection) {
		int row = userSelection[0];
		int col = userSelection[1];
		if (board[row][col] != TicTacToeEnum.EMPTY) 
			return false;
		else 
			return true;
	}
	
	// Ask the user to select a row and a column and output to array
	public int[] userSelect() {
		int row;
		do {
			System.out.printf("Choose a row to play? (1-3): ");
			row = input.nextInt();			
		} while (row < 1 && row > 3);

		int column;
		do {
			System.out.printf("Choose a column to play? (1-3): ");
			column = input.nextInt();		
		} while(column < 1 && column > 3);

		
		userSelection[0] = row;
		userSelection[1] = column;
		
		return userSelection;
	}
	
	// Initialize the board to all empty fields
	private final void initializeBoard() {
		for (int row = 1; row < board.length; row++) {
			for (int col = 1; col < board[row].length; col++) {
				board[row][col] = TicTacToeEnum.EMPTY;
			}
		}
	}
	
	// Display the board
	public void displayBoard() {
		System.out.printf("%n");
		for (int row = 1; row < board.length; row++) {
			for (int col = 1; col < board[row].length; col++) {
				System.out.printf("%5s%5s", "|", board[row][col]);
			}
			System.out.printf("%s%n", "|");
		}
	}
}