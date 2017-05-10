
public class TicTacToeTest {
	
	private static int[] userSelection = new int[2];
	
	// TO DO:
	// Add numbering to rows and columns when displaying table

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
		
		ttt.displayBoard();
		
		
		TicTacToePlayer player1 = new TicTacToePlayer();
		TicTacToePlayer player2 = new TicTacToePlayer();
		player1.selectUserFigure();
		player2.selectUserFigure();


		for (int i = 0; i < 9; i++) {
			userMove(ttt, player1);
			userMove(ttt, player2);	
		}
		
		System.out.println("Nobody Wins");
	}
	
	public static void userMove(TicTacToe ttt, TicTacToePlayer player) {
		boolean nextPlayer = true;
		while(nextPlayer) {
			System.out.printf("Player %s turn %n", player.getPlayerFigure());
			userSelection = ttt.userSelect();
			if (ttt.isEmpty(userSelection)) {
				ttt.makeMove(userSelection, player.getPlayerFigure());
				nextPlayer = false;
			}
			else {
				System.out.print("Space is already occupied. Choose another.");
			}
		}
		nextPlayer = true;
		ttt.displayBoard();
		if(ttt.checkWin()) {
			System.out.printf("Player %s wins!", player.getPlayerFigure());
			return;
		}
	}

}
