// ex 8.17
public class TicTacToe {

	private TicTacToeEnum[][] board = new TicTacToeEnum[3][3];
	
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
