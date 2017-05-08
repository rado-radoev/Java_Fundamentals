// ex 8.17
import java.util.Scanner;

public class TicTacToe {

	Scanner input = new Scanner(System.in);
	
	private TicTacToeEnum[][] board = new TicTacToeEnum[3][3];
	
	private boolean isEmpty(int row, int col) {
		if (board[row][col] != TicTacToeEnum.EMPTY) return false;
		else return true;
	}
	
	private int[] userSelect() {
		int[] userSelection = new int[2];
		System.out.printf("Choose a row to play? (1-3): ");
		int row = input.nextInt();
		input.next();
		System.out.printf("Choose a column to play? (1-3): ");
		int column = input.nextInt();
		
		userSelection[0] = row;
		userSelection[1] = column;
		
		return userSelection;
	}
	
	public void displayBoard() {
		System.out.printf("%s%s%s%n", "_______","_______","_______");
		for (int row = 0; row < board.length; row++) {
			board[row][0] = TicTacToeEnum.EMPTY;
			for (int col = 0; col < board[row].length; col++) {
				System.out.printf("%s%s", "|", "EMPTY");
				board[row][col] = TicTacToeEnum.EMPTY;
				System.out.printf("%s", "|");
			}
			System.out.println();
		}
		System.out.printf("%s%s%s%n", "_______","_______","_______");
	}
}
