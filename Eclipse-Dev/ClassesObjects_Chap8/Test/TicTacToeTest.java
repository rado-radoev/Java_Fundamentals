
public class TicTacToeTest {

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		
		ttt.displayBoard();
		int[] userSelection = new int[2];

		for (int i = 0; i < 9; i++) {
			System.out.println("Player 1 turn:");
			userSelection = ttt.userSelect();
			while(ttt.isEmpty(userSelection)) {
				ttt.makeMove(userSelection, TicTacToeEnum.X);
			}
			ttt.displayBoard();
			if(ttt.checkWin()) {
				System.out.println("Player 1 wins!");
				break;
			}
			
			System.out.println("Player 2 turn:");
			userSelection = ttt.userSelect();
			while(ttt.isEmpty(userSelection)) {
				ttt.makeMove(userSelection, TicTacToeEnum.O);
			}
			ttt.displayBoard();
			if(ttt.checkWin()) {
				System.out.println("Player 2 wins!");
				break;
			}
		}
	}

}
