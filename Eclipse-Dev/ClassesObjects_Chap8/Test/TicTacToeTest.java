
public class TicTacToeTest {
	
	
	// TO DO:
	// Add numbering to rows and columns when displaying table

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		
		ttt.displayBoard();
		int[] userSelection = new int[2];
		
		TicTacToePlayer player1 = new TicTacToePlayer();
		TicTacToePlayer player2 = new TicTacToePlayer();
		player1.selectUserFigure();
		player2.selectUserFigure();

		// sentinel controlling value
		boolean nextPlayer = true;
		for (int i = 0; i < 9; i++) {
			while(nextPlayer) {
				System.out.println("Player 1 turn:");
				userSelection = ttt.userSelect();
				if (ttt.isEmpty(userSelection)) {
					ttt.makeMove(userSelection, player1.getPlayerFigure());
					nextPlayer = false;
				}
				else {
					System.out.print("Space is already occupied. Choose another.");
				}
			}
			nextPlayer = true;
			ttt.displayBoard();
			if(ttt.checkWin()) {
				System.out.println("Player 1 wins!");
				break;
			}
			
			while(nextPlayer) {
				System.out.println("Player 2 turn:");
				userSelection = ttt.userSelect();
				if (ttt.isEmpty(userSelection)) {
					ttt.makeMove(userSelection, player2.getPlayerFigure());
					nextPlayer = false;
				}
				else {
					System.out.print("Space is already occupied. Choose another.");
				}
			}
			nextPlayer = true;
			ttt.displayBoard();
			if(ttt.checkWin()) {
				System.out.println("Player 2 wins!");
				break;
			}	
		}
		
		System.out.println("Nobody Wins");
	}

}
