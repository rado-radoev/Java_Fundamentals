import java.util.Scanner;

public class TicTacToeTest {
	
	// TO DO;
	// Add an option to choose number of players
	// Add an option for computer oponent
	
	private static Scanner input= new Scanner(System.in);
	private static int[] userSelection = new int[2];
	private static boolean win;

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();			
		TicTacToePlayer player1 = new TicTacToePlayer();
		TicTacToePlayer player2 = new TicTacToePlayer();
		
		player1.selectUserFigure();
		player2.selectUserFigure();

		
		ttt.displayBoard();
		
		for (int i = 0; i < 9; i++) {
			userMove(ttt, player1);
			userMove(ttt, player2);				

		}
		if (!win) {
			System.out.println("Nobody Wins");	
		}
	}
	
	// Choose number of player
	public static int numberOfPlayers() {
		System.out.println("Choose number of players 1 or 2?: ");
		int playerNumber = input.nextInt();
		return playerNumber;
	}
	
	// Users play on board
	public static void userMove(TicTacToe ttt, TicTacToePlayer player) {
		if (win) {
			return;
		}
	
		
		boolean nextPlayer = true;	// sentinel controlling variable
		while(nextPlayer) {
			System.out.printf("Player %s turn %n", player.getPlayerFigure());	// Display who's turn it is
			userSelection = ttt.userSelect();	// Select row and column to play
			if (ttt.isEmpty(userSelection)) {	// Check if selectd space is availabe == EMPTY
				ttt.makeMove(userSelection, player.getPlayerFigure());	// if space is available, make the move
				nextPlayer = false;	// set sentinel controlling variable to false - exit loop
			}
			else {
				System.out.print("Space is already occupied. Choose another.");	// If space is occupied ask the user to select again.
			}
		}	
		
		ttt.displayBoard();	// Display the board
		if(ttt.checkWin()) {	// Check if user has won
			System.out.printf("Player %s wins!", player.getPlayerFigure());
			win = true;
			return;
		}
	}

}
