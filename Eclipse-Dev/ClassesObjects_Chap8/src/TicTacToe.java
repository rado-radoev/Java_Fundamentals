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
	public boolean checkWin() {
		for (int i = 1; i < board.length; i++) {
			if ((board[i][1] == board[i][2] && board[i][1] == board[i][3]) && board[i][1] != TicTacToeEnum.EMPTY)
				return true;				
		}
		
		if ((board[1][1] == board[2][2] && board[1][1] == board[3][3]) && board[1][1] != TicTacToeEnum.EMPTY)
			return true;
		
		if ((board[1][3] == board[2][2] && board[1][3] == board[3][1]) && board[1][3] != TicTacToeEnum.EMPTY)
			return true;
		
		return false;
	}
	
	// place figure in array
	public void makeMove(int[] userChoice, TicTacToeEnum player) {
		board[userChoice[0]][userChoice[1]] = player;
	}
	 
	// Check if space is available to play
	public boolean isEmpty(int[] userSelection) {
		int row = userSelection[0];
		int col = userSelection[1];
		if (board[row][col] == TicTacToeEnum.EMPTY)
			return true;
		else 
			return false;
	}
	
	// Ask the user to select a row and a column and output to array
	public int[] userSelect() {
		// Perform a check. User cannot enter anything else than 1-3
		int row = 0;
		do {
			System.out.printf("Choose a row to play? (1-3): ");
			row = input.nextInt();			
		} while (row < 1 || row > 3);

		// Perform a check. User cannot enter anything else than 1-3
		int column = 0;
		do {
			System.out.printf("Choose a column to play? (1-3): ");
			column = input.nextInt();		
		} while(column < 1 || column > 3);

		
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
		System.out.printf("     1     2      3     %n");
		System.out.printf("------------------------%n");
		for (int row = 1; row < board.length; row++) {
			System.out.printf("%d", row);
			for (int col = 1; col < board[row].length; col++) {
				System.out.printf("%s%5s%s", 
						"|", 
						board[row][col] == TicTacToeEnum.EMPTY ? "" : board[row][col], 
						"|");
			}
			System.out.printf("%2d%n", row);
			System.out.printf("------------------------%n");
			
		}
		System.out.printf("     1     2      3     %n");
	}
}